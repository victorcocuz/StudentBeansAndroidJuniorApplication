package com.example.studentbeansandroidjuniorapplication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

enum class StudentBeansApiStatus { LOADING, ERROR, DONE }

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StudentBeansApiService {
    @GET("photos")
    suspend fun getPhotos(): List<NetworkPhoto>
}

object StudentBeansApi {
    val retrofitService: StudentBeansApiService by lazy {
        retrofit.create(StudentBeansApiService::class.java)
    }
}