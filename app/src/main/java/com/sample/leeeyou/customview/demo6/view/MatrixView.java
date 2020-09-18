package com.sample.leeeyou.customview.demo6.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo2.util.MeasureUtil;

import java.util.Arrays;

/**
 * Created by leeeyou on 16/5/3.
 */
public class MatrixView extends View {

    private static final int RECT_SIZE = 500;

    private Paint mPaint;

    private int left, top, right, bottom;
    private int screenX, screenY;

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenX = screenSize[0] / 2;
        screenY = screenSize[1] / 2;

        left = screenX - RECT_SIZE;
        top = screenY - RECT_SIZE;
        right = screenX + RECT_SIZE;
        bottom = screenY + RECT_SIZE;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.fj);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Matrix matrix = new Matrix();
        matrix.setTranslate(300, 300);
//        matrix.setRotate(5);//setXXX方法执行的操作是把原本Matrix对象中的数据重置，重新设置新的数据
//        matrix.preRotate(5);
        matrix.preScale(0.5f,0.5f);
        matrix.postRotate(5);

        float[] fs = new float[9];
        matrix.getValues(fs);
        Log.d("Aige", "Matrix的具体情况:" + Arrays.toString(fs));

        // Matrix的具体情况:[0.79695576, -0.06972459, 500.0, 0.06972459, 0.79695576, 500.0, 0.0, 0.0, 1.0]
        // Matrix的具体情况:[0.79695576, -0.06972459, 454.5195, 0.06972459, 0.79695576, 541.67523, 0.0, 0.0, 1.0]

        bitmapShader.setLocalMatrix(matrix);
        mPaint.setShader(bitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(left, top, right, bottom, mPaint);
        canvas.drawRect(0, 0, screenX * 2, screenY * 2, mPaint);
    }
}
