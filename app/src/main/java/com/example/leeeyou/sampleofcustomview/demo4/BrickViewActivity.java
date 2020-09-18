package com.example.leeeyou.sampleofcustomview.demo4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class BrickViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brickview);

        setTitle("BitmapShader repeat模式实现移动圆环");
    }

}
