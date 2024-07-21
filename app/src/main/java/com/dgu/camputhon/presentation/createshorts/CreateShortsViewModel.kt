package com.dgu.camputhon.presentation.createshorts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dgu.camputhon.domain.entity.SelectActivity
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

    private val _activityList: MutableLiveData<ArrayList<SelectActivity>> =
        MutableLiveData(
            arrayListOf(
                SelectActivity("수면"),
                SelectActivity("과제"),
                SelectActivity("운동"),
                SelectActivity("명상"),
                SelectActivity("밥"),
                SelectActivity("수다"),
                SelectActivity("데이트"),
                SelectActivity("팀플"),
                SelectActivity("독서"),
                SelectActivity("영화관람"),
                SelectActivity("전시관람"),
                SelectActivity("개발"),
                SelectActivity("연구"),
                SelectActivity("산책"),

            )
        )

    val activityList: LiveData<ArrayList<SelectActivity>>
        get() = _activityList

    private val _selectedDay = MutableLiveData<String>("")
    val selectedDay: LiveData<String>
        get() = _selectedDay

    private val _selectedStartTime = MutableLiveData<String>()
    val selectedStartTime: LiveData<String>
        get() = _selectedStartTime

    private val _selectedEndTime = MutableLiveData<String>()
    val selectedEndTime: LiveData<String>
        get() = _selectedEndTime

    private val _selectedLocation = MutableLiveData<String>()
    val selectedLocation: LiveData<String>
        get() = _selectedLocation

    private val _selectedActivity = MutableLiveData<String>()
    val selectedActivity: LiveData<String>
        get() = _selectedActivity

    val contents = MutableLiveData<String>()

    fun getSelectedDay(day: String) {
        _selectedDay.value = day
        Timber.d("[숏폼 생성] 제작: 요일 -> $day")
    }

    fun setSelectedStartTime(time: String) {
        Timber.d("[숏폼 생성] 제작 시작시간 바텀시트 테스트 -> $time")
        _selectedStartTime.value = time
    }

    fun countTime(ampm: Int, hour: Int, minute: Int): String {
        var resultTime = ""
        var newMinute = String.format("%02d", minute)

        if (ampm == 1) {
            resultTime = "${hour+12}:$newMinute"
        } else {
            var newHour = String.format("%02d", hour)
            resultTime = "$newHour:$newMinute"
        }

        return resultTime
    }

    fun setSelectedEndTime(time: String) {
        Timber.d("[숏폼 생성] 제작 종료시간 바텀시트 테스트 -> $time")
        _selectedEndTime.value = time
    }

    fun setSelectedLocation(location: String) {
        Timber.d("[숏폼 생성] 제작 장소 바텀시트 테스트 -> $location")
        _selectedLocation.value = location
    }

    fun setSelectedActivity(activity: String) {
        Timber.d("[숏폼 생성] 제작 활동 바텀시트 테스트 -> $activity")
        _selectedActivity.value = activity
    }

    fun createShorts(contents: String) {
        // TODO 영상 생성하기 서버통신
        Timber.d("[숏폼 생성] 제작 테스트 -> 장소: ${selectedLocation.value} // 활동: ${selectedActivity.value} //  일기: $contents")
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