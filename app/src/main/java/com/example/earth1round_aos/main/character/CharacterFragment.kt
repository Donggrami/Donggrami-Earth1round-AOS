package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.home.HomeFragment
import com.example.earth1round_aos.main.setting.SettingFragment

class CharacterFragment : Fragment() {

    lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterBinding.inflate(inflater, container, false)

        binding.characterHomeGoEarth.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, HomeFragment()).commitAllowingStateLoss()
        }

        binding.characterHomeTropiIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterPrizeFragment()).commitAllowingStateLoss()
        }

        binding.characterHomeCumulateCl.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterCalenderFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }
}