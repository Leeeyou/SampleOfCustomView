package com.sample.leeeyou.customview.demo4.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo2.util.MeasureUtil;

/**
 * Created by leeeyou on 16/4/28.
 * <p/>
 * Matrix练习
 */
public class MatrixImageView extends androidx.appcompat.widget.AppCompatImageView {

    private static final int MODE_NONE = 0X00123;//默认的触摸模式
    private static final int MODE_DRAG = 0X00321;//拖拽模式
    private static final int MODE_ZOOM = 0X00132;//缩放or旋转模式

    private int mode;//当前的触摸模式

    private float preMove = 1F;//上一次手指移动的距离
    private float saveRotate = 0F;//保存了的角度
    private float rotate = 0F;//旋转的角度

    private float[] preEventCoor;//上一次各触摸点的坐标集合

    private PointF start, mid;//起点 中点对象
    private Matrix currentMatrix, savedMatrix;//当前和保存了的matrix对象

    private Context context;

    public MatrixImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        init();
    }

    private void init() {
        currentMatrix = new Matrix();
        savedMatrix = new Matrix();

        start = new PointF();
        mid = new PointF();

        mode = MODE_NONE;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tw2);
        bitmap = Bitmap.createScaledBitmap(bitmap, MeasureUtil.getScreenSize((Activity) context)[0], MeasureUtil.getScreenSize((Activity) context)[1], false);
        setImageBitmap(bitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //使用switch (event.getAction() & MotionEvent.ACTION_MASK)就可以处理处理多点触摸的ACTION_POINTER_DOWN和ACTION_POINTER_UP事件
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                savedMatrix.set(currentMatrix);
                start.set(event.getX(), event.getY());
                mode = MODE_DRAG;
                preEventCoor = null;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                preMove = calSpacing(event);
                if (preMove > 10F) {
                    savedMatrix.set(currentMatrix);
                    calMidPoint(mid, event);
                    mode = MODE_ZOOM;
                }
                preEventCoor = new float[4];
                preEventCoor[0] = event.getX(0);
                preEventCoor[1] = event.getX(1);
                preEventCoor[2] = event.getY(0);
                preEventCoor[3] = event.getY(1);
                saveRotate = calRotation(event);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = MODE_NONE;
                preEventCoor = null;
                break;
            case MotionEvent.ACTION_MOVE:
                //单点触控拖拽平移
                if (mode == MODE_DRAG) {
                    currentMatrix.set(savedMatrix);
                    float dx = event.getX() - start.x;
                    float dy = event.getY() - start.y;
                    currentMatrix.postTranslate(dx, dy);
                } else if (mode == MODE_ZOOM && event.getPointerCount() == 2) {
                    //两点触控拖放旋转
                    float currentMove = calSpacing(event);
                    currentMatrix.set(savedMatrix);

                    if (currentMove > 10F) {
                        float scale = currentMove / preMove;
                        currentMatrix.postScale(scale, scale, mid.x, mid.y);
                    }

                    if (preEventCoor != null) {
                        rotate = calRotation(event);
                        float r = rotate - saveRotate;
                        currentMatrix.postRotate(r, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                    }
                }
                break;
        }

        setImageMatrix(currentMatrix);
        return true;

    }

    private float calRotation(MotionEvent event) {
        double deltax = event.getX(0) - event.getX(1);
        double deltay = event.getY(0) - event.getY(1);
        double radius = Math.atan2(deltay, deltax);
        return (float) Math.toDegrees(radius);
    }

    private void calMidPoint(PointF mid, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        mid.set(x / 2, y / 2);
    }

    private float calSpacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

}
