package com.example.studentbeansandroidjuniorapplication.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentbeansandroidjuniorapplication.utils.Event
import timber.log.Timber

class LoginViewModel: ViewModel() {

    private val _eventLoginNavigate = MutableLiveData<Event<Boolean>>()
    val eventLoginNavigate: LiveData<Event<Boolean>> = _eventLoginNavigate
    fun onEventLoginNavigate() {
        _eventLoginNavigate.value = Event(true)
    }

    fun validateLogin() {
        Timber.e("validateLogin")
        onEventLoginNavigate()
    }
}