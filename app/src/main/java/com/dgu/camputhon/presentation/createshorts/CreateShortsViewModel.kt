package com.dgu.camputhon.presentation.createshorts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class CreateShortsViewModel: ViewModel() {

    private val _selectedDay = MutableLiveData<String>("")
    val selectedDay: LiveData<String>
        get() = _selectedDay

    fun getSelectedDay(day: String) {
        _selectedDay.value = day
        Timber.d("[숏폼 생성] 제작: 요일 -> $day")
    }

    companion object {
        const val MON = "월"
        const val TUES = "화"
        const val WED = "수"
        const val THURS = "목"
        const val FRI = "금"
    }
}