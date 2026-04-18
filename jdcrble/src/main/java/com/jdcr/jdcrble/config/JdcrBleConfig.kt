package com.jdcr.jdcrble.config

import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanSettings
import android.os.ParcelUuid
import java.util.UUID

const val MTU_DEFAULT_SIZE = 23

data class JdcrBleScanConfig(
    val minRssi: Int = -100,
    val filterNullName: Boolean = true,
    val expiredTimeMills: Int = 2000,
    val resultIntervalMills: Long = 200,
    val rssiSort: Boolean = true,
    val scanFilters: List<ScanFilter>? = null,
    val settings: ScanSettings = getDefaultScanSettings(),
) {
    companion object {

        fun getUUIDFilter(uuid: UUID): List<ScanFilter> {
            return listOf(ScanFilter.Builder().setServiceUuid(ParcelUuid(uuid)).build())
        }

        fun getDefaultScanSettings(): ScanSettings {
            return ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build()
        }

    }
}

data class JdcrBleConnectConfig(
    val maxConnectDevice: Int = 3,
    val mtu: Int? = null,
    val autoConnect: Boolean = false
)

data class BleCommunicateConfig(val timeoutMills: Long = 5000)

data class JdcrBleConfig(
    val scan: JdcrBleScanConfig = JdcrBleScanConfig(),
    val connect: JdcrBleConnectConfig = JdcrBleConnectConfig(),
    val communicate: BleCommunicateConfig = BleCommunicateConfig()
)