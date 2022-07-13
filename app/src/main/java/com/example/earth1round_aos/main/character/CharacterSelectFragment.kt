package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.earth1round_aos.databinding.FragmentCharacterSelectBinding

class CharacterSelectFragment : AppCompatActivity() {

    lateinit var binding : FragmentCharacterSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCharacterSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.characterSelectBackIb.setOnClickListener {
            finish()
        }
    }


}