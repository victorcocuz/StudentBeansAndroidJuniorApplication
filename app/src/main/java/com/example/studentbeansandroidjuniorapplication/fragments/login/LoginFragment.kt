package com.example.studentbeansandroidjuniorapplication.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.studentbeansandroidjuniorapplication.R
import com.example.studentbeansandroidjuniorapplication.databinding.FragmentLoginBinding
import com.example.studentbeansandroidjuniorapplication.utils.EventObserver
import com.example.studentbeansandroidjuniorapplication.utils.StudentBeansAction.*
import com.example.studentbeansandroidjuniorapplication.utils.navigate
import com.example.studentbeansandroidjuniorapplication.utils.toast

class LoginFragment : Fragment() {
    private val loginVm: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            varLoginVm = this@LoginFragment.loginVm
        }

        loginVm.eventLoginNavigate.observe(viewLifecycleOwner, EventObserver {  action ->
            when (action) {
                NAVIGATE_PHOTOS -> navigate(LoginFragmentDirections.navToPhotosFragment())
                TOAST_EMPTY -> toast(getString(R.string.f_login_toast_user_or_pass_empty))
            }
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}