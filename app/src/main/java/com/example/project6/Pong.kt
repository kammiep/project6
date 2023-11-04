package com.example.project6

import android.graphics.Point

class Pong {
    private var ballRadius = 0f
    private var ballCenter : Point? = null
    private var ballAngle = 0f
    private var ballSpeed = 0f
    constructor(width:Int,height:Int) {
        ballRadius = 20f
        ballSpeed = 10f
        ballAngle = 45f
        ballCenter = Point(width/2,20)
    }

    fun getBallCenter():Point{
        return ballCenter!!
    }

    fun getBallRadius():Float{
        return ballRadius
    }
}