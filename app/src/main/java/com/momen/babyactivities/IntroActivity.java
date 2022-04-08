package com.momen.babyactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void Goals(View view) {
        startActivity(new Intent(this, DisplayActivity.class)
                .putExtra("index", 0));
    }

    public void Info(View view) {
        startActivity(new Intent(this, DisplayActivity.class)
                .putExtra("index", 1));
    }

    public void Conponants(View view) {
        startActivity(new Intent(this, ChooseLevelActivity.class));
    }
}