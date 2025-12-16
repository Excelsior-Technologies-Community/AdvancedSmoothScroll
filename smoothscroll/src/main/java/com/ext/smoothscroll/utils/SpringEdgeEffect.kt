package com.ext.smoothscroll.utils

import android.content.Context
import android.graphics.Canvas
import android.widget.EdgeEffect

class SpringEdgeEffect(context: Context) : EdgeEffect(context) {

    private var pullDistanceInternal = 0f

    override fun onPull(deltaDistance: Float) {
        pullDistanceInternal += deltaDistance
    }

    override fun onPull(deltaDistance: Float, displacement: Float) {
        pullDistanceInternal += deltaDistance
    }

    override fun onRelease() {
        pullDistanceInternal = 0f
    }

    override fun draw(canvas: Canvas): Boolean {
        // Disable default glow
        return false
    }

    fun getPullDistance(): Float = pullDistanceInternal
}
