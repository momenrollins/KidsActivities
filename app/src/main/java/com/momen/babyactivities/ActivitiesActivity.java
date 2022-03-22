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
        activitiesAdapter = new ActivitiesAdapter();
        recyclerView.setAdapter(activitiesAdapter);
        lvl = getIntent().getIntExtra("lvl", 1);
        activitiesAdapter.setOnItemClickListener(position ->
        {

                startActivity(new Intent(this, MainActivity.class)
                        .putExtra("lvl", lvl).putExtra("actvtyNum", position));
        });
    }
}