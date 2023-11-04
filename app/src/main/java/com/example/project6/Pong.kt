package com.example.project6

import android.graphics.Point

class Pong {
    private var ballRadius = 0
    private var ballCenter : Point? = null
    private var ballAngle = 45
    private var ballSpeed = 0f
    constructor(newBallRadius : Int, newBallSpeed : Float) {
        setBallSpeed(newBallSpeed)
        setBallRadius(newBallRadius)


    }

    fun setBallSpeed(newBallSpeed : Float) {
        if (newBallSpeed > 0) {
            ballSpeed = newBallSpeed
        }
    }

    fun setBallRadius(newBallRadius : Int) {
        if (newBallRadius > 0) {
            ballRadius = newBallRadius
        }
    }
}