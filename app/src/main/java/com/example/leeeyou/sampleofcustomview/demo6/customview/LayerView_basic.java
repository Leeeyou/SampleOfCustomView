package com.example.leeeyou.sampleofcustomview.demo6.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LayerView_basic extends View {

    private Paint mPaint;

    private int mViewWidth, mViewHeight;

    private float baseWidth, baseHeight;


    public LayerView_basic(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mViewHeight = h;
        mViewWidth = w;

        baseWidth = mViewWidth / 2F;
        baseHeight = mViewHeight / 2F;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawRect(baseWidth - 200, baseHeight - 200, baseWidth + 200, baseHeight + 200, mPaint);

        canvas.save();//保存当前画布
        canvas.rotate(20);//旋转20°

        mPaint.setColor(Color.GREEN);
        canvas.drawRect(baseWidth - 100, baseHeight - 100, baseWidth + 100, baseHeight + 100, mPaint);
        canvas.restore();//回滚到上一次保存的状态
    }
}
