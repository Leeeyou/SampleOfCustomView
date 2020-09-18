package com.example.leeeyou.sampleofcustomview.demo9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo9MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo9);
    }

    public void clickCombiningView(View v) {
        startActivity(new Intent().setClass(this, CombiningActivity.class));
    }

    public void clickSlackView(View v) {
        startActivity(new Intent().setClass(this, SlackActivity.class));
    }

}
