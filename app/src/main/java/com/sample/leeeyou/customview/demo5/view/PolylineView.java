package com.sample.leeeyou.customview.demo5.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PolylineView extends View {

    private static final float LEFT = 1 / 16F, TOP = 1 / 16F, RIGHT = 15 / 16F, BOTTOM = 7 / 8F;//网格区域相对位置
    private static final float TIME_X = 3 / 32F, TIME_Y = 1 / 16F, MONEY_X = 31 / 32F, MONEY_Y = 15 / 15F;//文字坐标相对位置
    private static final float TEXT_SIGN = 1 / 32F;//文字相对大小
    private static final float THICK_LINE_WIDTH = 1 / 128F, THIN_LINE_WIDTH = 1 / 512F;//粗线和细线相对大小

    private TextPaint mTextPaint;//文字画笔
    private Paint linePaint, pointPaint;//线条画笔和点画笔
    private Path mPath;//路径对象
    private Bitmap mBitmap;//绘制曲线的bitmap对象
    private Canvas mCanvas;//装载bitmap的canvas对象

    private List<PointF> pointFs;//数据列表
    private float[] ruleX, ruleY;//xy轴向刻度

    private String signX, signY;//设置X和Y坐标分别标示什么的文字
    private float textX_X, textX_Y, textY_X, textY_Y;//文字坐标
    private float textSignSize;//xy坐标标示文字字体大小
    private float thickLineWidth, thinLineWidth;//粗线和细线宽度
    private float left, top, right, bottom;//网格区域左上右下两点坐标
    private int viewSize;//控件尺寸
    private float maxX, maxY;//横纵轴向最大刻度
    private float spaceX, spaceY;//刻度间隔

    float first, last;
    Path gradientPath;
    Paint gradientPaint;

    public PolylineView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //实例化文本绘笔,并设置参数
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mTextPaint.setColor(Color.WHITE);

        //实例化线条画笔,并设置参数
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.parseColor("#ff4d7d25"));

        //实例化点画笔,并设置参数
        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setColor(Color.WHITE);

        //实例化渐变画笔,并设置参数
        gradientPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        gradientPaint.setPathEffect(new CornerPathEffect(100));

        //实例化path参数
        mPath = new Path();
        gradientPath = new Path();

        //实例化canvas对象
        mCanvas = new Canvas();

        //初始化数据
        initData();
    }

    private void initData() {
        Random random = new Random();
        pointFs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            PointF pointF = new PointF();

            pointF.x = (float) (random.nextInt(100) * i);
            pointF.y = (float) (random.nextInt(100) * i);

            pointFs.add(pointF);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        viewSize = w;//获取控件尺寸

        //计算纵轴标识文本坐标
        textY_X = viewSize * TIME_X;
        textY_Y = viewSize * TIME_Y;

        //计算横轴标识文本坐标
        textX_X = viewSize * MONEY_X;
        textX_Y = viewSize * MONEY_Y;

        //计算xy轴标识文本大小
        textSignSize = viewSize * TEXT_SIGN;

        //计算网格左上右下两点坐标
        left = viewSize * LEFT;
        top = viewSize * TOP;
        right = viewSize * RIGHT;
        bottom = viewSize * BOTTOM;

        //计算粗线宽度
        thickLineWidth = viewSize * THICK_LINE_WIDTH;

        //计算细线宽度
        thinLineWidth = viewSize * THIN_LINE_WIDTH;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0XFF9596C4);

        drawSign(canvas);

        drawGrid(canvas);

        drawPolyline(canvas);

        drawGradient(canvas);
    }

    private void drawGradient(Canvas canvas) {
        gradientPath.reset();
        gradientPath.addPath(mPath);
        gradientPath.lineTo(last, bottom);
        gradientPath.lineTo(first, bottom);
        gradientPath.close();

        gradientPaint.setShader(new LinearGradient(right, top, right, bottom - 2 * spaceY, Color.parseColor("#ff9ac4a0"), Color.TRANSPARENT, Shader.TileMode.CLAMP));

        canvas.translate(left, top + spaceY);
        canvas.drawPath(gradientPath, gradientPaint);
    }

    private void drawPolyline(Canvas canvas) {
        //生成一个Bitmap对象大小和我们的网格大小一致
        mBitmap = Bitmap.createBitmap((int) (viewSize * (RIGHT - LEFT) - spaceX), (int) (viewSize * (BOTTOM - TOP) - spaceY), Bitmap.Config.ARGB_8888);

        // 将Bitmap注入Canvas
        mCanvas.setBitmap(mBitmap);

        // 为画布填充一个半透明的蓝色
        mCanvas.drawARGB(175, 25, 39, 109);

        // 重置曲线
        mPath.reset();

        float width = mCanvas.getWidth() / maxX;
        float height = mCanvas.getHeight() / maxY;

        //生成Path和绘制Point
        for (int i = 0; i < pointFs.size(); i++) {
            //计算x轴坐标
            float x = width * pointFs.get(i).x;

            //计算y轴坐标
            float y = height * pointFs.get(i).y;
            y = mCanvas.getHeight() - y;

            //绘制小点点
//            mCanvas.drawCircle(x, y, thickLineWidth, pointPaint);

            //如果是第一个点则将其设置为Path的起点
            if (i == 0) {
                mPath.moveTo(x, y);
                first = x;
            }

            if (i == pointFs.size() - 1) {
                last = x;
            }

            //连接各点
            mPath.lineTo(x, y);
        }

//        linePaint.setShader(new LinearGradient(left, top, right, bottom, Color.GREEN, Color.TRANSPARENT, Shader.TileMode.CLAMP));

        // 设置PathEffect
        linePaint.setPathEffect(new CornerPathEffect(100));

        //重置线条宽度
        linePaint.setStrokeWidth(thickLineWidth);

        // 将Path绘制到我们自定的Canvas上
        mCanvas.drawPath(mPath, linePaint);

//        Region region = new Region();
//        region.setPath(mPath, region);

        //将mBitmap绘制到原来的canvas
        canvas.drawBitmap(mBitmap, left, top + spaceY, null);
    }

    private void drawGrid(Canvas canvas) {
        canvas.save();//锁定画布

        //设置线条画笔宽度
        linePaint.setStrokeWidth(thickLineWidth);

        //计算xy轴path
//        mPath.moveTo(left, top);
//        mPath.lineTo(left, bottom);
//        mPath.lineTo(right, bottom);

//        canvas.drawPath(mPath, linePaint);//绘制xy轴

        drawLines(canvas);//绘制线条

        canvas.restore();//释放画布
    }

    private void drawLines(Canvas canvas) {
        float textRulerSize = textSignSize / 2F;//计算刻度文字尺寸

        mTextPaint.setTextSize(textRulerSize);//重置文字画笔文字尺寸

        linePaint.setStrokeWidth(thinLineWidth);//重置线条画笔描边宽度

        int count = pointFs.size();//获取数据长度

        int divisor = count - 1;//计算除数的值为数据长度减一

        //计算横轴数据最大值
        maxX = 0;
        for (int i = 0; i < count; i++) {
            if (maxX < pointFs.get(i).x) {
                maxX = pointFs.get(i).x;
            }
        }

        //计算横轴最近的能被count整除的值
        int remainderX = ((int) maxX) % divisor;
        maxX = remainderX == 0 ? ((int) maxX) : divisor - remainderX + ((int) maxX);

        //计算纵轴数据最大值
        maxY = 0;
        for (int i = 0; i < count; i++) {
            if (maxY < pointFs.get(i).y) {
                maxY = pointFs.get(i).y;
            }
        }

        //计算纵轴最近的能被count整除的值
        int remainderY = ((int) maxY) % divisor;
        maxY = remainderY == 0 ? ((int) maxY) : divisor - remainderY + ((int) maxY);

        //生成横轴刻度值
        ruleX = new float[count];
        for (int i = 0; i < count; i++) {
            ruleX[i] = maxX / divisor * i;
        }

        //生成纵轴刻度值
        ruleY = new float[count];
        for (int i = 0; i < count; i++) {
            ruleY[i] = maxY / divisor * i;
        }

        //计算横纵坐标刻度间隔
        spaceY = viewSize * (BOTTOM - TOP) / count;
        spaceX = viewSize * (RIGHT - LEFT) / count;

        // 锁定画布并设置画布透明度为75%
        int sc = canvas.saveLayerAlpha(0, 0, canvas.getWidth(), canvas.getHeight(), 75, Canvas.ALL_SAVE_FLAG);

        //绘制横纵线段
        for (float y = viewSize * BOTTOM - spaceY; y > viewSize * TOP; y -= spaceY) {
            for (float x = viewSize * LEFT; x < viewSize * RIGHT; x += spaceX) {
                // 绘制纵向线段
                if (y == viewSize * TOP + spaceY) {
                    canvas.drawLine(x, y, x, y + spaceY * (count - 1), linePaint);
                }

                // 绘制横向线段
                if (x == viewSize * RIGHT - spaceX) {
                    canvas.drawLine(x, y, x - spaceX * (count - 1), y, linePaint);
                }
            }
        }

        // 还原画布
        canvas.restoreToCount(sc);

        // 绘制横纵轴向刻度值
        int index_x = 0, index_y = 1;
        for (float y = viewSize * BOTTOM - spaceY; y > viewSize * TOP; y -= spaceY) {
            for (float x = viewSize * LEFT; x < viewSize * RIGHT; x += spaceX) {
                // 绘制横轴刻度数值
                if (y == viewSize * BOTTOM - spaceY) {
                    canvas.drawText(String.valueOf(ruleX[index_x]), x, y + textSignSize + spaceY, mTextPaint);
                }

                // 绘制纵轴刻度数值
                if (x == viewSize * LEFT) {
                    canvas.drawText(String.valueOf(ruleY[index_y]), x - thickLineWidth, y + textRulerSize, mTextPaint);
                }

                index_x++;
            }
            index_y++;
        }

    }

    private void drawSign(Canvas canvas) {
        canvas.save();//锁定画布

        mTextPaint.setTextSize(textSignSize);//设置文本画笔文字尺寸

        //绘制纵轴标识文字
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(null == signY ? "y" : signY, textY_X, textY_Y, mTextPaint);

        //绘制横轴标识文字
        mTextPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(null == signX ? "x" : signX, textX_X, textX_Y, mTextPaint);

        canvas.restore();//释放画布
    }

    public synchronized void setData(List<PointF> pointFs, String singX, String signY) {
        if (null == pointFs || pointFs.size() == 0) {
            throw new IllegalArgumentException("No data to display!");
        }

        if (pointFs.size() > 10) {
            throw new IllegalArgumentException("The data is too long to display!");
        }

        this.pointFs = pointFs;
        this.signX = singX;
        this.signY = signY;
        invalidate();
    }


}
