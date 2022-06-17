package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class ColorActivity extends AppCompatActivity {

    private ImageView ivBluePin;
    private ImageView circleImage;
    private ImageView ivRedPin;
    private ImageView ivYellowPin;
    private LinearLayout options;
    private ImageButton nextBtn;
    private ImageButton replayBtn;
    private ImageButton backBtn;
    private MaterialButton homeBtn;
    int index = 0;
    private VideoView videoView;
    int startList[]={R.raw.blue_square,R.raw.square_yellow,R.raw.square_red};
    int countFaildPoints=0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initView();
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SHARDStorage.initShaird(this);

        homeBtn.setOnClickListener(view -> {
            Intent gotoScreenVar = new Intent(ColorActivity.this, LevelTypeActivity.class).putExtra("lvl", 1);
            gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(gotoScreenVar);
        });
        circleImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Log.d("TAG", "onTouch: x = " + motionEvent.getX() + " y = " + motionEvent.getY());
                return false;
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                     new Intent(ColorActivity.this, TasneefActivity.class)
                    .putExtra("actvtyNum", 20)
            );
                finish();
            }
        });
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                     new Intent(ColorActivity.this, ColorActivity.class)
            );
                finish();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                     new Intent(ColorActivity.this, CollectSquaresActivity.class)
            );
                finish();
            }
        });



        playVideo("android.resource://" + getPackageName() + "/" + R.raw.blue_square, false);
        ivBluePin.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivBluePin.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivBluePin.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivBluePin.getX(), ivBluePin.getY());


                      //  Log.d("TAG", "onTouch:faild x " + ivBluePin.getX() + " y " + ivBluePin.getY());
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivBluePin.getX(), ivBluePin.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivBluePin.getX() < 500 && ivBluePin.getX() > 100) &&
                                (ivBluePin.getY() < 590 && ivBluePin.getY() > 100) &&
                                index == 0

                        ) {
                            circleImage.setImageResource(R.drawable.color_blue_image);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, true);
//                            x 142.0 y 767.0
                        } else {
                            countFaildPoints=countFaildPoints+1;

                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

                            positionImage(ivBluePin, 1788, 594);
                        }

                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        ivYellowPin.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivYellowPin.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivYellowPin.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivYellowPin.getX(), ivYellowPin.getY());


//                        x 905.0 y 772.0
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivYellowPin.getX(), ivYellowPin.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivYellowPin.getX() < 500 && ivYellowPin.getX() > 100) &&
                                (ivYellowPin.getY() < 590 && ivYellowPin.getY() > 100) &&
                                index == 1

                        ) {
                            circleImage.setImageResource(R.drawable.color_yellow_image);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, true);

                        } else {
                            countFaildPoints=countFaildPoints+1;

                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

                            positionImage(ivYellowPin, 1778, 412);
                        }                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivRedPin.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivRedPin.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivRedPin.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivRedPin.getX(), ivRedPin.getY());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivRedPin.getX(), ivRedPin.getY());


                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivRedPin.getX() < 500 && ivRedPin.getX() > 100) &&
                                (ivRedPin.getY() < 590 && ivRedPin.getY() > 100) &&
                                index == 2

                        ) {
                            circleImage.setImageResource(R.drawable.color_red_imag);
                            videoView.setBackgroundResource(0);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);
//                            x 1683.0 y 765.0
                        } else {
                            countFaildPoints=countFaildPoints+1;

                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);

                            positionImage(ivRedPin, 1787, 234);
                        }                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    public void playVideo(String path, boolean isSuccess) {


        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (isSuccess) {
                    index++;
                    if (index == 0) {
                        circleImage.setImageResource(R.drawable.color_out_blue_image);

                    } else if (index == 1) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.square_yellow, false);

                        circleImage.setImageResource(R.drawable.color_out_yellow_image);
                        positionImage(ivBluePin,  1788 , 594);
                    } else if (index == 2) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.square_red, false);

                        circleImage.setImageResource(R.drawable.color_out_red_image);
                        positionImage(ivYellowPin,  1778 , 412);


                    }else  if (index == 3){

                        SHARDStorage.saveFaildPoints("color_activity_l",countFaildPoints);
                        if (countFaildPoints != 0) {
                            SHARDStorage.AliartResult(
                                    ColorActivity.this,
                                    SHARDStorage.sharedPreferences.getInt("color_activity_l", 0)+": محاولة "
                            );

                        }
                        countFaildPoints=0;
                        options.setVisibility(View.VISIBLE);
                        index=0;
                        positionImage(ivRedPin,  1787 , 234);

                    }
                }else {
                    playVideo("android.resource://" + getPackageName() + "/" +startList[index], false);

                }

            }
        });
    }

    public void positionImage(View view ,float x,float y) {

        view.animate()
                .x(x)
                .y(y)
                .setDuration(2200)
                .start();
    }

    private void initView() {
        ivBluePin = (ImageView) findViewById(R.id.iv_blue_pin);
        circleImage = (ImageView) findViewById(R.id.circle_image);
        ivRedPin = (ImageView) findViewById(R.id.iv_red_pin);
        ivYellowPin = (ImageView) findViewById(R.id.iv_yellow_pin);
        videoView = (VideoView) findViewById(R.id.videoView);
        options =  findViewById(R.id.options);
        nextBtn =  findViewById(R.id.nextBtn);
        backBtn =  findViewById(R.id.backBtn);
        replayBtn =  findViewById(R.id.replayBtn);
        homeBtn =  findViewById(R.id.homeBtn);
    }
}