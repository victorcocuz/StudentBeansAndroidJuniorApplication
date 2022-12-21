package com.example.studentbeansandroidjuniorapplication.fragments.photos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus.*
import com.example.studentbeansandroidjuniorapplication.repository.StudentBeansRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class PhotosViewModel(
    app: Application,
    private val studentBeansRepository: StudentBeansRepository,
) : AndroidViewModel(app) {

    private val _status = MutableLiveData<StudentBeansApiStatus>()
    val status: LiveData<StudentBeansApiStatus>
        get() = _status

    init {
        viewModelScope.launch {
            _status.value = LOADING
            if (studentBeansRepository.refreshPhotos().isEmpty()) _status.value = ERROR
            else _status.value = DONE
        }
    }

    val photos = studentBeansRepository.photos
}