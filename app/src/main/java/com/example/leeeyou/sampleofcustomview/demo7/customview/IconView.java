package com.example.leeeyou.sampleofcustomview.demo7.customview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.leeeyou.sampleofcustomview.R;
import com.example.leeeyou.sampleofcustomview.demo2.util.MeasureUtil;

/**
 * Created by leeeyou on 16/5/5.
 */
public class IconView extends View {

    private Bitmap mBitmap;
    private String mStr;
    private TextPaint mPaint;
    private float mTextSize;

    private enum Ratio {
        WIDTH, HEIGHT;
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);

        calArgs(context);

        init();
    }

    private void init() {
        if (mBitmap == null) {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tw);
        }

        if (TextUtils.isEmpty(mStr)) {
            mStr = "En Hen";
        }

        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(mTextSize);
        mPaint.setTypeface(Typeface.DEFAULT);
    }

    private void calArgs(Context context) {
        mTextSize = MeasureUtil.getScreenSize((Activity) context)[0] * 1 / 20F;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMeasureSize(widthMeasureSpec, Ratio.WIDTH), getMeasureSize(heightMeasureSpec, Ratio.HEIGHT));
    }

    private int getMeasureSize(int measureSpec, Ratio ratio) {
        int result = 0;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.EXACTLY:
                result = size;
                break;
            default:
                if (ratio == Ratio.WIDTH) {
                    int textWidth = (int) mPaint.measureText(mStr);
                    result = (textWidth >= mBitmap.getWidth() ? textWidth : mBitmap.getWidth()) + getPaddingLeft() + getPaddingRight();
                } else if (ratio == Ratio.HEIGHT) {
                    result = (int) ((mPaint.descent() - mPaint.ascent()) * 2 + mBitmap.getHeight()) + getPaddingTop() + getPaddingBottom();
                }

                if (mode == MeasureSpec.AT_MOST) {
                    result = Math.min(result, size);
                }
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.RED);
//        canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2, getHeight() / 2 - mBitmap.getHeight() / 2, null);
        canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2, getHeight() / 2 - mBitmap.getHeight() / 2, null);
        canvas.drawText(mStr, getWidth() / 2, mBitmap.getHeight() + getHeight() / 2 - mBitmap.getHeight() / 2 - mPaint.ascent(), mPaint);
    }

}
