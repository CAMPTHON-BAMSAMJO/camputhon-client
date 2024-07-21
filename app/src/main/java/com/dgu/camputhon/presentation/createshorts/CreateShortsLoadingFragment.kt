package com.dgu.camputhon.presentation.createshorts

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.activityViewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentCreateShortsLoadingBinding
import com.dgu.camputhon.presentation.MainViewModel
import com.dgu.camputhon.presentation.MainViewModel.Companion.VIEW_RESULT
import com.dgu.camputhon.presentation.SplashActivity
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateShortsLoadingFragment: BaseFragment<FragmentCreateShortsLoadingBinding>(R.layout.fragment_create_shorts_loading) {

    private val viewModel by activityViewModels<CreateShortsViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createAndWaitShorts()
        checkGetUrl()
    }

    private fun createAndWaitShorts() {
        viewModel.createShorts(viewModel.contents.value ?: "")
    }

    private fun checkGetUrl() {
        viewModel.createShortsUrl.observe(viewLifecycleOwner) {
            mainViewModel.setCurrentView(VIEW_RESULT)
        }

//        Handler(Looper.getMainLooper()).postDelayed({
//            mainViewModel.setCurrentView(VIEW_RESULT)
//        }, LOADING_DELAY)
    }

    companion object {
        const val LOADING_DELAY = 60000L
    }
}