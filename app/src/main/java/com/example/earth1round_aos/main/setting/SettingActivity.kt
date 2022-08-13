package com.example.earth1round_aos.main.setting

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.ActivityLoginBinding
import com.example.earth1round_aos.databinding.ActivitySettingBinding
import com.example.earth1round_aos.main.data.User
import com.google.gson.Gson

class SettingActivity: AppCompatActivity() {
    lateinit var binding : ActivitySettingBinding
    private var gson : Gson = Gson()
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 설정 화면 닫기
        binding.settingCloseIv.setOnClickListener {
            finish()
        }


        // 닉데임 수정 클릭
        binding.settingEditProfileNameCl.setOnClickListener {
            editName()
        }
    }


    private fun editName(){
        var dialog = EditNameBottomSheetDialog()

        dialog.show(this.supportFragmentManager, dialog.tag)
    }

//    val user = gson.fromJson("User", User::class.java)
//    user

    private fun getUser() {
        val email: String = binding.settingProfileNameTv.text.toString()
    }
}