package com.sample.leeeyou.customview.demo4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo4BrickViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4_brickview);
        setTitle("BitmapShader repeat模式实现移动圆环");
    }

}
