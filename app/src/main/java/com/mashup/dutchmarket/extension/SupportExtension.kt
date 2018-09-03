package com.mashup.dutchmarket.extension

import android.content.Context
import android.content.res.Resources
import java.util.regex.Pattern
import android.widget.Toast

val Int.paddingInPixel: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val String.isValidateEmail: Boolean
    get() = Pattern
            .compile("^[A-Za-z0-9._%+\\\\-]+@[A-Za-z0-9.\\\\-]+\\\\.[A-Za-z]{2,4}\$")
            .matcher(this)
            .find()

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
