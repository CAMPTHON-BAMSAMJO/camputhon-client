package com.dgu.camputhon.presentation.home

import android.os.Bundle
import android.view.View
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentHomeBinding
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}