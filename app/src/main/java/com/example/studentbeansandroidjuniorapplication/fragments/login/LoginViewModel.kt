package com.example.studentbeansandroidjuniorapplication.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentbeansandroidjuniorapplication.domain.DomainUserLogin
import com.example.studentbeansandroidjuniorapplication.domain.isCompleted
import com.example.studentbeansandroidjuniorapplication.utils.Event
import com.example.studentbeansandroidjuniorapplication.utils.StudentBeansAction
import com.example.studentbeansandroidjuniorapplication.utils.StudentBeansAction.*

class LoginViewModel: ViewModel() {

    private val _eventLoginNavigate = MutableLiveData<Event<StudentBeansAction>>()
    val eventLoginNavigate: LiveData<Event<StudentBeansAction>> = _eventLoginNavigate
    private fun onEventLoginNavigate(action: StudentBeansAction) {
        _eventLoginNavigate.value = Event(action)
    }

    private var _userLogin = MutableLiveData(DomainUserLogin("", ""))

    fun onEmailChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _userLogin.value!!.userName = s.toString()
    }

    fun onPasswordChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _userLogin.value!!.userPassword = s.toString()
    }

    fun validateLogin() {
        onEventLoginNavigate(if (_userLogin.value!!.isCompleted()) NAVIGATE_PHOTOS else TOAST_EMPTY)
    }
}