package com.mashup.dutchmarket.extension

import android.content.res.Resources


val Int.paddingInPixel: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
