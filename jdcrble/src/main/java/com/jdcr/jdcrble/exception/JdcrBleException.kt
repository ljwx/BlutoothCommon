package com.jdcr.jdcrble.exception

class JdcrBleAvailableException(val msg: String) : Exception(msg)

class JdcrBleConnectException(val msg: String) : Exception(msg)

class JdcrBleCommunicationException(val msg: String) : Exception(msg)