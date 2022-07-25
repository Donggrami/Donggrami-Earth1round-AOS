package com.example.donggrami.main.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterCourseBinding
import com.example.earth1round_aos.main.MainActivity
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class CharacterCourseFragment : Fragment(), OnMapReadyCallback {

    lateinit var binding : FragmentCharacterCourseBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterCourseBinding.inflate(inflater, container, false)

        // 화면에 지도 띄우기
        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.character_course_map) as SupportMapFragment
//            ?: MapFragment.newInstance().also {
//                fm.beginTransaction().add(R.id.map_frm, it)
//            }
        mapFragment.getMapAsync(this)


        //화면 돌아가기
        binding.characterCourseBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id. main_frm, CharacterFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // 서울 좌표
        val seoul = LatLng(37.564, 127.001)

        // 구글 지도에 좌표 표시
        googleMap.addMarker(
            MarkerOptions()
                .position(seoul)
                .title("Marker in Seoul")
        )

        // 핀에 맞춰서 카메라 설정
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))
    }

}

// 출발지점 도착지점 거리 구하는 함수
private fun distance(p1: LatLng, p2: LatLng){

}


