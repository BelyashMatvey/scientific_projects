package com.example.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.paint.display.Companion.colorList
import com.example.paint.display.Companion.pathList


class PathView : View {
    private var mPaint: Paint? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.isAntiAlias = true
        mPaint!!.color = colorList[colorList.size-1]
        mPaint!!.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawPath(pathList, mPaint!!)
    }
}