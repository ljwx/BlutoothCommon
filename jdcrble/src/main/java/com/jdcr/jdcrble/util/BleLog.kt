package com.jdcr.jdcrble.util

import android.util.Log

object BleLog {

    private val tag = "bbl_d"

    fun i(content: String) {
        Log.i(tag, content)
    }

    fun d(content: String) {
        Log.d(tag, content)
    }

    fun w(content: String, throwable: Throwable? = null) {
        Log.w(tag, content, throwable)
    }

    fun e(content: String, error: Throwable? = null) {
        Log.e(tag, content, error)
    }

}