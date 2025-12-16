package com.ext.smoothscroll.utils

import android.view.VelocityTracker
import android.view.MotionEvent

object VelocityTrackerHelper {

    fun getYVelocity(event: MotionEvent): Float {
        val tracker = VelocityTracker.obtain()
        tracker.addMovement(event)
        tracker.computeCurrentVelocity(1000)
        val velocity = tracker.yVelocity
        tracker.recycle()
        return velocity
    }
}