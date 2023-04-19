package com.amy.jetpackdemo

import android.os.CountDownTimer
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.amy.jetpackdemo.uitls.Trace

/**
 * @description 用于管理闪屏广告的计时，倒计时，结束等操作Lifecycle
 * @author Antonio
 * @date 2023/4/18
 */
class LifecycleSplashAdManager : DefaultLifecycleObserver {

    companion object {
        //TAG
        var TAG = "LifecycleSplashAdManager"

        //广告总时间
        const val TOTAL_TIME = 3000L

        //倒计时时间
        const val countDownTime = 1000L
    }

    //监听事件
    var adManageListener: SplashAdManageListener? = null

    //定时器
    private var countDownTimer: CountDownTimer? =
        object : CountDownTimer(TOTAL_TIME, countDownTime) {
            override fun onTick(millisUntilFinished: Long) {
                Trace.d(TAG, "广告剩余${(millisUntilFinished / 1000).toInt()}秒")
                adManageListener?.timing((millisUntilFinished / 1000).toInt())
            }

            override fun onFinish() {
                Trace.d(TAG, "广告结束，准备进入主页面")
                adManageListener?.enterHomeActivity()
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

    /**
     *广告管理接口
     */
    interface SplashAdManageListener {
        /**
         * 计时
         * @param second 秒
         */
        fun timing(second: Int)

        /**
         * 计时结束, 进入主页面
         */
        fun enterHomeActivity()
    }

}