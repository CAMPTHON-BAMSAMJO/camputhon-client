package com.dgu.camputhon.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dgu.camputhon.R
import com.dgu.camputhon.databinding.ActivityMainBinding
import com.dgu.camputhon.presentation.home.HomeFragment
import com.dgu.camputhon.presentation.createshorts.CreateShortsFragment
import com.dgu.camputhon.presentation.store.StoreFragment
import com.dgu.camputhon.util.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragment()
        initBottomNavigation()
        setBottomNavigationClickListener()
    }

    private fun setBottomNavigationClickListener() {
        binding.bnvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_navigation_plus -> changeFragment(CreateShortsFragment())
                R.id.bottom_navigation_home -> changeFragment(HomeFragment())
                R.id.bottom_navigation_store -> changeFragment(StoreFragment())
                else -> true
            }
        }
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_main, HomeFragment()).commit()
        }
    }

    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
        return true
    }

    private fun initBottomNavigation() {
        binding.bnvMain.selectedItemId = R.id.bottom_navigation_home
        binding.bnvMain.itemIconTintList = null
    }
}