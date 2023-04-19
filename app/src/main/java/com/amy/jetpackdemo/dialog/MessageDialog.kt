package com.amy.jetpackdemo.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.amy.jetpackdemo.R

/**
 * @description Dialog的测试类
 * @author Antonio
 * @date 2023/4/18
 */
class MessageDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_test)
    }
}