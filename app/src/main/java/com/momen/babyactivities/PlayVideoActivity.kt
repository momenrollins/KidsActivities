package com.momen.babyactivities

import android.net.Uri
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_play_video.*

class PlayVideoActivity : AppCompatActivity() {
    var path: String? = null
    var videos = intArrayOf(R.raw.amp, R.raw.jump)
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        index = intent.getIntExtra("actvtyNum", 0)
        path = "android.resource://" + packageName + "/" + videos[index]
        finishBtn.setOnClickListener { super.onBackPressed() }
        videoView.setVideoURI(Uri.parse(path))
        videoView.start()
        videoView.setOnCompletionListener { finishBtn.visibility = VISIBLE }
    }
}