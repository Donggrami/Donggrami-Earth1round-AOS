package com.example.earth1round_aos.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentSettingBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.home.HomeFragment

class SettingFragment: Fragment() {
    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.settingCloseIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }
}