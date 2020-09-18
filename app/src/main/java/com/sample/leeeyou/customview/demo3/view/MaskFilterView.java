package com.sample.leeeyou.customview.demo3.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo2.util.MeasureUtil;

/**
 * Created by leeyou on 2016/1/27.
 */
public class MaskFilterView extends View {

    private static final int RECT_SIZE = 800;

    private Paint mPaint;

    private int left, top, right, bottom;

    public MaskFilterView(Context context) {
        super(context);
    }

    public MaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
        initRes(context);
    }

    private void initRes(Context context) {
        left = MeasureUtil.getScreenSize((Activity) context)[0] / 2 - RECT_SIZE / 2;
        top = MeasureUtil.getScreenSize((Activity) context)[1] / 2 - RECT_SIZE / 2;
        right = MeasureUtil.getScreenSize((Activity) context)[0] / 2 + RECT_SIZE / 2;
        bottom = MeasureUtil.getScreenSize((Activity) context)[1] / 2 + RECT_SIZE / 2;
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0xff894312);

        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
    }

    public MaskFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.pageBackground));
        canvas.drawRect(left, top, right, bottom, mPaint);
    }

}
