package com.momen.babyactivities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_boyand_girl45.*

class BoyandGirl_45 : AppCompatActivity() {
    private var videoView: VideoView? = null
    private var boy: ImageView? = null
    private var girl: ImageView? = null
    private var basketBall: ImageView? = null
    var index = 0
    var girlTurn = false
    var boyTurn = true
    var startList = intArrayOf(R.raw.bassket_boy, R.raw.basket_girl)
    var handler = Handler()
    var runnable: Runnable? = null
    private var container: ConstraintLayout? = null
    private var boy2: ImageView? = null
    private var girl2: ImageView? = null
    var isGirlPlay = false
    var count = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boyand_girl45)
        initView()
        index = intent.getIntExtra("actvtyNum", 0)
        runnable = Runnable {
            if (!isGirlPlay) {
                basketBall!!.animate()
                    .rotationBy(360f).x(1444.toFloat())
                    .y(202.toFloat())
                    .setDuration(1100)
                    .start()
                isGirlPlay = true
                playVideo("android.resource://" + packageName + "/" + R.raw.shater, false, false)
            } else if (isGirlPlay) {
                basketBall!!.animate().rotationBy(-360f)
                    .x(414.toFloat())
                    .y(210.toFloat())
                    .setDuration(1100)
                    .start()
            }
        }
        container!!.setOnClickListener {
            if (boyTurn || girlTurn) if (index < 2) playVideo(
                "android.resource://" + packageName + "/" + R.raw.faild,
                true,
                false
            ) else playVideo("android.resource://" + packageName + "/" + R.raw.smile2, true, false)
        }

        /*girl.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        girl.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        girl.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(girl.getX(), girl.getY());


                        Log.d("TAG", "onTouch:y  y = " + girl.getY() +" x = "+ girl.getX());


                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(girl.getX(), girl.getY());

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });*/


        //============================
        boy2!!.setOnClickListener {
            if (index == 0) {
                if (boyTurn) {
                    basketBall!!.animate()
                        .rotationBy(360f).x(965.toFloat())
                        .y(103.toFloat())
                        .setDuration(1100)
                        .start()
                    handler.postDelayed(runnable!!, 900)
                    boyTurn = false
                    girlTurn = true
                } else {
                    playVideo("android.resource://" + packageName + "/" + R.raw.faild, true, false)
                }
            } else if (index == 1) {
                if (boyTurn) {
                    playVideo("android.resource://" + packageName + "/" + R.raw.shater, true, false)
                    count++
                    if (count == 4) {
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.ta3zez,
                            true,
                            true
                        )
                    }
                    boyTurn = false
                    girlTurn = true
                } else playVideo(
                    "android.resource://" + packageName + "/" + R.raw.faild,
                    true,
                    false
                )
            } else {
                if (boyTurn) {
                    playVideo("android.resource://" + packageName + "/" + R.raw.smile3, true, true)
                    girl!!.visibility = View.GONE
                    boyTurn = false
                    girlTurn = false
                }
            }
        }
        girl2!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (index == 0) {
                    if (girlTurn) {
                        run {
                            basketBall!!.animate()
                                .rotationBy(-360f).x(965.toFloat())
                                .y(103.toFloat())
                                .setDuration(1100)
                                .start()
                            handler.postDelayed(runnable!!, 1000)
                            playVideo(
                                "android.resource://" + packageName + "/" + R.raw.ta3zez,
                                true,
                                true
                            )
                            girlTurn = false
                        }
                    } else {
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.faild,
                            true,
                            false
                        )
                    }
                } else if (index == 1) {
                    if (girlTurn) {
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.shater,
                            true,
                            false
                        )
                        girlTurn = false
                        count++
                    } else playVideo(
                        "android.resource://" + packageName + "/" + R.raw.faild,
                        true,
                        false
                    )
                } else {
                    if (girlTurn) playVideo(
                        "android.resource://" + packageName + "/" + R.raw.smile2,
                        true,
                        false
                    )
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if (index == 0) playVideo(
            "android.resource://" + packageName + "/" + R.raw.bassket_boy,
            true,
            false
        ) else if (index == 1) {
            videoView!!.background = null
            isGirlPlay = java.lang.Boolean.parseBoolean(null)
            playVideo("android.resource://" + packageName + "/" + R.raw.lookleft, true, false)
            boy!!.setImageResource(R.drawable.left_tree)
            boy!!.layoutParams.height = 750
            boy!!.layoutParams.width = 630
            boy!!.scaleType = ImageView.ScaleType.FIT_XY
            boy2!!.layoutParams.height = 750
            boy2!!.layoutParams.width = 630
            boy2!!.scaleType = ImageView.ScaleType.FIT_XY
            girl!!.animate()
                .x(1565.toFloat())
                .y(152.toFloat())
                .setDuration(1)
                .start()
            girl2!!.animate()
                .x(1565.toFloat())
                .y(152.toFloat())
                .setDuration(1)
                .start()
            girl!!.setImageResource(R.drawable.right_tree)
            girl!!.layoutParams.height = 750
            girl!!.scaleType = ImageView.ScaleType.FIT_XY
            girl!!.layoutParams.width = 630
            girl2!!.scaleType = ImageView.ScaleType.FIT_XY
            girl2!!.layoutParams.height = 750
            girl2!!.layoutParams.width = 630
            Log.d("TAG", "onResume: x " + girl!!.x + " y " + girl!!.y)
            /*  girl.setX(1664);
            girl2.setX(1664);*/basketBall!!.visibility = View.GONE
            playVideo("android.resource://" + packageName + "/" + R.raw.lookleft, true, false)
        } else {
            videoView!!.background = null
            playVideo("android.resource://" + packageName + "/" + R.raw.smile1, true, false)
            boy!!.setImageResource(R.drawable.smile)
            girl!!.setImageResource(R.drawable.sad)
            boy!!.visibility = View.GONE
            girl!!.visibility = View.GONE
            boyTurn = false
            handler.postDelayed({
                boy!!.visibility = View.VISIBLE
                girlTurn = true
                boyTurn = true
            }, 5500)
            handler.postDelayed({ girl!!.visibility = View.VISIBLE }, 10000)
            basketBall!!.visibility = View.GONE
        }
    }

    fun playVideo(path: String?, isBoy: Boolean, finish: Boolean) {
        videoView!!.setVideoURI(Uri.parse(path))
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            if (finish) {
                if (index == 0) {
                    backBtn.setOnClickListener {
                        startActivity(Intent(this, RabbitJump::class.java))
                        finish()
                    }
                    nextBtn.setOnClickListener {
                        startActivity(
                            Intent(this, BressBall_L49::class.java).putExtra(
                                "actvtyNum",
                                46
                            )
                        )
                        finish()
                    }
                }
                else if (index == 1) {
                    backBtn.setOnClickListener {
                        startActivity(
                            Intent(this, BressBall_L49::class.java).putExtra(
                                "actvtyNum",
                                47
                            )
                        )
                        finish()
                    }
                    nextBtn.setOnClickListener {
                        startActivity(
                            Intent(this, BressBall_L49::class.java).putExtra(
                                "actvtyNum",
                                49
                            )
                        )
                        finish()
                    }
                }
                else if (index == 2) {
                    backBtn.setOnClickListener {
                        startActivity(
                            Intent(this, BressBall_L49::class.java).putExtra(
                                "actvtyNum",
                                51
                            )
                        )

                        finish()
                    }
                    nextBtn.setOnClickListener {
                        startActivity(
                            Intent(this, BressBall_L49::class.java).putExtra(
                                "actvtyNum",
                                53
                            )
                        )
                        finish()
                    }
                }
                replayBtn.setOnClickListener {
                    startActivity(
                        Intent(
                            this,
                            BoyandGirl_45::class.java
                        ).putExtra("actvtyNum", index)
                    )
                    finish()
                }

                options.visibility = View.VISIBLE

            } else {
                if (index == 0) {
                    if (!isBoy) {
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.basket_girl,
                            true,
                            false
                        )
                    } else {
                        if (!isGirlPlay) {
                            playVideo(
                                "android.resource://" + packageName + "/" + R.raw.bassket_boy,
                                true,
                                false
                            )
                        } else if (isGirlPlay) {
                            playVideo(
                                "android.resource://" + packageName + "/" + R.raw.basket_girl,
                                true,
                                false
                            )
                        }
                    }
                } else if (index == 1) {
                    if (count == 1) {
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.lookright,
                            true,
                            false
                        )
                    } else if (count == 2) {
                        girlTurn = true
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.lookright,
                            true,
                            false
                        )
                    } else if (count == 3) {
                        boyTurn = true
                        girlTurn = false
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.lookleft,
                            true,
                            false
                        )
                    } else if (isBoy && count == 0) {
                        playVideo(
                            "android.resource://" + packageName + "/" + R.raw.lookleft,
                            true,
                            false
                        )
                    }
                }
            }
        }
    }

    private fun initView() {
        videoView = findViewById<View>(R.id.videoView) as VideoView
        boy = findViewById<View>(R.id.boy) as ImageView
        girl = findViewById<View>(R.id.girl) as ImageView
        basketBall = findViewById<View>(R.id.basket_ball) as ImageView
        container = findViewById<View>(R.id.container) as ConstraintLayout
        boy2 = findViewById<View>(R.id.boy2) as ImageView
        girl2 = findViewById<View>(R.id.girl2) as ImageView
    }
}