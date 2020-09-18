package com.sample.leeeyou.customview.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo1.view.CustomCircleView;

public class Demo1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1_main);
        setTitle("Demo1");

        CustomCircleView customCircleView = findViewById(R.id.customCircleView);
        new Thread(customCircleView).start();
    }

    public void onClickEcgView(View v) {
        startActivity(new Intent().setClass(this, Demo1EcgViewActivity.class));
    }

}
