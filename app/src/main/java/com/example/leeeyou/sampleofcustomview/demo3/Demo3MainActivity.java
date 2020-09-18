package com.example.leeeyou.sampleofcustomview.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo3MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo3);

        Button btn_font = (Button) findViewById(R.id.btn_font);
        btn_font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3MainActivity.this, FontActivity.class));
            }
        });

        Button btn_maskfilter = (Button) findViewById(R.id.btn_maskfilter);
        btn_maskfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3MainActivity.this, MaskFilterActivity.class));
            }
        });

        Button btn_shadow = (Button) findViewById(R.id.btn_shadow);
        btn_shadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3MainActivity.this, ShadowActivity.class));
            }
        });
    }
}
