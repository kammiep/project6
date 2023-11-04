package com.example.project6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class GameView : View {
    private lateinit var paint : Paint
    private var width : Int = 0
    private var height : Int  = 0
    constructor(context: Context, width:Int, height:Int) : super(context){
        this.width = width
        this.height = height

        paint = Paint( )
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 20.0f
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        canvas.drawCircle(0.0f,height.toFloat(),100.0f,paint)
    }
}