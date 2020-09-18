package com.example.leeeyou.sampleofcustomview.demo7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo7MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo7);
    }

    public void clickImgView(View v) {
        startActivity(new Intent().setClass(this, ImgViewActivity.class));
    }

    public void clickIconView(View v) {
        startActivity(new Intent().setClass(this, IconViewActivity.class));
    }

    public void clickCustomLayout(View v) {
        startActivity(new Intent().setClass(this, CustomLayoutActivity.class));
    }
    
}
