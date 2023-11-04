package com.example.project6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class GameView : View {
    private lateinit var paint : Paint
    private var width : Int = 0
    private var height : Int  = 0
    private lateinit var paddle: Rect
    constructor(context: Context, width:Int, height:Int) : super(context){
        this.width = width
        this.height = height

        paint = Paint( )
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 20.0f

        paddle = Rect(width/2-100,height-100,width/2+100,height-80)
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        canvas.drawCircle(width.toFloat()/2,20.0f,20.0f,paint)
        canvas.drawRect(paddle,paint)
    }
}