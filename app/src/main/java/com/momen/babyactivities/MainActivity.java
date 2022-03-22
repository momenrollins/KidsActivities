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
    ImageView select_ivRight;
    ImageView select_ivLeft;

    ImageView arwImg;
    ImageView ballImg;
    Handler handler = new Handler();
    Runnable runnable;
    VideoView videoView;
    String path;
    RelativeLayout container;
    Button replatAgain;
    int[] imgList = {R.drawable.lvl1_1, R.drawable.lvl1_2,
            R.drawable.appal2, R.drawable.banana,
            R.drawable.duck, R.drawable.dog,
            R.drawable.lion, R.drawable.lion,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,};

    int[] startList = {R.raw.lvl1_1_start, R.raw.lvl1_2_start, R.raw.selectappal1, R.raw.bana_app1, R.raw.duck1, R.raw.duckdog1,
            R.raw.lion1, R.raw.lion_gr1, R.raw.red1, R.raw.black_red1,
            /*12*/ R.raw.apple_banana1,    /*14*/ R.raw.duck_dog1, R.raw.lion_grf1, R.raw.red_black1, R.raw.ap_bana1, R.raw.duck_dog_1,
            R.raw.lion_grf_1,R.raw.red_black_1,
    };
    int[] successList = {R.raw.lvl1_1_success, R.raw.lvl1_2_success, R.raw.selectappal3, R.raw.bana_app3, R.raw.duck3, R.raw.duckdog3,
            R.raw.lion2, R.raw.lion_gr2, R.raw.red2, R.raw.black_red2,
            R.raw.apple_banana2, R.raw.duck_dog2, R.raw.lion_grf2, R.raw.red_black2, R.raw.ap_bana2, R.raw.duck_dog_2,
            R.raw.lion_grf_2,R.raw.red_black_2,
    };
    int[] failedList = {R.raw.lvl1_1_failed, R.raw.lvl1_2_failed, R.raw.selectappal2, R.raw.bana_app2, R.raw.duck2, R.raw.duckdog2,
            R.raw.lion2, R.raw.lion_gr3, R.raw.red3, R.raw.black_red3,
            R.raw.apple_banana3, R.raw.duck_dog3, R.raw.lion_grf3, R.raw.red_black3, R.raw.ap_bana3, R.raw.duck_dog_3,
            R.raw.lion_grf_3,  R.raw.red_black_3,
    };
    int activityPosition = 0;
    View viewSuccess, viewFail, arrowTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.lvlImg);
        arwImg = findViewById(R.id.arwImg);
        ballImg = findViewById(R.id.ballImg);
        select_ivRight = findViewById(R.id.selectImage1);
        select_ivLeft = findViewById(R.id.selectImage2);

        activityPosition = getIntent().getIntExtra("actvtyNum", 0);
        ballImg.setImageResource(imgList[activityPosition]);
        container = findViewById(R.id.container);
        videoView = findViewById(R.id.VideoView);
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
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivRight.setImageResource(imgList[activityPosition]);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
                arrowTrue = findViewById(R.id.arwImgRight);

            }
            break;
            case 3: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivRight.setImageResource(R.drawable.appal2);
                select_ivLeft.setImageResource(R.drawable.banana);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
                arrowTrue = findViewById(R.id.arwImgRight);
            }
            break;
            case 4: {
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.duck);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);
            }
            break;
            case 5: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.duck);
                select_ivRight.setImageResource(R.drawable.dog);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);

            }
            break;
            case 6: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivRight.setImageResource(R.drawable.lion);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
                arrowTrue = findViewById(R.id.arwImgRight);

            }
            break;
            case 7: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivRight.setImageResource(R.drawable.lion);
                select_ivLeft.setImageResource(R.drawable.giraffe);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
            }
            break;
            case 8: {
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.red);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;

            }
            case 9: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.red);
                select_ivRight.setImageResource(R.drawable.black);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
            }
            break;
            // 11
            case 10:
                // 19
            case 14: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);

                select_ivRight.setImageResource(R.drawable.apple1);
                select_ivLeft.setImageResource(R.drawable.banana2);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;

                arrowTrue = findViewById(R.id.arwImgRight);
            }
            break;
            // 13
            case 11:
            case 15: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);

                select_ivLeft.setImageResource(R.drawable.duck1);
                select_ivRight.setImageResource(R.drawable.dog1);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;

                arrowTrue = findViewById(R.id.arwImgLeft);
            }
            break;
            // 15
            case 12:
            case 16: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);

                select_ivRight.setImageResource(R.drawable.lion1);
                select_ivLeft.setImageResource(R.drawable.grf1);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;

                arrowTrue = findViewById(R.id.arwImgRight);
            }
            break;
            // 17
            case 13: case 17: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);

                select_ivLeft.setImageResource(R.drawable.red1);
                select_ivRight.setImageResource(R.drawable.black1);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;

                arrowTrue = findViewById(R.id.arwImgLeft);
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
//                Toast.makeText(MainActivity.this, "iv", Toast.LENGTH_SHORT).show();

                path = "android.resource://" + getPackageName() + "/" + successList[activityPosition];
//                arwImg.setVisibility(View.GONE);
                handler.removeCallbacks(runnable);

                playVideo(path, true);
            }
        });
        if (viewSuccess != null) viewSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "viewSuccess", Toast.LENGTH_SHORT).show();
                path = "android.resource://" + getPackageName() + "/" + successList[activityPosition];
                if (viewFail != null)
                    viewFail.setVisibility(View.GONE);
         /*       view.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);*/
                playVideo(path, true);
            }
        });
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "container", Toast.LENGTH_SHORT).show();
                path = "android.resource://" + getPackageName() + "/" + failedList[activityPosition];

                if (arrowTrue != null) {
                    arrowTrue.setVisibility(View.VISIBLE);
                }
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
                        select_ivRight.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 3) {
                        select_ivRight.setVisibility(View.VISIBLE);
                        select_ivLeft.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 4) {
                        viewSuccess.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 5) {
                        select_ivRight.setVisibility(View.VISIBLE);
                        select_ivLeft.setVisibility(View.VISIBLE);
                    } else if (activityPosition == 6) {
                        select_ivRight.setVisibility(View.VISIBLE);
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