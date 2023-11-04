package com.example.project6

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import java.util.Timer

class MainActivity : AppCompatActivity() {
    private lateinit var gameView : GameView
    private lateinit var pong : Pong
    //private lateinit var detector : GestureDetector
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
        //pong = gameView.getPong()
        setContentView( gameView )
        /*
        // set up event handling
        var handler : TouchHandler = TouchHandler( )
        detector = GestureDetector( this, handler )
        detector.setOnDoubleTapListener( handler )
        */

        /*
        // set schedule
        var gameTimer : Timer = Timer( )
        var gameTimerTask : GameTimerTask = GameTimerTask( this )
        gameTimer.schedule( gameTimerTask, 0L, GameView.DELTA_TIME.toLong() )
        */
    }

}