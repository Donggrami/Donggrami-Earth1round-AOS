package com.example.earth1round_aos.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.earth1round_aos.databinding.FragmentEditImgBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditImgBottomSheetDialog : BottomSheetDialogFragment() {
    lateinit var binding: FragmentEditImgBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditImgBinding.inflate(inflater, container, false)

        return binding.root
    }
}