package com.example.project6

import android.graphics.Point
import android.util.Log
import kotlin.math.cos
import kotlin.math.sin

class Pong {
    private var ballRadius = 0f
    private var ballCenter : Point? = null
    private var ballAngle = 0f
    private var ballSpeed = 0f
    private var ballMoving = false
    private var deltaTime = 10
    private var width = 0
    private var height = 0
    private var left = true
    constructor(width:Int,height:Int) {
        ballMoving = false
        ballRadius = 20f
        ballSpeed = 10f
        ballAngle = 45f
        this.width = width
        this.height = height
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

    fun ballAtBottom():Boolean{
        return ballCenter!!.y + 50 >= height
    }

    fun ballAtWall():Boolean{
        return (ballCenter!!.x + 50 - ballRadius >= width) || (ballCenter!!.x - 50 <= 0)||
                (ballCenter!!.y - 50 <= 0)
    }

    fun moveBall() {
        if(ballAtWall())
            left = !left
        if(!left){
            ballCenter!!.x += (ballSpeed*Math.cos(ballAngle.toDouble())*deltaTime).toInt()
        }else{
            ballCenter!!.x -= (ballSpeed*Math.cos(ballAngle.toDouble())*deltaTime).toInt()
        }
        ballCenter!!.y += (ballSpeed*Math.sin(ballAngle.toDouble())*deltaTime).toInt()
        Log.w("Pong","ball is here: (" + ballCenter!!.x + ", " + ballCenter!!.y + ")")
    }
}