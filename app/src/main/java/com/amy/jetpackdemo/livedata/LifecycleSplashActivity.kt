package com.amy.jetpackdemo.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.amy.jetpackdemo.MainActivity
import com.amy.jetpackdemo.databinding.ActivitySplashBinding

/**
 *
 * @description lifecycle  闪屏页面
 * @author Antonio
 * @date 2023/4/18
 */
class LifecycleSplashActivity : AppCompatActivity() {

    private var mTimingLiveData = MutableLiveData<Int>()

    private lateinit var binding: ActivitySplashBinding

    private val splashAdManager: LifecycleSplashAdManager by lazy {
        LifecycleSplashAdManager(mTimingLiveData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAd()
        initListener()
    }

    /**
     * 事件监听
     */
    private fun initListener() {
        binding.adJumpButton.setOnClickListener {
            MainActivity.start(this)
            finish()
        }
    }

    /**
     * 广告初始化
     */
    private fun initAd() {
        lifecycle.addObserver(splashAdManager)

        mTimingLiveData.observe(this) {
            binding.adJumpButton.text = "$it|333232点击跳过"
            if (it == 0) {
                MainActivity.start(this@LifecycleSplashActivity)
                finish()
            }
        }
        mTimingLiveData.value = 223
    }
}