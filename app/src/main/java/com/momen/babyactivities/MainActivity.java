package com.momen.babyactivities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout iv;
    ImageView select_iv1;
    ImageView select_iv2;

    ImageView arwImg;
    ImageView ballImg;
    Handler handler = new Handler();
    Runnable runnable;
    VideoView videoView;
    String path;
    RelativeLayout container;
    Button replatAgain;
    int[] imgList = {R.drawable.lvl1_1, R.drawable.lvl1_2,
            R.drawable.appal2, R.drawable.banana, R.drawable.duck,
            R.drawable.dog, R.drawable.lion};

    int[] startList = {R.raw.lvl1_1_start, R.raw.lvl1_2_start, R.raw.selectappal1, R.raw.bana_app1, R.raw.duck1, R.raw.duckdog1, R.raw.lion1};
    int[] successList = {R.raw.lvl1_1_success, R.raw.lvl1_2_success, R.raw.selectappal2, R.raw.bana_app2, R.raw.duck2, R.raw.duckdog2, R.raw.lion2};
    int[] failedList = {R.raw.lvl1_1_failed, R.raw.lvl1_2_failed, R.raw.selectappal3, R.raw.bana_app3, R.raw.duck3, R.raw.duckdog3, R.raw.lion3};
    int activityPosition = 0;
    View view, view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.lvlImg);
        arwImg = findViewById(R.id.arwImg);
        ballImg = findViewById(R.id.ballImg);
        select_iv1 = findViewById(R.id.selectImage1);
        select_iv2 = findViewById(R.id.selectImage2);

        activityPosition = getIntent().getIntExtra("actvtyNum", 0);
        ballImg.setImageResource(imgList[activityPosition]);
        container = findViewById(R.id.container);
        videoView = (VideoView) findViewById(R.id.VideoView);
        replatAgain = findViewById(R.id.reply);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
        path = "android.resource://" + getPackageName() + "/" + startList[activityPosition];
        arwImg.setVisibility(View.GONE);
        playVideo(path, true);
        switch (activityPosition) {
            case 0:
            case 1: {
                iv.setVisibility(View.VISIBLE);
                ballImg.setImageResource(imgList[activityPosition]);

            }
            break;
            case 2: {
                select_iv1.setVisibility(View.VISIBLE);
                select_iv1.setImageResource(imgList[activityPosition]);
                view = select_iv1;
                view2 = select_iv2;

            }
            break;
            case 3: {
                select_iv1.setVisibility(View.VISIBLE);
                select_iv2.setVisibility(View.VISIBLE);
                select_iv1.setImageResource(R.drawable.appal2);
                select_iv2.setImageResource(R.drawable.banana);
                view = select_iv1;
                view2 = select_iv2;


            }
            break;
            case 4: {
                select_iv2.setVisibility(View.VISIBLE);
                select_iv2.setImageResource(R.drawable.duck);
                view = select_iv2;
                view2 = select_iv1;

            }
            break;
            case 5: {
                select_iv1.setVisibility(View.VISIBLE);
                select_iv2.setVisibility(View.VISIBLE);
                select_iv2.setImageResource(R.drawable.duck);
                select_iv1.setImageResource(R.drawable.dog);
                view = select_iv2;
                view2 = select_iv1;

            }
            break;
            case 6: {
                select_iv1.setVisibility(View.VISIBLE);
                select_iv1.setImageResource(R.drawable.lion);
                view = select_iv1;
                view2 = select_iv2;

            }
            break;


        }

        runnable = new Runnable() {
            @Override
            public void run() {
                positionImage();
                handler.postDelayed(runnable, 2200);

            }
        };
        if (activityPosition == 0 || activityPosition == 1) {
            handler.post(runnable);
        }
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = "android.resource://" + getPackageName() + "/" + successList[activityPosition];
//                arwImg.setVisibility(View.GONE);
                handler.removeCallbacks(runnable);

                playVideo(path, true);
            }
        });
        if (view != null) view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "YYY", Toast.LENGTH_SHORT).show();
                path = "android.resource://" + getPackageName() + "/" + successList[activityPosition];
         /*       view.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);*/
                playVideo(path, true);
            }
        });
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = "android.resource://" + getPackageName() + "/" + failedList[activityPosition];

                if (activityPosition == 0 || activityPosition == 1) {
                    arwImg.setVisibility(View.VISIBLE);
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                }
              /*  select_iv2.setVisibility(View.GONE);
                select_iv1.setVisibility(View.GONE);*/

                playVideo(path, false);
            }
        });
        /*replatAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    private static final String TAG = "MainActivity";


    public void playVideo(String path, boolean isSuccess) {
        videoView.setVisibility(View.VISIBLE);
//        container.setVisibility(View.INVISIBLE);
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!isSuccess) {
                    if (activityPosition == 2) {
                        select_iv1.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 3) {
                        select_iv1.setVisibility(View.VISIBLE);
                        select_iv2.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 4) {
                        view.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 5) {
                        select_iv1.setVisibility(View.VISIBLE);
                        select_iv2.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 6) {
                        select_iv1.setVisibility(View.VISIBLE);
                    }
//                    replatAgain.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void positionImage() {

//        DisplayMetrics metrics = container.getw;
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int DeviceTotalWidth = container.getWidth();
        int DeviceTotalHeight = container.getHeight();

        float randX = getRandomPositionX(DeviceTotalWidth);
        float randY = getRandomPositionY(DeviceTotalHeight);

        Log.d(TAG, "positionImage: totalX: " + DeviceTotalWidth + " totalY: " + DeviceTotalHeight);
        Log.d(TAG, "positionImage: ranX: " + randX + " ranY: " + randY);
        iv.animate()
                .x(randX)
                .y(randY)
                .setDuration(2200)
                .start();
    }

    public float getRandomPositionX(float deviceTotalWidth) {
        Random random = new Random();
        float randX = random.nextInt((int) deviceTotalWidth - (int) getImageSizeinPixels());
        return randX;
    }

    public float getRandomPositionY(float DeviceTotalHeight) {
        Random random = new Random();
        float randY = random.nextInt((int) DeviceTotalHeight - (int) getImageSizeinPixels());
        return randY;
    }

    public float getImageSizeinPixels() {
        // Converts 65 dip into its equivalent px
        float imageSize = 65f;
        float extraPadding = 40f;
        float dip = imageSize + extraPadding;
        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );

        return px;
    }
}