package com.dgu.camputhon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel : ViewModel() {

    private val _chooseSexView = MutableLiveData<Boolean>(false)
    val chooseSexView: LiveData<Boolean>
        get() = _chooseSexView

    private val _chooseSex = MutableLiveData<String>("")
    val chooseSex: LiveData<String>
        get() = _chooseSex

    fun clickChooseSexView() {
        _chooseSexView.value = true
    }

    fun chooseSex(sex: String) {
        _chooseSex.value = sex
    }

    companion object {
        const val SEX_MEN = "MALE"
        const val SEX_WOMEN = "FEMALE"
    }
}