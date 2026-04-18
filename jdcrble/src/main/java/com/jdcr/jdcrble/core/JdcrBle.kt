package com.jdcr.jdcrble.core

import android.content.Context
import com.jdcr.jdcrble.core.communicator.JdcrBleCommunicator
import com.jdcr.jdcrble.core.connector.JdcrBleConnector
import com.jdcr.jdcrble.core.scanner.JdcrBleScanner

interface JdcrBle : JdcrBleScanner, JdcrBleConnector, JdcrBleCommunicator {


}