package com.ext.smoothscroll.recycler

import android.content.Context
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class UltraSmoothLayoutManager(
    context: Context
) : LinearLayoutManager(context) {

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView,
        state: RecyclerView.State,
        position: Int
    ) {
        val smoothScroller = object : LinearSmoothScroller(recyclerView.context) {

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                // Smaller value = slower & smoother scroll
                return 100f / displayMetrics.densityDpi
            }

            override fun calculateTimeForScrolling(dx: Int): Int {
                // Control scroll duration
                return (abs(dx) * 0.5f).toInt().coerceIn(300, 1200)
            }
        }

        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }
}
