package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class RabbitJump extends AppCompatActivity {

    private ImageView rabbit;
    private Button finishBtn;
    Handler handler = new Handler();
    Runnable runnable;
    ArrayList<pointModel> pointList = new ArrayList();
    int index = 0;
    private VideoView videoView;
    private ConstraintLayout container;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit_jump);
        initView();
        playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_start, false);
        pointList.add(new pointModel(554, 342));
        pointList.add(new pointModel(803, 461));
        pointList.add(new pointModel(1020, 357));
        pointList.add(new pointModel(1257, 461));
        pointList.add(new pointModel(1505, 355));
        pointList.add(new pointModel(1708, 463));
        runnable = new Runnable() {
            @Override
            public void run() {
                if (index < pointList.size()) {
                    rabbit.animate()
                            .x((float) pointList.get(index).x)
                            .y((float) pointList.get(index).y)
                            .setDuration(1000)
                            .start();
                    index++;
                    handler.postDelayed(runnable, 1000);
                } else {
                    videoView.setBackground(null);
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_success, true);
                    handler.removeCallbacks(runnable);
                }

            }
        };
        rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0)
                    handler.post(runnable);
            }
        });
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

            }
        });
    }

    private void initView() {
        rabbit = (ImageView) findViewById(R.id.rabbit);
        videoView = (VideoView) findViewById(R.id.videoView);
        finishBtn = findViewById(R.id.finishBtn);
        container = (ConstraintLayout) findViewById(R.id.container);
    }

    public void playVideo(String path, boolean finish) {
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (finish) {
                    finishBtn.setVisibility(View.VISIBLE);
                    finishBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            RabbitJump.super.onBackPressed();
                        }
                    });
                }
            }
        });
    }


    private class pointModel {
        double x;
        double y;

        public pointModel(double x, double y) {
            this.x = x;
            this.y = y;
        }


        public pointModel() {
        }
    }
}