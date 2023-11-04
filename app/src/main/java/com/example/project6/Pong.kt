package com.example.project6

import android.graphics.Point

class Pong {
    private var ballRadius = 0f
    private var ballCenter : Point? = null
    private var ballAngle = 0f
    private var ballSpeed = 0f
    private var ballMoving = true
    private var deltaTime = 10
    constructor(width:Int,height:Int) {
        ballMoving = false
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

    fun startMovingBall() {
        ballMoving = true
    }

    // Has the user tapped the screen to start the game yet
    fun isBallMoving() : Boolean {
        return ballMoving
    }


    fun ballOffScreen():Boolean{
        return false
    }

    fun moveBall() {
        ballCenter!!.x += (ballSpeed * Math.cos(ballAngle.toDouble()) * deltaTime).toInt()
        ballCenter!!.y -= (ballSpeed * Math.sin(ballAngle.toDouble()) * deltaTime).toInt()
    }
}