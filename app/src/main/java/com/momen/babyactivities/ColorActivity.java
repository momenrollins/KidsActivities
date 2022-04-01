package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ColorActivity extends AppCompatActivity {

    private ImageView ivBluePin;
    private ImageView circleImage;
    private ImageView ivRedPin;
    private ImageView ivYellowPin;
    int index = 0;
    private VideoView videoView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initView();


        circleImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Log.d("TAG", "onTouch: x = " + motionEvent.getX() + " y = " + motionEvent.getY());
                return false;
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
                        if ((ivBluePin.getX() < 1000 && ivBluePin.getX() > 800) &&
                                (ivBluePin.getY() < 400 && ivBluePin.getY() > 250) &&
                                index == 0

                        ) {
                            circleImage.setImageResource(R.drawable.color_blue_image);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);
//                            x 142.0 y 767.0
                        } else
                            Log.d("TAG", "onTouch:faild x " + ivBluePin.getX() + " y " + ivBluePin.getY());
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivBluePin.getX(), ivBluePin.getY());

                        break;
                    case MotionEvent.ACTION_UP:

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
                        if ((ivYellowPin.getX() < 1000 && ivYellowPin.getX() > 800) &&
                                (ivYellowPin.getY() < 400 && ivYellowPin.getY() > 250) &&
                                index == 1

                        ) {
                            circleImage.setImageResource(R.drawable.color_yellow_image);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                        } else
                            Log.d("TAG", "onTouch:faild x " + ivYellowPin.getX() + " y " + ivYellowPin.getY());
//                        x 905.0 y 772.0
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivYellowPin.getX(), ivYellowPin.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
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
                        if ((ivRedPin.getX() < 1000 && ivRedPin.getX() > 800) &&
                                (ivRedPin.getY() < 400 && ivRedPin.getY() > 250) &&
                                index == 2

                        ) {
                            circleImage.setImageResource(R.drawable.color_red_imag);
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);
//                            x 1683.0 y 765.0
                        } else
                            Log.d("TAG", "onTouch:faild x " + ivRedPin.getX() + " y " + ivRedPin.getY());
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivRedPin.getX(), ivRedPin.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
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
                        positionImage(ivBluePin,142.0f , 767.0f);
                    } else if (index == 2) {
                        playVideo("android.resource://" + getPackageName() + "/" + R.raw.square_red, false);

                        circleImage.setImageResource(R.drawable.color_out_red_image);
                        positionImage(ivYellowPin, 905.0f , 772.0f);


                    }else  if (index == 3){
                        index=0;
                        positionImage(ivRedPin,  1683.0f , 765.0f);

                    }
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
    }
}