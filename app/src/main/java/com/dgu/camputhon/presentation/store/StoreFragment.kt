package com.dgu.camputhon.presentation.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.BottomsheetSelectActivityBinding
import com.dgu.camputhon.databinding.FragmentStoreBinding
import com.dgu.camputhon.presentation.createshorts.activity.SelectActivityAdapter
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreFragment : BaseFragment<FragmentStoreBinding>(R.layout.fragment_store) {

    private val viewModel by viewModels<StoreViewModel>()

    private var _storeShortsAdapter: StoreShortsAdapter? = null
    private val storeShortsAdapter
        get() = requireNotNull(_storeShortsAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getShortsItem()

        initSetAdapter()
        initSetShortsList()
    }

    private fun initSetAdapter() {
        _storeShortsAdapter = StoreShortsAdapter(requireContext(), requireActivity())
        binding.rcvStore.adapter = storeShortsAdapter
    }

    private fun initSetShortsList() {
        viewModel.storedShortsList.observe(viewLifecycleOwner) {
            storeShortsAdapter.submitList(it)
        }
    }
}