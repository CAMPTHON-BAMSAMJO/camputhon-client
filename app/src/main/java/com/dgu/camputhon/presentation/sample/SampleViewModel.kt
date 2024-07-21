package com.dgu.camputhon.presentation.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgu.camputhon.domain.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val sampleUseCase: SampleUseCase
) : ViewModel() {

    private val _isTestApiSuccess = MutableLiveData<Boolean>()
    val isTestApiSuccess: LiveData<Boolean>
        get() = _isTestApiSuccess

    fun getTest() {
        viewModelScope.launch {
            sampleUseCase().onSuccess {
                _isTestApiSuccess.value = it
                Timber.d("[test] 테스트 api 성공")
            }.onFailure { error ->
                Timber.d("[test] 테스트 api 실패 ${error.message}")
            }
        }
    }
}