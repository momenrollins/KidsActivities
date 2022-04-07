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

import com.google.android.material.button.MaterialButton;

public class BressBall_L49 extends AppCompatActivity {

    private VideoView videoView;
    private ImageView shape;
    private ImageView shape1;
    private MaterialButton repeat;
    private MaterialButton next;
    int[] startListL46 = {R.raw.l46_ball_start, R.raw.l46_start, R.raw.l46_maka3b_start};
    int[] startListL47 = {R.raw.l47_mawa7a_start, R.raw.l47__noor_start};
    int[] startListL49 = {R.raw.bress_ball_l49_start};
    int[] startListL50 = {R.raw.l50_start};
    int[] startListL51 = {R.raw.l51_start};
    int[] startListL53 = {R.raw.l53_tree_start, R.raw.l53_plane_start, R.raw.l53_3sfora_start, R.raw.l53_lookme_start};

    int[] successList46 = {R.raw.l46_ta3zeez, R.raw.l46_ta3zeez, R.raw.l46_ta3zeez};
    int[] successList47 = {R.raw.l47_ta3zeez, R.raw.l47_ta3zeez};
    int[] successList49 = {R.raw.ta3zeez_l49};
    int[] successList50 = {R.raw.l50_ta3zeez};
    int[] successList51 = {R.raw.l51_ta3zeez};
    int[] successList53 = {R.raw.ta3zez, R.raw.ta3zez, R.raw.ta3zez, R.raw.ta3zez};

    int[] faildList49 = {R.raw.bress_ball_l49_faild};
    int[] faildList50 = {R.raw.l50_faild};
    int index = 0;
    int stepIndex = 0;
    int numActivity = 0;
    /*Handler handler = new Handler();
    Runnable runnable;*/
    private Button finishBtn;
    private ImageView shape1;
    private ImageView shape2;
    private ImageView shape3;
    MediaPlayer ta3zezSound ;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bress_ball_l49);
        numActivity = getIntent().getIntExtra("actvtyNum", 0);

        initView();
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BressBall_L49.super.onBackPressed();
            }
        });

        /*shape.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shape.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        shape.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(shape.getX(), shape.getY());


                        Log.d("TAG", "onTouch:y  y = " + shape.getY() +" x = "+ shape.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(shape.getX(), shape.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });*/

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
//                shape.setVisibility(View.VISIBLE);

                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);

                if (numActivity == 46) {
                    if (index == 0) {
                        shape.setImageResource(R.drawable.basket_baal);

                    } else if (index == 1) {
                        shape.setImageResource(R.drawable.car_46);
                        /*shape.animate()
                                .x((float) 1768)
                                .y((float) 138)
                                .setDuration(1)
                                .start();*/

                    } else if (index == 2) {
                        shape.setImageResource(R.drawable.moka3b);
                        /*shape.animate()
                                .x((float) 1768)
                                .y((float) 138)
                                .setDuration(1)
                                .start();*/

                    }
                    playVideo("android.resource://" + getPackageName() + "/" + startListL46[index], false, stepIndex);

                } else if (numActivity == 47) {
                    if (index == 1) {
                        shape.setImageResource(0);

                        shape.getLayoutParams().height = 150;
                        shape.getLayoutParams().width = 120;
                        shape.animate()
                                .x((float) 230)
                                .y((float) 241)
                                .setDuration(2200)
                                .start();
                    }
                    playVideo("android.resource://" + getPackageName() + "/" + startListL47[index], false, stepIndex);


                } else if (numActivity == 49) {
                    shape.setImageResource(R.drawable.basket_baal);

                    playVideo("android.resource://" + getPackageName() + "/" + startListL49[index], false, stepIndex);

                } else if (numActivity == 50) {
                    shape.setImageResource(R.drawable.basket_baal);

                    playVideo("android.resource://" + getPackageName() + "/" + startListL50[index], false, stepIndex);

                } else if (numActivity == 51) {
                    shape.setVisibility(View.GONE);

                    playVideo("android.resource://" + getPackageName() + "/" + startListL51[index], false, stepIndex);

                } else if (numActivity == 53) {
                    if (index == 0) {
                        shape.setImageResource(R.drawable.l53_tree);
                        shape.animate()
                                .x((float) 1706)
                                .y((float) 297)
                                .setDuration(1)
                                .start();
                    } else if (index == 1) {

                    /*    shape.setImageResource(R.drawable.l53_plane);
                        shape.animate()
                                .x((float) 162)
                                .y((float) 158)
                                .setDuration(1)
                                .start();*/
                    } else if (index == 2) {
                        shape.setImageResource(R.drawable.l53_3sfora);
                        shape.animate()
                                .x((float) 1768)
                                .y((float) 138)
                                .setDuration(1)
                                .start();
                    } else if (index == 3) {
                        shape.setVisibility(View.GONE);
                    }
                    playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false, stepIndex);

                }


            }
        });
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                if (numActivity == 46)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL46[index], false, stepIndex);
                else if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL47[index], false, stepIndex);
                else if (numActivity == 49)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL49[index], false, stepIndex);
                else if (numActivity == 50)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL50[index], false, stepIndex);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL51[index], false, stepIndex);
                else if (numActivity == 53)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false, stepIndex);


            }
        });


        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stepIndex++;
                if (numActivity == 46)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true, stepIndex);
                else if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + successList47[index], true, stepIndex);
                else if (numActivity == 49)
                    playVideo("android.resource://" + getPackageName() + "/" + successList49[index], true, stepIndex);
                else if (numActivity == 50)
                    playVideo("android.resource://" + getPackageName() + "/" + successList50[index], true, stepIndex);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + successList51[index], true, stepIndex);
                else if (numActivity == 53) {
//                    if()
                  ta3zezSound = MediaPlayer.create(BressBall_L49.this, R.raw.ta3zez);
                    ta3zezSound.start();
                    ta3zezSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (index == 3) finishBtn.setVisibility(View.VISIBLE);
                            else {
                                next.setVisibility(View.VISIBLE);
                                repeat.setVisibility(View.VISIBLE);
                            }
//                            playVideo("android.resource://" + getPackageName() + "/" + successList53[index], true, stepIndex);
                        }
                    });
                }

            }
        });

        shape1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 1)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                else  playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

            }
        });
        shape2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                else  playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

            }
        });
        shape3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 2)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                else  playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numActivity == 49)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList49[index], false, stepIndex);

                else if (numActivity == 50)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList50[index], false, stepIndex);

            }
        });

