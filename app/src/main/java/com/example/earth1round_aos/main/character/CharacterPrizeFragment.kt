package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterPrizeBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.character.Prize
import com.example.earth1round_aos.main.character.PrizeRVAdapter

class CharacterPrizeFragment : Fragment() {

    lateinit var binding : FragmentCharacterPrizeBinding
    private var prizeDatas = ArrayList<Prize>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterPrizeBinding.inflate(inflater, container, false)

        //화면 돌아가기
        binding.characterPrizeBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        prizeDatas.apply {
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
            add(Prize("2022", "May", ". 01", "코스", "거리 km"))
        }

        val prizeRVAdapter = PrizeRVAdapter(prizeDatas)
        binding.characterPrizeRv.adapter = prizeRVAdapter
        binding.characterPrizeRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }


}