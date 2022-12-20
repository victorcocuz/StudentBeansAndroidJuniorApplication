package com.example.studentbeansandroidjuniorapplication.utils

import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.studentbeansandroidjuniorapplication.StudentBeansApplication
import com.example.studentbeansandroidjuniorapplication.fragments.login.LoginViewModel
import com.example.studentbeansandroidjuniorapplication.fragments.photos.PhotosViewModel

class ViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel() as T
        }
        if (modelClass.isAssignableFrom(PhotosViewModel::class.java)) {
            return PhotosViewModel(StudentBeansApplication.application(), StudentBeansApplication.getStudentBeansRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}