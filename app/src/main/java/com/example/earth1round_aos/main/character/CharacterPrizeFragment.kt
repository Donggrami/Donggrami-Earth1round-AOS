package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterPrizeBinding
import com.example.earth1round_aos.main.MainActivity

class CharacterPrizeFragment : Fragment() {

    lateinit var binding : FragmentCharacterPrizeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterPrizeBinding.inflate(inflater, container, false)

        //화면 돌아가기
        binding.characterPrizeBackIb.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }


}