package com.amy.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amy.jetpackdemo.databinding.ActivitySplashBinding

/**
 *
 * @description 闪屏页面
 * @author Antonio
 * @date 2023/4/18
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val splashAdManager: SplashAdManager by lazy {
        SplashAdManager()
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
        splashAdManager.adManageListener = object : SplashAdManager.SplashAdManageListener {
            override fun timing(second: Int) {
                binding.adJumpButton.text = "$second|跳过"
            }

            override fun enterHomeActivity() {
                MainActivity.start(this@SplashActivity)
                finish()
            }
        }
        splashAdManager.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        splashAdManager.onCancel()
    }
}