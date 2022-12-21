package com.example.studentbeansandroidjuniorapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentBeansDatabaseDao {
    @Query("SELECT * FROM DbPhoto")
    fun getPhotos(): LiveData<List<DbPhoto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg photos: DbPhoto)
}