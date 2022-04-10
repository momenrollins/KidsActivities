package com.momen.babyactivities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_play_video.*

class PlayVideoActivity : AppCompatActivity() {
    var path: String? = null
    var videos = intArrayOf(
        R.raw.amp,
        R.raw.jump,
        R.raw.lvl3_1,
        R.raw.lvl3_2,
        R.raw.lvl3_3,
        R.raw.lvl3_4,
        R.raw.lvl3_5,
        R.raw.lvl3_6,
        R.raw.lvl3_7,
        R.raw.lvl3_8,
        R.raw.lvl3_9,
        R.raw.lvl3_10
    )
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        index = intent.getIntExtra("actvtyNum", 0)

        action(index)

        finishBtn.setOnClickListener { super.onBackPressed() }
        backBtn.setOnClickListener {
            if (index == 0) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .putExtra("actvtyNum", 1)
                )
                finish()
            } else if (index == 1) {
                startActivity(
                    Intent(this, CollectSquaresActivity::class.java)
                        .putExtra("actvtyNum", 41)
                )
                finish()
            } else
                action(--index)
        }
        replayBtn.setOnClickListener {
            action(index)
        }
        nextBtn.setOnClickListener {
            if (index == 0) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .putExtra("actvtyNum", 3)
                )
                finish()
            } else
                action(++index)
        }
    }

    private fun action(index: Int) {
        finishBtn.visibility = GONE
        options.visibility = GONE
        nextBtn.visibility = VISIBLE
        backBtn.visibility = VISIBLE

        path = "android.resource://" + packageName + "/" + videos[index]
        videoView.setVideoURI(Uri.parse(path))
        videoView.start()
        videoView.setOnCompletionListener {
            if (index == 2) {
                options.visibility = VISIBLE
                backBtn.visibility = GONE
            } else if (index == videos.lastIndex || index == 1) {
                options.visibility = VISIBLE
                nextBtn.visibility = GONE
            } else options.visibility = VISIBLE
        }
    }
}