package com.example.studentbeansandroidjuniorapplication.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentbeansandroidjuniorapplication.domain.DomainUserLogin
import com.example.studentbeansandroidjuniorapplication.domain.isCompleted
import com.example.studentbeansandroidjuniorapplication.utils.Event
import com.example.studentbeansandroidjuniorapplication.utils.StudentBeansAction
import com.example.studentbeansandroidjuniorapplication.utils.StudentBeansAction.*
import timber.log.Timber

class LoginViewModel : ViewModel() {

    private val _eventLoginNavigate = MutableLiveData<Event<StudentBeansAction>>()
    val eventLoginNavigate: LiveData<Event<StudentBeansAction>> = _eventLoginNavigate
    private fun onEventLoginNavigate(action: StudentBeansAction) {
        Timber.i("onEventLoginNavigate action: $action")
        _eventLoginNavigate.value = Event(action)
    }

    private var _userLogin = MutableLiveData(DomainUserLogin("", ""))
    var userLogin: LiveData<DomainUserLogin> = _userLogin

    fun onEmailChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        Timber.i("onEmailChanged $s")
        _userLogin.value!!.userName = s.toString()
    }

    fun onPasswordChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        Timber.i("onPasswordChanged $s")
        _userLogin.value!!.userPassword = s.toString()
    }

    fun validateLogin() {
        onEventLoginNavigate(if (_userLogin.value!!.isCompleted()) NAVIGATE_PHOTOS else TOAST_EMPTY)
    }
}