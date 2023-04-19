package com.amy.jetpackdemo.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.amy.jetpackdemo.R
import com.amy.jetpackdemo.databinding.ActivityDialogTestBinding

/**
 * @description 测试Dialog的lifecycle Activity
 * @author Antonio
 * @date 2023/4/18
 */
class LifecycleDialogTestActivity : AppCompatActivity() {
    private val messageDialog: LifecycleMessageDialog by lazy {
        LifecycleMessageDialog(this)
    }
    private val messageDialogTwo: LifecycleMessageDialog by lazy {
        LifecycleMessageDialog(this)
    }
    private lateinit var binding: ActivityDialogTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        messageDialog.show()
        messageDialogTwo.show()
        lifecycle.addObserver(messageDialog)
        lifecycle.addObserver(messageDialogTwo)
        Handler(mainLooper).postDelayed({
            finish()
        }, 3000)
    }


}