package com.example.donggrami.main.character

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earth1round_aos.databinding.FragmentCharacterCourseBinding


class CharacterCourseFragment : AppCompatActivity() {

    lateinit var binding : FragmentCharacterCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCharacterCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.characterCourseBackIb.setOnClickListener {
            finish()
        }
    }


}