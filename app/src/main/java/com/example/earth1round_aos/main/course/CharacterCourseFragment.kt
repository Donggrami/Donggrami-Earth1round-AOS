package com.example.earth1round_aos.main.course

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.donggrami.main.character.CharacterFragment
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterCourseBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.data.LocationData
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.*

//OnMapReadyCallback, GoogleMap.OnMarkerClickListener
class CharacterCourseFragment : Fragment() {

    lateinit var binding : FragmentCharacterCourseBinding
    private val course = arrayListOf("출발지역", "도착지역")
    lateinit var viewPager: ViewPager2

    var sPlace = LocationData()
    var ePlace = LocationData()

    val bundle = Bundle()

//    lateinit var seoul: LatLng
//    lateinit var sydney: LatLng

//    lateinit var str1: String
//    lateinit var str2: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterCourseBinding.inflate(inflater,container,false)
        viewPager = binding.courseSelectVp



        // 화면 돌아가기
        binding.characterCourseBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        val courseAdapter = CourseVPAdapter(this)
        binding.courseSelectVp.adapter = courseAdapter
        TabLayoutMediator(binding.courseSelectTl, binding.courseSelectVp){
                tab, position ->
            tab.text = course[position]
        }.attach()


        binding.courseStartCl.setOnClickListener {
            binding.courseStartIv.setImageResource(R.drawable.ic_location_yellow)
            viewPager.currentItem = 0
        }
        binding.courseEndCl.setOnClickListener {
            binding.courseEndIv.setImageResource(R.drawable.ic_location_yellow)
            viewPager.currentItem = 1
        }

//        var sLat = arguments?.getDouble("sLat")
//        var sLong = arguments?.getDouble("sLong")
//        place.add(LocationData(arguments?.getInt("sId"), arguments?.getString("sName"), sLat!!, sLong!!))
//        Log.d("place size ", place.size.toString())

        val sArg = arguments
        val eArg = arguments

        sPlace.id = sArg?.getInt("sId")
        ePlace.id = eArg?.getInt("eId")
        sPlace.name = sArg?.getString("sName")
        ePlace.name = eArg?.getString("eName")
//        place.latitude = arguments?.getDouble("sLat")!!
//        place.longitude = arguments?.getDouble("sLong")!!
        binding.courseStartTv.text = sPlace.name.toString()
        binding.courseEndTv.text = ePlace.name.toString()

        Log.d("Course Start Latitude ", sPlace.toString())


        if (binding.courseStartTv.text != " " && binding.courseStartTv.text != "null"){
            binding.courseStartIv.setImageResource(R.drawable.ic_location_yellow)
        }else{
            binding.courseStartIv.setImageResource(R.drawable.ic_location_gray)
        }

        if (binding.courseEndTv.text != " " && binding.courseEndTv.text != "null"){
            binding.courseEndIv.setImageResource(R.drawable.ic_location_yellow)
        }else{
            binding.courseEndIv.setImageResource(R.drawable.ic_location_gray)
        }



        var eLat = arguments?.getDouble("eLat")
        var eLong = arguments?.getDouble("eLong")
//        end.latitude = eLat!!
//        end.longitude = eLong!!


        return binding.root
    }




    // 출발지점 도착지점 거리 구하는 함수
    private fun distance(x1:Double, y1:Double, x2:Double, y2:Double): Int{
        val r = 6372.8 * 1000
        var dLat = x1 - x2
        var dLon = y1 - y2
        val a = sin(dLat / 2).pow(2.0) + sin(dLon / 2).pow(2.0) * cos(Math.toRadians(x1)) * cos(Math.toRadians(x2))
        val c = 2 * asin(sqrt(a))
        return (r * c).toInt()
    }


}



