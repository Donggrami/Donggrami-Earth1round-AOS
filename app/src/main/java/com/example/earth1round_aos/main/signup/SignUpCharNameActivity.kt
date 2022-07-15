package com.example.earth1round_aos.main.signup

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivitySignupCharnameBinding
import com.example.earth1round_aos.main.MainActivity

class SignUpCharNameActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignupCharnameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupCharnameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //이름 입력하기 끝내고 어플 시작하기
        binding.signupCharnameStartCv.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}