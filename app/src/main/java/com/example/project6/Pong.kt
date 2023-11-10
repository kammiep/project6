package com.example.project6

import android.graphics.Point
import android.util.Log

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
    private var up = false
    private var paddleLeft = 0;
    private var paddleTop = 0;
    private var paddleRight = 0;
    private var paddleBottom = 0;
    private var score = 0
    private var hitPaddle = false
    constructor(width:Int,height:Int, paddleLeft:Int, paddleTop:Int, paddleRight:Int, paddleBottom:Int) {
        ballMoving = false
        ballRadius = 20f
        ballSpeed = 10f
        ballAngle = 45f
        score = 0
        hitPaddle = false
        this.width = width
        this.height = height
        ballCenter = Point(width/2,20)
        this.paddleLeft = paddleLeft
        this.paddleTop = paddleTop
        this.paddleRight = paddleRight
        this.paddleBottom = paddleBottom
    }

    fun getBallCenter():Point{
        return ballCenter!!
    }

    fun getBallRadius():Float{
        return ballRadius
    }

    fun getPaddleLeft():Int {
        return paddleLeft
    }

    fun getPaddleRight():Int {
        return paddleRight
    }

    fun getPaddleTop():Int {
        return paddleTop
    }

    fun getPaddleBottom():Int {
        return paddleBottom
    }

    fun movePaddle(x:Int) {
        val distanceFromX : Int = ((paddleRight - paddleLeft)/2)
        paddleLeft = x - distanceFromX
        paddleRight = x + distanceFromX
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

    private fun ballAtWall():Boolean{
        if((ballCenter!!.x + 50 <= paddleRight) && (ballCenter!!.x - 50 >= paddleLeft)
            && (ballCenter!!.y + 50 - ballRadius >= paddleTop) && (ballCenter!!.y - 50 - ballRadius <= paddleBottom)){
            up = true
            left = !left
            score++
            return true
        }else if(ballCenter!!.y - 50 - ballRadius <= 0){
            up = false
            left = !left
            return true
        }
        return (ballCenter!!.x + 50 - ballRadius >= width) || (ballCenter!!.x - 50 - ballRadius <= 0)
    }

    fun checkHit():Boolean{
        if((ballCenter!!.x + 50 <= paddleRight) && (ballCenter!!.x - 50 >= paddleLeft)
            && (ballCenter!!.y + 50 - ballRadius >= paddleTop) && (ballCenter!!.y - 50 - ballRadius <= paddleBottom)){
            return true
        }
        return false
    }

    fun getScore():Int{
        return score
    }

    fun moveBall() {
        if(ballAtWall())
            left = !left
        if(!left){
            ballCenter!!.x += (ballSpeed*Math.cos(ballAngle.toDouble())*deltaTime).toInt()
        }else{
            ballCenter!!.x -= (ballSpeed*Math.cos(ballAngle.toDouble())*deltaTime).toInt()
        }
        if(!up){
            ballCenter!!.y += (ballSpeed*Math.sin(ballAngle.toDouble())*deltaTime).toInt()
        }else{
            ballCenter!!.y -= (ballSpeed*Math.sin(ballAngle.toDouble())*deltaTime).toInt()
        }
        Log.w("Pong","ball is here: (" + ballCenter!!.x + ", " + ballCenter!!.y + ")")
    }
}