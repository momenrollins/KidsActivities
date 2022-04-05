package com.momen.babyactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ActivitiesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ActivitiesAdapter activitiesAdapter;
    int lvl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        recyclerView = findViewById(R.id.activity_recycler);
        recyclerView.setHasFixedSize(true);
        lvl = getIntent().getIntExtra("lvl", 1);
        activitiesAdapter = new ActivitiesAdapter(lvl);
        recyclerView.setAdapter(activitiesAdapter);
        activitiesAdapter.setOnItemClickListener(position ->
        {
            if (lvl == 1) {
                if (position == 2)
                    startActivity(new Intent(this, PlayVideoActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", 0));
                else if (position <= 26)
                    startActivity(new Intent(this, MainActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position <= 33)
                    startActivity(new Intent(this, DragActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position <= 36)
                    startActivity(new Intent(this, MovingActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position <= 39)
                    startActivity(new Intent(this, TasneefActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position <= 40)
                    startActivity(new Intent(this, ColorActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position <= 41)
                    startActivity(new Intent(this, CollectSquaresActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else
                    startActivity(new Intent(this, PlayVideoActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", 1));
            } else if (lvl == 2) {
                if (position == 0) startActivity(new Intent(this, RabbitJump.class));
                else if (position == 1) startActivity(new Intent(this, BoyandGirl_45.class).putExtra("actvtyNum", 0));
                else if (position == 2) startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 46));
                else if (position == 3) startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 47));
                else if (position == 5) startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 49));
                else if (position == 6) startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 50));
                else if (position == 7) startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 51));
                else if (position == 9) startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 53));
                else  startActivity(new Intent(this, BoyandGirl_45.class).putExtra("actvtyNum", 1));
            }
        });
    }
}