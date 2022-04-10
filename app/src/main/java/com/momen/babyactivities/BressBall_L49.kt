package com.momen.babyactivities

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bress_ball_l49.*

class BressBall_L49 : AppCompatActivity() {
    private var videoView: VideoView? = null
    private var shape: ImageView? = null

    /*   private var repeat: MaterialButton? = null
       private var next: MaterialButton? = null*/
    var startListL46 = intArrayOf(R.raw.l46_ball_start, R.raw.l46_start, R.raw.l46_maka3b_start)
    var startListL47 = intArrayOf(R.raw.l47_mawa7a_start, R.raw.l47__noor_start)
    var startListL49 = intArrayOf(R.raw.bress_ball_l49_start)
    var startListL50 = intArrayOf(R.raw.l50_start)
    var startListL51 = intArrayOf(R.raw.l51_start)
    var startListL53 = intArrayOf(
        R.raw.l53_tree_start,
        R.raw.l53_lookme_start,
        R.raw.l53_plane_start,
        R.raw.l53_lookme_start,
        R.raw.l53_3sfora_start
    )
    var successList46 = intArrayOf(R.raw.shater, R.raw.shater, R.raw.l46_ta3zeez)
    var successList47 = intArrayOf(R.raw.shater, R.raw.l47_ta3zeez)
    var successList49 = intArrayOf(R.raw.ta3zeez_l49)
    var successList50 = intArrayOf(R.raw.l50_ta3zeez)
    var successList51 = intArrayOf(R.raw.l51_ta3zeez)
    var successList53 = intArrayOf(R.raw.ta3zez, R.raw.ta3zez, R.raw.ta3zez, R.raw.ta3zez)
    var faildList47 = intArrayOf(R.raw.l47_marwa7a_faild, R.raw.l47_noor_faild)
    var faildList49 = intArrayOf(R.raw.bress_ball_l49_faild)
    var faildList50 = intArrayOf(R.raw.l50_faild)
    var faildList51 = intArrayOf(R.raw.l51_faild)
    var index = 0
    var stepIndex = 0
    var numActivity = 0

    /*Handler handler = new Handler();
    Runnable runnable;*/
    private var shape1: ImageView? = null
    private var shape2: ImageView? = null
    private var shape3: ImageView? = null
    private var shapeTrans: ImageView? = null
    var ta3zez_failed_Sound: MediaPlayer? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bress_ball_l49)
        numActivity = intent.getIntExtra("actvtyNum", 0)
        initView()

        backBtn.setOnClickListener {
            if (numActivity == 46)
                startActivity(Intent(this, BoyandGirl_45::class.java).putExtra("actvtyNum", 0))
            else if (numActivity == 49)
                startActivity(Intent(this, BoyandGirl_45::class.java).putExtra("actvtyNum", 1))
            else startActivity(
                Intent(this, BressBall_L49::class.java).putExtra(
                    "actvtyNum",
                    --numActivity
                )
            )
            finish()
        }
        replayBtn.setOnClickListener {
            startActivity(
                Intent(this, BressBall_L49::class.java).putExtra(
                    "actvtyNum",
                    numActivity
                )
            )
            finish()
        }
        nextBtn.setOnClickListener {
            if (numActivity == 47)
                startActivity(Intent(this, BoyandGirl_45::class.java).putExtra("actvtyNum", 1))
            else if (numActivity == 51)
                startActivity(Intent(this, BoyandGirl_45::class.java).putExtra("actvtyNum", 2))
            else
                startActivity(
                    Intent(this, BressBall_L49::class.java).putExtra(
                        "actvtyNum",
                        ++numActivity
                    )
                )
            finish()
        }
