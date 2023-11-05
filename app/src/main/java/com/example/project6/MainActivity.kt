package com.example.project6

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.Timer
import kotlin.math.roundToInt

class MainActivity : Activity() {
    private lateinit var gameView : GameView
    private lateinit var pong : Pong
    private lateinit var detector : GestureDetector
    lateinit var params : RelativeLayout.LayoutParams
    lateinit var tv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // need to comment out?
        // setContentView(R.layout.activity_main)

        var width : Int = Resources.getSystem().displayMetrics.widthPixels
        var height : Int = Resources.getSystem().displayMetrics.heightPixels

        // retrieve status bar height
        var statusBarId : Int = resources.getIdentifier( "status_bar_height", "dimen", "android" )
        var statusBarHeight : Int  = resources.getDimensionPixelSize( statusBarId )

        gameView = GameView( this, width, height - statusBarHeight )
        pong = gameView.getPong()
        setContentView( gameView )

        // set up event handling
        var handler : TouchHandler = TouchHandler( )
        detector = GestureDetector( this, handler )
        detector.setOnDoubleTapListener( handler )


        // set schedule
        var gameTimer : Timer = Timer( )
        var gameTimerTask : GameTimerTask = GameTimerTask( this )
        gameTimer.schedule( gameTimerTask, 0L, 200L )

        tv = TextView(this)
        params = RelativeLayout.LayoutParams(100,100)
        params.leftMargin = 100
        params.rightMargin = 100
    }

    override fun onTouchEvent(event:MotionEvent?):Boolean{
        if (event != null) {
            detector.onTouchEvent(event!!)
        }
        return super.onTouchEvent(event)
    }

    fun updateModel() {
        if (pong.isBallMoving()) {
            pong.moveBall()
        }
        if (pong.ballAtBottom()) {

        }
    }

    fun updateView() {
        gameView.postInvalidate()
    }

    inner class TouchHandler : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e:MotionEvent):Boolean{
            if(e != null && !pong.isBallMoving()){
                pong.startMovingBall()
            }
            return true
        }

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            var touchX : Int = e2.x.roundToInt()

            if(!pong.isBallMoving()){
                pong.startMovingBall()
            }

            // get rectangle, change location
            Log.w("MainActivity","Calling movePaddle " + touchX.toString())
            pong.movePaddle(touchX)
            return super.onScroll(e1, e2, distanceX, distanceY)
        }
    }
}