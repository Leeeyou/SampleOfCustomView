package com.sample.leeeyou.customview.demo1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo1EcgViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1_ect_view);
        setTitle("心电图示例");
    }
}
