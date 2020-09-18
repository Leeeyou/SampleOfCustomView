package com.example.leeeyou.sampleofcustomview.demo6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;

public class Demo6MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo6);
    }

    public void click_layerview_basic(View v) {
        startActivity(new Intent().setClass(this, LayerViewBasicActivity.class));
    }

    public void click_layerview_save_restore(View v) {
        startActivity(new Intent().setClass(this, LayerViewSaveRestoreActivity.class));
    }

    public void click_layerview_transfer(View v) {
        startActivity(new Intent().setClass(this, LayerViewTransferActivity.class));
    }

    public void click_matrixview_pre_post(View v) {
        startActivity(new Intent().setClass(this, MatrixViewActivity.class));
    }

    public void click_draw_pieview(View v) {
        startActivity(new Intent().setClass(this, PieViewActivity.class));
    }
}
