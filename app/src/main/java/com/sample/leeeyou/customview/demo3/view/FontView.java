package com.sample.leeeyou.customview.demo3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by leeyou on 2016/1/26.
 */
public class FontView extends View {

    private StaticLayout mStaticLayout;
    private TextPaint mPaint;

    private static final String TEXT = "这就是一行测试字符串 -- Android对文字的支持占用了Paint的将近一半API，可见Android对Paint写字功能的重视。 (⊙o⊙)…";

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(70);
        mPaint.setColor(Color.BLACK);

        Paint.FontMetrics mFontMetrics = mPaint.getFontMetrics();

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "a.ttf");
        mPaint.setTypeface(typeface);

        mPaint.setTextSkewX(-0.15f);
        mPaint.setTextScaleX(1.5f);

        Log.e("FontView", "ascent：" + mFontMetrics.ascent);
        Log.e("FontView", "descent：" + mFontMetrics.descent);
        Log.e("FontView", "leading：" + mFontMetrics.leading);
        Log.e("FontView", "top：" + mFontMetrics.top);
        Log.e("FontView", "bottom：" + mFontMetrics.bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mStaticLayout == null) {
            mStaticLayout = new StaticLayout(TEXT, mPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        }
        mStaticLayout.draw(canvas);
    }

}
