package com.momen.babyactivities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Path
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_play_video.*

class RabbitJump : AppCompatActivity() {
    private var rabbit: ImageView? = null
    var handler = Handler()
    var runnable: Runnable? = null
    var pointList: ArrayList<pointModel> = ArrayList()
    var index = 0
    private var videoView: VideoView? = null
    private var container: ConstraintLayout? = null
    var path = Path()
    var isStart = false
    var handler2 = Handler()
    var runnable2: Runnable? = null
    var countFaildPoints = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rabbit_jump)
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView()
        homeBtn.setOnClickListener {
            val gotoScreenVar =
                Intent(this, LevelTypeActivity::class.java).putExtra("lvl", 2)
            gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(gotoScreenVar)
        }
        runnable2 = Runnable {
            handler2.postDelayed(runnable2!!, 6500)

            playVideo(
                "android.resource://" + packageName + "/" + R.raw.rabbit_j_start,
                false,
                false
            )
        }
        action()
        replayBtn.setOnClickListener {
            options.visibility = GONE
            action()
        }
        nextBtn.setOnClickListener {
            startActivity(
                Intent(this, BoyandGirl_45::class.java).putExtra(
                    "actvtyNum",
                    0
                )
            )
            finish()
        }
    }

    private fun action() {
        index = 0
        rabbit!!.animate()
            .x(100.toFloat())
            .y(547f)
            .setDuration(1)
            .start()
        playVideo("android.resource://" + packageName + "/" + R.raw.rabbit_j_start, false, false)
        pointList.clear()
        pointList.add(pointModel(346, 321))
        pointList.add(pointModel(599, 547))
        pointList.add(pointModel(794, 334))
        pointList.add(pointModel(1057, 547))
        pointList.add(pointModel(1232, 339))
        pointList.add(pointModel(1501, 548))
        pointList.add(pointModel(1695, 355))
        pointList.add(pointModel(1956, 545))
        runnable = Runnable {
            Log.d("TAG", "run: is$isStart")
            if (isStart) {

                if (index % 2 != 0) rabbit!!.animate()
                    .x(pointList[index]!!.x.toFloat())
                    .y(pointList[index]!!.y.toFloat())
                    .setDuration(1000)
                    .start()
                index++
                if (index < pointList.size) {
                    playVideo(
                        "android.resource://" + packageName + "/" + R.raw.rabbit_j_start,
                        false,
                        false
                    )
                } else {
                    videoView!!.background = null
                    playVideo(
                        "android.resource://" + packageName + "/" + R.raw.rabbit_j_success,
                        true,
                        false
                    )
                    handler.removeCallbacks(runnable!!)
                }
            } else {

                playVideo(
                    "android.resource://" + packageName + "/" + R.raw.rabbit_j_start,
                    false,
                    false
                )

                // handler.postDelayed(runnable, 2500);
            }
        }

        rabbit!!.setOnClickListener { /* path.arcTo(0f, (float) pointList.get(index).y,(float) pointList.get(index).x,0f, 180f, 60f, true);
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
                animator.setDuration(2000);
                animator.start();*/
            handler2.removeCallbacks(runnable2!!)

            isStart = true
            Log.d("TAG", "action: INDEX $index")
            if (index < pointList.size) {
                rabbit!!.animate()
                    .x(pointList[index]!!.x.toFloat())
                    .y(pointList[index]!!.y.toFloat())
                    .setDuration(1000)
                    .start()
            }
            index++
            if (index < pointList.size) {
                Log.d("TAG", "action: INDEX IF $index ${pointList.size}")
                handler.postDelayed(runnable!!, 1000)
            } else {
                videoView!!.background = null
                playVideo(
                    "android.resource://" + packageName + "/" + R.raw.rabbit_j_success,
                    true,
                    false
                )
                handler.removeCallbacks(runnable!!)
                handler2.removeCallbacks(runnable2!!)
            }
        }
        container!!.setOnClickListener {
            //                            isStarted=false;
            countFaildPoints = countFaildPoints + 1

            playVideo(
                "android.resource://" + packageName + "/" + R.raw.faild,
                false,
                true
            )
        }

    }

    private fun initView() {
        rabbit = findViewById<View>(R.id.rabbit) as ImageView
        videoView = findViewById<View>(R.id.videoView) as VideoView
        container = findViewById<View>(R.id.container) as ConstraintLayout
    }

    fun playVideo(path: String?, finish: Boolean, faild: Boolean) {
      if (!finish)  handler2.postDelayed(runnable2!!, 6500)

        videoView!!.setVideoURI(Uri.parse(path))
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            if (finish) {

                SHARDStorage.saveFaildPoints("level1rabbit", countFaildPoints)
                if (countFaildPoints != 0) {
                    SHARDStorage.AliartResult(
                        this,
                        SHARDStorage.sharedPreferences.getInt("level1rabbit", 0)
                            .toString() + ": محاولة "
                    )
                }
                countFaildPoints = 0

                options.visibility = VISIBLE
                /* finishBtn.setVisibility(View.VISIBLE);
                        finishBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RabbitJump.super.onBackPressed();
                            }
                        });*/
            }/* else if (!isStart) {
                handler.postDelayed(runnable!!, 2500)
            }*/ else if (faild) {
                playVideo(
                    "android.resource://" + packageName + "/" + R.raw.rabbit_j_start,
                    false,
                    false
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    inner class pointModel {
        var x = 0
        var y = 0

        constructor(x: Int, y: Int) {
            this.x = x
            this.y = y
        }

        constructor() {}
    }
}