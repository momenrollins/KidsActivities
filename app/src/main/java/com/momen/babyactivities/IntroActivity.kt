package com.momen.babyactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.momen.babyactivities.R
import android.content.Intent
import android.view.View
import android.view.WindowManager
import com.momen.babyactivities.DisplayActivity
import com.momen.babyactivities.ChooseLevelActivity
import kotlinx.android.synthetic.main.activity_intro.*
import kotlin.system.exitProcess

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backBtn.setOnClickListener { onBackPressed() }
        exitBtn.setOnClickListener {this.finishAffinity()}
    }

    fun Goals(view: View?) {
        startActivity(
            Intent(this, DisplayActivity::class.java)
                .putExtra("index", 0)
        )
    }

    fun Info(view: View?) {
        startActivity(
            Intent(this, DisplayActivity::class.java)
                .putExtra("index", 1)
        )
    }

    fun Conponants(view: View?) {
        startActivity(Intent(this, ChooseLevelActivity::class.java))
    }
}