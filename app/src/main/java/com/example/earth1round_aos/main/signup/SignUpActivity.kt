package com.example.earth1round_aos.main.signup

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivitySignupBinding

class SignUpActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupGoogleSignupCv.setOnClickListener {
            gSignup()
            startActivity(Intent(this, SignUpTermsActivity::class.java))
            finish()
        }

        binding.signupKakaoSignupCv.setOnClickListener {
            kSignup()
            startActivity(Intent(this, SignUpTermsActivity::class.java))
            finish()
        }

        binding.signupLookAroundTv.setOnClickListener {
            startActivity(Intent(this, SignUpCharNameActivity::class.java))
            finish()
        }


    }

    private fun gSignup(){

    }

    private fun kSignup() {

    }
}