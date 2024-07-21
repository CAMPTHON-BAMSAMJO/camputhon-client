package com.dgu.camputhon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _currentView = MutableLiveData<String>()
    val currentView: LiveData<String>
        get() = _currentView

    fun setCurrentView(view: String) {
        _currentView.value = view
    }

    companion object {
        const val VIEW_LOADING = "LOADING"
        const val VIEW_RESULT = "RESULT"
    }
}