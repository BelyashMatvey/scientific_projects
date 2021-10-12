package com.example.paint_baby

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paint_baby.MainActivity.Companion.paint_brush
import kotlin.collections.ArrayList

class display : View {
    private var params: ViewGroup.LayoutParams? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        paint_brush.isAntiAlias = true
        paint_brush.color = Color.BLACK
        paint_brush.style = Paint.Style.STROKE
        paint_brush.strokeCap = Paint.Cap.ROUND
        paint_brush.strokeJoin = Paint.Join.ROUND
        paint_brush.strokeWidth = 10f
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                MainActivity.path.moveTo(x, y)
                invalidate()
                MainActivity.path.lineTo(x, y)
                pathList.addPath(MainActivity.path)
                colorList.add(current_brush)
                invalidate()
                true
            }
            MotionEvent.ACTION_MOVE -> {
                MainActivity.path.lineTo(x, y)
                pathList.addPath(MainActivity.path)
                colorList.add(current_brush)
                invalidate()
                true
            }
            else -> false
        }
    }
    companion object {
        var pathList = Path()
        var colorList = ArrayList<Int>()
        var current_brush = Color.BLACK
    }
}