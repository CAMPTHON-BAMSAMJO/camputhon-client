package com.dgu.camputhon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgu.camputhon.domain.usecase.GetUUIDUseCase
import com.dgu.camputhon.domain.usecase.SetUUIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val getUUIDUseCase: GetUUIDUseCase,
    private val setUUIDUseCase: SetUUIDUseCase
) : ViewModel() {

    private val _chooseSexView = MutableLiveData<Boolean>(false)
    val chooseSexView: LiveData<Boolean>
        get() = _chooseSexView

    private val _chooseSex = MutableLiveData<String>("")
    val chooseSex: LiveData<String>
        get() = _chooseSex

    private val _storedUserUUID = MutableLiveData<String>()
    val storedUserUUID: LiveData<String>
        get() = _storedUserUUID

    fun clickChooseSexView() {
        _chooseSexView.value = true
    }

    fun chooseSex(sex: String) {
        _chooseSex.value = sex
    }

    fun setStoredUserUUID(uuid: String) {
        viewModelScope.launch {
            setUUIDUseCase(uuid)
        }
    }

    fun getStoredUserUUID() {
        viewModelScope.launch {
            getUUIDUseCase().uuid.let { uuid ->
                _storedUserUUID.value = uuid
            }
        }
    }

    companion object {
        const val SEX_MEN = "MALE"
        const val SEX_WOMEN = "FEMALE"
    }
}