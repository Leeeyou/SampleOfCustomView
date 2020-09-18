package com.sample.leeeyou.customview.demo3.view;

import android.app.Activity;
import android.content.Context;
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
public class ShadowView extends View {
    private static final int RECT_SIZE = 800;

    private Paint mPaint;
    private int left, top, right, bottom;

    public ShadowView(Context context) {
        super(context);
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setLayerType(LAYER_TYPE_SOFTWARE, null);

        initPaint();
        initRes(context);
    }

    public ShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        mPaint.setColor(Color.parseColor("#ed4d4d"));
        mPaint.setShadowLayer(100, 0, 0, Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.pageBackground));
        canvas.drawRect(left, top, right, bottom, mPaint);
    }

}
