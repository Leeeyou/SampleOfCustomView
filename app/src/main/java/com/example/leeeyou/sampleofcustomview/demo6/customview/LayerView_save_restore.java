package com.example.leeeyou.sampleofcustomview.demo6.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * LayerView2的目的主要是掌握对"层"的理解,熟练掌握canvas.save()和canvas.restore();
 * <p/>
 * 可以简单的理解为:调用canvas.save()时进行一层入栈,调用canvas.restore()时栈顶出栈
 */
public class LayerView_save_restore extends View {

    private Paint mPaint;

    private int mViewWidth, mViewHeight;

    private float baseWidth, baseHeight;


    public LayerView_save_restore(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setColor(Color.RED);
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
        canvas.drawColor(Color.parseColor("#000000"));
//        canvas.save(Canvas.CLIP_SAVE_FLAG);//保存并裁剪画布
        canvas.save();//保存并裁剪画布

        canvas.clipRect(baseWidth - 250, baseHeight - 250, baseWidth + 250, baseHeight + 250);
        canvas.drawColor(Color.RED);
//        canvas.save(Canvas.CLIP_SAVE_FLAG);//保存并裁剪画布
        canvas.save();//保存并裁剪画布

        canvas.clipRect(baseWidth - 200, baseHeight - 200, baseWidth + 200, baseHeight + 200);
        canvas.drawColor(Color.GREEN);
//        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.save();//保存并裁剪画布

        canvas.restore();//回滚到上一次保存的状态
        mPaint.setColor(Color.BLUE);
        canvas.rotate(15);
        canvas.drawRect(baseWidth - 100, baseHeight - 100, baseWidth + 100, baseHeight + 100, mPaint);

        canvas.restore();
        canvas.rotate(-15);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(baseWidth, baseHeight, baseWidth + 400, baseHeight + 400, mPaint);
    }

}
