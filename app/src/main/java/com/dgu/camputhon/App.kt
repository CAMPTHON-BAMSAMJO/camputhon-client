package com.dgu.camputhon

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.util.UUID

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        Timber.d("키 해시 -> ${Utility.getKeyHash(this)}")
//        Timber.d("키 해시 uuid -> ${UUID.randomUUID().toString()}")

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}