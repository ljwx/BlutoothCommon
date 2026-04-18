package com.jdcr.jdcrble.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat

object JdcrBlePermissionUtils {

    fun getScanPermission(): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Manifest.permission.BLUETOOTH_SCAN
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Manifest.permission.ACCESS_FINE_LOCATION
        } else {
            null
        }
    }

    fun getConnectPermission(): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            //Android 12+：检查BLUETOOTH_CONNECT权限
            Manifest.permission.BLUETOOTH_CONNECT
        } else {
            //Android 12以下：BLUETOOTH/BLUETOOTH_ADMIN是普通权限，无需动态检查
            null
        }
    }

    fun checkScanPermission(context: Context): Boolean {
        getScanPermission()?.let {
            return ActivityCompat.checkSelfPermission(
                context, it
            ) == PackageManager.PERMISSION_GRANTED
        }
        return true
    }

    fun checkConnectPermission(context: Context): Boolean {
        getConnectPermission()?.let {
            return ActivityCompat.checkSelfPermission(
                context, it
            ) == PackageManager.PERMISSION_GRANTED
        }
        return true
    }

}