package com.momen.babyactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ChooseLevelActivity extends AppCompatActivity implements View.OnClickListener {

    Button lvl1;
    Button lvl2;
    Button lvl3;
    Button backBtn;
    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lvl1 = findViewById(R.id.lvl1);
        lvl1.setOnClickListener(this);
        lvl2 = findViewById(R.id.lvl2);
        lvl2.setOnClickListener(this);
        lvl3 = findViewById(R.id.lvl3);
        lvl3.setOnClickListener(this);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        exitBtn = findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int lvl;
        if (view == lvl1) {
            lvl = 1;
            startActivity(new Intent(this, LevelTypeActivity.class).putExtra("lvl", lvl));
        } else if (view == lvl2) {
            lvl = 2;
            startActivity(new Intent(this, LevelTypeActivity.class).putExtra("lvl", lvl));
        } else if (view == lvl3) {
            lvl = 3;
            startActivity(new Intent(this, LevelTypeActivity.class).putExtra("lvl", lvl));
        } else if (view == backBtn) {
            onBackPressed();
        } else if (view == exitBtn) {
            this.finishAffinity();
        }
    }
}