package com.example.studentbeansandroidjuniorapplication.utils

import android.content.Context
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.studentbeansandroidjuniorapplication.R
import com.squareup.picasso.Picasso

// Fragment
fun Fragment.navigate(directions: NavDirections) = findNavController().navigate(directions)
fun Fragment.toast(message: CharSequence) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

// Views
fun View.removeFocusAndHideKeyboard(context: Context, event: MotionEvent) {
    if (event.action == MotionEvent.ACTION_DOWN) {
        if (this is EditText) {
            val outRect = Rect()
            getGlobalVisibleRect(outRect)
            if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                clearFocus()
                val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(getWindowToken(), 0)
            }
        }
    }
}

fun ImageView.bindImage(imgUrl: String?) = imgUrl?.let {
    val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
    Picasso
        .get()
        .load(imgUri)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken_image)
        .into(this)
}
