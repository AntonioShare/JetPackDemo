package com.amy.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amy.jetpackdemo.databinding.ActivityMainBinding
import com.amy.jetpackdemo.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun start(splashActivity: AppCompatActivity) {
            splashActivity.startActivity(Intent(splashActivity, MainActivity::class.java))
        }
    }
}