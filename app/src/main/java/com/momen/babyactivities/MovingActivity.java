package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MovingActivity extends AppCompatActivity {

    ImageView img;
    ArrayList<matahaModel> pointArrayList = new ArrayList();
    ArrayList<matahaModel> pointArrayList2 = new ArrayList();
    ArrayList<matahaModel> pointArrayList3 = new ArrayList();
    ArrayList<Double> toleranceArrayListx = new ArrayList();
    ArrayList<Double> toleranceArrayListy = new ArrayList();
    //    ArrayList<LatLng> latLngsArrayListy = new ArrayList();
    private float width = 250;
    private TextView fResult;
    private LinearLayout moviLinear;
    private VideoView videoView;
    int index = 0;
    int[] startList = {R.raw.mataha_l1_v1, R.raw.mataha_l2_v1, R.raw.mataha_l3_1};
    int[] endtList = {R.raw.mataha_l11_v2, R.raw.mataha_l12_v2, R.raw.mataha_l3_v2};
    String path = "";
    private LinearLayout moviLinearv;
    private ImageView btn;
    private MaterialButton repeat;
    private MaterialButton next;
    private LinearLayout options;
    private ImageButton nextBtn;
    private ImageButton replayBtn;
    private ImageButton backBtn;
    boolean isWalkRight = true;
    boolean isStarted = false;
    Handler handler = new Handler();
    Runnable runnable;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving);
        index = getIntent().getIntExtra("actvtyNum", 0) - 34;

        Log.d("TAG", "onCreate: " + Environment.getExternalStorageDirectory());


        img = findViewById(R.id.btn);
        initView();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0)
                    startActivity(new Intent(MovingActivity.this, DragActivity.class)
                            .putExtra("actvtyNum", 33));
                else  startActivity(new Intent(MovingActivity.this, MovingActivity.class)
                        .putExtra("actvtyNum", --index + 34));
                finish();
            }
        });
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MovingActivity.this, MovingActivity.class)
                        .putExtra("actvtyNum", index + 34));
                finish();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 2)
                    startActivity(new Intent(MovingActivity.this,  TasneefActivity.class)
                        .putExtra("actvtyNum", 37));
                else
                    startActivity(new Intent(MovingActivity.this, MovingActivity.class)
                            .putExtra("actvtyNum", ++index + 34));
                finish();
            }
        });
        playVideo(path, false);


        double tolerance = Math.sqrt(
                Math.pow(img.getWidth(), 2.5) + Math.pow(
                        img.getHeight(),
                        2.5
                )

        );

        runnable = new Runnable() {
            @Override
            public void run() {
                path = "android.resource://" + getPackageName() + "/" + startList[index];

                if (!isStarted)
                    playVideo(path, false);

            }
        };


       /* moviLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onTouch:ffff rrrrrrrrrrr ");

                img.animate()
                        .x(view.getX())
                        .y(view.getY())
                        .setDuration(2200)
                        .start();            }
        });*/
       /* moviLinear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                Log.d("TAG", "onTouch: pointsmoviLinear "+ moviLinear.getWidth() +" h = "+moviLinear.getHeight());

                return false;
            }
        });*/

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next.setVisibility(View.INVISIBLE);
                repeat.setVisibility(View.INVISIBLE);
                isStarted = false;
                index++;
                if (index == 3) index = 0;
                if (index == 0) {
                    moviLinear.setBackgroundResource(R.drawable.mataha1);
                    moveingRabbitIndex1();
                } else if (index == 1) {
                    moviLinear.setBackgroundResource(R.drawable.mataha2);
                    moveingRabbitIndex2();

                } else if (index == 2) {
                    moviLinear.setBackgroundResource(R.drawable.mataha3);
                    moveingRabbitIndex3();

                }
                playVideo("android.resource://" + getPackageName() + "/" + startList[index], false);

            }
        });
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.INVISIBLE);
                repeat.setVisibility(View.INVISIBLE);
                isStarted = false;
                if (index == 0) {
                    moviLinear.setBackgroundResource(R.drawable.mataha1);
                    moveingRabbitIndex1();
                } else if (index == 1) {
                    moviLinear.setBackgroundResource(R.drawable.mataha2);
                    moveingRabbitIndex2();

                } else if (index == 2) {
                    moviLinear.setBackgroundResource(R.drawable.mataha3);
                    moveingRabbitIndex3();

                }
                playVideo("android.resource://" + getPackageName() + "/" + startList[index], false);

            }
        });

    }


    @SuppressLint("ClickableViewAccessibility")
    void moveingRabbitIndex1() {


        if (!isStarted)
            img.animate()
                    .x((float) 410)
                    .y((float) 397)
                    .setDuration(2200)
                    .start();

        img.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        isStarted = true;

                        img.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        img.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(img.getX(), img.getY());


                        Log.d("TAG", "onTouch:y  y = " + img.getY() + " max = " + img.getMaxHeight() + " min " + img.getMinimumHeight());
                        Log.d("TAG", "onTouch:x  x = " + img.getX());
                        if (img.getX() < 852) {
                            if (img.getY() > 300 && img.getY() < 560) {
                                fResult.setText("شااااااااااطر");
                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 852 && img.getX() < 2000) {
                            if (img.getY() > 400 && img.getY() < 590) {
                                fResult.setText("شااااااااااطر");
                                if (img.getX() > 1675 && img.getX() < 2000 && isWalkRight) {
                                    playVideo("android.resource://" + getPackageName() + "/" + endtList[index], true);

                                }

                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        }


                        break;
                    case MotionEvent.ACTION_DOWN:
                        isStarted = true;

                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(img.getX(), img.getY());

                        break;
                    case MotionEvent.ACTION_UP:
                        if (isWalkRight == false) {
                            path = "android.resource://" + getPackageName() + "/" + R.raw.faild;
//                            isStarted=false;

                            playVideo(path, false);
                            img.animate()
                                    .x((float) 410)
                                    .y((float) 397)
                                    .setDuration(2200)
                                    .start();
                            isWalkRight = true;

                            fResult.setText("حاااااااول تاااانى");
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    void moveingRabbitIndex2() {
        width = 120;
//        latLngsArrayListy.clear();
        if (!isStarted)
            img.animate()
                    .x((float) 314)
                    .y((float) 323)
                    .setDuration(2200)
                    .start();

        img.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        isStarted = true;

                        img.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        img.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(img.getX(), img.getY());

                        Log.d("TAG", "onTouch:y  y = " + img.getY());
                        Log.d("TAG", "onTouch:x  x= " + img.getX());


                        if (img.getX() < 800) {
                            if (img.getY() > 268 && img.getY() < 419) {
                                fResult.setText("شااااااااااطر");
                            } else {
                                isWalkRight = false;
                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 800 && img.getX() < 830) {
                            if (img.getY() > 260 && img.getY() < 373) {
                                fResult.setText("شااااااااااطر");


                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 830 && img.getX() < 1188) {

                            if (img.getY() > 270 && img.getY() < 612) {
                                fResult.setText("شااااااااااطر");


                            } else {

                                isWalkRight = false;
                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 1188 && img.getX() < 1392) {
                            if (img.getY() > 463 && img.getY() < 625) {
                                fResult.setText("شااااااااااطر");


                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 1392 && img.getX() < 1695) {
                            if (img.getY() > 433 && img.getY() < 590) {
                                fResult.setText("شااااااااااطر");


                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 1695 && img.getX() < 1952) {
                            if (img.getY() > 420 && img.getY() < 570) {
                                fResult.setText("شااااااااااطر");
                                if (img.getX() > 1766 && img.getX() < 2008 && isWalkRight) {
                                    playVideo("android.resource://" + getPackageName() + "/" + endtList[index], true);

                                }

                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        }


                        break;
                    case MotionEvent.ACTION_DOWN:
                        isStarted = true;

                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(img.getX(), img.getY());
                        break;
                    case MotionEvent.ACTION_UP:

                        if (isWalkRight == false) {
                            path = "android.resource://" + getPackageName() + "/" + R.raw.faild;
//                            isStarted=false;

                            playVideo(path, false);
                            img.animate()
                                    .x((float) 314)
                                    .y((float) 323)
                                    .setDuration(2200)
                                    .start();
                            isWalkRight = true;
                            fResult.setText("حاااااااول تاااانى");
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    void moveingRabbitIndex3() {

        if (!isStarted)
            img.animate()
                    .x(304)
                    .y(274)
                    .setDuration(2200)
                    .start();

        img.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        isStarted = true;

                        img.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        img.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(img.getX(), img.getY());


                        Log.d("TAG", "onTouch:y  y = " + img.getY());
                        Log.d("TAG", "onTouch:x  x = " + img.getX());


                        if (img.getX() > 70 && img.getX() < 558) {
                            if (img.getY() > 179 && img.getY() < 643) {
                                fResult.setText("شااااااااااطر");
                            } else {
                                isWalkRight = false;
                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 558 && img.getX() < 802) {
                            if (img.getY() > 507 && img.getY() < 674) {
                                fResult.setText("شااااااااااطر");


                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 802 && img.getX() < 1418) {
                            if (img.getY() > 126 && img.getY() < 704) {

                                fResult.setText("شااااااااااطر");


                            } else {

                                isWalkRight = false;
                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 1418 && img.getX() < 1730) {
                            if (img.getY() > 172 && img.getY() < 593.0) {

                                fResult.setText("شااااااااااطر");


                            } else {
                                isWalkRight = false;

                                fResult.setText("حاااااااول تاااانى");
                            }
                        } else if (img.getX() > 1730 && img.getX() < 1900) {
                            if (img.getY() > 173 && img.getY() < 595) {

                                fResult.setText("شااااااااااطر");
                                if (img.getX() > 1724 && isWalkRight) {
                                    playVideo("android.resource://" + getPackageName() + "/" + endtList[index], true);

                                }

                            } else {
                                isWalkRight = false;
                                path = "android.resource://" + getPackageName() + "/" + R.raw.faild;
//                            isStarted=false;

                                playVideo(path, false);
                                fResult.setText("حاااااااول تاااانى");
                            }
                        }


                        break;
                    case MotionEvent.ACTION_DOWN:
                        isStarted = false;
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(img.getX(), img.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        if (!isWalkRight) {
                            path = "android.resource://" + getPackageName() + "/" + R.raw.faild;
                            isStarted = false;
                            playVideo(path, false);
                            img.animate()
                                    .x((float) 314)
                                    .y((float) 323)
                                    .setDuration(2200)
                                    .start();
                            isWalkRight = true;
                            fResult.setText("حاااااااول تاااانى");
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }


    public boolean isPointOnLine(PointF lineStaPt, PointF lineEndPt, PointF point) {
        final float EPSILON = width;
        if (Math.abs(lineStaPt.x - lineEndPt.x) < EPSILON) {
            // We've a vertical line, thus check only the x-value of the point.
            return (Math.abs(point.x - lineStaPt.x) < EPSILON);
        } else {
            double m = (lineEndPt.y - lineStaPt.y) / (lineEndPt.x - lineStaPt.x);
            double b = lineStaPt.y - m * lineStaPt.x;
            return (Math.abs(point.y - (m * point.x + b)) < EPSILON);
        }
    }


    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            String rootPath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/MyFolder/";
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        fResult = (TextView) findViewById(R.id.f_result);
        videoView = findViewById(R.id.VideoView);
        videoView = findViewById(R.id.VideoView);
        moviLinear = findViewById(R.id.moviLinearv);


        btn = (ImageView) findViewById(R.id.btn);
        repeat = (MaterialButton) findViewById(R.id.repeat);
        next = (MaterialButton) findViewById(R.id.next);
        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        replayBtn = findViewById(R.id.replayBtn);
        options = findViewById(R.id.options);    }

    public void playVideo(String path, boolean isSuccess) {
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {


                if (isSuccess) {
                   /* next.setVisibility(View.VISIBLE);
                    repeat.setVisibility(View.VISIBLE);*/
                    options.setVisibility(View.VISIBLE);
                    
                } else {

                    if (isStarted) {
                        if (index == 0) {
//                            moveingRabbitIndex1();
                        } else if (index == 1) {
//                            moveingRabbitIndex2();
                        } else if (index == 2) {
//                            moveingRabbitIndex3();
                        }
                    } else handler.postDelayed(runnable, 3000);
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        path = "android.resource://" + getPackageName() + "/" + startList[index];
        playVideo(path, false);
        if (index == 0) {
//            moviLinear.setBackgroundResource(R.drawable.mataha1);
            moveingRabbitIndex1();
        } else if (index == 1) {
//            moviLinear.setBackgroundResource(R.drawable.mataha2);
            moveingRabbitIndex2();

        } else if (index == 2) {
//            moviLinear.setBackgroundResource(R.drawable.mataha3);
            moveingRabbitIndex3();

        }
    }

    private class matahaModel {
        double x;
        double y;

        public matahaModel(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public matahaModel(double x) {
            this.x = x;
        }


        public matahaModel() {
        }
    }
}

class PointF {
    public double x = 0;
    public double y = 0;

    public PointF() {
    }

    ;

    public PointF(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public void set(float _x, float _y) {
        x = _x;
        y = _y;
    }

}