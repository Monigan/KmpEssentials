package com.architect.kmpessentials.deviceInfo

import kotlinx.datetime.TimeZone
import platform.UIKit.UIDevice

actual class KmpDeviceInfo {
    actual companion object {
        actual fun getDeviceTimeZone(): String {
            return TimeZone.currentSystemDefault().id
        }

        actual fun getRunningPlatform(): DevicePlatform {
            return DevicePlatform.iOS
        }

        actual fun getDeviceSpecs(): DeviceSpecs {
            return DeviceSpecs(
                UIDevice.currentDevice.model,
                UIDevice.currentDevice.systemVersion,
                "Apple Inc"
            )
        }
    }
}

