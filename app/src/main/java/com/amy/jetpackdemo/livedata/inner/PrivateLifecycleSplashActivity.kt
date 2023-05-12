package com.amy.jetpackdemo.livedata.inner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.amy.jetpackdemo.MainActivity
import com.amy.jetpackdemo.databinding.ActivitySplashBinding
import com.amy.jetpackdemo.livedata.LifecycleSplashAdManager

/**
 *
 * @description lifecycle  闪屏页面
 * @author Antonio
 * @date 2023/4/18
 */
class PrivateLifecycleSplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding

    private val splashAdManager: PrivateLifecycleSplashAdManager by lazy {
        PrivateLifecycleSplashAdManager()
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

        splashAdManager.timingLiveData.observe(this) {
            binding.adJumpButton.text = "$it|点击跳过"
            if (it == 0) {
                MainActivity.start(this@PrivateLifecycleSplashActivity)
                finish()
            }
        }
        lifecycle.addObserver(splashAdManager)
    }
}