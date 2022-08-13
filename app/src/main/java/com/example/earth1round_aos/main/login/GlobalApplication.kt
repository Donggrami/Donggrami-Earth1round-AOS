package com.example.earth1round_aos.main.login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "7858293610f37e4c9eeb809456609bab")
    }
}