package com.example.leeeyou.sampleofcustomview.demo9.customView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.example.leeeyou.sampleofcustomview.R;

/**
 * Created by leeeyou on 16/5/6.
 * <p/>
 * 自定义CheckBox
 */
public class CustomCheckBox1 extends androidx.appcompat.widget.AppCompatCheckBox {
    private boolean mChecked;
    private OnCheckedChangeListener mOnCheckedChangeListener;

    private Drawable selectDrawable, unselectDrawable;

    public CustomCheckBox1(Context context) {
        this(context, null);
    }

    public CustomCheckBox1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCheckBox1(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @SuppressLint("NewApi")
    public CustomCheckBox1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.customCheckBox);

        selectDrawable = a.getDrawable(R.styleable.customCheckBox_selectButtonDrawable);
        if (selectDrawable == null) {
            selectDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.key_selected));
        }

        unselectDrawable = a.getDrawable(R.styleable.customCheckBox_unselectButtonDrawable);
        if (unselectDrawable == null) {
            unselectDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.key));
        }

        mChecked = a.getBoolean(R.styleable.customCheckBox_checked, false);

        changeButtoDrawable();

        a.recycle();

        setClickable(true);
    }

    private void changeButtoDrawable() {
        if (mChecked) {
            setButtonDrawable(selectDrawable);
        } else {
            setButtonDrawable(unselectDrawable);
        }
    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;

        changeButtoDrawable();

        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, checked);
        }
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    public void setButtonDrawable(Drawable selectDrawable, Drawable unselectDrawable) {
        this.selectDrawable = selectDrawable;
        this.unselectDrawable = unselectDrawable;
        invalidate();
    }

}
