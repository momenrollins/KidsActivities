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
import androidx.constraintlayout.widget.ConstraintLayout;

public class CollectSquaresActivity extends AppCompatActivity {

    private ImageView ivS2;
    private ImageView ivS3;
    private ImageView ivS4;
    private ImageView ivS5;
    private ImageView ivS1;
    private ImageView ivS6;
    private ImageView ivS7;
    private ImageView ivSContainer;
    private VideoView VideoView;
    private ConstraintLayout mainContainer;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_squares);


        initView();

        playVideo("android.resource://" + getPackageName() + "/" + R.raw.collect_square_start,false);
        ivS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });

        ivS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });
        ivS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });
        ivS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });
        ivS5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });
        ivS6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });
        ivS7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(view);
            }
        });
        ivSContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("TAG", "containertt: x =  "+motionEvent.getX() +"  y ="+motionEvent.getY());
                return false;
            }
        });


    }

    void action(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        view.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        view.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(view.getX(), view.getY());
                        if ((ivS1.getX() < 775.0 && ivS1.getY() > 50) &&
                                (ivS2.getX() < 775.0 && ivS2.getY() > 50) &&
                                (ivS3.getX() < 775.0 && ivS3.getY() > 50) &&
                                (ivS4.getX() < 775.0 && ivS4.getY() > 50) &&
                                (ivS5.getX() < 775.0 && ivS5.getY() > 50) &&
                                (ivS6.getX() < 775.0 && ivS6.getY() > 50) &&
                                (ivS7.getX() < 775.0 && ivS7.getY() > 50)


                        ) {
                            playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez,true);

                            Log.d("TAG", "onTouch:successs  ");
                        }else  Log.d("TAG", "onTouch:faild  "+ivS2.getX() + "  y "+ivS2.getY()  );
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(view.getX(), view.getY());

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


        VideoView.setVideoURI(Uri.parse(path));
        VideoView.start();

        VideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {




            }
        });
    }

    private void initView() {
        ivS2 = (ImageView) findViewById(R.id.iv_s_2);
        ivS3 = (ImageView) findViewById(R.id.iv_s_3);
        ivS4 = (ImageView) findViewById(R.id.iv_s_4);
        ivS5 = (ImageView) findViewById(R.id.iv_s_5);
        ivS1 = (ImageView) findViewById(R.id.iv_s_1);
        ivS6 = (ImageView) findViewById(R.id.iv_s_6);
        ivS7 = (ImageView) findViewById(R.id.iv_s_7);
        ivSContainer = (ImageView) findViewById(R.id.iv_s_container);
        VideoView = (VideoView) findViewById(R.id.VideoView);
        mainContainer = (ConstraintLayout) findViewById(R.id.mainContainer);
    }
}