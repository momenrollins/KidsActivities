package com.momen.babyactivities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.momen.babyactivities.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var iv: LinearLayout? = null

    var select_ivRight: ImageView? = null
    var select_ivLeft: ImageView? = null
    var arwImg: ImageView? = null
    var handler = Handler()
    var runnable: Runnable? = null
    var videoView: VideoView? = null
    var path: String? = null
    var container: RelativeLayout? = null
    var replatAgain: Button? = null
    var nextIndex = 0
    var handler2 = Handler()
    var runnable2: Runnable? = null
    var isStarted = false
    var imgList = intArrayOf(
        R.drawable.lvl1_1,
        R.drawable.lvl1_2,
        R.drawable.appal2,
        R.drawable.banana,
        R.drawable.duck,
        R.drawable.dog,
        R.drawable.lion,
        R.drawable.lion,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red,
        R.drawable.red
    )
    var startList = intArrayOf(
        R.raw.lvl1_1_start,
        R.raw.lvl1_2_start,
        R.raw.selectappal1,
        R.raw.bana_app1,
        R.raw.duck1,
        R.raw.duckdog1,
        R.raw.lion1,
        R.raw.lion_gr1,
        R.raw.red1,
        R.raw.black_red1,
        R.raw.v12_1,
        R.raw.apple_banana1,
        R.raw.v14_1,
        R.raw.duck_dog1,
        R.raw.v16_1,
        R.raw.lion_grf1,
        R.raw.v18_1,
        R.raw.red_black1,
        R.raw.v20_1,
        R.raw.ap_bana1,
        R.raw.v22_1,
        R.raw.duck_dog_1,
        R.raw.v24_1,
        R.raw.lion_grf_1,
        R.raw.v26_1,
        R.raw.red_black_1
    )
    var successList = intArrayOf(
        R.raw.lvl1_1_success, R.raw.lvl1_2_success,
        R.raw.selectappal3, R.raw.bana_app3,
        R.raw.duck3, R.raw.duckdog3,
        R.raw.lion3, R.raw.lion_gr3, R.raw.red3,
        R.raw.black_red2, R.raw.v12_3, R.raw.apple_banana2,
        R.raw.v14_3,
        R.raw.duck_dog2, R.raw.v16_3, R.raw.lion_grf2,
        R.raw.v18_3, R.raw.red_black2, R.raw.v20_3,
        R.raw.ap_bana2,
        R.raw.v22_3, R.raw.duck_dog_2, R.raw.v24_3,
        R.raw.lion_grf_2, R.raw.v26_3, R.raw.red_black_2
    )
    var failedList = intArrayOf(
        R.raw.lvl1_1_failed,
        R.raw.lvl1_2_failed,
        R.raw.selectappal2,
        R.raw.bana_app2,
        R.raw.duck2,
        R.raw.duckdog2,
        R.raw.lion2,
        R.raw.lion_gr2,
        R.raw.red2,
        R.raw.black_red3,
        R.raw.v12_2,
        R.raw.apple_banana3,
        R.raw.v14_2,
        R.raw.duck_dog3,
        R.raw.v16_2,
        R.raw.lion_grf3,
        R.raw.v18_2,
        R.raw.red_black3,
        R.raw.v20_2,
        R.raw.ap_bana3,
        R.raw.v22_2,
        R.raw.duck_dog_3,
        R.raw.v24_2,
        R.raw.lion_grf_3,
        R.raw.v26_2,
        R.raw.red_black_3
    )
    var activityPosition = 0
    var viewSuccess: View? = null
    var viewFail: View? = null
    var arrowTrue: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv = findViewById(R.id.lvlImg)
        arwImg = findViewById(R.id.arwImg)

        select_ivRight = findViewById(R.id.selectImage1)
        select_ivLeft = findViewById(R.id.selectImage2)
        activityPosition = intent.getIntExtra("actvtyNum", 0) - 1
        if (activityPosition == 0 || activityPosition == -1) activityPosition++
        nextIndex = activityPosition
        Log.d(TAG, "onCreate:activityPosition  " + imgList.size)
        ballImg.setImageResource(imgList[activityPosition])
        container = findViewById(R.id.container)
        videoView = findViewById(R.id.VideoView)
        replatAgain = findViewById(R.id.reply)
        action(activityPosition)
        if (activityPosition == 0)
            backBtn.visibility = GONE

        replayBtn.setOnClickListener {
            if (activityPosition > 1)
                ++activityPosition

            startActivity(
                Intent(this, MainActivity::class.java)
                    .putExtra("actvtyNum", activityPosition)
            )
            finish()
        }
        backBtn.setOnClickListener {
            if (activityPosition == 1) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .putExtra("actvtyNum", --activityPosition)
                )
            } else if (activityPosition == 2) {
                startActivity(
                    Intent(this, PlayVideoActivity::class.java)
                        .putExtra("lvl", 1).putExtra("actvtyNum", 0)
                )
            } else startActivity(
                Intent(this, MainActivity::class.java)
                    .putExtra("actvtyNum", activityPosition)
            )
            finish()
        }
        nextBtn.setOnClickListener {
            if (activityPosition == 0) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .putExtra("actvtyNum", ++activityPosition)
                )
            } else if (activityPosition == 1) {
                startActivity(
                    Intent(this, PlayVideoActivity::class.java)
                        .putExtra("lvl", 1).putExtra("actvtyNum", 0)
                )
            } else if (activityPosition == 25) {
                startActivity(
                    Intent(this, DragActivity::class.java)
                       .putExtra("actvtyNum", 27)
                )
            } else {
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .putExtra("actvtyNum", activityPosition + 2)
                )
            }
            finish()
        }

        //        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);

        /*replatAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    fun action(index: Int) {
        path = "android.resource://" + packageName + "/" + startList[index]
        Log.d(TAG, "action:index  $index")
        arwImg!!.visibility = View.GONE
        iv!!.visibility = View.GONE
        select_ivRight!!.visibility = View.INVISIBLE
        select_ivLeft!!.visibility = View.INVISIBLE
        if (arrowTrue != null) {
            arrowTrue!!.visibility = View.INVISIBLE
        }
        playVideo(path, false)
        when (index) {
            0, 1 -> {
                iv!!.visibility = View.VISIBLE
                ballImg!!.setImageResource(imgList[index])
            }
            2 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivRight!!.setImageResource(imgList[index])
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            3 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivRight!!.setImageResource(R.drawable.appal2)
                select_ivLeft!!.setImageResource(R.drawable.banana)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            4 -> {
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.duck)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            5 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.duck)
                select_ivRight!!.setImageResource(R.drawable.dog)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            6 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivRight!!.setImageResource(R.drawable.lion)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            7 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivRight!!.setImageResource(R.drawable.lion)
                select_ivLeft!!.setImageResource(R.drawable.giraffe)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            8 -> {
                arrowTrue = findViewById(R.id.arwImgLeft)
                select_ivRight!!.visibility = View.INVISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.red)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
            }
            9 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.red)
                select_ivRight!!.setImageResource(R.drawable.black)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            10, 18 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.INVISIBLE
                select_ivRight!!.setImageResource(R.drawable.appel_with_back)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            11, 19 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivRight!!.setImageResource(R.drawable.apple1)
                select_ivLeft!!.setImageResource(R.drawable.banana2)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            12 -> {
                select_ivRight!!.visibility = View.INVISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.duck_with_back)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            13, 21 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.duck1)
                select_ivRight!!.setImageResource(R.drawable.dog1)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            14, 22 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.INVISIBLE
                select_ivRight!!.setImageResource(R.drawable.lion_with_back)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            15, 23 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivRight!!.setImageResource(R.drawable.lion1)
                select_ivLeft!!.setImageResource(R.drawable.grf1)
                viewSuccess = select_ivRight
                viewFail = select_ivLeft
                arrowTrue = findViewById(R.id.arwImgRight)
            }
            16 -> {
                select_ivRight!!.visibility = View.INVISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.red_with_back)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            17, 25 -> {
                select_ivRight!!.visibility = View.VISIBLE
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivLeft!!.setImageResource(R.drawable.red1)
                select_ivRight!!.setImageResource(R.drawable.black1)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            20 -> {
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivRight!!.visibility = View.INVISIBLE
                select_ivLeft!!.setImageResource(R.drawable.duck_with_back)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
            24 -> {
                select_ivLeft!!.visibility = View.VISIBLE
                select_ivRight!!.visibility = View.INVISIBLE
                select_ivLeft!!.setImageResource(R.drawable.red_with_back)
                viewSuccess = select_ivLeft
                viewFail = select_ivRight
                arrowTrue = findViewById(R.id.arwImgLeft)
            }
        }
        if (arrowTrue != null) YoYo.with(Techniques.Pulse)
            .repeat(YoYo.INFINITE)
            .duration(1500)
            .playOn(arrowTrue)
        runnable = Runnable {
            positionImage()
            handler.postDelayed(runnable!!, 2200)
        }
        runnable2 = Runnable {
            if (isStarted) YoYo.with(Techniques.Pulse)
                .duration(2000)
                .playOn(viewSuccess) else playVideo(path, false)
        }
        if (index == 0 || index == 1) {
            handler.post(runnable!!)
        }
        iv!!.setOnClickListener { //                Toast.makeText(MainActivity.this, "iv", Toast.LENGTH_SHORT).show();
            path = "android.resource://" + packageName + "/" + successList[index]
            //                arwImg.setVisibility(View.GONE);
            handler.removeCallbacks(runnable!!)
            playVideo(path, true)
        }
        if (viewSuccess != null) viewSuccess!!.setOnClickListener { //                Toast.makeText(MainActivity.this, "viewSuccess", Toast.LENGTH_SHORT).show();
            isStarted = true
            path = "android.resource://" + packageName + "/" + successList[index]
            handler2.postDelayed(runnable2!!, 8500)
            if (viewFail != null) viewFail!!.visibility = View.GONE
            //viewSuccess.setVisibility(View.GONE);
            arrowTrue!!.visibility = View.INVISIBLE
            /*       view.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);*/playVideo(path, true)
        }
        container!!.setOnClickListener { //                Toast.makeText(MainActivity.this, "container", Toast.LENGTH_SHORT).show();
            path = "android.resource://" + packageName + "/" + failedList[index]
            if (arrowTrue != null) {
                arrowTrue!!.visibility = View.VISIBLE
            }
            if (index == 0 || index == 1) {
                arwImg!!.visibility = View.VISIBLE
                YoYo.with(Techniques.Pulse)
                    .repeat(YoYo.INFINITE)
                    .duration(1500)
                    .playOn(arwImg)
                handler.removeCallbacks(runnable!!)
                handler.post(runnable!!)
            }
            /*  select_ivLeft.setVisibility(View.GONE);
                    select_ivRight.setVisibility(View.GONE);*/playVideo(path, false)
        }
    }

    fun playVideo(path: String?, isSuccess: Boolean) {

        videoView!!.visibility = View.VISIBLE
        //        container.setVisibility(View.INVISIBLE);
        videoView!!.setVideoURI(Uri.parse(path))
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            if (isSuccess) {
                options.visibility = VISIBLE


                /* if (activityPosition == 2) {
                            select_ivRight.setVisibility(View.VISIBLE);
    
                        } else if (activityPosition == 3) {
                            select_ivRight.setVisibility(View.VISIBLE);
                            select_ivLeft.setVisibility(View.VISIBLE);
                        } else if (activityPosition == 4) {
                            viewSuccess.setVisibility(View.VISIBLE);
                        } else if (activityPosition == 5) {
                            select_ivRight.setVisibility(View.VISIBLE);
                            select_ivLeft.setVisibility(View.VISIBLE);
                        } else if (activityPosition == 6) {
                            select_ivRight.setVisibility(View.VISIBLE);
                        }*/

//                    replatAgain.setVisibility(View.INVISIBLE);
            } else {
                if (!isStarted) handler2.postDelayed(runnable2!!, 2000)
            }
        }
    }

    fun positionImage() {

//        DisplayMetrics metrics = container.getw;
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        val DeviceTotalWidth = container!!.width
        val DeviceTotalHeight = container!!.height
        val randX = getRandomPositionX(DeviceTotalWidth.toFloat())
        val randY = getRandomPositionY(DeviceTotalHeight.toFloat())
        Log.d(TAG, "positionImage: totalX: $DeviceTotalWidth totalY: $DeviceTotalHeight")
        Log.d(TAG, "positionImage: ranX: $randX ranY: $randY")
        iv!!.animate()
            .x(randX)
            .y(randY)
            .setDuration(2200)
            .start()
    }

    fun getRandomPositionX(deviceTotalWidth: Float): Float {
        val random = Random()
        return random.nextInt(deviceTotalWidth.toInt() - 700 - imageSizeinPixels.toInt())
            .toFloat()
    }

    fun getRandomPositionY(DeviceTotalHeight: Float): Float {
        val random = Random()
        return random.nextInt(DeviceTotalHeight.toInt() - 200 - imageSizeinPixels.toInt())
            .toFloat()
    }

    // Converts 65 dip into its equivalent px
    val imageSizeinPixels: Float
        get() {
            // Converts 65 dip into its equivalent px
            val imageSize = 65f
            val extraPadding = 40f
            val dip = imageSize + extraPadding
            val r = resources
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.displayMetrics
            )
        }

    companion object {
        private const val TAG = "MainActivity"
    }
}