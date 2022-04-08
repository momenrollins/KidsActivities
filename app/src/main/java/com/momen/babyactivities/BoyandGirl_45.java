package com.momen.babyactivities;

import android.animation.ObjectAnimator;
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
    private ImageView boy2;
    private ImageView girl2;
    boolean isGirlPlay=false;
    int count =0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boyand_girl45);
        initView();
        index = getIntent().getIntExtra("actvtyNum", 0);

        runnable = new Runnable() {
            @Override
            public void run() {

                if (!isGirlPlay) {
                    basketBall.animate()
                            .rotationBy(360).x((float) 1444)
                            .y((float) 202)
                            .setDuration(1100)
                            .start();
                    isGirlPlay = true;
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, false, false);


                } else if (isGirlPlay) {
                    basketBall.animate().rotationBy(-360)
                            .x((float) 414)
                            .y((float) 210)
                            .setDuration(1100)
                            .start();
                }
            }
        };
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

        /*girl.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        girl.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        girl.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(girl.getX(), girl.getY());


                        Log.d("TAG", "onTouch:y  y = " + girl.getY() +" x = "+ girl.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(girl.getX(), girl.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });*/


        //============================


        boy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0) {
                    if (boyTurn) {
                        basketBall.animate()
                                .rotationBy(360).x((float) 965)
                                .y((float) 103)
                                .setDuration(1100)
                                .start();

                        handler.postDelayed(runnable, 900);
                        boyTurn = false;
                        girlTurn = true;
                    }
                } else if (index == 1) {
                    if (boyTurn) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, true, false);

                        count++;
                        if (count==4){
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true, true);

                        }
                        boyTurn = false;
                        girlTurn = true;
                    }else playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, true, false);

                } else {
                    if (boyTurn) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile3, true, true);
                        girl.setVisibility(View.GONE);
                        boyTurn = false;
                        girlTurn = false;
                    }
                }
            }
        });
        girl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0) {
                    if (girlTurn) {
                        {

                            basketBall.animate()
                                    .rotationBy(-360).x((float) 965)
                                    .y((float) 103)
                                    .setDuration(1100)
                                    .start();
                            handler.postDelayed(runnable, 1000);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true, true);
                            girlTurn = false;
                        }
                    }
                } else if (index == 1) {
                    if (girlTurn) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, true, false);
                        girlTurn = false;
                        count++;
                    }else playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, true, false);

                } else {
                    if (girlTurn)
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile2, true, false);
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
            isGirlPlay = Boolean.parseBoolean(null);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookleft, true, false);
            boy.setImageResource(R.drawable.left_tree);
            boy.getLayoutParams().height = 750;
            boy.getLayoutParams().width = 630;
            boy.setScaleType(ImageView.ScaleType.FIT_XY);

            boy2.getLayoutParams().height = 750;
            boy2.getLayoutParams().width = 630;
            boy2.setScaleType(ImageView.ScaleType.FIT_XY);
            girl.animate()
                    .x((float) 1565)
                    .y((float) 152)
                    .setDuration(500)
                    .start();

            girl2.animate()
                    .x((float) 1565)
                    .y((float) 152)
                    .setDuration(500)
                    .start();
            girl.setImageResource(R.drawable.right_tree);
            girl.getLayoutParams().height = 750;
            girl.setScaleType(ImageView.ScaleType.FIT_XY);
            girl.getLayoutParams().width = 630;
            girl2.setScaleType(ImageView.ScaleType.FIT_XY);

            girl2.getLayoutParams().height = 750;
            girl2.getLayoutParams().width = 630;
            Log.d("TAG", "onResume: x "+girl.getX() +" y "+girl.getY());
          /*  girl.setX(1664);
            girl2.setX(1664);*/

            basketBall.setVisibility(View.GONE);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookleft, true, false);

        } else {
            videoView.setBackground(null);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.smile1, true, false);

            boy.setImageResource(R.drawable.smile);
            girl.setImageResource(R.drawable.sad);
            boy.setVisibility(View.GONE);
            girl.setVisibility(View.GONE);
            boyTurn = false;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    boy.setVisibility(View.VISIBLE);
                    girlTurn = true;
                    boyTurn = true;

                }
            }, 5500);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    girl.setVisibility(View.VISIBLE);
                }
            }, 10000);
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
                } else {
                    if (index == 0) {
                        if (!isBoy) {
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.basket_girl, true, false);

                        } else {
                            if (!isGirlPlay) {
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.bassket_boy, true, false);

                            } else if (isGirlPlay) {
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.basket_girl, true, false);

                            }
                        }
                    }else if (index==1){
                        if (count==1){
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookright, true, false);


                        }
                        else if (count==2){
                            girlTurn=true;
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookright, true, false);

                        }else if (count==3){
                            boyTurn=true;
                            girlTurn=false;

                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookleft, true, false);

                        }else if ( isBoy && count==0){
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.lookleft, true, false);

                        }
                    }
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
        boy2 = (ImageView) findViewById(R.id.boy2);
        girl2 = (ImageView) findViewById(R.id.girl2);
    }
}