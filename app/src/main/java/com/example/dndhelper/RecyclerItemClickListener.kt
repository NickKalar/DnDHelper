package com.example.dndhelper

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView


/*
 * Created by Nicholas Kalar on 6/4/21
 */

private const val TAG = "RecyclerItemClickListen"

class RecyclerItemClickListener(context: Context, recyclerView: RecyclerView, private val listener: OnRecyclerClickListener)
    : RecyclerView.SimpleOnItemTouchListener() {

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
//        Log.d(TAG, ".onInterceptTouchEvent: starts $e")
        val result = gestureDetector.onTouchEvent(e)
//        Log.d(TAG, ".onInterceptTouchEven() returning: $result")
//        return super.onInterceptTouchEvent(rv, e)
        return result
    }

    interface OnRecyclerClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    // add the gestureDetector
    private val gestureDetector = GestureDetectorCompat(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return super.onSingleTapUp(e)
        }

        override fun onLongPress(e: MotionEvent?) {
            super.onLongPress(e)
        }
    })


}