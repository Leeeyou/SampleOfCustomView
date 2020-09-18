package com.sample.leeeyou.customview.demo4.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo2.util.MeasureUtil;

/**
 * Created by leeeyou on 16/4/28.
 * <p/>
 * 利用PorterDuffXfermode和LinearGradient实现倒影效果
 */
public class ReflectView extends View {

    private Bitmap mSrcBitmap, mReflectBitmap;
    private Paint mPaint;
    private PorterDuffXfermode mPorterDuffXfermode;

    private int x, y;

    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initRes(context);
    }

    private void initRes(Context context) {
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.qihao);

        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);

        mReflectBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(), mSrcBitmap.getHeight(), matrix, true);

        int screenW = MeasureUtil.getScreenSize((Activity) context)[0];
        int screenH = MeasureUtil.getScreenSize((Activity) context)[1];

        x = screenW / 2 - mSrcBitmap.getWidth() / 2;
        y = screenH / 2 - mSrcBitmap.getHeight() / 2;

        mPaint = new Paint();
        mPaint.setShader(new LinearGradient(x, y + mSrcBitmap.getHeight(), x, y + mSrcBitmap.getHeight() + mSrcBitmap.getHeight() / 4, 0xAA000000, Color.TRANSPARENT, Shader.TileMode.CLAMP));

        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.pageBackground));
        canvas.drawBitmap(mSrcBitmap, x, y, null);

        int sc = canvas.saveLayer(x, y + mSrcBitmap.getHeight(), x + mReflectBitmap.getWidth(), y + mSrcBitmap.getHeight() * 2, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mReflectBitmap, x, y + mSrcBitmap.getHeight(), null);//画目标图像
        mPaint.setXfermode(mPorterDuffXfermode);
        canvas.drawRect(x, y + mSrcBitmap.getHeight(), x + mReflectBitmap.getWidth(), y + mSrcBitmap.getHeight() * 2, mPaint);//画源图像
        mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }

}
