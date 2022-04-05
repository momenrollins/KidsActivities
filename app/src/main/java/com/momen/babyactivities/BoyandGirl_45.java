package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BoyandGirl_45 extends AppCompatActivity {

    private VideoView videoView;
    private ImageView boy;
    private ImageView girl;
    private Button finishBtn;
    private ImageView basketBall;
    int index = 0;
    boolean girlTurn = false;
    boolean boyTurn = true;
    int[] startList = {R.raw.bassket_boy, R.raw.basket_girl};
    Handler handler = new Handler();
    Runnable runnable;
    private ConstraintLayout container;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boyand_girl45);
        initView();
        index = getIntent().getIntExtra("actvtyNum", 0);
        if (index == 0)
            runnable = () -> playVideo("android.resource://" + getPackageName() + "/" + R.raw.basket_girl, false, false);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boyTurn || girlTurn)
                    if (index < 2)
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, true, false);
                    else
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile2, true, false);


            }
        });
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0) {
                    if (boyTurn) {
                        basketBall.animate()
                                .x((float) 1489)
                                .y((float) 189)
                                .setDuration(2200)
                                .start();
                        handler.postDelayed(runnable, 2200);
                        boyTurn = false;
                        girlTurn = true;
                    }
                } else if (index == 1) {
                    if (boyTurn) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookright, true, false);

                        boyTurn = false;
                        girlTurn = true;
                    }
                } else {
                    if (boyTurn) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile3, true, true);

                        boyTurn = false;
                        girlTurn = false;
                    }
                }
            }
        });
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0) {
                    if (girlTurn) {
                        {
                            basketBall.animate()
                                    .x((float) 414)
                                    .y((float) 210)
                                    .setDuration(2200)
                                    .start();
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true, true);
                            girlTurn = false;
                        }
                    }
                } else if (index == 1) {
                    if (girlTurn) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true, true);
                        girlTurn = false;
                    }
                } else {
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile2, true, true);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (index == 0)
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.bassket_boy, true, false);
        else if (index == 1) {
            videoView.setBackground(null);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookleft, true, false);
            boy.setImageResource(R.drawable.left_tree);

            girl.setImageResource(R.drawable.right_tree);
            basketBall.setVisibility(View.GONE);
        } else {
            videoView.setBackground(null);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile1, true, false);
            boy.setImageResource(R.drawable.smile);

            girl.setImageResource(R.drawable.sad);
            basketBall.setVisibility(View.GONE);
        }
    }

    public void playVideo(String path, boolean isBoy, boolean finish) {
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
                            BoyandGirl_45.super.onBackPressed();
                        }
                    });
                }

            }
        });
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        boy = (ImageView) findViewById(R.id.boy);
        finishBtn = findViewById(R.id.finishBtn);
        girl = (ImageView) findViewById(R.id.girl);
        basketBall = (ImageView) findViewById(R.id.basket_ball);
        container = (ConstraintLayout) findViewById(R.id.container);
    }
}