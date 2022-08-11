package com.example.earth1round_aos.main

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.ActivityMainBinding
import com.example.earth1round_aos.main.home.HomeFragment
import com.kakao.sdk.common.util.Utility

import java.security.MessageDigest

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id. main_frm, HomeFragment()).commitAllowingStateLoss()

        setContentView(R.layout.activity_main)

//        //해시키 얻는 코드
//        val keyHash = Utility.getKeyHash(this)
//        Toast.makeText(applicationContext, keyHash, Toast.LENGTH_LONG).show()
    }

}