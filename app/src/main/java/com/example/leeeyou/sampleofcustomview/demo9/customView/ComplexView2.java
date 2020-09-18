package com.example.leeeyou.sampleofcustomview.demo9.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.leeeyou.sampleofcustomview.R;

/**
 * Created by leeeyou on 16/5/6.
 * <p/>
 * 继承LinearLayout,采用new的方式创建ImageView和TextView,并添加到控件中
 */
public class ComplexView2 extends LinearLayout {
    private ImageView itemImageView;
    private TextView itemTextView;

    public ComplexView2(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        itemImageView = new ImageView(context);
        itemImageView.setImageResource(R.mipmap.ic_launcher);

        itemTextView = new TextView(context);
        itemTextView.setText("Compond new Object");
        itemTextView.setTextSize(25);
        itemTextView.setTypeface(Typeface.DEFAULT_BOLD);

        addView(itemImageView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(itemTextView, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

}
