package com.dgu.camputhon.presentation

import android.content.Intent
import android.os.Bundle
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ActivityStartAppBinding
import com.dgu.camputhon.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartAppActivity : BaseActivity<ActivityStartAppBinding>(R.layout.activity_start_app) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clickStartBtn()
    }

    private fun clickStartBtn() {
        binding.btnStartApp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}