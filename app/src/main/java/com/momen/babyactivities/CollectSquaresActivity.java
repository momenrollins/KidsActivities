package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
    boolean isStarted = false;
    private ImageView ivS8;
    private ImageView ivS9;
    ArrayList<String> items = new ArrayList<>();
    private LinearLayout options;
    private ImageButton nextBtn;
    private ImageButton replayBtn;
    private ImageButton backBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_squares);


        initView();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CollectSquaresActivity.this, ColorActivity.class)
                       .putExtra("actvtyNum", 40));
                finish();
            }
        });
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(CollectSquaresActivity.this, CollectSquaresActivity.class)
                );
                finish();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CollectSquaresActivity.this, PlayVideoActivity.class)
                        .putExtra("lvl", 1).putExtra("actvtyNum", 1));
                finish();
            }
        });
        playVideo("android.resource://" + getPackageName() + "/" + R.raw.collect_square_start, false);

        ivS1.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS1.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS1.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS1.getX(), ivS1.getY());

                        isStarted = true;

                        Log.d("TAG", "onTouch:y  y = " + ivS1.getY() + " x = " + ivS1.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS1.getX(), ivS1.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS1.getX() < 500 && ivS1.getY() > 500)) {
                            if (!items.contains("ivS1")) items.add("ivS1");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);
                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS1")) items.remove("ivS1");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        ivS2.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS2.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS2.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS2.getX(), ivS2.getY());


                        Log.d("TAG", "onTouch:y  y = " + ivS2.getY() + " x = " + ivS2.getX());
                        isStarted = true;


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS2.getX(), ivS2.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS2.getX() < 500 && ivS2.getY() > 500)) {
                            if (!items.contains("ivS2")) items.add("ivS2");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS2")) items.remove("ivS2");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS3.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS3.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS3.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS3.getX(), ivS3.getY());


                        Log.d("TAG", "onTouch:y  y = " + ivS3.getY() + " x = " + ivS3.getX());

                        isStarted = true;

                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS3.getX(), ivS3.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS3.getX() < 500 && ivS3.getY() > 500)) {
                            if (!items.contains("ivS3")) items.add("ivS3");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS3")) items.remove("ivS3");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS4.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS4.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS4.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS4.getX(), ivS4.getY());


                        Log.d("TAG", "onTouch:y  y = " + ivS1.getY() + " x = " + ivS1.getX());

                        isStarted = true;

                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS4.getX(), ivS4.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS4.getX() < 500 && ivS4.getY() > 500)) {
                            if (!items.contains("ivS4")) items.add("ivS4");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS4")) items.remove("ivS4");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS5.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS5.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS5.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS5.getX(), ivS5.getY());


                        Log.d("TAG", "onTouch:y  y = " + ivS5.getY() + " x = " + ivS5.getX());

                        isStarted = true;

                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS1.getX(), ivS1.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS5.getX() < 500 && ivS5.getY() > 500)) {
                            if (!items.contains("ivS5")) items.add("ivS5");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS5")) items.remove("ivS5");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS6.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS6.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS6.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS6.getX(), ivS6.getY());

                        isStarted = true;

                        Log.d("TAG", "onTouch:y  y = " + ivS6.getY() + " x = " + ivS6.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS6.getX(), ivS6.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS6.getX() < 500 && ivS6.getY() > 500)) {
                            if (!items.contains("ivS6")) items.add("ivS6");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS6")) items.remove("ivS6");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS7.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS7.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS7.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS7.getX(), ivS7.getY());
                        isStarted = true;


                        Log.d("TAG", "onTouch:y  y = " + ivS7.getY() + " x = " + ivS7.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS7.getX(), ivS7.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS7.getX() < 500 && ivS7.getY() > 500)) {
                            if (!items.contains("ivS7")) items.add("ivS7");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS7")) items.remove("ivS7");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS8.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS8.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS8.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS8.getX(), ivS8.getY());
                        isStarted = true;


                        Log.d("TAG", "onTouch:y  y = " + ivS8.getY() + " x = " + ivS8.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS8.getX(), ivS8.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS8.getX() < 500 && ivS8.getY() > 500)) {
                            if (!items.contains("ivS8")) items.add("ivS8");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS8")) items.remove("ivS8");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivS9.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        ivS9.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        ivS9.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(ivS9.getX(), ivS9.getY());


                        Log.d("TAG", "onTouch:y  y = " + ivS9.getY() + " x = " + ivS9.getX());
                        isStarted = true;


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(ivS9.getX(), ivS9.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((ivS9.getX() < 500 && ivS9.getY() > 500)) {
                            if (!items.contains("ivS9")) items.add("ivS9");
                            if (items.size() == 3 || items.size() == 6) {
                                isStarted = false;
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.shater, false);

                            } else if (items.size() == 9) {
                                VideoView.setBackground(null);
                                playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);

                            }
                            Log.d("TAG", "onTouch:successs  ");
                        } else {
                            if (items.contains("ivS9")) items.remove("ivS9");

                            Log.d("TAG", "onTouch:faild  ");

//                    isStarted=false;
//                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.faild, false);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivSContainer.animate().x(5).y(455).start();
      /*  ivS1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS1");
            }
        });
*/
       /* ivS2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS2");
            }
        });
        ivS3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS3");
            }
        });
        ivS4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS4");
            }
        });
        ivS5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS5");
            }
        });
        ivS6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS6");
            }
        });
        ivS7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent,"ivS7");
            }
        });*/
       /* ivSContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("TAG", "containertt: x =  " + motionEvent.getX() + "  y =" + motionEvent.getY());
                return false;
            }
        });*/


    }

    float dX = 0f, dY = 0f;

    boolean action(View view, MotionEvent event, String name) {
        isStarted = true;
        PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
        PointF StartPT = new PointF(); // Record Start Position of 'img'
        isStarted = true;
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                view.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();
                break;
            case MotionEvent.ACTION_DOWN:
                DownPT.set(event.getX(), event.getY());
                StartPT.set(view.getX(), view.getY());

                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                view.setX((int) (StartPT.x + event.getX() - DownPT.x));
                view.setY((int) (StartPT.y + event.getY() - DownPT.y));
                StartPT.set(view.getX(), view.getY());
                Log.d("TAG", "action: x=" + view.getX() + " y=" + view.getY());

                break;
            default:
                break;
        }

        return true;
    }

    public void playVideo(String path, boolean isSuccess) {


        VideoView.setVideoURI(Uri.parse(path));
        VideoView.start();

        VideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (isSuccess) {
                    options.setVisibility(View.VISIBLE);
                } else if (!isStarted)
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.collect_square_start, false);

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
        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        replayBtn = findViewById(R.id.replayBtn);
        options = findViewById(R.id.options);
        ivSContainer = (ImageView) findViewById(R.id.iv_s_container);
        VideoView = (VideoView) findViewById(R.id.VideoView);
        ivS8 = (ImageView) findViewById(R.id.iv_s_8);
        ivS9 = (ImageView) findViewById(R.id.iv_s_9);
    }
}