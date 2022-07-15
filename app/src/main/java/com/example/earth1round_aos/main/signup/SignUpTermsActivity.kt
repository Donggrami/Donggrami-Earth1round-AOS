package com.example.earth1round_aos.main.signup

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivitySignupTermsBinding

class SignUpTermsActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignupTermsBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivitySignupTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}