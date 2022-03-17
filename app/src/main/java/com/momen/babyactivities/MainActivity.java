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
import android.widget.VideoView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout iv;
    ImageView arwImg;
    ImageView ballImg;
    Handler handler = new Handler();
    Runnable runnable;
    VideoView videoView;
    String path;
    LinearLayout container;
    Button replatAgain;
    int[] imgList = {R.drawable.lvl1_1, R.drawable.lvl1_2,};
    int[] startList = {R.raw.lvl1_1_start, R.raw.lvl1_2_start,};
    int[] successList = {R.raw.lvl1_1_success, R.raw.lvl1_2_success};
    int[] failedList = {R.raw.lvl1_1_failed, R.raw.lvl1_2_failed};
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.lvlImg);
        arwImg = findViewById(R.id.arwImg);
        ballImg = findViewById(R.id.ballImg);
        num = getIntent().getIntExtra("actvtyNum", 0);
        ballImg.setImageResource(imgList[num]);
        container = findViewById(R.id.container);
        videoView = (VideoView) findViewById(R.id.VideoView);
        replatAgain = findViewById(R.id.reply);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
        path = "android.resource://" + getPackageName() + "/" + startList[num];
        arwImg.setVisibility(View.GONE);

        playVideo(path, true);

        runnable = new Runnable() {
            @Override
            public void run() {
                positionImage();
                handler.postDelayed(runnable, 2200);

            }
        };
        handler.post(runnable);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = "android.resource://" + getPackageName() + "/" + successList[num];
//                arwImg.setVisibility(View.GONE);
                handler.removeCallbacks(runnable);

                playVideo(path, true);
            }
        });
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = "android.resource://" + getPackageName() + "/" + failedList[num];
                arwImg.setVisibility(View.VISIBLE);

                handler.removeCallbacks(runnable);
                handler.post(runnable);

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
        /*        if (!isSuccess) {
//                    videoView.setVisibility(View.INVISIBLE);
//                    container.setVisibility(View.VISIBLE);
//                    replatAgain.setVisibility(View.INVISIBLE);
                }*/

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