package com.dgu.camputhon.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgu.camputhon.domain.entity.HomeItem
import com.dgu.camputhon.domain.usecase.GetHomeUseCase
import com.dgu.camputhon.domain.usecase.GetUserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase,
    private val getUserIdUseCase: GetUserIdUseCase
): ViewModel() {

    private val _homeData = MutableLiveData<HomeItem>()
    val homeData: LiveData<HomeItem>
        get() = _homeData

    fun getHomeAPIData() {
        viewModelScope.launch {
            getUserIdUseCase().userId?.let {userId ->
                getHomeUseCase(userId).onSuccess { homeData ->
                    _homeData.value = homeData
                    Timber.d("[서버통신] 홈 뷰 성공 -> $homeData")
                }.onFailure { error ->
                    Timber.d("[서버통신] 홈 뷰 실패 -> ${error.message}")
                }
            }
        }
    }
}