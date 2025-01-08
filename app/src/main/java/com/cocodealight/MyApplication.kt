package com.cocodealight

import android.app.Application
import android.content.Context
import kr.co.ksystem.companity.utils.PushNotificationConfig
import kr.co.ksystem.companity.utils.PushNotificationHandler

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 푸시 알림 설정
        PushNotificationConfig.setPushNotificationHandler(object : PushNotificationHandler {
            override fun handleMessage(
                context: Context,
                remoteMessage: com.google.firebase.messaging.RemoteMessage
            ): Boolean {
                return false
            }

            override fun getTargetActivity(remoteMessage: com.google.firebase.messaging.RemoteMessage): Class<*> {
                return MainActivity::class.java // 앱의 MainActivity 지정
            }
        })
    }
}