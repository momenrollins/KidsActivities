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

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout iv, resultContainer;

    Button next, repeat;

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
    int nextIndex = 0;
    int[] imgList = {R.drawable.lvl1_1, R.drawable.lvl1_2,
            R.drawable.appal2, R.drawable.banana,
            R.drawable.duck, R.drawable.dog,
            R.drawable.lion, R.drawable.lion,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red, R.drawable.red, R.drawable.red, R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red, R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,
            R.drawable.red, R.drawable.red,};

    int[] startList = {R.raw.lvl1_1_start, R.raw.lvl1_2_start, R.raw.selectappal1, R.raw.bana_app1, R.raw.duck1, R.raw.duckdog1,
            R.raw.lion1, R.raw.lion_gr1, R.raw.red1, R.raw.black_red1, R.raw.v12_1, R.raw.apple_banana1, R.raw.v14_1,
            R.raw.duck_dog1, R.raw.v16_1, R.raw.lion_grf1, R.raw.v18_1, R.raw.red_black1, R.raw.v20_1, R.raw.ap_bana1, R.raw.v22_1, R.raw.duck_dog_1,
            R.raw.v24_1, R.raw.lion_grf_1, R.raw.v26_1, R.raw.red_black_1};

    int[] successList = {R.raw.lvl1_1_success, R.raw.lvl1_2_success, R.raw.selectappal3, R.raw.bana_app3, R.raw.duck3, R.raw.duckdog3,
            R.raw.lion3, R.raw.lion_gr3, R.raw.red3, R.raw.black_red2, R.raw.v12_3, R.raw.apple_banana2, R.raw.v14_3,
            R.raw.duck_dog2, R.raw.v16_3, R.raw.lion_grf2, R.raw.v18_3, R.raw.red_black2, R.raw.v20_3, R.raw.ap_bana2,
            R.raw.v22_3, R.raw.duck_dog_2, R.raw.v24_3, R.raw.lion_grf_2, R.raw.v26_3, R.raw.red_black_2};

    int[] failedList = {R.raw.lvl1_1_failed, R.raw.lvl1_2_failed, R.raw.selectappal2, R.raw.bana_app2, R.raw.duck2, R.raw.duckdog2,
            R.raw.lion2, R.raw.lion_gr2, R.raw.red2, R.raw.black_red3,
            R.raw.v12_2, R.raw.apple_banana3, R.raw.v14_2,
            R.raw.duck_dog3, R.raw.v16_2, R.raw.lion_grf3, R.raw.v18_2, R.raw.red_black3, R.raw.v20_2, R.raw.ap_bana3,
            R.raw.v22_2, R.raw.duck_dog_3, R.raw.v24_2, R.raw.lion_grf_3, R.raw.v26_2, R.raw.red_black_3};

    int activityPosition = 0;
    View viewSuccess, viewFail, arrowTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.lvlImg);
        arwImg = findViewById(R.id.arwImg);
        ballImg = findViewById(R.id.ballImg);

        next = findViewById(R.id.next);
        repeat = findViewById(R.id.repeat);
        resultContainer = findViewById(R.id.resultContainer);

        select_ivRight = findViewById(R.id.selectImage1);
        select_ivLeft = findViewById(R.id.selectImage2);

        activityPosition = getIntent().getIntExtra("actvtyNum", 0);
        nextIndex = activityPosition;

        Log.d(TAG, "onCreate:activityPosition  " + imgList.length);
        ballImg.setImageResource(imgList[activityPosition]);
        container = findViewById(R.id.container);
        videoView = findViewById(R.id.VideoView);
        replatAgain = findViewById(R.id.reply);
        action(activityPosition);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);

        /*replatAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    public void action(int index) {
        path = "android.resource://" + getPackageName() + "/" + startList[index];
        Log.d(TAG, "action:index  " + index);
        arwImg.setVisibility(View.GONE);
        iv.setVisibility(View.GONE);
        select_ivRight.setVisibility(View.INVISIBLE);
        select_ivLeft.setVisibility(View.INVISIBLE);
        resultContainer.setVisibility(View.INVISIBLE);
        if (arrowTrue != null) {
            arrowTrue.setVisibility(View.INVISIBLE);
        }
        playVideo(path, false);
        switch (index) {
            case 0:
            case 1: {
                iv.setVisibility(View.VISIBLE);
                ballImg.setImageResource(imgList[index]);

            }
            break;
            case 2: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivRight.setImageResource(imgList[index]);

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
                arrowTrue = findViewById(R.id.arwImgRight);
            }
            break;
            case 8: {
                arrowTrue = findViewById(R.id.arwImgLeft);
                select_ivRight.setVisibility(View.INVISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.red);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
            }
            break;
            case 9: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.red);
                select_ivRight.setImageResource(R.drawable.black);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);
            }
            break;
            case 10:
            case 18: {

                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.INVISIBLE);
                select_ivRight.setImageResource(R.drawable.appel_with_back);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
                arrowTrue = findViewById(R.id.arwImgRight);

            }
            break;
            case 11:
            case 19: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivRight.setImageResource(R.drawable.apple1);
                select_ivLeft.setImageResource(R.drawable.banana2);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
                arrowTrue = findViewById(R.id.arwImgRight);
            }
            break;
            case 12: {

                select_ivRight.setVisibility(View.INVISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.duck_with_back);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);

            }
            break;
            case 13:
            case 21: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.duck1);
                select_ivRight.setImageResource(R.drawable.dog1);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;

                arrowTrue = findViewById(R.id.arwImgLeft);
            }
            break;
            case 14:
            case 22: {

                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.INVISIBLE);
                select_ivRight.setImageResource(R.drawable.lion_with_back);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;
                arrowTrue = findViewById(R.id.arwImgRight);

            }
            break;
            case 15:
            case 23: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);

                select_ivRight.setImageResource(R.drawable.lion1);
                select_ivLeft.setImageResource(R.drawable.grf1);
                viewSuccess = select_ivRight;
                viewFail = select_ivLeft;

                arrowTrue = findViewById(R.id.arwImgRight);
            }
            break;
            case 16: {

                select_ivRight.setVisibility(View.INVISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivLeft.setImageResource(R.drawable.red_with_back);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);

            }
            break;
            case 17:
            case 25: {
                select_ivRight.setVisibility(View.VISIBLE);
                select_ivLeft.setVisibility(View.VISIBLE);

                select_ivLeft.setImageResource(R.drawable.red1);
                select_ivRight.setImageResource(R.drawable.black1);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;

                arrowTrue = findViewById(R.id.arwImgLeft);
            }
            break;
            case 20: {

                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivRight.setVisibility(View.INVISIBLE);
                select_ivLeft.setImageResource(R.drawable.duck_with_back);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);

            }
            break;
            case 24: {
                select_ivLeft.setVisibility(View.VISIBLE);
                select_ivRight.setVisibility(View.INVISIBLE);
                select_ivLeft.setImageResource(R.drawable.red_with_back);
                viewSuccess = select_ivLeft;
                viewFail = select_ivRight;
                arrowTrue = findViewById(R.id.arwImgLeft);
            }
            break;

        }
        if (arrowTrue != null)
            YoYo.with(Techniques.Pulse)
                    .repeat(YoYo.INFINITE)
                    .duration(1500)
                    .playOn(arrowTrue);
        runnable = new Runnable() {
            @Override
            public void run() {
                positionImage();
                handler.postDelayed(runnable, 2200);

            }
        };
        if (index == 0 || index == 1) {
            handler.post(runnable);
        }
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "iv", Toast.LENGTH_SHORT).show();

                path = "android.resource://" + getPackageName() + "/" + successList[index];
//                arwImg.setVisibility(View.GONE);
                handler.removeCallbacks(runnable);

                playVideo(path, true);
            }
        });
        if (viewSuccess != null) viewSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "viewSuccess", Toast.LENGTH_SHORT).show();
                path = "android.resource://" + getPackageName() + "/" + successList[index];

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
                path = "android.resource://" + getPackageName() + "/" + failedList[index];


                if (arrowTrue != null) {
                    arrowTrue.setVisibility(View.VISIBLE);
                }
                if (index == 0 || index == 1) {
                    arwImg.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.Pulse)
                            .repeat(YoYo.INFINITE)
                            .duration(1500)
                            .playOn(arwImg);
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                }
              /*  select_ivLeft.setVisibility(View.GONE);
                select_ivRight.setVisibility(View.GONE);*/

                playVideo(path, false);
            }
        });
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
                if (isSuccess) {
                    resultContainer.setVisibility(View.VISIBLE);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d(TAG, "onClick: ");
                            activityPosition = (activityPosition + 1) < 26 ? activityPosition + 1 : 0;
                            action(activityPosition);
                        }
                    });
                    repeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            action(activityPosition);
                        }
                    });
                   /* if (activityPosition == 2) {
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
                    }*/

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