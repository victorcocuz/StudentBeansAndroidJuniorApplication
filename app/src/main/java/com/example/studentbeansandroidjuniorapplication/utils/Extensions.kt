package com.example.studentbeansandroidjuniorapplication.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(directions: NavDirections) = findNavController().navigate(directions)
fun Fragment.toast(message: CharSequence) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
