package com.sample.leeeyou.customview.demo5.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by leeeyou on 16/5/1.
 * <p/>
 * Path.Direction只有两个常量值CCW和CW分别表示逆时针方向闭合和顺时针方向闭合
 */
public class PathView extends View {
    private Path path;
    private Paint paint;
    private TextPaint textPaint;

    RectF rectF;

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(40);

        path = new Path();
        rectF = new RectF(100, 100, 700, 900);
        path.addOval(rectF, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
        canvas.drawTextOnPath("郭德纲的德云社能够在各种限制的形式中突出重围，让相声重新回到剧场，直接面对观众演出，这是需要很大的勇气的。", path, 0, 0, textPaint);
    }

}
