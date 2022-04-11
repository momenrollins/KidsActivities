package com.momen.babyactivities

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drag.*
import kotlin.math.pow
import kotlin.math.sqrt

class DragActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    //    var videoView: VideoView? = null
    var path: String? = null
    var dX = 0f
    var dY = 0f
    var isShape1 = false
    var isShape2 = false
    var isShape3 = false
    var isShape4 = false
    var isShape5 = false
    var isShape6 = false
    var isShape7 = false
    var isShape8 = false
    var isShape9 = false

    val shape1X = 884.0f
    val shape1Y = 332.0f
    val shape2X = 577.0f
    val shape2Y = 597.0f
    val shape3X = 265.0f
    val shape3Y = 807.0f

    val shape01X = 1537.0f
    val shape01Y = 561.0f
    val shape02X = 961.0f
    val shape02Y = 570.0f
    val shape03X = 1307.0f
    val shape03Y = 337.0f
    val shape04X = 1295.0f
    val shape04Y = 834.0f
    val shape05X = 1265.0f
    val shape05Y = 665.0f

    val shape001X = 1333.0f
    val shape001Y = 524.0f
    val shape002X = 1728.0f
    val shape002Y = 355.0f
    val shape003X = 874.0f
    val shape003Y = 525.0f
    val shape004X = 1092.0f
    val shape004Y = 718.0f
    val shape005X = 1468.0f
    val shape005Y = 432.0f
    val shape006X = 1444.0f
    val shape006Y = 594.0f
    val shape007X = 1137.0f
    val shape007Y = 373.0f

    val shape0001X = 1151.0f
    val shape0001Y = 506.0f
    val shape0002X = 1280.0f
    val shape0002Y = 419.0f
    val shape0003X = 1025.0f
    val shape0003Y = 499.0f
    val shape0004X = 1085.0f
    val shape0004Y = 790.0f
    val shape0005X = 1532.0f
    val shape0005Y = 785.0f
    val shape0006X = 865.0f
    val shape0006Y = 534.0f
    val shape0007X = 1274.0f
    val shape0007Y = 860.0f
    val shape0008X = 1656.0f
    val shape0008Y = 583.0f
    val shape0009X = 1451.0f
    val shape0009Y = 335.0f

    val shape00001X = 1561.0f
    val shape00001Y = 425.0f
    val shape00002X = 1227.0f
    val shape00002Y = 590.0f
    val shape00003X = 1329.0f
    val shape00003Y = 859.0f
    val shape00004X = 1060.0f
    val shape00004Y = 725.0f

    val shape000001X = 1695.0f
    val shape000001Y = 655.0f
    val shape000002X = 1429.0f
    val shape000002Y = 359.0f
    val shape000003X = 1211.0f
    val shape000003Y = 340.0f
    val shape000004X = 1349.0f
    val shape000004Y = 670.0f
    val shape000005X = 959.0f
    val shape000005Y = 366.0f
    val shape000006X = 931.0f
    val shape000006Y = 740.0f

    val shape0000001X = 1567.0f
    val shape0000001Y = 234.0f
    val shape0000002X = 1348.0f
    val shape0000002Y = 603.0f
    val shape0000003X = 1367.0f
    val shape0000003Y = 336.0f
    val shape0000004X = 1256.0f
    val shape0000004Y = 878.0f
    val shape0000005X = 1264.0f
    val shape0000005Y = 705.0f
    val shape0000006X = 931.0f
    val shape0000006Y = 740.0f
    val shape0000007X = 931.0f
    val shape0000007Y = 740.0f
    val shape0000008X = 1048.0f
    val shape0000008Y = 870.0f

    val s1X = -395.0f
    val s1Y = 107.0f
    val s2X = -606.0f
    val s2Y = 401.0f
    val s3X = -883.084f
    val s3Y = 671.0f

    val s01X = 1289.0f
    val s01Y = 294.0f
    val s02X = 711.0f
    val s02Y = 338.0f
    val s03X = 997.0f
    val s03Y = 111.0f
    val s04X = 1016.0f
    val s04Y = 585.0f
    val s05X = 1009.0f
    val s05Y = 401.0f

    val s001X = 1000.0f
    val s001Y = 309.0f
    val s002X = 1424.0f
    val s002Y = 178.0f
    val s003X = 611.0f
    val s003Y = 323.0f
    val s004X = 822.0f
    val s004Y = 534.0f
    val s005X = 1227.0f
    val s005Y = 152.0f
    val s006X = 1158.0f
    val s006Y = 472.0f
    val s007X = 846.0f
    val s007Y = 142.0f

    val s0001X = 1033.0f
    val s0001Y = 367.0f
    val s0002X = 1039.0f
    val s0002Y = 132.0f
    val s0003X = 813.0f
    val s0003Y = 237.0f
    val s0004X = 860.0f
    val s0004Y = 574.0f
    val s0005X = 1301.0f
    val s0005Y = 535.0f
    val s0006X = 719.0f
    val s0006Y = 412.0f
    val s0007X = 1089.0f
    val s0007Y = 613.0f
    val s0008X = 1382.0f
    val s0008Y = 351.0f
    val s0009X = 1274.0f
    val s0009Y = 191.0f

    val s00001X = 1221.0f
    val s00001Y = 132.0f
    val s00002X = 888.0f
    val s00002Y = 213.0f
    val s00003X = 1083.0f
    val s00003Y = 434.0f
    val s00004X = 707.0f
    val s00004Y = 346.0f

    val s000001X = 1268.0f
    val s000001Y = 252.0f
    val s000002X = 1180.0f
    val s000002Y = 127.0f
    val s000003X = 883.5f
    val s000003Y = 147.5f
    val s000004X = 1112.0f
    val s000004Y = 443.0f
    val s000005X = 639.0f
    val s000005Y = 160.0f
    val s000006X = 657.0f
    val s000006Y = 494.0f

    val s0000001X = 1270.0f
    val s0000001Y = -65.0f
    val s0000002X = 1043.0f
    val s0000002Y = 271.0f
    val s0000003X = 1113.5f
    val s0000003Y = 76.5f
    val s0000004X = 1031.0f
    val s0000004Y = 689.0f
    val s0000005X = 966.0f
    val s0000005Y = 364.0f
    val s0000006X = 672.0f
    val s0000006Y = 453.0f
    val s0000007X = 814.0f
    val s0000007Y = 384.0f
    val s0000008X = 837.0f
    val s0000008Y = 683.0f


    val oldX1 = 0.0f
    val oldY1 = 0.0f
    val oldX2 = 0.0f
    val oldY2 = 0.0f
    val oldX3 = 0.0f
    val oldY3 = 0.0f
    val oldX4 = 0.0f
    val oldY4 = 0.0f
    val oldX5 = 0.0f
    val oldY5 = 0.0f
    val oldX6 = 0.0f
    val oldY6 = 0.0f
    val oldX7 = 0.0f
    val oldY7 = 0.0f
    val oldX8 = 0.0f
    val oldY8 = 0.0f
    val oldX9 = 0.0f
    val oldY9 = 0.0f

    var index = 0


    var startList = intArrayOf(
        R.raw.sampel1,
        R.raw.transports1,
        R.raw.clothes1,
        R.raw.fruit1,
        R.raw.horse1,
        R.raw.eleph1,
        R.raw.grif1,
    )
    var failedList = intArrayOf(
        R.raw.sampel2,
        R.raw.transports2,
        R.raw.clothes2,
        R.raw.fruit2,
        R.raw.horse2,
        R.raw.eleph2,
        R.raw.grif2,
    )
    var count = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag)
        index = intent.getIntExtra("actvtyNum", 0) - 27

        backBtn.setOnClickListener {
            if (index == 0)
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .putExtra("actvtyNum", 26)
                )
            else startActivity(
                Intent(this, DragActivity::class.java)
                    .putExtra("actvtyNum", --index + 27)
            )
            finish()
        }
        replayBtn.setOnClickListener {
            startActivity(
                Intent(this, DragActivity::class.java)
                    .putExtra("actvtyNum", index + 27)
            )
            finish()
        }
        nextBtn.setOnClickListener {
            if (index == 6)
                startActivity(
                    Intent(this, MovingActivity::class.java)
                        .putExtra("actvtyNum", 34)
                )
            else startActivity(
                Intent(this, DragActivity::class.java)
                    .putExtra("actvtyNum", ++index + 27)
            )
            finish()
        }
        var isShape = false
        shape1!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.1) + view.height.toDouble().pow(2.1)
            ) / 10
            checkAction(tolerance, event, view, shape1X, shape1Y, "Sh1", isShape1)
        })
        shape2!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.1) + view.height.toDouble().pow(2.1)
            ) / 10
            checkAction(tolerance, event, view, shape2X, shape2Y, "Sh2", isShape2)
        })
        shape3!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                view.width.toDouble().pow(2.1) + view.height.toDouble().pow(2.1)
            ) / 10
            checkAction(tolerance, event, view, shape3X, shape3Y, "Sh3", isShape3)
        })
        shape01!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape01X, shape01Y, "Sh01", isShape)
        })
        shape02!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape02X, shape02Y, "Sh02", isShape)
        })
        shape03!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape03X, shape03Y, "Sh03", isShape)
        })
        shape04!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape04X, shape04Y, "Sh04", isShape)
        })
        shape05!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = Math.sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape05X, shape05Y, "Sh05", isShape)
        })

        shape001!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape001X, shape001Y, "Sh001", isShape)
        })
        shape002!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape002X, shape002Y, "Sh002", isShape)
        })
        shape003!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape003X, shape003Y, "Sh003", isShape)
        })
        shape004!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape004X, shape004Y, "Sh004", isShape)
        })
        shape005!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape005X, shape005Y, "Sh005", isShape)
        })
        shape006!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape006X, shape006Y, "Sh006", isShape)
        })
        shape007!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape007X, shape007Y, "Sh007", isShape)
        })

        shape0001!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0001X, shape0001Y, "Sh0001", isShape)
        })
        shape0002!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0002X, shape0002Y, "Sh0002", isShape)
        })
        shape0003!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0003X, shape0003Y, "Sh0003", isShape)
        })
        shape0004!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0004X, shape0004Y, "Sh0004", isShape)
        })
        shape0005!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0005X, shape0005Y, "Sh0005", isShape)
        })
        shape0006!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0006X, shape0006Y, "Sh0006", isShape)
        })
        shape0007.setOnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0007X, shape0007Y, "Sh0007", isShape)
        }
        shape0008!!.setOnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0008X, shape0008Y, "Sh0008", isShape)
        }
        shape0009!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0009X, shape0009Y, "Sh0009", isShape)
        })
        shape00001!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape00001X, shape00001Y, "Sh00001", isShape)
        })

        shape00002!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape00002X, shape00002Y, "Sh00002", isShape)
        })

        shape00003!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape00003X, shape00003Y, "Sh00003", isShape)
        })

        shape00004!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape00004X, shape00004Y, "Sh00004", isShape)
        })

        shape000001!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape000001X, shape000001Y, "Sh000001", isShape)
        })

        shape000002!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape000002X, shape000002Y, "Sh000002", isShape)
        })

        shape000003!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape000003X, shape000003Y, "Sh000003", isShape)
        })

        shape000004!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape000004X, shape000004Y, "Sh000004", isShape)
        })

        shape000005!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape000005X, shape000005Y, "Sh000005", isShape)
        })

        shape000006!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape000006X, shape000006Y, "Sh000006", isShape)
        })

        shape0000001!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000001X, shape0000001Y, "Sh0000001", isShape)
        })
        shape0000002!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000002X, shape0000002Y, "Sh0000002", isShape)
        })
        shape0000003!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000003X, shape0000003Y, "Sh0000003", isShape)
        })
        shape0000004!!.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000004X, shape0000004Y, "Sh0000004", isShape)
        })
        shape0000005.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000005X, shape0000005Y, "Sh0000005", isShape)
        })
        shape0000006.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000006X, shape0000006Y, "Sh0000006", isShape)
        })
        shape0000007.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000007X, shape0000007Y, "Sh0000007", isShape)
        })
        shape0000008.setOnTouchListener(OnTouchListener { view, event ->
            val tolerance = sqrt(
                view.width.toDouble().pow(2.5) + view.height.toDouble().pow(2.5)
            ) / 10
            checkAction(tolerance, event, view, shape0000008X, shape0000008Y, "Sh0000008", isShape)
        })
        startLevel(index)
    }

    private fun startLevel(index: Int) {
//        options.visibility = GONE
        path = "android.resource://" + packageName + "/" + startList[index]
        playVideo(path, false)
    }

    private fun checkAction(
        tolerance: Double,
        event: MotionEvent,
        view: View,
        shapeX: Float,
        shapeY: Float,
        shape: String,
        stop: Boolean,
    ): Boolean {
        if (stop)
            return false
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
                    TAG, "onCreate: SHAPE ${event.rawX} ${event.rawY} == " +
                            "    ${shape0000001.x} ${shape0000001.y} // ${shape0000002.x} ${shape0000002.y}" +
                            " // ${shape0000003.x} ${shape0000003.y} // ${shape0000004.x} ${shape0000004.y}" +
                            " // ${shape0000005.x} ${shape0000005.y} // ${shape0000006.x} ${shape0000006.y}" +
                            " // ${shape0000007.x} ${shape0000007.y} // ${shape0000008.x} ${shape0000008.y}"
                )

                val xDiff = StrictMath.abs(shapeX - event.rawX)
                val yDiff = StrictMath.abs(shapeY - event.rawY)
                if (xDiff <= tolerance && yDiff <= tolerance) {
                    if (index == 0) {
                        when (shape) {
                            "Sh1" -> {
                                shape1!!.animate().x(s1X).y(s1Y).duration = 150
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                isShape1 = true
                            }
                            "Sh2" -> {
                                shape2!!.animate().x(s2X).y(s2Y).duration = 150
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                isShape2 = true
                            }
                            else -> {
                                shape3!!.animate().x(s3X).y(s3Y).duration = 150
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                isShape3 = true
                            }
                        }
                        checkFinished()
                    } else if (index == 1) {
                        when (shape) {
                            "Sh01" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape01!!.animate().x(s01X).y(s01Y).duration = 150
                                isShape1 = true
                            }
                            "Sh02" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape02!!.animate().x(s02X).y(s02Y).duration = 150
                                isShape2 = true
                            }
                            "Sh03" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape03!!.animate().x(s03X).y(s03Y).duration = 150
                                isShape3 = true
                            }
                            "Sh04" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape04!!.animate().x(s04X).y(s04Y).duration = 150
                                isShape4 = true
                            }
                            else -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape05!!.animate().x(s05X).y(s05Y).duration = 150
                                isShape5 = true
                            }
                        }
                        checkFinished2()
                    } else if (index == 2) {
                        when (shape) {
                            "Sh001" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape001!!.animate().x(s001X).y(s001Y).duration = 150
                                isShape1 = true
                            }
                            "Sh002" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape002!!.animate().x(s002X).y(s002Y).duration = 150
                                isShape2 = true
                            }
                            "Sh003" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape003!!.animate().x(s003X).y(s003Y).duration = 150
                                isShape3 = true
                            }
                            "Sh004" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape004!!.animate().x(s004X).y(s004Y).duration = 150
                                isShape4 = true
                            }
                            "Sh005" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape005!!.animate().x(s005X).y(s005Y).duration = 150
                                isShape5 = true
                            }
                            "Sh006" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape006!!.animate().x(s006X).y(s006Y).duration = 150
                                isShape6 = true
                            }
                            else -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape007!!.animate().x(s007X).y(s007Y).duration = 150
                                isShape7 = true
                            }
                        }
                        checkFinished3()
                    } else if (index == 3) {
                        when (shape) {
                            "Sh0001" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0001!!.animate().x(s0001X).y(s0001Y).duration = 150
                                isShape1 = true
                            }
                            "Sh0002" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0002!!.animate().x(s0002X).y(s0002Y).duration = 150
                                isShape2 = true
                            }
                            "Sh0003" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0003!!.animate().x(s0003X).y(s0003Y).duration = 150
                                isShape3 = true
                            }
                            "Sh0004" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0004!!.animate().x(s0004X).y(s0004Y).duration = 150
                                isShape4 = true
                            }
                            "Sh0005" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0005!!.animate().x(s0005X).y(s0005Y).duration = 150
                                isShape5 = true
                            }
                            "Sh0006" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0006!!.animate().x(s0006X).y(s0006Y).duration = 150
                                isShape6 = true
                            }
                            "Sh0007" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0007!!.animate().x(s0007X).y(s0007Y).duration = 150
                                isShape7 = true
                            }
                            "Sh0008" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0008!!.animate().x(s0008X).y(s0008Y).duration = 150
                                isShape8 = true
                            }
                            else -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0009!!.animate().x(s0009X).y(s0009Y).duration = 150
                                isShape9 = true
                            }
                        }
                        checkFinished4()
                    } else if (index == 4) {
                        when (shape) {
                            "Sh00001" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape00001!!.animate().x(s00001X).y(s00001Y).duration = 150
                                isShape1 = true
                            }
                            "Sh00002" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape00002!!.animate().x(s00002X).y(s00002Y).duration = 150
                                isShape2 = true
                            }
                            "Sh00003" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape00003!!.animate().x(s00003X).y(s00003Y).duration = 150
                                isShape3 = true
                            }
                            else -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape00004!!.animate().x(s00004X).y(s00004Y).duration = 150
                                isShape4 = true
                            }
                        }
                        checkFinished5()
                    } else if (index == 5) {
                        when (shape) {
                            "Sh000001" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape000001!!.animate().x(s000001X).y(s000001Y).duration = 150
                                isShape1 = true
                            }
                            "Sh000002" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape000002!!.animate().x(s000002X).y(s000002Y).duration = 150
                                isShape2 = true
                            }
                            "Sh000003" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape000003!!.animate().x(s000003X).y(s000003Y).duration = 150
                                isShape3 = true
                            }
                            "Sh000004" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape000004!!.animate().x(s000004X).y(s000004Y).duration = 150
                                isShape4 = true
                            }
                            "Sh000005" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape000005!!.animate().x(s000005X).y(s000005Y).duration = 150
                                isShape5 = true
                            }
                            else -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape000006!!.animate().x(s000006X).y(s000006Y).duration = 150
                                isShape6 = true
                            }
                        }
                        checkFinished6()
                    } else {
                        when (shape) {
                            "Sh0000001" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000001!!.animate().x(s0000001X).y(s0000001Y).duration = 150
                                isShape1 = true
                            }
                            "Sh0000002" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000002!!.animate().x(s0000002X).y(s0000002Y).duration = 150
                                isShape2 = true
                            }
                            "Sh0000003" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000003!!.animate().x(s0000003X).y(s0000003Y).duration = 150
                                isShape3 = true
                            }
                            "Sh0000004" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000004!!.animate().x(s0000004X).y(s0000004Y).duration = 150
                                isShape4 = true
                            }
                            "Sh0000005" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000005!!.animate().x(s0000005X).y(s0000005Y).duration = 150
                                isShape5 = true
                            }
                            "Sh0000006" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000006!!.animate().x(s0000006X).y(s0000006Y).duration = 150
                                isShape6 = true
                            }
                            "Sh0000007" -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000007!!.animate().x(s0000007X).y(s0000007Y).duration = 150
                                isShape7 = true
                            }
                            else -> {
                                count++
                                if (count < 3) MediaPlayer.create(this, R.raw.shater).start()
                                shape0000008!!.animate().x(s0000008X).y(s0000008Y).duration = 150
                                isShape8 = true
                            }
                        }
                        checkFinished7()
                    }
                } else {
                    MediaPlayer.create(this, R.raw.faild).start()
                    if (index == 0) {
                        when (shape) {
                            "Sh1" -> isShape1 = false
                            "Sh2" -> isShape2 = false
                            else -> isShape3 = false
                        }
                    } else if (index == 1) {
                        when (shape) {
                            "Sh01" -> isShape1 = false
                            "Sh02" -> isShape2 = false
                            "Sh03" -> isShape3 = false
                            "Sh04" -> isShape4 = false
                            else -> isShape5 = false
                        }
                    } else if (index == 2) {
                        when (shape) {
                            "Sh001" -> isShape1 = false
                            "Sh002" -> isShape2 = false
                            "Sh003" -> isShape3 = false
                            "Sh004" -> isShape4 = false
                            "Sh005" -> isShape5 = false
                            "Sh006" -> isShape6 = false
                            else -> isShape7 = false
                        }
                    } else if (index == 3) {
                        when (shape) {
                            "Sh0001" -> isShape1 = false
                            "Sh0002" -> isShape2 = false
                            "Sh0003" -> isShape3 = false
                            "Sh0004" -> isShape4 = false
                            "Sh0005" -> isShape5 = false
                            "Sh0006" -> isShape6 = false
                            "Sh0007" -> isShape7 = false
                            "Sh0008" -> isShape8 = false
                            else -> isShape9 = false
                        }
                    } else if (index == 4) {
                        when (shape) {
                            "Sh00001" -> isShape1 = false
                            "Sh00002" -> isShape2 = false
                            "Sh00003" -> isShape3 = false
                            else -> isShape4 = false
                        }
                    } else if (index == 5) {
                        when (shape) {
                            "Sh000001" -> isShape1 = false
                            "Sh000002" -> isShape2 = false
                            "Sh000003" -> isShape3 = false
                            "Sh000004" -> isShape4 = false
                            "Sh000005" -> isShape5 = false
                            else -> isShape6 = false
                        }
                    } else {
                        when (shape) {
                            "Sh0000001" -> isShape1 = false
                            "Sh0000002" -> isShape2 = false
                            "Sh0000003" -> isShape3 = false
                            "Sh0000004" -> isShape4 = false
                            "Sh0000005" -> isShape5 = false
                            "Sh0000006" -> isShape6 = false
                            "Sh0000007" -> isShape7 = false
                            else -> isShape8 = false
                        }
                    }
                }
            }
            else -> return false
        }
        return true
    }

    private fun checkFinished() {
        if (isShape1 && isShape2 && isShape3) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape1!!.visibility = GONE
            shape2!!.visibility = GONE
            shape3!!.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun checkFinished2() {
        if (isShape1 && isShape2 && isShape3 && isShape4 && isShape5) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape01!!.visibility = GONE
            shape02!!.visibility = GONE
            shape03!!.visibility = GONE
            shape04!!.visibility = GONE
            shape05!!.visibility = GONE
            shape01s.visibility = GONE
            shape02s.visibility = GONE
            shape03s.visibility = GONE
            shape04s.visibility = GONE
            shape05s.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun checkFinished3() {
        Log.d(
            TAG,
            "checkFinished3: $isShape1 - $isShape2 - $isShape3 - $isShape4 - $isShape5 - $isShape6 - $isShape7"
        )
        if (isShape1 && isShape2 && isShape3 && isShape4 && isShape5 && isShape6 && isShape7) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape001!!.visibility = GONE
            shape002!!.visibility = GONE
            shape003!!.visibility = GONE
            shape004!!.visibility = GONE
            shape005.visibility = GONE
            shape006.visibility = GONE
            shape007.visibility = GONE
            shape001s.visibility = GONE
            shape002s.visibility = GONE
            shape003s.visibility = GONE
            shape004s.visibility = GONE
            shape005s.visibility = GONE
            shape006s.visibility = GONE
            shape007s.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun checkFinished4() {
        Log.d(
            TAG,
            "checkFinished3: $isShape1 - $isShape2 - $isShape3 - $isShape4 - $isShape5 - $isShape6 - $isShape7"
        )
        if (isShape1 && isShape2 && isShape3 && isShape4 && isShape5 && isShape6 && isShape7 && isShape8 && isShape9) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape0001!!.visibility = GONE
            shape0002!!.visibility = GONE
            shape0003!!.visibility = GONE
            shape0004!!.visibility = GONE
            shape0005.visibility = GONE
            shape0006.visibility = GONE
            shape0007.visibility = GONE
            shape0008.visibility = GONE
            shape0009.visibility = GONE
            shape0001s.visibility = GONE
            shape0002s.visibility = GONE
            shape0003s.visibility = GONE
            shape0004s.visibility = GONE
            shape0005s.visibility = GONE
            shape0006s.visibility = GONE
            shape0007s.visibility = GONE
            shape0008s.visibility = GONE
            shape0009s.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun checkFinished5() {
        Log.d(
            TAG,
            "checkFinished3: $isShape1 - $isShape2 - $isShape3 - $isShape4"
        )
        if (isShape1 && isShape2 && isShape3 && isShape4) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape00001.visibility = GONE
            shape00002.visibility = GONE
            shape00003.visibility = GONE
            shape00004.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun checkFinished6() {
        Log.d(
            TAG,
            "checkFinished3: $isShape1 - $isShape2 - $isShape3 - $isShape4 - $isShape5 - $isShape6"
        )
        if (isShape1 && isShape2 && isShape3 && isShape4 && isShape5 && isShape6) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape000001.visibility = GONE
            shape000002.visibility = GONE
            shape000003.visibility = GONE
            shape000004.visibility = GONE
            shape000005.visibility = GONE
            shape000006.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun checkFinished7() {
        Log.d(
            TAG,
            "checkFinished3: $isShape1 - $isShape2 - $isShape3 - $isShape4 - $isShape5 - $isShape6"
        )
        if (isShape1 && isShape2 && isShape3 && isShape4 && isShape5 && isShape6 && isShape7 && isShape8) {

            path = "android.resource://" + getPackageName() + "/" + failedList[index];
//            handler.removeCallbacks(runnable!!);
            shape0000001.visibility = GONE
            shape0000002.visibility = GONE
            shape0000003.visibility = GONE
            shape0000004.visibility = GONE
            shape0000005.visibility = GONE
            shape0000006.visibility = GONE
            shape0000007.visibility = GONE
            shape0000008.visibility = GONE
            playVideo(path, true);
        }
    }

    private fun playVideo(path: String?, isSuccess: Boolean) {
        videoView!!.visibility = VISIBLE
        container!!.visibility = INVISIBLE
        imgBack!!.visibility = INVISIBLE
        videoView!!.setVideoURI(Uri.parse(path))

        videoView!!.start()
        videoView!!.setOnCompletionListener {
            if (!isSuccess) {
                videoView!!.visibility = INVISIBLE
                if (index == 0) {
                    container!!.visibility = VISIBLE
                    shape1!!.visibility = VISIBLE
                    shape2!!.visibility = VISIBLE
                    shape3!!.visibility = VISIBLE
                } else if (index == 1) {
                    imgBack.visibility = VISIBLE
                    shape01.visibility = VISIBLE
                    shape02.visibility = VISIBLE
                    shape03.visibility = VISIBLE
                    shape04.visibility = VISIBLE
                    shape05.visibility = VISIBLE
                    shape01s.visibility = VISIBLE
                    shape02s.visibility = VISIBLE
                    shape03s.visibility = VISIBLE
                    shape04s.visibility = VISIBLE
                    shape05s.visibility = VISIBLE
                    shape01s.animate().x(s01X).y(s01Y).duration = 1
                    shape02s.animate().x(s02X).y(s02Y).duration = 1
                    shape03s.animate().x(s03X).y(s03Y).duration = 1
                    shape04s.animate().x(s04X).y(s04Y).duration = 1
                    shape05s.animate().x(s05X).y(s05Y).duration = 1

                } else if (index == 2) {
                    imgBack.setImageResource(R.drawable.clothes_back)
                    imgBack.visibility = VISIBLE
                    shape001.visibility = VISIBLE
                    shape002.visibility = VISIBLE
                    shape003.visibility = VISIBLE
                    shape004.visibility = VISIBLE
                    shape005.visibility = VISIBLE
                    shape006.visibility = VISIBLE
                    shape007.visibility = VISIBLE
                    shape001s.visibility = VISIBLE
                    shape002s.visibility = VISIBLE
                    shape003s.visibility = VISIBLE
                    shape004s.visibility = VISIBLE
                    shape005s.visibility = VISIBLE
                    shape006s.visibility = VISIBLE
                    shape007s.visibility = VISIBLE
                    shape001s!!.animate().x(s001X).y(s001Y).duration = 1
                    shape002s!!.animate().x(s002X).y(s002Y).duration = 1
                    shape003s!!.animate().x(s003X).y(s003Y).duration = 1
                    shape004s!!.animate().x(s004X).y(s004Y).duration = 1
                    shape005s!!.animate().x(s005X).y(s005Y).duration = 1
                    shape006s!!.animate().x(s006X).y(s006Y).duration = 1
                    shape007s!!.animate().x(s007X).y(s007Y).duration = 1
                } else if (index == 3) {
                    imgBack.setImageResource(R.drawable.fruit_board)
                    imgBack.visibility = VISIBLE
                    shape0001.visibility = VISIBLE
                    shape0002.visibility = VISIBLE
                    shape0003.visibility = VISIBLE
                    shape0004.visibility = VISIBLE
                    shape0005.visibility = VISIBLE
                    shape0006.visibility = VISIBLE
                    shape0007.visibility = VISIBLE
                    shape0008.visibility = VISIBLE
                    shape0009.visibility = VISIBLE
                    shape0001s.visibility = VISIBLE
                    shape0002s.visibility = VISIBLE
                    shape0003s.visibility = VISIBLE
                    shape0004s.visibility = VISIBLE
                    shape0005s.visibility = VISIBLE
                    shape0006s.visibility = VISIBLE
                    shape0007s.visibility = VISIBLE
                    shape0008s.visibility = VISIBLE
                    shape0009s.visibility = VISIBLE
                    shape0001s.animate().x(s0001X).y(s0001Y).duration = 1
                    shape0002s.animate().x(s0002X).y(s0002Y).duration = 1
                    shape0003s.animate().x(s0003X).y(s0003Y).duration = 1
                    shape0004s.animate().x(s0004X).y(s0004Y).duration = 1
                    shape0005s.animate().x(s0005X).y(s0005Y).duration = 1
                    shape0006s.animate().x(s0006X).y(s0006Y).duration = 1
                    shape0007s.animate().x(s0007X).y(s0007Y).duration = 1
                    shape0008s.animate().x(s0008X).y(s0008Y).duration = 1
                    shape0009s.animate().x(s0009X).y(s0009Y).duration = 1

                } else if (index == 4) {
                    imgBack.setImageResource(R.drawable.horse_back)
                    imgBack.visibility = VISIBLE
                    shape00001.visibility = VISIBLE
                    shape00002.visibility = VISIBLE
                    shape00003.visibility = VISIBLE
                    shape00004.visibility = VISIBLE
                } else if (index == 5) {
                    imgBack.setImageResource(R.drawable.eleph_back)
                    imgBack.scaleType = ImageView.ScaleType.CENTER_CROP
                    imgBack.visibility = VISIBLE
                    shape000001.visibility = VISIBLE
                    shape000002.visibility = VISIBLE
                    shape000003.visibility = VISIBLE
                    shape000004.visibility = VISIBLE
                    shape000005.visibility = VISIBLE
                    shape000006.visibility = VISIBLE
                } else {
                    imgBack.setImageResource(R.drawable.grif_back)
                    imgBack.scaleType = ImageView.ScaleType.CENTER_CROP
                    imgBack.visibility = VISIBLE
                    shape0000001.visibility = VISIBLE
                    shape0000002.visibility = VISIBLE
                    shape0000003.visibility = VISIBLE
                    shape0000004.visibility = VISIBLE
                    shape0000005.visibility = VISIBLE
                    shape0000006.visibility = VISIBLE
                    shape0000007.visibility = VISIBLE
                    shape0000008.visibility = VISIBLE
                }
            } else {
                options.visibility = VISIBLE
            }
        }
    }
}