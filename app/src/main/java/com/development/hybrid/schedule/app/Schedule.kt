package com.development.hybrid.schedule.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class Schedule: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
    }
}