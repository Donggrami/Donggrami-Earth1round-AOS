package com.example.earth1round_aos.main.signup

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivitySignupTermsBinding

class SignUpTermsActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignupTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 화면 넘어가기
        binding.signupTermOkCv.setOnClickListener {
            startActivity(Intent(this, SignUpCharNameActivity::class.java))
            finish()
        }
    }
}