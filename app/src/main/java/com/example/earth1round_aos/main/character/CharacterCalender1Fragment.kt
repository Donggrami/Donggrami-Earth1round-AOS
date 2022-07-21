package com.example.earth1round_aos.main.character

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterCalender1Binding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CharacterCalender1Fragment : AppCompatActivity() {

        private lateinit var binding: FragmentCharacterCalender1Binding

        //년월 변수
        lateinit var selectedDate: LocalDate

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_character_calender_1)

            //binding 초기화
            binding = DataBindingUtil.setContentView(this, R.layout.fragment_character_calender_1)

            //현재 날짜
            selectedDate = LocalDate.now()

            //화면 설정
            setMonthView()

            //이전달 버튼 이벤트
            binding.characterJustCalenderLeftIb.setOnClickListener {
                //현재 월 -1 변수에 담기
                selectedDate = selectedDate.minusMonths(1)
                setMonthView()
            }

            //다음달 이벤트
            binding.characterJustCalenderRightIb.setOnClickListener {
                selectedDate = selectedDate.plusMonths(1)
                setMonthView()
            }
        }

        //날짜 화면에 보여주기
        private fun setMonthView() {
            //년월 텍스트뷰 세팅
            binding.characterJustCalenderMonthTv.text = monthYearFromDate(selectedDate)
        }

        //날짜 타입 설정
        private fun monthYearFromDate(date: LocalDate): String{

            var formatter = DateTimeFormatter.ofPattern("MM월 yyyy")

            //받아온 날짜를 해당 포맷으로 변경
            return date.format(formatter)
        }
}