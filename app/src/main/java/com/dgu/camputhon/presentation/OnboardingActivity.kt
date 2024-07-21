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
import java.util.UUID

@AndroidEntryPoint
class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>(R.layout.activity_onboarding) {

    private val viewModel by viewModels<OnboardingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        viewModel.getStoredUserUUID()

        initCheckIsAppFirst()
        clickChooseSexBtn()
        chooseSex()
    }

    private fun initCheckIsAppFirst() {
        viewModel.storedUserUUID.observe(this) { storedUserUUID ->
            Timber.d("[온보딩] uuid 저장 -> ${viewModel.storedUserUUID.value}")
            if (storedUserUUID.isNullOrBlank()) {
                val uuid = UUID.randomUUID().toString()
                Timber.d("[온보딩] 처음 uuid -> $uuid")
                viewModel.setStoredUserUUID(uuid)
            }
        }
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
    }
}