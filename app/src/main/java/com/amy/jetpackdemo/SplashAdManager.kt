package com.amy.jetpackdemo

import android.os.CountDownTimer
import com.amy.jetpackdemo.uitls.Trace
/**
 * @description 用于管理闪屏广告的计时，倒计时，结束等操作
 * @author Antonio
 * @date 2023/4/18
 */
class SplashAdManager {
    companion object {
        //TAG
        var TAG = "SplashAdManager"
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

    /**
     * 开始计时
     */
    fun start() {
        Trace.d(TAG, "开始计时")
        countDownTimer?.start()
    }
    /**
     * 停止计时
     */
    fun onCancel() {
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