package com.sample.leeeyou.customview.demo4.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo2.util.MeasureUtil;

/**
 * Created by leeeyou on 16/4/28.
 * <p/>
 * 图片小清新的LOMO风格
 */
public class DreamEffectView extends View {

    private Paint mBitmapPaint, mShaderPaint;
    private Bitmap mBitmap, darkCornerBitmap;
    private PorterDuffXfermode porterDuffXfermode;
    private int x, y;

    public DreamEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRes(context);
        initPaint();
    }

    private void initPaint() {
        mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 去饱和、提亮、色相矫正
        mBitmapPaint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.8587F, 0.2940F, -0.0927F, 0, 6.79F, 0.0821F, 0.9145F, 0.0634F, 0, 6.79F, 0.2019F, 0.1097F, 0.7483F, 0, 6.79F, 0, 0, 0, 1, 0}));
    }

    private void initRes(Context context) {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.qihao);

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);

        int screenW = MeasureUtil.getScreenSize((Activity) context)[0];
        int screenH = MeasureUtil.getScreenSize((Activity) context)[1];

        x = screenW / 2 - mBitmap.getWidth() / 2;
        y = screenH / 2 - mBitmap.getHeight() / 2;

        mShaderPaint = new Paint();
        mShaderPaint.setShader(new RadialGradient(screenW / 2, screenH / 2, mBitmap.getHeight() * 7 / 8, Color.TRANSPARENT, Color.BLACK, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.pageBackground));

        int sc = canvas.saveLayer(x, y, x + mBitmap.getWidth(), y + mBitmap.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(0xcc1c093e);// 绘制混合颜色
        mBitmapPaint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(mBitmap, x, y, mBitmapPaint);
        mBitmapPaint.setXfermode(null);
        canvas.restoreToCount(sc);

        canvas.drawRect(x, y, x + mBitmap.getWidth(), y + mBitmap.getHeight(), mShaderPaint);
    }

}
