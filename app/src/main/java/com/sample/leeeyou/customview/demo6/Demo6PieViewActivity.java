package com.sample.leeeyou.customview.demo6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo6.bean.PieData;
import com.sample.leeeyou.customview.demo6.view.PieView;

import java.util.ArrayList;

public class Demo6PieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6_pie_view);

        setTitle("pie_view");

        ArrayList<PieData> mPieData = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PieData pieData = new PieData("position " + i, (float) Math.random());
            mPieData.add(pieData);
        }

        PieView pieView = (PieView) findViewById(R.id.pieView);
        pieView.setmData(mPieData);
    }

}
