package com.sample.leeeyou.customview.demo3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo3ShadowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3_shadow);
        setTitle("绘制阴影 setShadowLayer");
    }
}
