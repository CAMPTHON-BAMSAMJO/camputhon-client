package com.dgu.camputhon.presentation.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgu.camputhon.domain.entity.StoredShortsItem
import com.dgu.camputhon.domain.usecase.GetShortsUseCase
import com.dgu.camputhon.domain.usecase.GetUserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getShortsUseCase: GetShortsUseCase,
    private val getUserIdUseCase: GetUserIdUseCase
): ViewModel() {

    private val _storedShortsList = MutableLiveData<List<StoredShortsItem>>()
    val storedShortsList: LiveData<List<StoredShortsItem>>
        get() = _storedShortsList

    fun getShortsItem() {
        viewModelScope.launch {
            getUserIdUseCase().userId?.let { userId ->
                getShortsUseCase(userId).onSuccess { list ->
                    _storedShortsList.value = list
                    Timber.d("[서버통신] 숏폼 저장 성공 -> $list")
                }.onFailure {  error ->
                    Timber.d("[서버통신] 숏폼 저장 실패 -> $error")
                }
            }
        }
    }
}