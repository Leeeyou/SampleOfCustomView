package com.example.leeeyou.sampleofcustomview.demo7;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;
import com.example.leeeyou.sampleofcustomview.demo7.customview.ImgView;

public class ImgViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_view);

        ImgView imgView = (ImgView) findViewById(R.id.imgView);
        imgView.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.a));

        setTitle("ImgView");
    }

}
