package com.example.paint_baby

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import kotlin.math.atan2


class s : View {
    private var mPaint: Paint? = null
    private var mPath: Path? = null
    private var mBitmap: Bitmap? = null
    private var mPathMeasure: PathMeasure? = null
    private var mMatrix: Matrix? = null
    private var mOffsetX = 0
    private var mOffsetY = 0
    private var mPathLength = 0f
    private var mStep // distance each step
            = 0f
    private var mDistance // distance moved
            = 0f
    private lateinit var mPosition: FloatArray
    private lateinit var mTan: FloatArray

    constructor(context: Context?) : super(context) {
        // TODO Auto-generated constructor stub
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        val displayMetrics = DisplayMetrics()
        val height=context.getResources().getDisplayMetrics().heightPixels
        val width =context.getResources().getDisplayMetrics().widthPixels
        this.alpha
        mPaint = Paint()
        mPaint!!.isAntiAlias = true
        mPaint!!.color = Color.WHITE
        mPaint!!.strokeWidth = 3f
        mBitmap = BitmapFactory.decodeResource(resources,
                R.drawable.lol)
        mOffsetX = 20
        mOffsetY =20
        mPath = Path()
        mPath!!.moveTo(106f, 700f)
        mPath!!.lineTo(106f, 230f)
        mPath!!.lineTo(254f, 230f)
        mPath!!.lineTo(254f, 787f)
        mPath!!.lineTo(550f,787f)
        mPath!!.lineTo(106f, 700f)
        mPathMeasure = PathMeasure(mPath, false)
        mPathLength = mPathMeasure!!.length
        mStep = 2.5f
        mDistance = 0f
        mPosition = FloatArray(2)
        mTan = FloatArray(2)
        mMatrix = Matrix()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // TODO Auto-generated method stub
        if (mDistance < mPathLength) {
            mPathMeasure!!.getPosTan(mDistance, mPosition, mTan)
            mMatrix!!.reset()
            val degrees = (atan2(mTan[1].toDouble(), mTan[0].toDouble()) * 180.0 / Math.PI).toFloat()
            mMatrix!!.postRotate(degrees, mOffsetX.toFloat(), mOffsetY.toFloat())
            mMatrix!!.postTranslate(mPosition[0] - mOffsetX, mPosition[1] - mOffsetY)
            canvas.drawBitmap(mBitmap!!, mMatrix!!, null)
            mDistance += mStep
        } else {
            mDistance = 0f
        }
        invalidate()
    }
}