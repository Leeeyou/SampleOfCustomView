package com.sample.leeeyou.customview.demo5;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo5.view.ThirdBezierView;

public class Demo5ThirdOrderBesselActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_third_order_bessel);
        setTitle("三阶贝塞尔曲线");

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final RadioButton radioBtn1 = findViewById(R.id.radioBtn1);
        RadioButton radioBtn2 = findViewById(R.id.radioBtn2);

        final ThirdBezierView thirdBezierView = findViewById(R.id.thirdBezierView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioBtn1.getId()) {
                    thirdBezierView.setMode(true);
                } else {
                    thirdBezierView.setMode(false);
                }
            }
        });

    }
}
