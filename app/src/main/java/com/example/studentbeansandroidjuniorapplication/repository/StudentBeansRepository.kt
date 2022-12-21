package com.example.studentbeansandroidjuniorapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.studentbeansandroidjuniorapplication.database.StudentBeansDatabase
import com.example.studentbeansandroidjuniorapplication.database.asDomainModel
import com.example.studentbeansandroidjuniorapplication.domain.DomainPhoto
import com.example.studentbeansandroidjuniorapplication.network.NetworkPhoto
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApi
import com.example.studentbeansandroidjuniorapplication.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class StudentBeansRepository(private val database: StudentBeansDatabase) {
    val photos: LiveData<List<DomainPhoto>> = Transformations.map(database.studentBeansDatabaseDao.getPhotos()) {
        it.asDomainModel()
    }

    suspend fun refreshPhotos(): List<NetworkPhoto> {
        return withContext(Dispatchers.IO) {
            val photos = fetchStudentBeansPhotos()
            database.studentBeansDatabaseDao.insertAll(*photos.asDatabaseModel())
            return@withContext photos
        }
    }

    private suspend fun fetchStudentBeansPhotos(): List<NetworkPhoto> {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext StudentBeansApi.retrofitService.getPhotos()
            } catch (e: java.lang.Exception) {
                Timber.e("Error: $e")
                return@withContext ArrayList()
            }
        }
    }
}