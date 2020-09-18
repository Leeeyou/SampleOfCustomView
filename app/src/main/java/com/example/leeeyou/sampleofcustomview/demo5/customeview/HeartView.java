package com.example.leeeyou.sampleofcustomview.demo5.customeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by leeeyou on 2016/9/30.
 */

public class HeartView extends View {

    private Paint mPaint;

    private int centerX, centerY;

    private PointF start, end, leftControl, rightControl;



    public HeartView(Context context) {
        this(context, null);
    }

    public HeartView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
    }

    public HeartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;

        start = new PointF();
        end = new PointF();
        leftControl = new PointF();
        rightControl = new PointF();

        start.x = centerX;
        start.y = centerY;

        end.x = centerX + 300;
        end.y = centerY + 300;

        leftControl.x = start.x - 300;
        leftControl.y = start.y - 200;

        rightControl.x = start.x + 300;
        rightControl.y = start.y - 200;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStrokeWidth(20);

        canvas.drawPoint(leftControl.x, leftControl.y, mPaint);
        canvas.drawPoint(rightControl.x, rightControl.y, mPaint);

    }
}
