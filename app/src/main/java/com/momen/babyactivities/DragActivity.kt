package com.momen.babyactivities

import androidx.appcompat.app.AppCompatActivity
import android.view.View.OnTouchListener
import android.widget.VideoView
import android.widget.LinearLayout
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.net.Uri
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import java.util.*

class DragActivity : AppCompatActivity(), OnTouchListener {
    //    ImageView iv;
    var handler = Handler()
    var runnable: Runnable? = null
    var videoView: VideoView? = null
    var path: String? = null
    var container: LinearLayout? = null
    var shape1: ImageView? = null
    var shape2: ImageView? = null
    var shape3: ImageView? = null
    var dX = 0f
    var dY = 0f
    var isShape1 = false
    var isShape2 = false
    var isShape3 = false
    val shape1X = 884.0f
    val shape1Y = 332.0f
    val shape2X = 577.0f
    val shape2Y = 597.0f
    val shape3X = 265.0f
    val shape3Y = 807.0f

    val s1X = -395.0f
    val s1Y = 107.0f
    val s2X = -606.0f
    val s2Y = 401.0f
    val s3X = -883.084f
    val s3Y = 671.0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag)
        //        iv = findViewById(R.id.ballImage);
        container = findViewById(R.id.container)
        videoView = findViewById<View>(R.id.VideoView) as VideoView
        shape1 = findViewById(R.id.shape1)
        shape2 = findViewById(R.id.shape2)
        shape3 = findViewById(R.id.shape3)

        shape1!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                Math.pow(view.width.toDouble(), 2.0) + Math.pow(
                    view.height.toDouble(),
                    2.0
                )
            ) / 10
            checkAction(tolerance, event, view, shape1X, shape1Y, "Sh1")
        })
        shape2!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                Math.pow(view.width.toDouble(), 2.0) + Math.pow(
                    view.height.toDouble(),
                    2.0
                )
            ) / 10
            checkAction(tolerance, event, view, shape2X, shape2Y, "Sh2")
        })
        shape3!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                Math.pow(view.width.toDouble(), 2.0) + Math.pow(
                    view.height.toDouble(),
                    2.0
                )
            ) / 10
            checkAction(tolerance, event, view, shape3X, shape3Y, "Sh3")
        })
        /* shape2.setOnTouchListener(this);
        shape3.setOnTouchListener(this);*/
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
        path = "android.resource://" + packageName + "/" + R.raw.sampel1
        playVideo(path, false)

        /*runnable = Runnable {
            positionImage()
            handler.postDelayed(runnable!!, 2000)
        }*/

        /*   iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = "android.resource://" + getPackageName() + "/" + R.raw.success_touch_ball;

                handler.removeCallbacks(runnable);

                playVideo(path, true);
            }
        });*/
        /*  container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path = "android.resource://" + getPackageName() + "/" + R.raw.faild_touch_ball;

                handler.removeCallbacks(runnable);

                playVideo(path, false);
            }
        });*/
    }

    private fun checkAction(
        tolerance: Double,
        event: MotionEvent,
        view: View,
        shapeX: Float,
        shapeY: Float,
        shape: String,
    ): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
                dY = view.y - event.rawY
            }
            MotionEvent.ACTION_MOVE -> view.animate()
                .x(event.rawX + dX)
                .y(event.rawY + dY)
                .setDuration(0)
                .start()
            MotionEvent.ACTION_UP -> {
                Log.d(
                    TAG,
                    "onCreate:ACTION_UP ${event.rawX}, ${event.rawY} // ${shape1!!.x} ${shape1!!.y} // ${shape2!!.x} ${shape2!!.y}" +
                            " // ${shape3!!.x} ${shape3!!.y}"
                )
                val xDiff = StrictMath.abs(shapeX - event.rawX)
                val yDiff = StrictMath.abs(shapeY - event.rawY)
                if (xDiff <= tolerance && yDiff <= tolerance) {
                    Log.d(TAG, "onCreate: YESSSS ${shapeX} ${shapeY} ${shape1!!.x} ${shape1!!.y}")
                    when (shape) {
                        "Sh1" -> {
                            shape1!!.animate().x(s1X).y(s1Y).duration = 200
                            isShape1 = true
                        }
                        "Sh2" -> {
                            shape2!!.animate().x(s2X).y(s2Y).duration = 200
                            isShape2 = true
                        }
                        else -> {
                            shape3!!.animate().x(s3X).y(s3Y).duration = 200
                            isShape3 = true
                        }
                    }
                    checkFinished()
                } else {
                    when (shape) {
                        "Sh1" -> isShape1 = false
                        "Sh2" -> isShape2 = false
                        else -> isShape3 = false
                    }
                }
            }
            else -> return false
        }
        return true
    }

    private fun checkFinished() {
        if (isShape1 && isShape2 && isShape3) {

            path = "android.resource://" + getPackageName() + "/" + R.raw.sampel2;
//            handler.removeCallbacks(runnable!!);
            shape1!!.visibility = View.GONE
            shape2!!.visibility = View.GONE
            shape3!!.visibility = View.GONE
            playVideo(path, true);
        }
    }

    fun playVideo(path: String?, isSuccess: Boolean) {
        videoView!!.visibility = View.VISIBLE
        container!!.visibility = View.INVISIBLE
        videoView!!.setVideoURI(Uri.parse(path))
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            if (!isSuccess) {
                videoView!!.visibility = View.INVISIBLE
                container!!.visibility = View.VISIBLE
//                handler.post(runnable!!)
                shape1!!.visibility = View.VISIBLE
                shape2!!.visibility = View.VISIBLE
                shape3!!.visibility = View.VISIBLE
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

        /*  iv.setX(randX);
        iv.setY(randY);*/
    }

    fun getRandomPositionX(deviceTotalWidth: Float): Float {
        val random = Random()
        return random.nextInt(deviceTotalWidth.toInt() - imageSizeinPixels.toInt()).toFloat()
    }

    fun getRandomPositionY(DeviceTotalHeight: Float): Float {
        val random = Random()
        return random.nextInt(DeviceTotalHeight.toInt() - imageSizeinPixels.toInt()).toFloat()
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

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
                dY = view.y - event.rawY
            }
            MotionEvent.ACTION_MOVE -> view.animate()
                .x(event.rawX + dX)
                .y(event.rawY + dY)
                .setDuration(0)
                .start()
            else -> return false
        }
        return true
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}