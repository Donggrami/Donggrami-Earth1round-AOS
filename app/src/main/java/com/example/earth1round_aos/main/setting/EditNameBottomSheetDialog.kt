package com.example.earth1round_aos.main.setting

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.earth1round_aos.R
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

        binding.bottomEditNameEt.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (binding.bottomEditNameEt.text.isNullOrBlank()){
                    binding.bottomEditNameOkTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_gray))
                    binding.bottomEditNameOkTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.bottomEditNameOkTv.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.bg_yellow))
                binding.bottomEditNameOkTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                if (binding.bottomEditNameEt.text.isNullOrBlank()){
                    binding.bottomEditNameOkTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_gray))
                    binding.bottomEditNameOkTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                }
            }
        })


        binding.bottomEditNameOkTv.setOnClickListener {
            nameChange()
        }

        return binding.root
    }

    private fun nameChange(){
        binding.bottomEditNameOkTv.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_gray))
        binding.bottomEditNameOkTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        if(binding.bottomEditNameEt.text.toString().isEmpty()) {
            Toast.makeText(requireActivity(), "변경하실 이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }
    }
}