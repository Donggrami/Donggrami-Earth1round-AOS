package com.example.earth1round_aos.main.course

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.donggrami.main.character.CharacterFragment
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterCourseBinding
import com.example.earth1round_aos.main.MainActivity
import com.example.earth1round_aos.main.data.LocationData
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.*

//OnMapReadyCallback, GoogleMap.OnMarkerClickListener
class CharacterCourseFragment : Fragment() {

    lateinit var binding : FragmentCharacterCourseBinding
    private val course = arrayListOf("출발지역", "도착지역")
    lateinit var viewPager: ViewPager2

    private var intent = Intent()
    private var bundle = Bundle()

    lateinit var seoul: LatLng
    lateinit var sydney: LatLng

//    lateinit var str1: String
//    lateinit var str2: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterCourseBinding.inflate(inflater, container, false)
        viewPager = binding.courseSelectVp

        // 화면 돌아가기
        binding.characterCourseBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        val courseAdapter = CourseVPAdapter(this)
        binding.courseSelectVp.adapter = courseAdapter
        TabLayoutMediator(binding.courseSelectTl, binding.courseSelectVp){
            tab, position ->
            tab.text = course[position]
        }.attach()


        binding.courseStartCl.setOnClickListener {
            binding.courseStartIv.setImageResource(R.drawable.ic_location_yellow)
            binding.courseEndIv.setImageResource(R.drawable.ic_location_gray)
            viewPager.currentItem = 0
        }
        binding.courseEndCl.setOnClickListener {
            binding.courseEndIv.setImageResource(R.drawable.ic_location_yellow)
            binding.courseStartIv.setImageResource(R.drawable.ic_location_gray)
            viewPager.currentItem = 1
        }

//        if (viewPager.currentItem == 0){
//            viewPager.setCurrentItem(0)
//            binding.courseStartIv.setImageResource(R.drawable.ic_location_yellow)
//            binding.courseEndIv.setImageResource(R.drawable.ic_location_gray)
//        }else{
//            viewPager.setCurrentItem(1)
//            binding.courseEndIv.setImageResource(R.drawable.ic_location_yellow)
//            binding.courseStartIv.setImageResource(R.drawable.ic_location_gray)
//        }

        val end = LocationData()

        arguments.let {
            end.name = bundle.getString("eName")
            Log.d("Char Course Fragment ", end.name.toString())
        }

        if (intent.hasExtra("sBundle")){
            val start = LocationData()
            bundle = intent.getBundleExtra("sBundle")!!

            start.id = bundle.getInt("sId")
            start.name = bundle.getString("sName")
            start.latitude = bundle.getDouble("sLat")
            start.longitude = bundle.getDouble("sLong")

            Log.d("Start place", start.toString())
        }else{
            Log.d("FAILED ", "NO INTENT")
        }




        return binding.root

//        seoul = LatLng(37.564, 127.001)
//        sydney = LatLng(-33.315, 151.124)



//        // 화면에 지도 띄우기
//        val fm = childFragmentManager
//        val mapFragment = fm.findFragmentById(R.id.character_course_map) as SupportMapFragment
////            ?: MapFragment.newInstance().also {
////                fm.beginTransaction().add(R.id.map_frm, it)
////            }
//        mapFragment.getMapAsync(this)


//
//        // 출발지 도착지 선택
////        binding.courseStartTv.text = onMarkerClick(Seoul)
//
//
//        // 거리 적용 나중에 출발지 선택지 들어갈 예정
//        val str = "${distance(seoul,sydney)} km"
//        binding.characterCourseDistance.text = str

    }

    override fun onResume() {
        super.onResume()

        if (intent.hasExtra("sBundle")){
            val start = LocationData()
            bundle = intent.getBundleExtra("sBundle")!!

            start.id = bundle.getInt("sId")
            start.name = bundle.getString("sName")
            start.latitude = bundle.getDouble("sLat")
            start.longitude = bundle.getDouble("sLong")

            Log.d("Start place", start.toString())
        }else{
            Log.d("FAILED ", "NO INTENT")
        }
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

//    override fun onMapReady(googleMap: GoogleMap) {
//
//        // 구글 지도에 좌표 표시
//        var Seoul = googleMap.addMarker(
//            MarkerOptions()
//                .position(seoul)
//                .title("Seoul")
//                .snippet("in 대한민국")
//        )
//
//        // 구글 지도에 좌표 표시
//        var Sydney = googleMap.addMarker(
//            MarkerOptions()
//                .position(sydney)
//                .title("Sydney")
//                .snippet("in 호주")
//                .icon(
//                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
//        )
//
//        // 핀에 맞춰서 카메라 설정
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))
//
//        googleMap.setOnMarkerClickListener(this)
//
//        googleMap.uiSettings.isZoomControlsEnabled
//    }

//    override fun onMarkerClick(marker: Marker): String {
//
////        var str1: String
//
//        Toast.makeText(
//            requireActivity(),
//            "${marker.title} is clicked",
//            Toast.LENGTH_SHORT
//        ).show()
//
//        var str1 = marker.title
//
//        return str1
//    }

//    override fun onMarkerClick(marker: Marker): Boolean {
//
////        var str1: String
//
//        Toast.makeText(
//            requireActivity(),
//            "${marker.title} is clicked",
//            Toast.LENGTH_SHORT
//        ).show()
//
//        var str1 = marker.title
//
//        return true
//    }


    // 이름 받아오는 함수
//    private fun getMarkerTitle(marker: Marker){
//        var str1 = marker.title
//    }
//    private fun getMarkerCountry(marker: Marker){
//        var str2 = marker.snippet
//    }
//    private fun setMarkerTitle(): String{
//        return str1
//    }
//    private fun setMarkerCountry(): String{
//        return str2
//    }
//

}



