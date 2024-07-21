package com.dgu.camputhon.presentation.createshorts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.FragmentCreateShortsBinding
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel.Companion.BOTTOM_SHEET
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel.Companion.FRI
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel.Companion.MON
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel.Companion.THURS
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel.Companion.TUES
import com.dgu.camputhon.presentation.createshorts.CreateShortsViewModel.Companion.WED
import com.dgu.camputhon.presentation.createshorts.activity.SelectActivityBottomSheet
import com.dgu.camputhon.presentation.createshorts.location.SelectLocationBottomSheet
import com.dgu.camputhon.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateShortsFragment :
    BaseFragment<FragmentCreateShortsBinding>(R.layout.fragment_create_shorts) {

    private val viewModel by viewModels<CreateShortsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        selectDay()
        selectLocation()
        selectActivity()
        clickCreateShortsBtn()
    }

    private fun selectDay() {
        binding.tvCreateDayMon.setOnClickListener {
            viewModel.getSelectedDay(MON)
        }
        binding.tvCreateDayTues.setOnClickListener {
            viewModel.getSelectedDay(TUES)
        }
        binding.tvCreateDayWed.setOnClickListener {
            viewModel.getSelectedDay(WED)
        }
        binding.tvCreateDayThurs.setOnClickListener {
            viewModel.getSelectedDay(THURS)
        }
        binding.tvCreateDayFri.setOnClickListener {
            viewModel.getSelectedDay(FRI)
        }
    }

    private fun selectLocation() {
        binding.tvCreateShortsLocationInput.setOnClickListener {
            SelectLocationBottomSheet().show(parentFragmentManager, BOTTOM_SHEET)
        }
    }

    private fun selectActivity() {
        binding.tvCreateShortsActivityInput.setOnClickListener {
            SelectActivityBottomSheet().show(parentFragmentManager, BOTTOM_SHEET)
        }
    }

    private fun clickCreateShortsBtn() {
        binding.btnCreateShorts.setOnClickListener {
            viewModel.createShorts(viewModel.contents.value ?: "")
        }
    }
}