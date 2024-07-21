package com.dgu.camputhon.presentation.createshorts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dgu.camputhon.domain.entity.SelectLocation
import timber.log.Timber

class CreateShortsViewModel: ViewModel() {

    private val _locationList: MutableLiveData<ArrayList<SelectLocation>> =
        MutableLiveData(
            arrayListOf(
                SelectLocation("카페"),
                SelectLocation("식당"),
                SelectLocation("도서관"),
                SelectLocation("휴식공간"),
                SelectLocation("과방동방"),
                SelectLocation("헬스장"),
                SelectLocation("영화관"),
                SelectLocation("강의실"),
                SelectLocation("연구실"),
                SelectLocation("야외"),
                SelectLocation("벤치"),
            )
        )

    val locationList: LiveData<ArrayList<SelectLocation>>
        get() = _locationList

    private val _selectedDay = MutableLiveData<String>("")
    val selectedDay: LiveData<String>
        get() = _selectedDay

    private val _selectedLanguage = MutableLiveData<String>()
    val selectedLanguage: LiveData<String>
        get() = _selectedLanguage

    val contents = MutableLiveData<String>()

    fun getSelectedDay(day: String) {
        _selectedDay.value = day
        Timber.d("[숏폼 생성] 제작: 요일 -> $day")
    }

    fun setSelectedLocation(location: String) {
        _selectedLanguage.value = location
    }

    fun createShorts(contents: String) {
        // TODO 영상 생성하기 서버통신
        Timber.d("[숏폼 생성] 제작 테스트 -> 장소: ${selectedLanguage.value}  일기: $contents")
    }

    companion object {
        const val MON = "월"
        const val TUES = "화"
        const val WED = "수"
        const val THURS = "목"
        const val FRI = "금"

        const val BOTTOM_SHEET = "BOTTOM_SHEET"
    }
}