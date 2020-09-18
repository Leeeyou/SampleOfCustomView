package com.sample.leeeyou.customview.demo5.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by leeeyou on 16/9/29.
 */

public class RadarView extends View {

    private int count = 6;//数据个数
    private float angle = (float) (Math.PI * 2 / count);
    private float radius;//网格最大半径
    private int centerX;//中心点x
    private int centerY;//中心点y
    private String[] titles = {"a", "b", "c", "d", "e", "f"};
    private double[] data = {100, 78, 20, 90, 45, 61, 88, 19};//各维度分值
    private float maxValue = 100;//数据最大值
    private Paint mainPaint;//雷达区画笔
    private Paint valuePaint;//数据区画笔
    private Paint textPaint;//文本画笔
    private LinearGradient linearGradient;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        radius = Math.min(w, h) / 2 * 0.9f;

        centerX = w / 2;
        centerY = h / 2;

        postInvalidate();
    }

    public RadarView(Context context) {
        super(context);
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mainPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mainPaint.setColor(Color.parseColor("#e8e8e8"));
        mainPaint.setStyle(Paint.Style.STROKE);
        mainPaint.setStrokeWidth(3);

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        textPaint.setColor(Color.parseColor("#000000"));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(14);

        valuePaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        valuePaint.setColor(Color.parseColor("#084A83"));
        valuePaint.setStyle(Paint.Style.STROKE);
        valuePaint.setStrokeWidth(4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);
        drawLines(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

    /**
     * 绘制多边形
     *
     * @param canvas
     */
    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        float r = radius / (count - 1);//间距
        for (int i = 1; i < count; i++) {
            float currentRadius = r * i;
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path.moveTo(centerX + currentRadius, centerY);
                } else {
                    float x = (float) (centerX + currentRadius * Math.cos(angle * j));
                    float y = (float) (centerY + currentRadius * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, mainPaint);
        }
    }

    /**
     * 画直线
     *
     * @param canvas
     */
    private void drawLines(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);

            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));

            path.lineTo(x, y);

            canvas.drawPath(path, mainPaint);
        }
    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));
            if (angle * i >= 0 && angle * i <= Math.PI / 2) {//第4象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {//第3象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (angle * i >= Math.PI && angle * i < 3 * Math.PI / 2) {//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            }
        }
    }

    /**
     * 绘制区域
     *
     * @param canvas
     */
    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(255);
        for (int i = 0; i < count; i++) {
            float percent = (float) (data[i] / maxValue);
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);

            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }

            canvas.drawCircle(x, y, 4, valuePaint);
        }

        path.close();

        if (linearGradient == null) {
            linearGradient = new LinearGradient(
                    0,
                    0,
                    radius * 2,
                    radius * 2,
                    new int[]{Color.parseColor("#6ad1d0"), Color.parseColor("#5bd6f6"), Color.parseColor("#a89ae4"), Color.parseColor("#ed4d4d")},
                    null,
                    Shader.TileMode.CLAMP
            );
        }
        valuePaint.setShader(linearGradient);

        canvas.drawPath(path, valuePaint);
    }

}
