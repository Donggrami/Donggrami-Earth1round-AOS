package com.example.earth1round_aos.main.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.earth1round_aos.databinding.ActivitySplashBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.login.LoginActivity
import com.example.earth1round_aos.main.signup.SignUpTermsActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Handler의 postDelayed를 이용하면 일정 시간 후에 안에 있는 함수를 실행할 수 있다
        // Handler를 만들 때에는 () 안에 Looper.getMainLooper()를 넣어주어야 에러가 나지 않는다!
        Handler(Looper.getMainLooper()).postDelayed({
//            // 현재 Activity에서 MainActivity로 이동하기 위한 Intent 변수 만들기
//            val moveActivityIntent = Intent(this, MainActivity::class.java)
//
//            // Intent에 정의된대로 MainActivity를 열기
//            startActivity(moveActivityIntent)

//            // 현재 Activity (SplashActivity)를 닫기
//            finish();

            // splash 끝나면 signup 화면 열고 splash activity 닫기
            signup()

        }, 3000) // 2000은 지연시간 설정 (2000 -> 2초, 즉 밀리초 단위로 입력해야 함)
    }

    private fun signup(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}