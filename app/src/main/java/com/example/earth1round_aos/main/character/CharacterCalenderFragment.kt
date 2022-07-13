package com.example.donggrami.main.character

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.FragmentCharacterCalenderBinding

class CharacterCalenderFragment : AppCompatActivity() {

    lateinit var binding : FragmentCharacterCalenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCharacterCalenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.characterCalenderBackIb.setOnClickListener {
            finish()
        }
    }


}