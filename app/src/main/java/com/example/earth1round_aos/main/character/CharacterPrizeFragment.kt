package com.example.donggrami.main.character

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.FragmentCharacterPrizeBinding

class CharacterPrizeFragment : AppCompatActivity() {

    lateinit var binding : FragmentCharacterPrizeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCharacterPrizeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.characterPrizeBackIb.setOnClickListener {
            finish()
        }
    }


}