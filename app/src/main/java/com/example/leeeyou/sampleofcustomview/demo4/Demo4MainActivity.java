package com.example.leeeyou.sampleofcustomview.demo4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo4);
    }

    public void clickBrickView(View v) {
        startActivity(new Intent().setClass(this, BrickViewActivity.class));
    }

    public void clickReflectView(View v) {
        startActivity(new Intent().setClass(this, ReflectViewActivity.class));
    }

    public void clickDreamView(View v) {
        startActivity(new Intent().setClass(this, DreamViewActivity.class));
    }

    public void clickMatrixImageView(View v) {
        startActivity(new Intent().setClass(this, MatrixImageViewActivity.class));
    }

}
