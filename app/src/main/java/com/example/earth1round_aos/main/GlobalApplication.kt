import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // KaKao SDK  초기화
        KakaoSdk.init(this, "7858293610f37e4c9eeb809456609bab")
    }
}