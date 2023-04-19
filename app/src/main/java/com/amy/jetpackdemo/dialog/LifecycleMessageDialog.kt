package com.amy.jetpackdemo.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.amy.jetpackdemo.R
import com.amy.jetpackdemo.databinding.DialogTestBinding

/**
 * @description Dialog的测试类
 * @author Antonio
 * @date 2023/4/18
 */
class LifecycleMessageDialog(context: Context)
    : Dialog(context), DefaultLifecycleObserver {
    private lateinit var binding: DialogTestBinding
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Dialog>.onCreate(savedInstanceState)
        binding = DialogTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}