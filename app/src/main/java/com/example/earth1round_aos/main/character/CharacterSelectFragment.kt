package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.earth1round_aos.databinding.FragmentCharacterSelectBinding

class CharacterSelectFragment : Fragment() {

    lateinit var binding: FragmentCharacterSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterSelectBinding.inflate(inflater, container, false)

        return binding.root
    }


}