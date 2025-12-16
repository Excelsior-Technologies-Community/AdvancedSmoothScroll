package com.ext.smoothscroll.utils

import android.content.Context
import android.widget.EdgeEffect
import androidx.recyclerview.widget.RecyclerView

class SpringEdgeEffectFactory(
    private val context: Context
) : RecyclerView.EdgeEffectFactory() {

    override fun createEdgeEffect(
        recyclerView: RecyclerView,
        direction: Int
    ): EdgeEffect {
        return SpringEdgeEffect(context)
    }
}
