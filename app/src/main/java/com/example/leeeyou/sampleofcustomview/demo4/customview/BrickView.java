package com.example.leeeyou.sampleofcustomview.demo4.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.leeeyou.sampleofcustomview.R;

/**
 * Created by LeeeYou on 2016/4/27.
 * <p/>
 * BitmapShader的repeat模式实现移动的圆环
 */
public class BrickView extends View {

    private Paint mFillPaint, mStrokePaint;
    private float posX, posY;

    public BrickView(Context context) {
        super(context);
    }

    public BrickView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    public BrickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mStrokePaint.setColor(0x55ff0000);
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(50);

        mFillPaint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tw2);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mFillPaint.setShader(bitmapShader);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                posX = event.getX();
                posY = event.getY();

                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        canvas.drawCircle(posX, posY, 200, mFillPaint);
        canvas.drawCircle(posX, posY, 200, mStrokePaint);
    }

}
