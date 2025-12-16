package com.ext.smoothscroll.fastscroll

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FastScroller(
    private val recyclerView: RecyclerView,
    private val handle: View
) {

    init {
        handle.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE) {
                val proportion = event.y / recyclerView.height
                val position =
                    (proportion * recyclerView.adapter!!.itemCount).toInt()
                        .coerceIn(0, recyclerView.adapter!!.itemCount - 1)

                recyclerView.scrollToPosition(position)
            }
            true
        }
    }
}
