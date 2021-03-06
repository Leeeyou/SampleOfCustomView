package com.sample.leeeyou.customview.demo5;

import android.graphics.PointF;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo5.view.PolylineView;

import java.util.ArrayList;
import java.util.List;

public class Demo5PolyLineViewActivity extends AppCompatActivity {
    PolylineView mPolylineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_poly_line_view);

        mPolylineView = findViewById(R.id.main_pv);

        List<PointF> pointFs = new ArrayList<>();
        pointFs.add(new PointF(0.3F, 0.5F));
        pointFs.add(new PointF(1F, 2.7F));
        pointFs.add(new PointF(2F, 8.5F));
        pointFs.add(new PointF(3F, 1.2F));
        pointFs.add(new PointF(4F, 1.6F));
        pointFs.add(new PointF(5F, 0.9F));
        pointFs.add(new PointF(6F, 4.2F));
        pointFs.add(new PointF(7F, 5.5F));
        pointFs.add(new PointF(8F, 7F));
        pointFs.add(new PointF(8.6F, 5.7F));

        mPolylineView.setData(pointFs, "Money", "Time");
    }


}
