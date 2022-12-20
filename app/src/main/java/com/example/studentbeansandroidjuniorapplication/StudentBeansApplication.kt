package com.example.studentbeansandroidjuniorapplication

import android.app.Application
import timber.log.Timber

class StudentBeansApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i(getString(R.string.helper_first_line))
    }
}