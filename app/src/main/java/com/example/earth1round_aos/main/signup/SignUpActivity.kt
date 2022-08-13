package com.example.earth1round_aos.main.signup

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivitySignupBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class SignUpActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로 돌아가기
        binding.signupTermBackIc.setOnClickListener {
            finish()
        }


        // 구글 회원가입
        binding.signupGoogleSignupCv.setOnClickListener {
            gSignup()
            startActivity(Intent(this, SignUpTermsActivity::class.java))
        }


        // 카카오 회원가입
        binding.signupKakaoSignupCv.setOnClickListener {
            kSignup()
            startActivity(Intent(this, SignUpTermsActivity::class.java))
        }


        // 그냥 둘러보기
        binding.signupLookAroundTv.setOnClickListener {
            startActivity(Intent(this, SignUpCharNameActivity::class.java))
        }


    }

    private fun gSignup(){

    }

    private fun kSignup() {

    }
}