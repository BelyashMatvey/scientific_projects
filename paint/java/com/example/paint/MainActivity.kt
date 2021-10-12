package com.example.paint

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.paint.display.Companion.colorList
import com.example.paint.display.Companion.current_brush
import com.example.paint.display.Companion.pathList

class MainActivity : AppCompatActivity() {
    public override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val second = findViewById<View>(R.id.second) as AppCompatButton
        second.setOnClickListener{
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
    fun eraser(view: View?) {
        pathList.reset()
        colorList.clear()
        path.reset()
    }

    fun pencil(view: View?) {
        paint_brush.color = Color.BLACK
        CurrentColor(paint_brush.color)
    }

    fun redColor(view: View?) {
        paint_brush.color = Color.RED
        CurrentColor(paint_brush.color)
    }

    fun greenColor(view: View?) {
        paint_brush.color = Color.GREEN
        CurrentColor(paint_brush.color)
    }

    fun blueColor(view: View?) {
        paint_brush.color = Color.BLUE
        CurrentColor(paint_brush.color)
    }

    fun pinkColor(view:View?) {
        paint_brush.color = Color.rgb(255, 20, 147)
        CurrentColor(paint_brush.color)
    }

    fun orangeColor(view: View?) {
        paint_brush.color = Color.rgb(255, 128, 0)
        CurrentColor(paint_brush.color)
    }

    fun yellowColor(view: View?) {
        paint_brush.color = Color.YELLOW
        CurrentColor(paint_brush.color)
    }
    private fun CurrentColor(c: Int) {
        current_brush = c
        path = Path()
    }

    companion object {
        @JvmField
        var path = Path()
        @JvmField
        var paint_brush = Paint()
    }
}