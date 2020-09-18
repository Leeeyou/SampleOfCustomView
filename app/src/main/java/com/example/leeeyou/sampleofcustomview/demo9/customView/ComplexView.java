package com.example.leeeyou.sampleofcustomview.demo9.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leeeyou.sampleofcustomview.R;

/**
 * Created by leeeyou on 16/5/6.
 * <p/>
 * 继承FrameLayout,并且指定xml布局文件
 */
public class ComplexView extends FrameLayout {
    private ImageView itemImageView;
    private TextView itemTextView;

    public ComplexView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater LayoutInflater = (android.view.LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater.inflate(R.layout.activity_text_image, this);

        itemImageView = (ImageView) findViewById(R.id.item_imageview);
        itemTextView = (TextView) findViewById(R.id.item_textview);
    }

    public void setImageIcon(int resId) {
        itemImageView.setImageResource(resId);
    }

    public TextView getTextView() {
        return itemTextView;
    }

}
