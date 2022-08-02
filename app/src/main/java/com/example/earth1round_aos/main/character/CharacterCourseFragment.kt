package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterCourseBinding
import com.example.earth1round_aos.main.MainActivity
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.lang.Math.cos
import java.lang.Math.sin
import kotlin.math.asin
import kotlin.math.pow
import kotlin.math.sqrt


class CharacterCourseFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    lateinit var binding : FragmentCharacterCourseBinding
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
        seoul = LatLng(37.564, 127.001)
        sydney = LatLng(-33.315, 151.124)


        // 화면에 지도 띄우기
        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.character_course_map) as SupportMapFragment
//            ?: MapFragment.newInstance().also {
//                fm.beginTransaction().add(R.id.map_frm, it)
//            }
        mapFragment.getMapAsync(this)


        // 화면 돌아가기
        binding.characterCourseBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterFragment()).commitAllowingStateLoss()
        }


        // 출발지 도착지 선택
//        binding.courseStartTv.text = onMarkerClick(Seoul)


        // 거리 적용 나중에 출발지 선택지 들어갈 예정
        val str = "${distance(seoul,sydney)} km"
        binding.characterCourseDistance.text = str


        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {

        // 구글 지도에 좌표 표시
        var Seoul = googleMap.addMarker(
            MarkerOptions()
                .position(seoul)
                .title("Seoul")
                .snippet("in 대한민국")
        )

        // 구글 지도에 좌표 표시
        var Sydney = googleMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Sydney")
                .snippet("in 호주")
                .icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        )

        // 핀에 맞춰서 카메라 설정
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))

        googleMap.setOnMarkerClickListener(this)

        googleMap.uiSettings.isZoomControlsEnabled
    }

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

    override fun onMarkerClick(marker: Marker): Boolean {

//        var str1: String

        Toast.makeText(
            requireActivity(),
            "${marker.title} is clicked",
            Toast.LENGTH_SHORT
        ).show()

        var str1 = marker.title

        return true
    }


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

// 출발지점 도착지점 거리 구하는 함수
private fun distance(p1: LatLng, p2: LatLng): Int{
    val r = 6372.8 * 1000
    var dLat = p1.latitude - p2.latitude
    var dLon = p1.longitude - p2.longitude
    val a = sin(dLat / 2).pow(2.0) + sin(dLon / 2).pow(2.0) * cos(Math.toRadians(p1.latitude)) * cos(Math.toRadians(p2.latitude))
    val c = 2 * asin(sqrt(a))
    return (r * c).toInt()
}


