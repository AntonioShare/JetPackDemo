package com.amy.jetpackdemo.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amy.jetpackdemo.MainActivity
import com.amy.jetpackdemo.databinding.ActivitySplashBinding

/**
 *
 * @description lifecycle  闪屏页面
 * @author Antonio
 * @date 2023/4/18
 */
class LifecycleSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val splashAdManager: LifecycleSplashAdManager by lazy {
        LifecycleSplashAdManager()
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
        splashAdManager.adManageListener = object : LifecycleSplashAdManager.SplashAdManageListener {
            override fun timing(second: Int) {
                binding.adJumpButton.text = "$second|点击跳过"
            }

            override fun enterHomeActivity() {
                MainActivity.start(this@LifecycleSplashActivity)
                finish()
            }
        }
    }
}