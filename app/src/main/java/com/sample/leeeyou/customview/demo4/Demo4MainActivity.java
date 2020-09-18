package com.sample.leeeyou.customview.demo4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4_main);
    }

    public void clickBrickView(View v) {
        startActivity(new Intent().setClass(this, Demo4BrickViewActivity.class));
    }

    public void clickReflectView(View v) {
        startActivity(new Intent().setClass(this, Demo4ReflectViewActivity.class));
    }

    public void clickDreamView(View v) {
        startActivity(new Intent().setClass(this, Demo4DreamViewActivity.class));
    }

    public void clickMatrixImageView(View v) {
        startActivity(new Intent().setClass(this, Demo4MatrixImageViewActivity.class));
    }

}
