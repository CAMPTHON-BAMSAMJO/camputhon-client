package com.dgu.camputhon.presentation.createshorts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgu.camputhon.domain.entity.SelectActivity
import com.dgu.camputhon.domain.entity.SelectLocation
import com.dgu.camputhon.domain.usecase.GetUserIdUseCase
import com.dgu.camputhon.domain.usecase.PostShortsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CreateShortsViewModel @Inject constructor(
    private val postShortsUseCase: PostShortsUseCase,
    private val getUserIdUseCase: GetUserIdUseCase
) : ViewModel() {

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
                SelectActivity("과제"),
                SelectActivity("운동"),
                SelectActivity("밥"),
                SelectActivity("수다"),
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

    private val _createShortsUrl = MutableLiveData<String>()
    val createShortsUrl: LiveData<String>
        get() = _createShortsUrl

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
            resultTime = "${hour + 12}:$newMinute"
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
        Timber.d("[숏폼 생성] 제작 테스트 -> 요일: ${selectedDay.value} // 시간: ${selectedStartTime.value} - ${selectedEndTime.value} // 장소: ${selectedLocation.value} // 활동: ${selectedActivity.value} //  일기: $contents")
        viewModelScope.launch {
            getUserIdUseCase().userId?.let { userId ->
                postShortsUseCase(
                    userId,
                    selectedDay.value ?: "",
                    selectedStartTime.value ?: "",
                    selectedEndTime.value ?: "",
                    selectedActivity.value ?: "",
                    selectedLocation.value ?: "",
                    contents
                ).onSuccess {
                    _createShortsUrl.value = it.shortsUrl
                    Timber.d("[서버통신] 숏폼 생성 성공")
                }.onFailure { error ->
                    Timber.d("[서버통신] 숏폼 생성 실패 -> ${error.message}")
                }
            }
        }
    }

    companion object {
        const val MON = "월요일"
        const val TUES = "화요일"
        const val WED = "수요일"
        const val THURS = "목요일"
        const val FRI = "금요일"

        const val BOTTOM_SHEET = "BOTTOM_SHEET"
    }
}