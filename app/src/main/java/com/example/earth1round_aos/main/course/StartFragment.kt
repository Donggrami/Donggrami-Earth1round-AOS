package com.example.earth1round_aos.main.course

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.earth1round_aos.databinding.FragmentStartBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.data.LocationData

class StartFragment: Fragment() {
    lateinit var binding: FragmentStartBinding
    private val locationData = ArrayList<LocationData>()
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        locationData.apply {
            add(LocationData(1, "경복궁", 100.2, 100.42))
            add(LocationData(2, "에펠탑", 10.2, 10.4))
        }

        val startRVAdapter = LocationRVAdapter(locationData)
        binding.courseStartLocationRv.adapter = startRVAdapter
        binding.courseStartLocationRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        startRVAdapter.setMyItemClickListener(object : LocationRVAdapter.MyItemClickListener{
            override fun onItemClick(position: Int) {
                // 동작 입력
                saveData(locationData[position])

            }

        })



        return binding.root
    }

    private fun saveData(location: LocationData) {
        val intent = Intent(context, MainActivity::class.java)
        val start = LocationData(location.id, location.name, location.latitude, location.longitude)

        val bundle = Bundle()
        bundle.putInt("sId", start.id!!)
        bundle.putString("sName", start.name)
        bundle.putDouble("sLat", start.latitude)
        bundle.putDouble("sLong", start.longitude)

        intent.putExtra("sBundle", bundle)
    }
}