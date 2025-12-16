package com.ext.smoothscroll.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.ext.smoothscroll.R
import com.ext.smoothscroll.utils.SpringEdgeEffectFactory
import kotlin.math.roundToInt

class SmoothRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {

    var flingMultiplier: Float = 0.85f
    var enableSmoothPhysics: Boolean = true
    var enableSpringOverscroll = true

    init {
        attrs?.let {
            val ta = context.obtainStyledAttributes(
                it,
                R.styleable.SmoothRecyclerView
            )
            flingMultiplier = ta.getFloat(
                R.styleable.SmoothRecyclerView_flingMultiplier,
                0.85f
            )
            enableSmoothPhysics = ta.getBoolean(
                R.styleable.SmoothRecyclerView_enableSmoothPhysics,
                true
            )
            ta.recycle()
        }
        if (enableSpringOverscroll) {
            edgeEffectFactory = SpringEdgeEffectFactory(context)
            overScrollMode = OVER_SCROLL_ALWAYS
        }
    }

    override fun fling(velocityX: Int, velocityY: Int): Boolean {
        if (!enableSmoothPhysics) {
            return super.fling(velocityX, velocityY)
        }

        return super.fling(
            velocityX,
            (velocityY * flingMultiplier).roundToInt()
        )
    }
}
