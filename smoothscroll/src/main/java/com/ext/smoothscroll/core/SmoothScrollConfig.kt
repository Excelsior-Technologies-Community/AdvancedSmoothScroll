package com.ext.smoothscroll.core

data class SmoothScrollConfig(
    val flingMultiplier: Float = 0.85f,
    val scrollDurationMultiplier: Float = 0.6f,
    val enableOverScroll: Boolean = true
)