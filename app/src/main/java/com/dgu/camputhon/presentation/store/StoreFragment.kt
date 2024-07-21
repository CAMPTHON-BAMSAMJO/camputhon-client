package com.dgu.camputhon.presentation.store

import android.os.Bundle
import android.view.View
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentStoreBinding
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreFragment : BaseFragment<FragmentStoreBinding>(R.layout.fragment_store) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}