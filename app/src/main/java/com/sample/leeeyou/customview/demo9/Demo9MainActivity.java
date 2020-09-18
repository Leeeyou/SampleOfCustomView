package com.sample.leeeyou.customview.demo9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo9MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo9_main);
    }

    public void clickCombiningView(View v) {
        startActivity(new Intent().setClass(this, Demo9CombiningActivity.class));
    }

    public void clickSlackView(View v) {
        startActivity(new Intent().setClass(this, Demo9SlackActivity.class));
    }

}
