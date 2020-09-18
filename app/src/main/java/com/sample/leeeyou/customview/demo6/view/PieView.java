package com.sample.leeeyou.customview.demo6.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.sample.leeeyou.customview.demo6.bean.PieData;

import java.util.ArrayList;

/**
 * Created by leeeyou on 16/9/28.
 */
public class PieView extends View {
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private float mStartAngle = 0;

    private ArrayList<PieData> mData;

    private int mWidth, mHeight;

    private Paint mPaint = new Paint();

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (null == mData) {
            return;
        }

        float currentStartAngle = this.mStartAngle;
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.7);

        RectF rect = new RectF(-r, -r, r, r);

        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            mPaint.setColor(pieData.getColor());

            /**
             * 画圆弧的时候,注意第四个参数中true和false的区别:
             *
             * true表示使用了中心点之后绘制出来类似于一个扇形，false表示不使用中心点则是圆弧起始点和结束点之间的连线加上圆弧围成的图形
             */
            canvas.drawArc(rect, currentStartAngle, pieData.getAngle(), true, mPaint);

            currentStartAngle += pieData.getAngle();
        }
    }

    public void setmStartAngle(float mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    public void setmData(ArrayList<PieData> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0) {
            return;
        }

        float sumValue = 0;

        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);

            sumValue += pieData.getValue();

            int colorIndex = i % mColors.length;
            pieData.setColor(mColors[colorIndex]);
        }

        float sumAngle = 0;
        for (int j = 0; j < mData.size(); j++) {
            PieData pieData = mData.get(j);
            float percentage = pieData.getValue() / sumValue;
            float angle = percentage * 360;

            pieData.setPercentage(percentage);
            pieData.setAngle(angle);

            sumAngle += angle;
        }

    }

}
