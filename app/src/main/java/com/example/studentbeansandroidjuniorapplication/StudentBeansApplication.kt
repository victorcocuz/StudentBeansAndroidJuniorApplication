package com.example.studentbeansandroidjuniorapplication

import android.app.Application
import android.content.Context
import com.example.studentbeansandroidjuniorapplication.database.StudentBeansDatabase
import com.example.studentbeansandroidjuniorapplication.repository.StudentBeansRepository
import timber.log.Timber

class StudentBeansApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: StudentBeansApplication? = null
        private fun applicationContext(): Context = instance!!.applicationContext
        fun application(): Application = instance!!
        fun getStudentBeansRepository() = StudentBeansRepository(StudentBeansDatabase.getDatabase(applicationContext()))
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i(getString(R.string.helper_first_line))
    }
}