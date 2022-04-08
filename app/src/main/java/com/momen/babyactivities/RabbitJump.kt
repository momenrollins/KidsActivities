package com.momen.babyactivities;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
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
    Path path = new Path();
    boolean isStart=false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit_jump);
        initView();
        playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_start, false,false);

        pointList.add(new pointModel(346, 321));
        pointList.add(new pointModel(599, 547));
        pointList.add(new pointModel(794, 334));
        pointList.add(new pointModel(1057, 547));
        pointList.add(new pointModel(1232, 339));
        pointList.add(new pointModel(1501, 548));
        pointList.add(new pointModel(1695, 355));
        pointList.add(new pointModel(1956, 545));
        runnable = new Runnable() {
            @Override
            public void run() {

                Log.d("TAG", "run: is"+isStart);

                if (isStart) {
                    if (index % 2 != 0)
                        rabbit.animate()
                                .x((float) pointList.get(index).x)
                                .y((float) pointList.get(index).y)
                                .setDuration(1000)
                                .start();
                    index++;
                    if (index < pointList.size()) {

                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_start, false,false);
                    } else {
                        videoView.setBackground(null);
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_success, true,false);
                        handler.removeCallbacks(runnable);
                    }
                }else {
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_start, false,false);

                   // handler.postDelayed(runnable, 2500);

                }

            }
        };

        rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* path.arcTo(0f, (float) pointList.get(index).y,(float) pointList.get(index).x,0f, 180f, 60f, true);
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
                animator.setDuration(2000);
                animator.start();*/

                isStart=true;
                rabbit.animate()
                        .x((float) pointList.get(index).x)
                        .y((float) pointList.get(index).y)
                        .setDuration(1000)
                        .start();
                index++;

                if (index < pointList.size()) {

                    handler.postDelayed(runnable, 1000);
                } else {
                    videoView.setBackground(null);
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_success, true,false);
                    handler.removeCallbacks(runnable);
                }
            }
        });

        /*rabbit.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        rabbit.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        rabbit.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(rabbit.getX(), rabbit.getY());


                        Log.d("TAG", "onTouch:y  y = " + rabbit.getY() +" x = "+ rabbit.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(rabbit.getX(), rabbit.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });*/

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false,true);

            }
        });
    }

    private void initView() {
        rabbit = (ImageView) findViewById(R.id.rabbit);
        videoView = (VideoView) findViewById(R.id.videoView);
        finishBtn = findViewById(R.id.finishBtn);
        container = (ConstraintLayout) findViewById(R.id.container);
    }

    public void playVideo(String path, boolean finish,boolean faild) {
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
                }else if (!isStart){
                    handler.postDelayed(runnable, 2500);

                }else if (faild){
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.rabbit_j_start, false,false);

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

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