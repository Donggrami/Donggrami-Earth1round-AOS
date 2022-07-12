package com.example.earth1round_aos.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.ActivityMainBinding
import com.example.earth1round_aos.main.home.HomeFragment
import com.example.earth1round_aos.main.setting.SettingFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id. main_frm, HomeFragment()).commitAllowingStateLoss()

        setContentView(R.layout.activity_main)

    }
}