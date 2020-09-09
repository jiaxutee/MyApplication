package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var score = 0
    private var gameStarted = false
    private lateinit var countDownTimer: CountDownTimer
    private var initialCountDown : Long = 60000
    private var countDownInterval : Long = 1000
    private var timeLeft = 60
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_tap_me.setOnClickListener{incrementScore()}
        resetGame()
    }

    private fun incrementScore(){
        if (!gameStarted){
            startGame()
        }
        score++
        val newScore = getString(R.string.your_score,score)
        txtGameScore.text = newScore
    }

    private fun resetGame(){
        score = 0
        val initialScore = getString(R.string.your_score, score)
        txtGameScore.text = initialScore

        val initialTimeLeft = getString(R.string.time_left, 60)
        txtTimeLeft.text = initialTimeLeft

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval){
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished.toInt()/1000
                val timeLeftString = getString(R.string.time_left,timeLeft)
                txtTimeLeft.text = timeLeftString
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }
        gameStarted = false
    }

    private fun startGame(){
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame(){}

}