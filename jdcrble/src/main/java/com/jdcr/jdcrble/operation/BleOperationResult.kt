package com.jdcr.jdcrble.operation

sealed class BleOperationResult(
    open val address: String?,
    open val characterUuid: String,
    open val success: Boolean
) {
    data class EnableNotification(
        override val address: String?,
        override val characterUuid: String,
        val notificationUuid: String?,
        override val success: Boolean
    ) : BleOperationResult(address, characterUuid, success)

    data class Read(
        override val address: String?,
        override val success: Boolean,
        override val characterUuid: String,
        val value: ByteArray?,
        val status: Int? = null
    ) : BleOperationResult(address, characterUuid, success)

    data class Write(
        override val address: String?,
        override val success: Boolean,
        override val characterUuid: String,
        val status: Int
    ) : BleOperationResult(address, characterUuid, success)

    fun getDisplayTag(): String {
        return javaClass.simpleName + "," + success + ",address:" + (address
            ?: "") + ",characterUuid:" + characterUuid
    }

}