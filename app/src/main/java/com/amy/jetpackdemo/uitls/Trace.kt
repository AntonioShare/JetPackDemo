package com.amy.jetpackdemo.uitls

import android.util.Log

/**
 * @description 日志打印类，用于打印日志，方便调试，发布时关闭日志打印
 * @author Antonio
 * @date 2023/4/18
 */
class Trace {

    companion object {
        private const val TAG = "Trace"

        /**
         * 打印debug日志
         */
        fun log(message: String) {
            Log.d(TAG, message)
        }

        fun d(tag: String, message: String) {
            Log.d(tag, message)
        }
    }


}