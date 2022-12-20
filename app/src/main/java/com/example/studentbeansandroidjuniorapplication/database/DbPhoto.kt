package com.example.studentbeansandroidjuniorapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.studentbeansandroidjuniorapplication.domain.DomainPhoto

@Entity
data class DbPhoto (
    @PrimaryKey
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

fun List<DbPhoto>.asDomainModel(): List<DomainPhoto> {
    return map {
        DomainPhoto (
            albumId = it.albumId,
            id = it.id,
            title = it.title,
            url = it.url,
            thumbnailUrl = it.thumbnailUrl)
    }
}