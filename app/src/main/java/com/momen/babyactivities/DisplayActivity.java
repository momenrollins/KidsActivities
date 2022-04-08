package com.momen.babyactivities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private ImageView img;
    int[] images={R.drawable.img_intro_1,R.drawable.img_intro_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initView();
        img.setImageResource(images[getIntent().getIntExtra("index", 0)]);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
    }
}