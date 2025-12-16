package com.ext.smoothscroll.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class SmoothRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {

    var flingMultiplier: Float = 0.85f

    override fun fling(velocityX: Int, velocityY: Int): Boolean {
        return super.fling(
            velocityX,
            (velocityY * flingMultiplier).roundToInt()
        )
    }
}
