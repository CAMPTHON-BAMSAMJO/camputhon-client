package com.dgu.camputhon.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ActivityOnboardingBinding
import com.dgu.camputhon.presentation.OnboardingViewModel.Companion.SEX_MEN
import com.dgu.camputhon.presentation.OnboardingViewModel.Companion.SEX_WOMEN
import com.dgu.camputhon.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>(R.layout.activity_onboarding) {

    private val viewModel by viewModels<OnboardingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        clickChooseSexBtn()
        chooseSex()
    }

    private fun clickChooseSexBtn() {
        binding.btnOnboardingChooseSex.setOnClickListener {
            viewModel.clickChooseSexView()
        }
    }

    private fun chooseSex() {
        binding.tvOnboardingSexMen.setOnClickListener {
            viewModel.chooseSex(SEX_MEN)
        }
        binding.tvOnboardingSexWomen.setOnClickListener {
            viewModel.chooseSex(SEX_WOMEN)
        }

        viewModel.chooseSex.observe(this) {
            Timber.d("클릭 성별 -> $it")
        }
    }
}