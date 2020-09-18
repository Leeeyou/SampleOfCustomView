package com.sample.leeeyou.customview.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo3MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3_main);

        Button btn_font = (Button) findViewById(R.id.btn_font);
        btn_font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3MainActivity.this, Demo3FontActivity.class));
            }
        });

        Button btn_maskfilter = (Button) findViewById(R.id.btn_maskfilter);
        btn_maskfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3MainActivity.this, Demo3MaskFilterActivity.class));
            }
        });

        Button btn_shadow = (Button) findViewById(R.id.btn_shadow);
        btn_shadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3MainActivity.this, Demo3ShadowActivity.class));
            }
        });
    }
}
