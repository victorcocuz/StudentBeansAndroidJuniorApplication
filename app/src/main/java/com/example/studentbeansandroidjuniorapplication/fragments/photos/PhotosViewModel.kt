package com.example.studentbeansandroidjuniorapplication.fragments.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentbeansandroidjuniorapplication.network.NetworkPhoto
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApi
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus.*
import kotlinx.coroutines.launch
import timber.log.Timber

class PhotosViewModel: ViewModel() {
    private val _status = MutableLiveData<StudentBeansApiStatus>()
    val status: LiveData<StudentBeansApiStatus>
    get() = _status

    private val _photos = MutableLiveData<List<NetworkPhoto>>()
    val photos: LiveData<List<NetworkPhoto>> = _photos

    init {
        Timber.e("init")
        getStudentBeansPhotos()
    }

    private fun getStudentBeansPhotos() {
        viewModelScope.launch {
            _status.value = LOADING
            try {
                _photos.value = StudentBeansApi.retrofitService.getPhotos()
                _status.value = DONE
            } catch (e: java.lang.Exception) {
                _photos.value = ArrayList()
                _status.value = ERROR
                Timber.e("Error: $e")
            }
        }
    }
}