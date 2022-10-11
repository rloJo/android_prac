package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyView : View {
    var index =0;
    var rect = Rect(10, 10, 110, 110)
    var color = Color.BLUE
    private var paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (index ==0 ) {
            paint.color = color
            canvas.drawRect(rect, paint)
        } else if (index ==1 ) {
            paint.color = color
            canvas.drawCircle((rect.left + 50).toFloat(), (rect.top + 50).toFloat(), 50F, paint)

        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN ||
            event.action == MotionEvent.ACTION_MOVE) {
            rect.left = event.x.toInt()
            rect.top = event.y.toInt()
            rect.right = rect.left + 100
            rect.bottom = rect.top + 100
            invalidate()
            return true
        }
        return super.onTouchEvent(event)
    }

    fun setRect(){
        index= 0
    }

    fun setCir(){
        index =1

    }
}
