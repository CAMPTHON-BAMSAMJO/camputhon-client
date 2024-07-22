package com.dgu.camputhon.presentation.home

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.dgu.camputhon.R

class CustomCircleBarView: View {

    // 생성자
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    // ARC(호)의 각도값을 관리할 변수
    var numProgress: Float = 0.0f

    // 뷰 그리기
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()

        paint.color = ContextCompat.getColor(context, R.color.gray7)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        canvas?.drawArc(200f, 200f, 700f, 700f, 0f, 360f, false, paint)


        paint.color = ContextCompat.getColor(context, R.color.main_brown)
        paint.strokeWidth = 40f
        canvas?.drawArc(200f, 200f, 700f, 700f, -90f, numProgress, false, paint)

    }


    // 함수: 프로그레스바의 각도값을 변경하는 함수
    fun setProgress(num: Float){

        // numProgress 값을 변경한다.
        numProgress = num

        // 뷰 갱신: 변경된 numProgress 값을 적용하여 뷰를 다시 그린다.
        invalidate()
    }

}