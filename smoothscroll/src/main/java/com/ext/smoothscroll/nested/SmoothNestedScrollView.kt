package com.ext.smoothscroll.nested

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView
import kotlin.math.roundToInt

class SmoothNestedScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : NestedScrollView(context, attrs) {

    var flingMultiplier: Float = 0.8f

    override fun fling(velocityY: Int) {
        super.fling((velocityY * flingMultiplier).roundToInt())
    }
}
