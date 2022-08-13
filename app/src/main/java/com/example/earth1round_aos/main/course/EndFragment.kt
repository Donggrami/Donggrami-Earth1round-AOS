package com.example.earth1round_aos.main.course

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentEndBinding
import com.example.earth1round_aos.main.data.LocationData

class EndFragment: Fragment() {
    lateinit var binding: FragmentEndBinding
    private val locationData = ArrayList<LocationData>()
    private val intent = Intent()
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEndBinding.inflate(inflater, container, false)

        locationData.apply {
            add(LocationData(1, "경복궁", 100.2, 100.42))
            add(LocationData(2, "에펠탑", 10.2, 10.4))
        }

        val endRVAdapter = LocationRVAdapter(locationData)
        binding.courseEndLocationRv.adapter = endRVAdapter
        binding.courseEndLocationRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        endRVAdapter.setMyItemClickListener(object : LocationRVAdapter.MyItemClickListener{
            override fun onItemClick(position: Int) {
                // 동작 입력
                saveInfo(locationData[position])
                setDataAtFragment(CharacterCourseFragment(), locationData[position])
                Log.d("End Bundle", bundle.getBundle("eBundle").toString())
            }

        })

        return binding.root
    }

    private fun saveInfo(location: LocationData) {
        bundle.apply {
            putInt("eId", location.id!!)
            putString("eName", location.name)
            putDouble("eLat", location.latitude)
            putDouble("eLong", location.longitude)
        }

        Log.d("End Name", bundle.getString("endName").toString())

        Bundle().putBundle("eBundle", bundle)
    }

    fun setDataAtFragment(fragment:Fragment, location:LocationData){
        bundle.apply {
            putInt("eId", location.id!!)
            putString("eName", location.name)
            putDouble("eLat", location.latitude)
            putDouble("eLong", location.longitude)
        }

        fragment.arguments = bundle
        setFragment(fragment)
    }
    fun setFragment(fragment: Fragment){
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frm,fragment)
        transaction.commit()
    }
}