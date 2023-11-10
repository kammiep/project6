package com.example.project6

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView

class GameView : View {
    private lateinit var paint : Paint
    private var width : Int = 0
    private var height : Int  = 0
    private lateinit var paddle: Rect
    private lateinit var pong : Pong
    private lateinit var context : Context
    constructor(context: Context, width:Int, height:Int) : super(context){
        this.width = width
        this.height = height

        paint = Paint( )
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 20.0f

        paddle = Rect(width/2-100,height-100,width/2+100,height-80)
        pong = Pong(width,height, width/2-100, height-100, width/2+100, height-80)
        this.context = context
    }

    fun getPong():Pong{
        return pong
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        Log.w("GameView","Drawing paddle at left " + pong.getPaddleLeft().toString())
        paddle = Rect(pong.getPaddleLeft(), pong.getPaddleTop(),
            pong.getPaddleRight(), pong.getPaddleBottom())
        canvas.drawRect(paddle, paint)
        if(!pong.ballAtBottom()) {
            canvas.drawCircle(
                pong.getBallCenter().x.toFloat(), pong.getBallCenter().y.toFloat(),
                pong.getBallRadius(), paint
            )
        } else {
            val score = pong.getScore()
            var displayText : String = "Final Score: " + score
            // get data from persistent data
            var pref : SharedPreferences = context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)
            val best = pref.getInt("best", 0)
            if (score < best) {
                displayText += "\n\nNOT your best score"
            } else {
                displayText += "\n\nNew best score!"
                var editor = pref.edit()
                editor.putInt("best", score)
            }
            paint.setTextSize(60F);
            canvas.drawText(displayText, 18F, 60F, paint)
        }
    }
}