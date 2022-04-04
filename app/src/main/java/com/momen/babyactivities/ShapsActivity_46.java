package com.momen.babyactivities;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ShapsActivity_46 extends AppCompatActivity {

    private VideoView videoView;
    private ImageView shape;
    int[] startList = {R.raw.moka3b_l46_1, R.raw.ball_l46_1, R.raw.car_l46_1};
    int[] faildList = {R.raw.moka3b_l46_1, R.raw.ball_l46_2, R.raw.car_l46_2};
    int[] images = {R.drawable.moka3b, R.drawable.basket_baal, R.drawable.car_46};
    int index = 0;
    private MaterialButton repeat;
    private MaterialButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaps46);
        initView();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index==2)index=0;
                else index++;
                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                playVideo("android.resource://" + getPackageName() + "/" + startList[index], true);


            }
        });
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.GONE);
                repeat.setVisibility(View.GONE);
                playVideo("android.resource://" + getPackageName() + "/" + startList[index], true);

            }
        });

        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("android.resource://" + getPackageName() + "/" + faildList[index], false);

            }
        });
        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("android.resource://" + getPackageName() + "/" +R.raw.ta3zez_l46, true);

            }
        });

    }

    public void playVideo(String path, boolean isBoy) {
        shape.setImageResource(images[index]);
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (isBoy) {
                    next.setVisibility(View.VISIBLE);
                    repeat.setVisibility(View.VISIBLE);

                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        next.setVisibility(View.GONE);
        repeat.setVisibility(View.GONE);
        playVideo("android.resource://" + getPackageName() + "/" + startList[index], true);

    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        shape = (ImageView) findViewById(R.id.shape);
        repeat = (MaterialButton) findViewById(R.id.repeat);
        next = (MaterialButton) findViewById(R.id.next);
    }
}