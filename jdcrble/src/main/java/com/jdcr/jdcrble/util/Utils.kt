package com.jdcr.jdcrble.util

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice

@SuppressLint("MissingPermission")
fun BluetoothDevice.nameAndAddress(): String {
    return (name ?: "empty") + "," + this.address
}