package com.example.earth1round_aos.main.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.earth1round_aos.databinding.FragmentCharacterPrizeItemBinding

class PrizeRVAdapter(private val prizeList: ArrayList<Prize>): RecyclerView.Adapter<PrizeRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PrizeRVAdapter.ViewHolder {
        val binding: FragmentCharacterPrizeItemBinding = FragmentCharacterPrizeItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrizeRVAdapter.ViewHolder, position: Int) {
        holder.bind(prizeList[position])
    }

    override fun getItemCount(): Int = prizeList.size

    inner class ViewHolder(val binding: FragmentCharacterPrizeItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(prize: Prize){
            binding.characterPrizeItemYearTv.text = prize.year
            binding.characterPrizeItemMonthTv.text = prize.month
            binding.characterPrizeItemDateTv.text = prize.date
            binding.characterPrizeItemCourseTv.text = prize.course
            binding.characterPrizeItemDistanceTv.text = prize.distance

        }

    }

}