package com.example.clientapp.feature.splash

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SplashViewModel:ViewModel() {
    private var timer: CountDownTimer? = null

    private val _timeCount = MutableStateFlow(0L)
    val timeCount:StateFlow<Long> = _timeCount

    val navTopMain = MutableStateFlow(false)


    init {
        delayToNext()
    }

    private fun delayToNext(time:Long = 3000) {
        timer = object :CountDownTimer(time,1000){
            override fun onTick(millisUntilFinished: Long) {
                _timeCount.value = millisUntilFinished/1000 + 1
            }

            override fun onFinish() {
                toNext()
            }

        }.start()
    }

    private fun toNext() {
        navTopMain.value = true
    }

    //   跳过广告
    fun skipAd() {
        timer?.cancel()
        toNext()
    }

}