/*
        shapeTrans.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shapeTrans.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        shapeTrans.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(shapeTrans.getX(), shapeTrans.getY());


                        Log.d("TAG", "onTouch:y  y = " + shapeTrans.getY() + " x = " + shapeTrans.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(shape.getX(), shape.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
*/
        /*next!!.setOnClickListener {
            index++
            //                shape.setVisibility(View.VISIBLE);
            next!!.visibility = View.GONE
            repeat!!.visibility = View.GONE
            if (numActivity == 49) {
                shape!!.setImageResource(R.drawable.basket_baal)
                playVideo("android.resource://" + packageName + "/" + startListL49[index], false)
            } else if (numActivity == 50) {
                shape!!.setImageResource(R.drawable.basket_baal)
                playVideo("android.resource://" + packageName + "/" + startListL50[index], false)
            } else if (numActivity == 51) {
                shape!!.visibility = View.GONE
                playVideo("android.resource://" + packageName + "/" + startListL51[index], false)
            } else if (numActivity == 53) {
                playVideo("android.resource://" + packageName + "/" + startListL53[index], false)
            }
        }
        repeat!!.setOnClickListener {
            next!!.visibility = View.GONE
            repeat!!.visibility = View.GONE
            if (numActivity == 46) playVideo(
                "android.resource://" + packageName + "/" + startListL46[index],
                false
            ) else if (numActivity == 47) playVideo(
                "android.resource://" + packageName + "/" + startListL47[index],
                false
            ) else if (numActivity == 49) playVideo(
                "android.resource://" + packageName + "/" + startListL49[index],
                false
            ) else if (numActivity == 50) playVideo(
                "android.resource://" + packageName + "/" + startListL50[index],
                false
            ) else if (numActivity == 51) playVideo(
                "android.resource://" + packageName + "/" + startListL51[index],
                false
            ) else if (numActivity == 53) playVideo(
                "android.resource://" + packageName + "/" + startListL53[index],
                false
            )
        }*/
        shape!!.setOnClickListener {
            stepIndex++
            if (numActivity == 46) playVideo(
                "android.resource://" + packageName + "/" + successList46[index],
                true
            ) else if (numActivity == 47) {
                if (index == 1) playVideo(
                    "android.resource://" + packageName + "/" + faildList47[index],
                    true
                ) else playVideo(
                    "android.resource://" + packageName + "/" + successList47[index],
                    true
                )
            } else if (numActivity == 49) playVideo(
                "android.resource://" + packageName + "/" + successList49[index],
                true
            ) else if (numActivity == 50) playVideo(
                "android.resource://" + packageName + "/" + successList50[index],
                true
            ) else if (numActivity == 51) playVideo(
                "android.resource://" + packageName + "/" + successList51[index],
                true
            )
        }
        shape1!!.setOnClickListener {
            if (numActivity == 47) playVideo(
                "android.resource://" + packageName + "/" + successList47[index],
                true
            ) else if (numActivity == 53) {
                if (index == 0) {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.shater)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener { mediaPlayer: MediaPlayer? ->
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[++index],
                            false
                        )
                    })
                } else {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.faild)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener {
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[index],
                            false
                        )
                    })
                }
            } else {
                if (index == 1) playVideo(
                    "android.resource://" + packageName + "/" + successList46[index],
                    true
                ) else playVideo("android.resource://" + packageName + "/" + R.raw.faild, false)
            }
        }
        shape2!!.setOnClickListener {
            if (numActivity == 53) {
                if (index == 2) {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.shater)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener { mediaPlayer: MediaPlayer? ->
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[++index],
                            false
                        )
                    })
                } else {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.faild)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener {
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[index],
                            false
                        )
                    })
                }
            } else {
                if (index == 0) playVideo(
                    "android.resource://" + packageName + "/" + successList46[index],
                    true
                ) else playVideo("android.resource://" + packageName + "/" + R.raw.faild, false)
            }
        }
        shape3!!.setOnClickListener {
            if (numActivity == 53) {
                if (index == 4) {

                    options!!.visibility = View.VISIBLE
                    nextBtn.visibility=GONE
                    playVideo("android.resource://" + packageName + "/" + R.raw.shate_vid, true)
                    /*    ta3zez_failed_Sound = MediaPlayer.create(BressBall_L49.this, R.raw.shater);
                            ta3zez_failed_Sound!!.start();
                            ta3zez_failed_Sound!!.setOnCompletionListener(mediaPlayer -> {
                                next.setVisibility(View.VISIBLE);
                                repeat.setVisibility(View.VISIBLE);
                            });*/
                } else {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.faild)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener {
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[index],
                            false
                        )
                    })
                }
            } else {
                if (index == 2) playVideo(
                    "android.resource://" + packageName + "/" + successList46[index],
                    true
                ) else playVideo("android.resource://" + packageName + "/" + R.raw.faild, false)
            }
        }
        videoView!!.setOnClickListener {
            if (numActivity == 47) playVideo(
                "android.resource://" + packageName + "/" + faildList47[index],
                false
            ) else if (numActivity == 49) playVideo(
                "android.resource://" + packageName + "/" + faildList49[index],
                false
            ) else if (numActivity == 50) playVideo(
                "android.resource://" + packageName + "/" + faildList50[index],
                false
            ) else if (numActivity == 51) playVideo(
                "android.resource://" + packageName + "/" + faildList51[index],
                false
            ) else if (numActivity == 53) {
                ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.faild)
                ta3zez_failed_Sound!!.start()
                ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener {
                    playVideo(
                        "android.resource://" + packageName + "/" + startListL53[index],
                        false
                    )
                })
            }
        }
        shapeTrans!!.setOnClickListener {
            if (numActivity == 51) playVideo(
                "android.resource://" + packageName + "/" + successList51[index],
                true
            ) else {
                if (index == 1 || index == 3 || index == 5) {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.shater)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener { mediaPlayer: MediaPlayer? ->
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[++index],
                            false
                        )
                    })
                } else {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.faild)
                    ta3zez_failed_Sound!!.start()
                    ta3zez_failed_Sound!!.setOnCompletionListener(OnCompletionListener {
                        playVideo(
                            "android.resource://" + packageName + "/" + startListL53[index],
                            false
                        )
                    })
                }
            }
        }
        /*
        runnable = new Runnable() {
            @Override
            public void run() {

                if (numActivity == 46)
                    playVideo("android.resource://" + getPackageName() + "/" + successList46[index], true);
                else if (numActivity == 47)
                    playVideo("android.resource://" + getPackageName() + "/" + successList47[index], true);
                else if (numActivity == 51)
                    playVideo("android.resource://" + getPackageName() + "/" + successList51[index], true);
                else if (numActivity == 53)
                    playVideo("android.resource://" + getPackageName() + "/" + successList53[index], true);


            }
        };
*/
/*
        shape2.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shape2.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        shape2.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(shape2.getX(), shape2.getY());
                        Log.d("TAG", "onTouch:y  y = " + shape2.getY());
                        Log.d("TAG", "onTouch:x  x= " + shape2.getX());

                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(shape.getX(), shape.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
*/
    }

    fun playVideo(path: String?, isSuccess: Boolean) {
        videoView!!.setVideoURI(Uri.parse(path))
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            if (isSuccess) {
                if (numActivity == 46) if (index == 2) options!!.visibility = View.VISIBLE else {
                    next!!.visibility = View.GONE
                    repeat!!.visibility = View.GONE
                    nextStep()
                } else if (numActivity == 47) if (index == 1) options!!.visibility =
                    View.VISIBLE else {
                    next!!.visibility = View.GONE
                    repeat!!.visibility = View.GONE
                    nextStep()
                } else if (numActivity == 49) if (index == 0) options!!.visibility =
                    View.VISIBLE else {
                    next!!.visibility = View.VISIBLE
                    repeat!!.visibility = View.VISIBLE
                } else if (numActivity == 50) if (index == 0) options!!.visibility =
                    View.VISIBLE else {
                    next!!.visibility = View.VISIBLE
                    repeat!!.visibility = View.VISIBLE
                } else if (numActivity == 51) if (index == 0) options!!.visibility =
                    View.VISIBLE else {
                    next!!.visibility = View.VISIBLE
                    repeat!!.visibility = View.VISIBLE
                } else if (numActivity == 53) {
                    ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.shater)
                    ta3zez_failed_Sound!!.start()
                    /*  if (index == 3) finishBtn.setVisibility(View.VISIBLE);
                            else {
                                next.setVisibility(View.VISIBLE);
                                repeat.setVisibility(View.VISIBLE);
                            }*/
                }
            } else {
                if (numActivity != 49 && numActivity != 50) {
                    //handler.postDelayed(runnable, 2200);
                }
            }
        }
    }

    private fun nextStep() {
        index++
        //                shape.setVisibility(View.VISIBLE);
        next!!.visibility = View.GONE
        repeat!!.visibility = View.GONE
        if (numActivity == 46) {
            if (index == 0) {
                shape!!.setImageResource(R.drawable.basket_baal)
            } else if (index == 1) {
                shape!!.setImageResource(R.drawable.car_46)
                /*shape.animate()
                                .x((float) 1768)
                                .y((float) 138)
                                .setDuration(1)
                                .start();*/
            } else if (index == 2) {
                shape!!.setImageResource(R.drawable.moka3b)
                /*shape.animate()
                                .x((float) 1768)
                                .y((float) 138)
                                .setDuration(1)
                                .start();*/
            }
            playVideo("android.resource://" + packageName + "/" + startListL46[index], false)
        } else if (numActivity == 47) {
            if (index == 1) {
                shape1!!.setImageResource(0)
                shape1!!.visibility = View.VISIBLE
                shape1!!.layoutParams.height = 150
                shape1!!.layoutParams.width = 120
                shape1!!.animate()
                    .x(230.toFloat())
                    .y(241.toFloat())
                    .setDuration(2200)
                    .start()
            }
            playVideo("android.resource://" + packageName + "/" + startListL47[index], false)
        }
    }

    override fun onResume() {
        super.onResume()
        ta3zez_failed_Sound = MediaPlayer.create(this@BressBall_L49, R.raw.shater)
        next!!.visibility = View.GONE
        repeat!!.visibility = View.GONE
        if (numActivity == 46) {
            shape!!.visibility = View.GONE
            shape1!!.visibility = View.VISIBLE
            shape2!!.visibility = View.VISIBLE
            shape3!!.visibility = View.VISIBLE
            /* shape.animate()
                    .x((float) 772)
                    .y((float) 466)
                    .setDuration(2200)
                    .start();*/playVideo(
                "android.resource://" + packageName + "/" + startListL46[index],
                false
            )
        } else if (numActivity == 47) {
            index = 0
            shape!!.layoutParams.height = 350
            shape!!.layoutParams.width = 320
            shape!!.setImageResource(R.drawable.marwa7a)
            shape!!.animate()
                .x(1768.toFloat())
                .y(138.toFloat())
                .setDuration(1)
                .start()
            playVideo("android.resource://" + packageName + "/" + startListL47[index], false)
        } else if (numActivity == 49) {
            shape!!.setImageResource(R.drawable.basket_baal)
            shape!!.animate()
                .x(1560.toFloat())
                .y(499.toFloat())
                .setDuration(1)
                .start()
            playVideo("android.resource://" + packageName + "/" + startListL49[index], false)
        } else if (numActivity == 50) {
            shape!!.animate()
                .x(772.toFloat())
                .y(466.toFloat())
                .setDuration(1)
                .start()
            playVideo("android.resource://" + packageName + "/" + startListL50[index], false)
        } else if (numActivity == 51) {
            shape!!.visibility = View.GONE
            shapeTrans!!.layoutParams.height = 550
            shapeTrans!!.layoutParams.width = 630
            shapeTrans!!.visibility = View.VISIBLE
            shapeTrans!!.animate()
                .x(52.toFloat())
                .y(138.toFloat())
                .setDuration(1)
                .start()
            playVideo("android.resource://" + packageName + "/" + startListL51[index], false)
        } else if (numActivity == 53) {
            shape!!.visibility = View.GONE
            shapeTrans!!.visibility = View.VISIBLE
            shape1!!.setImageResource(R.drawable.l53_tree)
            shape1!!.visibility = View.VISIBLE
            shape2!!.setImageResource(R.drawable.l53_plane)
            shape2!!.visibility = View.VISIBLE
            shape3!!.setImageResource(R.drawable.l53_3sfora)
            shape3!!.visibility = View.VISIBLE
            shape1!!.animate()
                .x(1706.toFloat())
                .y(303.toFloat())
                .setDuration(1)
                .start()
            shape2!!.animate()
                .x(301.toFloat())
                .y(164.toFloat())
                .setDuration(1)
                .start()
            shape3!!.animate()
                .x(1606.toFloat())
                .y(127.toFloat())
                .setDuration(1)
                .start()
            playVideo("android.resource://" + packageName + "/" + startListL53[index], false)
        }
    }

    private fun initView() {
        videoView = findViewById(R.id.videoView)
        shape = findViewById(R.id.shape)
        shape1 = findViewById(R.id.shape1)
        shape2 = findViewById(R.id.shape2)
        shape3 = findViewById(R.id.shape3)
        shapeTrans = findViewById(R.id.shapetrans)
        shape1 = findViewById<View>(R.id.shape1) as ImageView
    }

    companion object {
        private const val TAG = "BressBall_L49"
    }
}