package com.example.earth1round_aos.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.earth1round_aos.databinding.FragmentEditNameBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditNameBottomSheetDialog: BottomSheetDialogFragment() {
    lateinit var binding: FragmentEditNameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNameBinding.inflate(inflater, container, false)

        return binding.root
    }
}