package com.example.earth1round_aos.main.login

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivityLoginBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.signup.SignUpActivity

class LoginActivity: AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 카카오 로그인
        binding.loginKakaoLoginCv.setOnClickListener {
            kLogin()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        // 구글 로그인
        binding.loginGoogleLoginCv.setOnClickListener {
            gLogin()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        // 회원이 아닐 경우
        binding.loginNotMemberYetTv.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }

    }

    private fun kLogin(){

    }

    private fun gLogin(){

    }
}