package com.example.earth1round_aos.main.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.earth1round_aos.databinding.FragmentCharacterSelectItemBinding

class SelectRVAdapter(private val selectList: ArrayList<Select>): RecyclerView.Adapter<SelectRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SelectRVAdapter.ViewHolder {
        val binding: FragmentCharacterSelectItemBinding = FragmentCharacterSelectItemBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectRVAdapter.ViewHolder, position: Int) {
        holder.bind(selectList[position])
    }

    override fun getItemCount(): Int = selectList.size

    inner class ViewHolder(val binding: FragmentCharacterSelectItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(select: Select){
            binding.characterSelectItemPhotoIv.setImageResource(select.characterImage!!)
        }

    }
}