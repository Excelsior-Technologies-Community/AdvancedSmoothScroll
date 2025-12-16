package com.ext.smoothscroll.nested

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView
import com.ext.smoothscroll.R
import kotlin.math.roundToInt

class SmoothNestedScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : NestedScrollView(context, attrs) {

    var flingMultiplier: Float = 0.8f

    init {
        attrs?.let {
            val ta = context.obtainStyledAttributes(
                it,
                R.styleable.SmoothNestedScrollView
            )
            flingMultiplier = ta.getFloat(
                R.styleable.SmoothNestedScrollView_flingMultiplier,
                0.8f
            )
            ta.recycle()
        }
    }

    override fun fling(velocityY: Int) {
        super.fling((velocityY * flingMultiplier).roundToInt())
    }
}
