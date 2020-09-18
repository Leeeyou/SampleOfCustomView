package com.example.leeeyou.sampleofcustomview.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo1);

        CustomCircleView customCircleView = (CustomCircleView) findViewById(R.id.customCircleView);
        new Thread(customCircleView).start();
    }

    public void clickECGView(View v) {
        startActivity(new Intent().setClass(this, ECGViewActivity.class));
    }
}
