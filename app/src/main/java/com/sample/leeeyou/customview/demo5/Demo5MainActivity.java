package com.sample.leeeyou.customview.demo5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo5MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_main);
    }

    public void clickPathTextPaint(View v) {
        startActivity(new Intent().setClass(this, Demo5PathTextPaintActivity.class));
    }

    public void clickPolyLineView(View v) {
        startActivity(new Intent().setClass(this, Demo5PolyLineViewActivity.class));
    }

    public void clickRadarView(View v) {
        startActivity(new Intent().setClass(this, Demo5RadarActivity.class));
    }

    public void clickSecondOrderBesselView(View v) {
        startActivity(new Intent().setClass(this, Demo5SecondOrderBesselActivity.class));
    }

    public void clickThirdOrderBesselView(View v) {
        startActivity(new Intent().setClass(this, Demo5ThirdOrderBesselActivity.class));
    }

    public void clickPathMeasureView(View v) {
        startActivity(new Intent().setClass(this, Demo5PathMeasureActivity.class));
    }

}
