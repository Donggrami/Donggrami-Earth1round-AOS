package com.example.donggrami.main.character

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earth1round_aos.R
import com.example.earth1round_aos.databinding.FragmentCharacterCalenderBinding
import com.example.earth1round_aos.main.character.CharacterCalenderAdapter
import com.example.earth1round_aos.main.character.CharacterCalenderUtil
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class CharacterCalenderActivity : AppCompatActivity() {

    private lateinit var binding: FragmentCharacterCalenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_character_calender)

        //binding 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_character_calender)

        //화면 돌아가기
        binding.characterCalenderBackIv.setOnClickListener {
            finish()
        }

        //현재 날짜
        CharacterCalenderUtil.selectedDate = LocalDate.now()

        //화면 설정
        setMonthView()

        //이전달 버튼 이벤트
        binding.characterCalenderLeftIb.setOnClickListener {
            //현재 월 -1 변수에 담기
            CharacterCalenderUtil.selectedDate = CharacterCalenderUtil.selectedDate.minusMonths(1)
            setMonthView()
        }

        //다음달 이벤트
        binding.characterCalenderRightIb.setOnClickListener {
            CharacterCalenderUtil.selectedDate = CharacterCalenderUtil.selectedDate.plusMonths(1)
            setMonthView()
        }
    }

    //날짜 화면에 보여주기
    private fun setMonthView() {
        //년월 텍스트뷰 세팅
        binding.characterCalenderMonthTv.text = monthYearFromDate(CharacterCalenderUtil.selectedDate)

        //날짜 생성해서 리스트 담기
        val dayList = dayInMonthArray(CharacterCalenderUtil.selectedDate)

        //어댑터 초기화
        val adapter = CharacterCalenderAdapter(dayList)

        //레이아웃 설정(열 7개)
        var manager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 7)

        //레이아웃 적용
        binding.characterCalenderRv.layoutManager = manager

        //어댑터 적용
        binding.characterCalenderRv.adapter = adapter
    }

    //날짜 타입 설정
    private fun monthYearFromDate(date: LocalDate): String{

        var formatter = DateTimeFormatter.ofPattern("MM월 yyyy")

        //받아온 날짜를 해당 포맷으로 변경
        return date.format(formatter)
    }

    //날짜 생성
    private fun dayInMonthArray(date: LocalDate): ArrayList<String>{

        var dayList = ArrayList<String>()

        var yearMonth = YearMonth.from(date)

        //해당 월 마지막 날짜 가져오기(예: 28, 30, 31)
        var lastDay = yearMonth.lengthOfMonth()

        //해당 월의 첫번째 날 가져오기(예: 4월 1일)
        var firstDay = CharacterCalenderUtil.selectedDate.withDayOfMonth(1)

        //첫 번째 날 요일 가져오기 (월:1, 일:7)
        var dayOfWeek = firstDay.dayOfWeek.value

        for(i in 1..41){
            if (i <= dayOfWeek || i > (lastDay + dayOfWeek)){
                dayList.add("")
            }else{
                dayList.add((i - dayOfWeek).toString())
            }
        }

        return dayList
    }


}