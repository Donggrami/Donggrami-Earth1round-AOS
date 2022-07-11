package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.donggrami_android.databinding.FragmentCharacterCourseBinding

class CharacterCourseFragment : Fragment() {

    lateinit var binding: FragmentCharacterCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterCourseBinding.inflate(inflater, container, false)

        return binding.root
    }


}