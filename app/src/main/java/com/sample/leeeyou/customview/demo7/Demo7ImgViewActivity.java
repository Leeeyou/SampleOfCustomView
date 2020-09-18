package com.sample.leeeyou.customview.demo7;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo7.view.ImgView;

public class Demo7ImgViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_img_view);

        ImgView imgView = findViewById(R.id.imgView);
        imgView.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.a));

        setTitle("ImgView");
    }

}
