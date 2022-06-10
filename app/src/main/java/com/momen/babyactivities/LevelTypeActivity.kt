package com.momen.babyactivities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display.*
import kotlinx.android.synthetic.main.activity_display.backBtn
import kotlinx.android.synthetic.main.activity_display.exitBtn
import kotlinx.android.synthetic.main.activity_level_type.*

class LevelTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_type)
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val lvl = intent.getIntExtra("lvl", 1)
        val level = if (lvl == 1) "المرحلة الأولى\nالتدريب على المهارات المهيئة للانتباه المشترك"
        else if (lvl == 2) "المرحلة الثانية\nالتدريب على الاستجابة للانتباه المشترك"
        else "المرحلة الثالثة\nالتدريب على المبادأة بالانتباه المشترك"

        levelTv.text = level.trim()
        backBtn.setOnClickListener { onBackPressed() }
        exitBtn.setOnClickListener { this.finishAffinity() }

        goals.setOnClickListener {  startActivity(Intent(this, DisplayActivity::class.java).putExtra("index", lvl+1)) }
        activities.setOnClickListener {
            startActivity(Intent(this, ActivitiesActivity::class.java).putExtra("lvl", lvl))
        }
    }
}