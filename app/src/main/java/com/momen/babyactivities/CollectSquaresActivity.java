package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CollectSquaresActivity extends AppCompatActivity {

    private ImageView ivS2;
    private ImageView ivS3;
    private ImageView ivS4;
    private ImageView ivS5;
    private ImageView ivS1;
    private ImageView ivS6;
    private ImageView ivS7;
    private ImageView ivSContainer;
    private VideoView VideoView;
    private Button finishBtn;
    private ConstraintLayout mainContainer;
    boolean isStarted = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_squares);


        initView();

        playVideo("android.resource://" + getPackageName() + "/" + R.raw.collect_square_start, false);
        ivS1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });

        ivS2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivS3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivS4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivS5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivS6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivS7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivSContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("TAG", "containertt: x =  " + motionEvent.getX() + "  y =" + motionEvent.getY());
                return false;
            }
        });


    }

    float dX = 0f, dY = 0f;

    boolean action(View view, MotionEvent event) {
        PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
        PointF StartPT = new PointF(); // Record Start Position of 'img'
        isStarted = true;
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                view.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();
                break;
            case MotionEvent.ACTION_DOWN:
                DownPT.set(event.getX(), event.getY());
                StartPT.set(view.getX(), view.getY());

                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                view.setX((int) (StartPT.x + event.getX() - DownPT.x));
                view.setY((int) (StartPT.y + event.getY() - DownPT.y));
                StartPT.set(view.getX(), view.getY());
                if ((ivS1.getX() < 775.0 && ivS1.getY() > 50) &&
                        (ivS2.getX() < 775.0 && ivS2.getY() > 50) &&
                        (ivS3.getX() < 775.0 && ivS3.getY() > 50) &&
                        (ivS4.getX() < 775.0 && ivS4.getY() > 50) &&
                        (ivS5.getX() < 775.0 && ivS5.getY() > 50) &&
                        (ivS6.getX() < 775.0 && ivS6.getY() > 50) &&
                        (ivS7.getX() < 775.0 && ivS7.getY() > 50)


                ) {
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                    Log.d("TAG", "onTouch:successs  ");
                }
               /* else {
                    isStarted=false;
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                }*/
                break;
            default:
                break;
        }

        return true;
    }

    public void playVideo(String path, boolean isSuccess) {


        VideoView.setVideoURI(Uri.parse(path));
        VideoView.start();

        VideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (isSuccess) {
                    finishBtn.setVisibility(View.VISIBLE);
                    finishBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            CollectSquaresActivity.super.onBackPressed();
                        }
                    });
                } else if (!isStarted)
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.collect_square_start, false);

            }
        });
    }

    private void initView() {
        ivS2 = (ImageView) findViewById(R.id.iv_s_2);
        ivS3 = (ImageView) findViewById(R.id.iv_s_3);
        ivS4 = (ImageView) findViewById(R.id.iv_s_4);
        ivS5 = (ImageView) findViewById(R.id.iv_s_5);
        ivS1 = (ImageView) findViewById(R.id.iv_s_1);
        ivS6 = (ImageView) findViewById(R.id.iv_s_6);
        ivS7 = (ImageView) findViewById(R.id.iv_s_7);
        finishBtn = findViewById(R.id.finishBtn);
        ivSContainer = (ImageView) findViewById(R.id.iv_s_container);
        VideoView = (VideoView) findViewById(R.id.VideoView);
        mainContainer = (ConstraintLayout) findViewById(R.id.mainContainer);
    }
}