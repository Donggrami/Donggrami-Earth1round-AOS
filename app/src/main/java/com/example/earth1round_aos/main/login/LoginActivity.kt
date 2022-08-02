package com.example.earth1round_aos.main.login

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivityLoginBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.signup.SignUpActivity

class LoginActivity: AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 카카오 로그인
        binding.loginKakaoLoginCv.setOnClickListener {
            kLogin()
            Toast.makeText(this, "카카오톡 로그인", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        // 구글 로그인
        binding.loginGoogleLoginCv.setOnClickListener {
            gLogin()
            Toast.makeText(this, "구글 로그인", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        // 회원이 아닐 경우
        binding.loginNotMemberYetTv.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

    }

    private fun kLogin(){

    }

    private fun gLogin(){

    }
}