/*
        runnable = new Runnable() {
            @Override
            public void run() {

                if (numActivity == 46)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                else if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + successList47[index], true);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + successList51[index], true);
                else if (numActivity == 53)
                    playVideo("android.resource://" + getPackageName() + "/" + successList53[index], true);


            }
        };
*/
/*
        shape.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shape.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        shape.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(shape.getX(), shape.getY());
                        Log.d("TAG", "onTouch:y  y = " + shape.getY());
                        Log.d("TAG", "onTouch:x  x= " + shape.getX());

                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(shape.getX(), shape.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
*/
    }

    public void playVideo(String path, boolean isSuccess, int stepIndex) {
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (isSuccess) {
                    if (numActivity == 46)
                        if (index == 2) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }

                    else if (numActivity == 47)
                        if (index == 1) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }
                    else if (numActivity == 49)
                        if (index == 0) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }
                    else if (numActivity == 50)
                        if (index == 0) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }
                    else if (numActivity == 51)
                        if (index == 0) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }
                    else if (numActivity == 53)
                        if (index == 3) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }

                } else {
                    if (numActivity != 49 && numActivity != 50) {
                        //handler.postDelayed(runnable, 2200);

                    }
                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        next.setVisibility(View.GONE);
        repeat.setVisibility(View.GONE);
        if (numActivity == 46) {
            shape.setVisibility(View.GONE);
            shape1.setVisibility(View.VISIBLE);
            shape2.setVisibility(View.VISIBLE);
            shape3.setVisibility(View.VISIBLE);
           /* shape.animate()
                    .x((float) 772)
                    .y((float) 466)
                    .setDuration(2200)
                    .start();*/
            playVideo("android.resource://" + getPackageName() + "/" + startListL46[index], false);

        } else if (numActivity == 47) {
            index=0;
            shape.getLayoutParams().height = 350;
            shape.getLayoutParams().width = 320;
            shape.setImageResource(R.drawable.marwa7a);
            shape.animate()
                    .x((float) 1768)
                    .y((float) 138)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL47[index], false, stepIndex);
        } else if (numActivity == 49) {
            shape.setImageResource(R.drawable.basket_baal);
            shape.animate()
                    .x((float) 1560)
                    .y((float) 499)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL49[index], false, stepIndex);
        } else if (numActivity == 50) {
            shape.animate()
                    .x((float) 772)
                    .y((float) 466)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL50[index], false, stepIndex);
        } else if (numActivity == 51) {
            shape.setVisibility(View.GONE);
            playVideo("android.resource://" + getPackageName() + "/" + startListL51[index], false, stepIndex);
        } else if (numActivity == 53) {
            shape.setImageResource(R.drawable.l53_tree);
            shape1.setVisibility(View.VISIBLE);
            shape.animate()
                    .x((float) 1706)
                    .y((float) 297)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false, stepIndex);
        }
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        shape = (ImageView) findViewById(R.id.shape);
        repeat = (MaterialButton) findViewById(R.id.repeat);
        next = (MaterialButton) findViewById(R.id.next);
        finishBtn = (Button) findViewById(R.id.finishBtn);
        shape1 = (ImageView) findViewById(R.id.shape1);
        shape2 = (ImageView) findViewById(R.id.shape2);
        shape3 = (ImageView) findViewById(R.id.shape3);

    }
}