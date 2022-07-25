package com.example.earth1round_aos.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.donggrami.main.character.CharacterFragment
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentHomeBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.setting.SettingActivity

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("SUCCESS ", "HomeFragment")
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.homeHamburgerBtnIv.setOnClickListener {
            startActivity(Intent(requireActivity(),SettingActivity::class.java))
        }

        binding.homeCharSelectIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }
}