package com.example.studentbeansandroidjuniorapplication.network

import com.example.studentbeansandroidjuniorapplication.database.DbPhoto

data class NetworkPhoto(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

fun List<NetworkPhoto>.asDatabaseModel(): Array<DbPhoto> {
    return map {
        DbPhoto (
            albumId = it.albumId,
            id = it.id,
            url = it.url,
            title = it.title,
            thumbnailUrl = it.thumbnailUrl)
    }.toTypedArray()
}