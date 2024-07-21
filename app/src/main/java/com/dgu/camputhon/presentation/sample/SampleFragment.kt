package com.dgu.camputhon.presentation.sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentSampleBinding
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding>(R.layout.fragment_sample) {

    private val viewModel by viewModels<SampleViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        initTestApi()
    }

    private fun initTestApi() {
        viewModel.getTest()
    }
}