package com.dgu.camputhon.presentation.plus

import android.os.Bundle
import android.view.View
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentPlusBinding
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlusFragment : BaseFragment<FragmentPlusBinding>(R.layout.fragment_plus) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}