package com.example.leeeyou.sampleofcustomview.demo5;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leeeyou.sampleofcustomview.R;
import com.example.leeeyou.sampleofcustomview.demo5.customeview.ThirdBezierView;

public class ThirdOrderBesselActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_order_bessel);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radioBtn1 = (RadioButton) findViewById(R.id.radioBtn1);
        RadioButton radioBtn2 = (RadioButton) findViewById(R.id.radioBtn2);

        final ThirdBezierView thirdBezierView = (ThirdBezierView) findViewById(R.id.thirdBezierView);

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
