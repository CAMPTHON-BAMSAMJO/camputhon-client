package com.dgu.camputhon.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ActivitySplashBinding
import com.dgu.camputhon.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.checkAppFirst()
        setSplash()
    }

    private fun setSplash() {

        Handler(Looper.getMainLooper()).postDelayed({
            if (viewModel.isAppFirst.value == true) {
                startOnboarding()
            } else {
                startLogIn()
            }
        }, SPLASH_DELAY)
    }

    private fun startOnboarding() {
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startLogIn() {
        val intent = Intent(this, StartAppActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val SPLASH_DELAY = 3000L
    }
}