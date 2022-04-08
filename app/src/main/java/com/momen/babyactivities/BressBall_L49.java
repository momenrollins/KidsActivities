package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class BressBall_L49 extends AppCompatActivity {

    private VideoView videoView;
    private ImageView shape;
    private MaterialButton repeat;
    private MaterialButton next;
    int[] startListL46 = {R.raw.l46_ball_start, R.raw.l46_start, R.raw.l46_maka3b_start};
    int[] startListL47 = {R.raw.l47_mawa7a_start, R.raw.l47__noor_start};
    int[] startListL49 = {R.raw.bress_ball_l49_start};
    int[] startListL50 = {R.raw.l50_start};
    int[] startListL51 = {R.raw.l51_start};
    int[] startListL53 = {R.raw.l53_tree_start, R.raw.l53_lookme_start, R.raw.l53_plane_start, R.raw.l53_lookme_start, R.raw.l53_3sfora_start};

    int[] successList46 = {R.raw.l46_ta3zeez, R.raw.l46_ta3zeez, R.raw.l46_ta3zeez};
    int[] successList47 = {R.raw.l47_ta3zeez, R.raw.l47_ta3zeez};
    int[] successList49 = {R.raw.ta3zeez_l49};
    int[] successList50 = {R.raw.l50_ta3zeez};
    int[] successList51 = {R.raw.l51_ta3zeez};
    int[] successList53 = {R.raw.ta3zez, R.raw.ta3zez, R.raw.ta3zez, R.raw.ta3zez};
    int[] faildList47 = {R.raw.l47_marwa7a_faild, R.raw.l47_noor_faild};

    int[] faildList49 = {R.raw.bress_ball_l49_faild};
    int[] faildList50 = {R.raw.l50_faild};
    int[] faildList51 = {R.raw.l51_faild};
    int index = 0;
    int stepIndex = 0;
    int numActivity = 0;
    /*Handler handler = new Handler();
    Runnable runnable;*/
    private Button finishBtn;
    private ImageView shape1;
    private ImageView shape2;
    private ImageView shape3;
    private ImageView shapeTrans;
    MediaPlayer ta3zez_failed_Sound;
    private ImageView shapetrans;

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

/*
        shapeTrans.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shapeTrans.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        shapeTrans.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(shapeTrans.getX(), shapeTrans.getY());


                        Log.d("TAG", "onTouch:y  y = " + shapeTrans.getY() + " x = " + shapeTrans.getX());


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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
//                shape.setVisibility(View.VISIBLE);

                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                if (numActivity == 49) {
                    shape.setImageResource(R.drawable.basket_baal);

                    playVideo("android.resource://" + getPackageName() + "/" + startListL49[index], false);

                } else if (numActivity == 50) {
                    shape.setImageResource(R.drawable.basket_baal);

                    playVideo("android.resource://" + getPackageName() + "/" + startListL50[index], false);

                } else if (numActivity == 51) {
                    shape.setVisibility(View.GONE);

                    playVideo("android.resource://" + getPackageName() + "/" + startListL51[index], false);

                } else if (numActivity == 53) {
                    playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
                }


            }
        });
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                if (numActivity == 46)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL46[index], false);
                else if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL47[index], false);
                else if (numActivity == 49)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL49[index], false);
                else if (numActivity == 50)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL50[index], false);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL51[index], false);
                else if (numActivity == 53)
                    playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);


            }
        });


        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stepIndex++;
                if (numActivity == 46)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                else if (numActivity == 47) {
                    if (index == 1)
                        playVideo("android.resource://" + getPackageName() + "/" + faildList47[index], true);
                    else
                        playVideo("android.resource://" + getPackageName() + "/" + successList47[index], true);
                } else if (numActivity == 49)
                    playVideo("android.resource://" + getPackageName() + "/" + successList49[index], true);
                else if (numActivity == 50)
                    playVideo("android.resource://" + getPackageName() + "/" + successList50[index], true);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + successList51[index], true);
                else if (numActivity == 53) {
//                    if()
                    ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                    ta3zez_failed_Sound.start();
                    ta3zez_failed_Sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (index == 3) finishBtn.setVisibility(View.VISIBLE);
                            else {
                                playVideo("android.resource://" + getPackageName() + "/" + startListL53[++index], false);

                            /*    next.setVisibility(View.VISIBLE);
                                repeat.setVisibility(View.VISIBLE);*/
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
                if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + successList47[index], true);
                else if (numActivity == 53) {
                    if (index == 0) {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(mediaPlayer -> {
                            playVideo("android.resource://" + getPackageName() + "/" + startListL53[++index], false);

                        });
                    } else {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.faild);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
                            }
                        });
                    }
                } else {
                    if (index == 1)
                        playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                    else
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                }
            }
        });
        shape2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numActivity == 53) {
                    if (index == 2) {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(mediaPlayer -> {
                            playVideo("android.resource://" + getPackageName() + "/" + startListL53[++index], false);

                        });
                    } else {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.faild);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
                            }
                        });
                    }
                } else {
                    if (index == 0)
                        playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                    else
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                }
            }
        });
        shape3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numActivity == 53) {
                    if (index == 4) {
                        finishBtn.setVisibility(View.VISIBLE);

                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.shate_vid, true);
                    /*    ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(mediaPlayer -> {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        });*/
                    } else {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.faild);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
                            }
                        });
                    }
                } else {
                    if (index == 2)
                        playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                    else
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                }
            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList47[index], false);

                else if (numActivity == 49)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList49[index], false);

                else if (numActivity == 50)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList50[index], false);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList51[index], false);

                else if (numActivity == 53) {
                    ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.faild);
                    ta3zez_failed_Sound.start();
                    ta3zez_failed_Sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
                        }
                    });
                }
            }
        });
        shapeTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + successList51[index], true);
                else {
                    if (index == 1 || index == 3 || index == 5) {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(mediaPlayer -> {
                            playVideo("android.resource://" + getPackageName() + "/" + startListL53[++index], false);


                        });
                    } else {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.faild);
                        ta3zez_failed_Sound.start();
                        ta3zez_failed_Sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
                            }
                        });
                    }
                }

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
        shape2.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shape2.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        shape2.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(shape2.getX(), shape2.getY());
                        Log.d("TAG", "onTouch:y  y = " + shape2.getY());
                        Log.d("TAG", "onTouch:x  x= " + shape2.getX());

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

    public void playVideo(String path, boolean isSuccess) {
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (isSuccess) {
                    if (numActivity == 46)
                        if (index == 2) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.GONE);
                            repeat.setVisibility(View.GONE);
                            nextStep();
                        }

                    else if (numActivity == 47)
                        if (index == 1) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.GONE);
                            repeat.setVisibility(View.GONE);
                            nextStep();
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
                    else if (numActivity == 53) {
                        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                        ta3zez_failed_Sound.start();
                      /*  if (index == 3) finishBtn.setVisibility(View.VISIBLE);
                        else {
                            next.setVisibility(View.VISIBLE);
                            repeat.setVisibility(View.VISIBLE);
                        }*/
                    }

                } else {
                    if (numActivity != 49 && numActivity != 50) {
                        //handler.postDelayed(runnable, 2200);

                    }
                }


            }
        });
    }

    private void nextStep() {
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
            playVideo("android.resource://" + getPackageName() + "/" + startListL46[index], false);

        } else if (numActivity == 47) {
            if (index == 1) {
                shape1.setImageResource(0);
                shape1.setVisibility(View.VISIBLE);
                shape1.getLayoutParams().height = 150;
                shape1.getLayoutParams().width = 120;
                shape1.animate()
                        .x((float) 230)
                        .y((float) 241)
                        .setDuration(2200)
                        .start();
            }
            playVideo("android.resource://" + getPackageName() + "/" + startListL47[index], false);


        }
    }

    private static final String TAG = "BressBall_L49";

    @Override
    protected void onResume() {
        super.onResume();
        ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);

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
            index = 0;
            shape.getLayoutParams().height = 350;
            shape.getLayoutParams().width = 320;
            shape.setImageResource(R.drawable.marwa7a);
            shape.animate()
                    .x((float) 1768)
                    .y((float) 138)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL47[index], false);
        } else if (numActivity == 49) {
            shape.setImageResource(R.drawable.basket_baal);
            shape.animate()
                    .x((float) 1560)
                    .y((float) 499)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL49[index], false);
        } else if (numActivity == 50) {
            shape.animate()
                    .x((float) 772)
                    .y((float) 466)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL50[index], false);
        } else if (numActivity == 51) {
            shape.setVisibility(View.GONE);
            shapeTrans.getLayoutParams().height = 550;
            shapeTrans.getLayoutParams().width = 630;
            shapeTrans.setVisibility(View.VISIBLE);
            shapeTrans.animate()
                    .x((float) 52)
                    .y((float) 138)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL51[index], false);
        } else if (numActivity == 53) {
            shape.setVisibility(View.GONE);
            shapeTrans.setVisibility(View.VISIBLE);
            shape1.setImageResource(R.drawable.l53_tree);
            shape1.setVisibility(View.VISIBLE);
            shape2.setImageResource(R.drawable.l53_plane);
            shape2.setVisibility(View.VISIBLE);
            shape3.setImageResource(R.drawable.l53_3sfora);
            shape3.setVisibility(View.VISIBLE);
            shape1.animate()
                    .x((float) 1706)
                    .y((float) 303)
                    .setDuration(1)
                    .start();
            shape2.animate()
                    .x((float) 301)
                    .y((float) 164)
                    .setDuration(1)
                    .start();
            shape3.animate()
                    .x((float) 1606)
                    .y((float) 127)
                    .setDuration(1)
                    .start();
            playVideo("android.resource://" + getPackageName() + "/" + startListL53[index], false);
        }
    }

    private void initView() {
        videoView = findViewById(R.id.videoView);
        shape = findViewById(R.id.shape);
        repeat = findViewById(R.id.repeat);
        next = findViewById(R.id.next);
        finishBtn = findViewById(R.id.finishBtn);
        shape1 = findViewById(R.id.shape1);
        shape2 = findViewById(R.id.shape2);
        shape3 = findViewById(R.id.shape3);
        shapeTrans = findViewById(R.id.shapetrans);

        shape1 = (ImageView) findViewById(R.id.shape1);
        shapetrans = (ImageView) findViewById(R.id.shapetrans);
    }
}