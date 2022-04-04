package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BoyandGirl_45 extends AppCompatActivity {

    private VideoView videoView;
    private ImageView boy;
    private ImageView girl;
    private ImageView basketBall;
    int index = 0;
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
        runnable = new Runnable() {
            @Override
            public void run() {

                playVideo("android.resource://" + getPackageName() + "/" + R.raw.basket_girl, false);


            }
        };
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, true);

            }
        });
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basketBall.animate()
                        .x((float) 1489)
                        .y((float) 189)
                        .setDuration(2200)
                        .start();
                handler.postDelayed(runnable, 2200);

            }
        });
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basketBall.animate()
                        .x((float) 414)
                        .y((float) 210)
                        .setDuration(2200)
                        .start();
                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

            }
        });

        basketBall.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        basketBall.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        basketBall.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(basketBall.getX(), basketBall.getY());
                        Log.d("TAG", "onTouch:y  y = " + basketBall.getY());
                        Log.d("TAG", "onTouch:x  x= " + basketBall.getX());

                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(basketBall.getX(), basketBall.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        playVideo("android.resource://" + getPackageName() + "/" + R.raw.bassket_boy, true);

    }

    public void playVideo(String path, boolean isBoy) {
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!isBoy) {

                }

            }
        });
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        boy = (ImageView) findViewById(R.id.boy);
        girl = (ImageView) findViewById(R.id.girl);
        basketBall = (ImageView) findViewById(R.id.basket_ball);
        container = (ConstraintLayout) findViewById(R.id.container);
    }
}