package com.dgu.camputhon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgu.camputhon.domain.usecase.GetUserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userIdUseCase: GetUserIdUseCase): ViewModel() {

    private val _isAppFirst = MutableLiveData<Boolean>()
    val isAppFirst: LiveData<Boolean>
        get() = _isAppFirst

    fun checkAppFirst() {
        viewModelScope.launch {
            _isAppFirst.value = userIdUseCase().userId == null
            Timber.d("[온보딩] 스플래시 -> 앱 처음 진입인지: ${userIdUseCase().userId.toString()} // ${userIdUseCase().userId == null}")
        }
    }

}