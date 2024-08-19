package com.architect.kmpessentials.deviceInfo

expect class KmpDeviceInfo {
    companion object {
        /**
         * Gets your device's timezone string
         * */
        fun getDeviceTimeZone(): String

        /**
         * @return Running Platform (Android, iOS, Windows, etc)
         * */
        fun getRunningPlatform(): DevicePlatform

        /**
         * @return Device Information (Manufacturer, Device Name, etc)
         * */
        fun getDeviceSpecs(): DeviceSpecs
    }
}

