package com.amy.jetpackdemo.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.amy.jetpackdemo.R
import com.amy.jetpackdemo.databinding.ActivityDialogTestBinding

/**
 * @description 测试Dialog的Activity
 * @author Antonio
 * @date 2023/4/18
 */
class DialogTestActivity : AppCompatActivity() {
    private val messageDialog: MessageDialog by lazy {
        MessageDialog(this)
    }
    private val messageDialogTwo: MessageDialog by lazy {
        MessageDialog(this)
    }
    private lateinit var binding: ActivityDialogTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        messageDialog.show()
        messageDialogTwo.show()
        Handler(mainLooper).postDelayed({
            messageDialog.cancel()
            messageDialogTwo.cancel()
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}