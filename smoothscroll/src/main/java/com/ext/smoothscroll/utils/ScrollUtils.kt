package com.ext.smoothscroll.utils

import kotlin.math.abs

object ScrollUtils {

    fun calculateDuration(distance: Int): Int {
        return (abs(distance) * 0.5f)
            .toInt()
            .coerceIn(200, 1000)
    }
}