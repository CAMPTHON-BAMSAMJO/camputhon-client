package com.dgu.camputhon.presentation

import android.os.Bundle
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ActivityMainBinding
import com.dgu.camputhon.presentation.sample.SampleFragment
import com.dgu.camputhon.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragment()
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main_test)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_main_test, SampleFragment()).commit()
        }
    }
}