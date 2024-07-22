package com.dgu.camputhon.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentShortsResultBinding
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShortsResultFragment : BaseFragment<FragmentShortsResultBinding>(R.layout.fragment_shorts_result) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}