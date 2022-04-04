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
    int[] startList = {R.raw.bress_ball_l49_start, R.raw.l50_start, R.raw.l51_start};
    int[] successList = {R.raw.ta3zeez_l49, R.raw.l50_ta3zeez, R.raw.l51_ta3zeez};
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
                if (index == 3) index = 0;
                shape.setVisibility(View.VISIBLE);

                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                if (index == 0) {
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
                if (index != 2)
                    playVideo("android.resource://" + getPackageName() + "/" + faildList[index], false);

            }
        });

        runnable = new Runnable() {
            @Override
            public void run() {

                playVideo("android.resource://" + getPackageName() + "/" + successList[index], true);


            }
        };


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
                    if (index == 2) {
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