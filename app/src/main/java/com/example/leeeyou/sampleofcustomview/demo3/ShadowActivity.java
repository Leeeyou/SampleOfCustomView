package com.example.leeeyou.sampleofcustomview.demo3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class ShadowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
        setTitle("绘制阴影 setShadowLayer");
    }
}
