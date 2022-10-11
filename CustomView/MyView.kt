package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.Random


class MyView : View {
    val random = Random() 
    var ranNum = 0 //ranNum 값에 따라 도형을 생성하기 위해 변수 생성
    var rect = Rect(10, 10, 110, 110)
    var color = Color.BLUE
    private var paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (ranNum == 0) {
            paint.color = color
            canvas.drawRect(rect, paint)
        } else if (ranNum == 1) {
            paint.color = color
            canvas.drawCircle((rect.left + 50).toFloat(), (rect.top + 50).toFloat(), 50F, paint)

        } else if (ranNum == 2) {
            paint.color = color
            canvas.drawLine((rect.left).toFloat(), (rect.bottom).toFloat(),(rect.left + 50).toFloat(),(rect.top).toFloat(),paint)
            canvas.drawLine((rect.left + 50).toFloat(),(rect.top).toFloat(),rect.right.toFloat(),rect.bottom.toFloat(),paint)
            canvas.drawLine((rect.left).toFloat(), (rect.bottom).toFloat(),(rect.right).toFloat(),rect.bottom.toFloat(),paint )
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        ranNum = random.nextInt(3) // 터치할때마다 랜덤값 변경
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
