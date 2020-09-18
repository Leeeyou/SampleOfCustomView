package com.sample.leeeyou.customview.demo6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;

public class Demo6MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6_main);
    }

    public void click_layerview_basic(View v) {
        startActivity(new Intent().setClass(this, Demo6LayerViewBasicActivity.class));
    }

    public void click_layerview_save_restore(View v) {
        startActivity(new Intent().setClass(this, Demo6LayerViewSaveRestoreActivity.class));
    }

    public void click_layerview_transfer(View v) {
        startActivity(new Intent().setClass(this, Demo6LayerViewTransferActivity.class));
    }

    public void click_matrixview_pre_post(View v) {
        startActivity(new Intent().setClass(this, Demo6MatrixViewActivity.class));
    }

    public void click_draw_pieview(View v) {
        startActivity(new Intent().setClass(this, Demo6PieViewActivity.class));
    }
}
