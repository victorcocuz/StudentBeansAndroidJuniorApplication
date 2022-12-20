package com.example.studentbeansandroidjuniorapplication.domain

data class DomainUserLogin(
    var userName: String,
    var userPassword: String
)

fun DomainUserLogin.isCompleted() = userName != "" && userPassword != ""