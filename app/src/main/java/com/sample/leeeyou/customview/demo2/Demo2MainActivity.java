package com.sample.leeeyou.customview.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2_main);
        setTitle("Demo2");

        Button btn_color_matrix_filter = findViewById(R.id.btn_color_matrix_filter);
        btn_color_matrix_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2ColorMatrixFilterActivity.class));
            }
        });

        Button btn_lighting_color_filter = findViewById(R.id.btn_lighting_color_filter);
        btn_lighting_color_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2LightingColorFilterActivity.class));
            }
        });

        Button btn_porter_duff_color_filter = findViewById(R.id.btn_porter_duff_color_filter);
        btn_porter_duff_color_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2PorterDuffColorFilterActivity.class));
            }
        });

        Button btn_porter_duff_xfermode = findViewById(R.id.btn_porter_duff_xfermode);
        btn_porter_duff_xfermode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2PorterDuffXfermodeActivity.class));
            }
        });

        Button btn_dst_in_exercise = findViewById(R.id.btn_dst_in_exercise);
        btn_dst_in_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2DstInActivity.class));
            }
        });

        Button btn_dst_out_exercise = findViewById(R.id.btn_dst_out_exercise);
        btn_dst_out_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2DstOutActivity.class));
            }
        });

        Button btn_eraser = findViewById(R.id.btn_eraser);
        btn_eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo2MainActivity.this, Demo2EraserActivity.class));
            }
        });

    }
}
