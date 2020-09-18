package com.example.leeeyou.sampleofcustomview.demo5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo5MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo5);
    }

    public void clickPathTextPaint(View v) {
        startActivity(new Intent().setClass(this, PathTextPaintActivity.class));
    }

    public void clickPolyLineView(View v) {
        startActivity(new Intent().setClass(this, PolyLineViewActivity.class));
    }

    public void clickRadarView(View v) {
        startActivity(new Intent().setClass(this, RadarActivity.class));
    }

    public void clickSecondOrderBesselView(View v) {
        startActivity(new Intent().setClass(this, SecondOrderBesselActivity.class));
    }

    public void clickThirdOrderBesselView(View v) {
        startActivity(new Intent().setClass(this, ThirdOrderBesselActivity.class));
    }

    public void clickPathMeasureView(View v) {
        startActivity(new Intent().setClass(this, PathMeasureActivity.class));
    }

}
