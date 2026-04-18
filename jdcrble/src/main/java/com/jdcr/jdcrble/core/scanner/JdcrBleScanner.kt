package com.jdcr.jdcrble.core.scanner

import com.jdcr.jdcrble.state.JdcrBleScanResult
import kotlinx.coroutines.flow.SharedFlow

interface JdcrBleScanner {

    fun startScan(timeoutMills: Long = 60): Result<SharedFlow<JdcrBleScanResult>>

    fun stopScan()

    fun release()

}