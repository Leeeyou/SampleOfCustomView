package com.sample.leeeyou.customview.demo1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircleView extends View implements Runnable {
    private Paint mPaint;

    private int radiu;

    private int cx, cy;

    private int[] colors = new int[]{Color.RED, Color.GREEN, Color.GRAY, Color.MAGENTA};

    public CustomCircleView(Context context) {
        super(context);
        initPaint();
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w / 2;
        cy = h / 2;
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, radiu, mPaint);
    }

    @Override
    public void run() {
        while (true) {
            if (radiu < 36) {
                radiu += 3;

                mPaint.setColor(colors[radiu % 4]);

                postInvalidate();
            } else {
                radiu = 0;
            }

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
