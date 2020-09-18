package com.sample.leeeyou.customview.demo2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo2.view.ColorMatrixView;

public class Demo2ColorMatrixFilterActivity extends AppCompatActivity {
    private ColorMatrixView mColorMatrixView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2_color_matrix_filter);
        setTitle("颜色矩阵过滤器示例");
        mColorMatrixView = findViewById(R.id.colorMatrixView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_color_matrix_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                mColorMatrixView.setColorMatrix(1);
                setTitle("颜色矩阵过滤器示例：变暗效果");
                break;
            case R.id.action_2:
                mColorMatrixView.setColorMatrix(2);
                setTitle("颜色矩阵过滤器示例：变灰效果");
                break;
            case R.id.action_3:
                mColorMatrixView.setColorMatrix(3);
                setTitle("颜色矩阵过滤器示例：反相效果");
                break;
            case R.id.action_4:
                mColorMatrixView.setColorMatrix(4);
                setTitle("颜色矩阵过滤器示例：红、蓝色相互变换效果");
                break;
            case R.id.action_5:
                mColorMatrixView.setColorMatrix(5);
                setTitle("颜色矩阵过滤器示例：老旧照片效果");
                break;
            case R.id.action_6:
                mColorMatrixView.setColorMatrix(6);
                setTitle("颜色矩阵过滤器示例：去色后高对比度");
                break;
            case R.id.action_7:
                mColorMatrixView.setColorMatrix(7);
                setTitle("颜色矩阵过滤器示例：饱和度对比度加强");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
