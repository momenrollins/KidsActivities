package com.momen.babyactivities;

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

import com.google.android.material.button.MaterialButton;

public class BressBall_L49 extends AppCompatActivity {

    private VideoView videoView;
    private ImageView shape;
    private MaterialButton repeat;
    private MaterialButton next;
    int[] startList = {R.raw.bress_ball_l49_start, R.raw.l50_start, R.raw.l51_start, R.raw.l46_ball_start, R.raw.l46_start, R.raw.l46_maka3b_start, R.raw.l47_mawa7a_start, R.raw.l47__noor_start};
    int[] successList = {R.raw.ta3zeez_l49, R.raw.l50_ta3zeez, R.raw.l51_ta3zeez, R.raw.l46_ta3zeez, R.raw.l46_ta3zeez, R.raw.l46_ta3zeez, R.raw.l47_ta3zeez, R.raw.l47_ta3zeez};
    int[] faildList = {R.raw.bress_ball_l49_faild, R.raw.l50_faild};
    int index = 0;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bress_ball_l49);
        initView();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index == 8) index = 0;
                shape.setVisibility(View.VISIBLE);

                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                if (index == 0) {
                    shape.setImageResource(R.drawable.basket_baal);
                    shape.animate()
                            .x((float) 1560)
                            .y((float) 499)
                            .setDuration(2200)
                            .start();
                } else if (index == 1) {
                    shape.animate()
                            .x((float) 772)
                            .y((float) 466)
                            .setDuration(2200)
                            .start();
                } else if (index == 2) {
                    shape.setVisibility(View.GONE);
                } else if (index == 3) {
                    shape.setImageResource(R.drawable.basket_baal);
                } else if (index == 4) {
                    shape.setImageResource(R.drawable.car_46);

                } else if (index == 5) {
                    shape.setImageResource(R.drawable.moka3b);

                } else if (index == 6) {
                    shape.setImageResource(R.drawable.marwa7a);
                    shape.animate()
                            .x((float) 1768)
                            .y((float) 138)
                            .setDuration(2200)
                            .start();

                }
                playVideo("android.resource://" + getPackageName() + "/" + startList[index], false);

            }
        });
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                playVideo("android.resource://" + getPackageName() + "/" + startList[index], false);

            }
        });
        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("android.resource://" + getPackageName() + "/" + successList[index], true);

            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0 || index == 1)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList[index], false);

            }
        });

        runnable = new Runnable() {
            @Override
            public void run() {

                playVideo("android.resource://" + getPackageName() + "/" + successList[index], true);


            }
        };
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
        });*/

    }

    public void playVideo(String path, boolean isSuccess) {
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (isSuccess) {
                    next.setVisibility(View.VISIBLE);
                    repeat.setVisibility(View.VISIBLE);


                } else {
                    if (index > 1) {
                        handler.postDelayed(runnable, 2200);

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
        playVideo("android.resource://" + getPackageName() + "/" + startList[index], false);

    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        shape = (ImageView) findViewById(R.id.shape);
        repeat = (MaterialButton) findViewById(R.id.repeat);
        next = (MaterialButton) findViewById(R.id.next);
    }
}