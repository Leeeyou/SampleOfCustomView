package com.example.leeeyou.sampleofcustomview.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by leeeyou on 16/4/29.
 * <p>
 * 心电图
 */
public class ECGView extends View {

    private Paint paint;

    private Path path;

    private float x, y;
    private float initScreenW;
    private float initX;
    private float transX, moveX;

    private boolean isCanvasMove;

    public ECGView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);//用来设置我们画笔的笔触风格
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setShadowLayer(7, 0, 0, Color.GREEN);

        path = new Path();
        transX = 0;
        isCanvasMove = false;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        x = 0;
        y = (h / 2) + (h / 4) + (h / 10);

        initScreenW = w;

        initX = (w / 2) + (w / 4);

        moveX = (w / 24);

        path.moveTo(x, y);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        path.lineTo(x, y);

        canvas.translate(-transX, 0);

        calCoors();

        canvas.drawPath(path, paint);
        invalidate();
    }

    private void calCoors() {
        if (isCanvasMove) {
            transX += 4;
        }

        if (x < initX) {
            x += 8;
        } else {
            if (x < initX + moveX) {
                x += 2;
                y -= 8;
            } else {
                if (x < initX + (moveX * 2)) {
                    x += 2;
                    y += 14;
                } else {
                    if (x < initX + (moveX * 3)) {
                        x += 2;
                        y -= 12;
                    } else {
                        if (x < initX + (moveX * 4)) {
                            x += 2;
                            y += 6;
                        } else {
                            if (x < initScreenW) {
                                x += 8;
                            } else {
                                isCanvasMove = true;
                                initX = initX + initScreenW;
                            }
                        }
                    }
                }
            }
        }
    }

}
