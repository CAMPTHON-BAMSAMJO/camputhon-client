package com.dgu.camputhon.presentation.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentStoreBinding
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreFragment : BaseFragment<FragmentStoreBinding>(R.layout.fragment_store) {

    private val viewModel by viewModels<StoreViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getShortsItem()
    }
}