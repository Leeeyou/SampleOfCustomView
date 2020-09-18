package com.sample.leeeyou.customview.demo6.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.sample.leeeyou.customview.R;

public class LayerViewTransfer extends View {

    private Bitmap bitmap;

    private int mViewWidth, mViewHeight;
    private Matrix matrix;

    public LayerViewTransfer(Context context, AttributeSet attrs) {
        super(context, attrs);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tw2);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mViewHeight = h;
        mViewWidth = w;

        bitmap = Bitmap.createScaledBitmap(bitmap, mViewWidth, mViewHeight, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.save();//保存并裁剪画布
        canvas.scale(0.5f, 0.4f, mViewWidth, 0);
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.restore();

//        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.save();//保存并裁剪画布

        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.setScale(0.75f, 0.30f);
        matrix.postTranslate(100, 700);

        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.restore();

        /**
         * pre方法表示矩阵前乘，例如：变换矩阵为A，原始矩阵为B，pre方法的含义即是A*B
         * post方法表示矩阵后乘，例如：变换矩阵为A，原始矩阵为B，post方法的含义即是B*A
         * set方法一旦调用即会清空之前matrix中的所有变换
         */
    }

}
