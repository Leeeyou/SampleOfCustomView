package com.sample.leeeyou.customview.demo9;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.leeeyou.customview.R;
import com.sample.leeeyou.customview.demo9.customView.CustomCheckBox1;

public class Demo9CombiningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo9_combining);

        CustomCheckBox1 checkBox = findViewById(R.id.complexView);
        BitmapDrawable conference = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.conference));
        BitmapDrawable conference_select = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.conference_select));
        checkBox.setButtonDrawable(conference_select, conference);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(Demo9CombiningActivity.this, "选中", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Demo9CombiningActivity.this, "未选中", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
