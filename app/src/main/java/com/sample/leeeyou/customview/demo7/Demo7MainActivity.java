package com.sample.leeeyou.customview.demo7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo7MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_main);
    }

    public void clickImgView(View v) {
        startActivity(new Intent().setClass(this, Demo7ImgViewActivity.class));
    }

    public void clickIconView(View v) {
        startActivity(new Intent().setClass(this, Demo7IconViewActivity.class));
    }

    public void clickCustomLayout(View v) {
        startActivity(new Intent().setClass(this, Demo7CustomLayoutActivity.class));
    }
    
}
