package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterSelectBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.character.Prize
import com.example.earth1round_aos.main.character.PrizeRVAdapter
import com.example.earth1round_aos.main.character.Select
import com.example.earth1round_aos.main.character.SelectRVAdapter

class CharacterSelectFragment : Fragment() {

    lateinit var binding : FragmentCharacterSelectBinding
    private var selectDatas = ArrayList<Select>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterSelectBinding.inflate(inflater, container, false)

        //화면 돌아가기
        binding.characterSelectBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        selectDatas.apply {
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
            add(Select(R.drawable.img_character_character))
        }

        val selectRVAdapter = SelectRVAdapter(selectDatas)
        binding.characterSelectCustomRv.adapter = selectRVAdapter
        binding.characterSelectCustomRv.layoutManager = GridLayoutManager(context, 3)

        return binding.root
    }
}