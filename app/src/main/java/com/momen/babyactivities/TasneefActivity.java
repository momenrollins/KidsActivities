package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.button.MaterialButton;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Random;

public class TasneefActivity extends AppCompatActivity {

    private ConstraintLayout container;
    private ImageView ivA1;
    private ImageView ivA2;
    private ImageView ivA3;
    private ImageView ivA4;
    private ImageView ivF1;
    private ImageView ivF2;
    private ImageView ivF3;
    private ImageView ivF4;
    private VideoView VideoView;
    private ConstraintLayout innerContainer;
    private TextView txtLeft;
    private TextView txtRight;
    private MaterialButton repeat;
    private MaterialButton next;
    private Button finishBtn;
    int index = 0;

    int[] tasnefl1A_images = {R.drawable.tasneefl1_hours, R.drawable.dog, R.drawable.tasneefl1_cat, R.drawable.tasneefl1_cow};
    int[] tasnefl1F_images = {R.drawable.tasneefl1_ornage, R.drawable.tasneefl1_mango, R.drawable.banana, R.drawable.appal2};
    int[] tasnefl2G_images = {R.drawable.tasneef_botato, R.drawable.tasneef_5yar, R.drawable.tasneef_felfel, R.drawable.tasneef_gazar};
    int[] tasnefl2C_images = {R.drawable.tasneef_banby, R.drawable.tasneef_red, R.drawable.tasneef_blue, R.drawable.tasneef_asfar};
    int[] tasnefl3B_images = {R.drawable.tasneef_7amama, R.drawable.duck, R.drawable.tasneef_3sfora, R.drawable.tasneef_far5a};
    int[] tasnefl3T_images = {R.drawable.tasneef_motsikl, R.drawable.tasneef_tayara, R.drawable.tasneef_3gla, R.drawable.tasneef_3rbya};
    int[] tasnefStartVideos = {R.raw.tasneef_start_l1, R.raw.tasneef_start_l2, R.raw.tasneef_start_l3};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasneef);
        initView();
        index = getIntent().getIntExtra("actvtyNum", 0) - 37;
        setData(index);

        ivA1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });

        ivA2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivA3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivA4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivF1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivF2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivA1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivF3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });
        ivF4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return action(view, motionEvent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                setData(index);

            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData(index);

            }
        });
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TasneefActivity.super.onBackPressed();
            }
        });

    }

    void setData(int index) {

        if (index == 0) {
            ivA1.setImageResource(tasnefl1A_images[0]);
            ivA2.setImageResource(tasnefl1A_images[1]);
            ivA3.setImageResource(tasnefl1A_images[2]);
            ivA4.setImageResource(tasnefl1A_images[3]);
            ivF1.setImageResource(tasnefl1F_images[0]);
            ivF2.setImageResource(tasnefl1F_images[1]);
            ivF3.setImageResource(tasnefl1F_images[2]);
            ivF4.setImageResource(tasnefl1F_images[3]);
            next.setVisibility(View.GONE);
            repeat.setVisibility(View.GONE);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.tasneef_start_l1, false);
            txtRight.setText("ضع الحيوانات على اليمين");
            txtLeft.setText("ضع الفاكهة على اليسار");

        } else if (index == 1) {
            ivA1.setImageResource(tasnefl2G_images[0]);
            ivA2.setImageResource(tasnefl2G_images[1]);
            ivA3.setImageResource(tasnefl2G_images[2]);
            ivA4.setImageResource(tasnefl2G_images[3]);
            ivF1.setImageResource(tasnefl2C_images[0]);
            ivF2.setImageResource(tasnefl2C_images[1]);
            ivF3.setImageResource(tasnefl2C_images[2]);
            ivF4.setImageResource(tasnefl2C_images[3]);
            next.setVisibility(View.GONE);
            repeat.setVisibility(View.GONE);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.tasneef_start_l2, false);
            txtRight.setText("ضع الخضار على اليمين");
            txtLeft.setText("ضع لالوان على اليسار");

        } else if (index == 2) {
            ivA1.setImageResource(tasnefl3T_images[0]);
            ivA2.setImageResource(tasnefl3T_images[1]);
            ivA3.setImageResource(tasnefl3T_images[2]);
            ivA4.setImageResource(tasnefl3T_images[3]);
            ivF1.setImageResource(tasnefl3B_images[0]);
            ivF2.setImageResource(tasnefl3B_images[1]);
            ivF3.setImageResource(tasnefl3B_images[2]);
            ivF4.setImageResource(tasnefl3B_images[3]);
            next.setVisibility(View.GONE);
            repeat.setVisibility(View.GONE);
            playVideo("android.resource://" + getPackageName() + "/" + R.raw.tasneef_start_l3, false);

            txtRight.setText("ضع وسايل الموصلات على اليمين");
            txtLeft.setText("ضع الطيور على اليسار");
        }
        for (int d = 0; d < 8; d++) {

        }
        positionImage(ivA1);
        positionImage(ivA2);
        positionImage(ivA3);
        positionImage(ivA4);
        positionImage(ivF1);
        positionImage(ivF2);
        positionImage(ivF3);
        positionImage(ivF4);

    }

    public void playVideo(String path, boolean isSuccess) {

        VideoView.setVideoURI(Uri.parse(path));
        VideoView.start();

        VideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (isSuccess) {

                    finishBtn.setVisibility(View.VISIBLE);
                    /*next.setVisibility(View.VISIBLE);
                    repeat.setVisibility(View.VISIBLE);*/
                } else {
                    next.setVisibility(View.INVISIBLE);
                    repeat.setVisibility(View.INVISIBLE);
                }


            }
        });
    }


    public void number(int num_v, Context ctx) {
        final AssetFileDescriptor afd = ctx.getResources().openRawResourceFd(tasnefStartVideos[num_v]);
        final FileDescriptor fileDescriptor = afd.getFileDescriptor();
        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(fileDescriptor, afd.getStartOffset(),
                    afd.getLength());
            player.setLooping(false);
            player.prepare();
            player.start();
        } catch (IOException ex) {
            player.start();
            Log.d("TAG", "number: " + ex.getMessage());
        }
    }

    float dX = 0f, dY = 0f;

    boolean action(View view, MotionEvent event) {
        PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
        PointF StartPT = new PointF(); // Record Start Position of 'img'

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
                if (ivA1.getX() > container.getWidth() / 2 &&
                        ivA2.getX() > container.getWidth() / 2 &&
                        ivA3.getX() > container.getWidth() / 2 &&
                        ivA4.getX() > container.getWidth() / 2 &&
                        ivF1.getX() < container.getWidth() / 2 &&
                        ivF2.getX() < container.getWidth() / 2 &&
                        ivF3.getX() < container.getWidth() / 2 &&
                        ivF4.getX() < container.getWidth() / 2


                ) {
                    playVideo("android.resource://" + getPackageName() + "/" + R.raw.ta3zez, true);
                }
                break;
            default:
                break;
        }
        return true;

    }


    public void positionImage(View view) {


        int DeviceTotalWidth = container.getWidth();
        int DeviceTotalHeight = container.getHeight();


        Random random = new Random();
        float randX = random.nextInt(1500);
        float randY = random.nextInt(700);
        view.animate()
                .x(randX)
                .y(randY)
                .setDuration(2200)
                .start();
    }

    public float getRandomPositionX(float deviceTotalWidth) {
        Random random = new Random();
        float randX = random.nextInt((int) deviceTotalWidth);
        return randX;
    }

    public float getRandomPositionY(float DeviceTotalHeight) {
        Random random = new Random();
        float randY = random.nextInt((int) DeviceTotalHeight);
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

    private void initView() {
        container = (ConstraintLayout) findViewById(R.id.container);
        ivA1 = (ImageView) findViewById(R.id.iv_a_1);
        ivA2 = (ImageView) findViewById(R.id.iv_a_2);
        ivA3 = (ImageView) findViewById(R.id.iv_a_3);
        ivA4 = (ImageView) findViewById(R.id.iv_a_4);
        ivF1 = (ImageView) findViewById(R.id.iv_f_1);
        ivF2 = (ImageView) findViewById(R.id.iv_f_2);
        ivF3 = (ImageView) findViewById(R.id.iv_f_3);
        ivF4 = (ImageView) findViewById(R.id.iv_f_4);
        VideoView = (VideoView) findViewById(R.id.VideoView);
        innerContainer = (ConstraintLayout) findViewById(R.id.inner_container);
        txtLeft = (TextView) findViewById(R.id.txt_left);
        txtRight = (TextView) findViewById(R.id.txt_right);
        repeat = (MaterialButton) findViewById(R.id.repeat);
        next = (MaterialButton) findViewById(R.id.next);
        finishBtn =  findViewById(R.id.finishBtn);

    }
}