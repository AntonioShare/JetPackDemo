package com.amy.jetpackdemo.livedata.inner

import android.os.CountDownTimer
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amy.jetpackdemo.uitls.Trace

/**
 * @description 用于管理闪屏广告的计时，倒计时，结束等操作Lifecycle
 * @author Antonio
 * @date 2023/4/18
 */
class PrivateLifecycleSplashAdManager : DefaultLifecycleObserver {
    private var mTimingLiveData: MutableLiveData<Int> = MutableLiveData<Int>()
    val timingLiveData: LiveData<Int> get() = mTimingLiveData

    companion object {
        //TAG
        var TAG = "LifecycleLiveDataSplashAdManager"

        //广告总时间
        const val TOTAL_TIME = 3000L

        //倒计时时间
        const val countDownTime = 1000L
    }

    //定时器
    private var countDownTimer: CountDownTimer? =
        object : CountDownTimer(TOTAL_TIME, countDownTime) {
            override fun onTick(millisUntilFinished: Long) {
                Trace.d(TAG, "广告剩余${(millisUntilFinished / 1000).toInt()}秒")
                mTimingLiveData.value = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                Trace.d(TAG, "广告结束，准备进入主页面")
                mTimingLiveData.value = 0
            }
        }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        start()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        onCancel()
    }

    /**
     * 开始计时
     */
    private fun start() {
        Trace.d(TAG, "开始计时")
        countDownTimer?.start()
    }

    /**
     * 停止计时
     */
    private fun onCancel() {
        Trace.d(TAG, "停止计时")
        countDownTimer?.cancel()
        countDownTimer = null
    }

}