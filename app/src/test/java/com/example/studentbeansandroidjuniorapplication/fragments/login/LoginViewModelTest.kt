package com.example.studentbeansandroidjuniorapplication.fragments.login

import com.example.studentbeansandroidjuniorapplication.domain.isCompleted
import org.junit.Test
import com.google.common.truth.Truth.assertThat


internal class LoginViewModelTest {
    private val loginVm = LoginViewModel()

    @Test
    fun validate_login_user_or_password_empty_returns_false_to_is_completed() {
        loginVm.apply {
            onEmailChanged("random.user@yahoo.com", 0, 0, 0)
            onPasswordChanged("", 0, 0,0)
            assertThat(userLogin.value!!.isCompleted()).isEqualTo(false)

            onEmailChanged("", 0, 0, 0)
            onPasswordChanged("pass", 0, 0,0)
            assertThat(userLogin.value!!.isCompleted()).isEqualTo(false)
        }
    }

    @Test
    fun validate_login_user_password_completed_returns_true_to_is_completed() {
        loginVm.apply {
            onEmailChanged("random.user@yahoo.com", 0, 0, 0)
            onPasswordChanged("pass", 0, 0,0)
            assertThat(userLogin.value!!.isCompleted()).isEqualTo(true)
        }
    }
}