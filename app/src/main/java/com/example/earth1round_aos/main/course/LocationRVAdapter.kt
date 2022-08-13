package com.example.earth1round_aos.main.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.ItemLocationBinding
import com.example.earth1round_aos.main.data.LocationData
import kotlinx.coroutines.currentCoroutineContext

class LocationRVAdapter(private var locaionData: ArrayList<LocationData>): RecyclerView.Adapter<LocationRVAdapter.ViewHolder>() {
    var selectPos = -1

    interface MyItemClickListener{
        fun onItemClick(position: Int)
    }

    private lateinit var mItemClickListner : MyItemClickListener
    fun setMyItemClickListener(itemClickListener: LocationRVAdapter.MyItemClickListener) {
        mItemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): LocationRVAdapter.ViewHolder {
        val binding: ItemLocationBinding = ItemLocationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        binding.locationTv.background

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationRVAdapter.ViewHolder, position: Int) {
        holder.bind(locaionData[position])
        if (selectPos == position){
            holder.itemView.setBackgroundResource(R.color.light_yellow)
        } else{
            holder.itemView.setBackgroundResource(R.color.white)
        }
        holder.itemView.setOnClickListener {
            var beforePos = selectPos
            selectPos = position

            notifyItemChanged(beforePos)
            notifyItemChanged(selectPos)
            mItemClickListner.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = locaionData.size


    inner class ViewHolder(var binding: ItemLocationBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(locationList: LocationData){
            binding.locationTv.text = locationList.name
        }

    }
}