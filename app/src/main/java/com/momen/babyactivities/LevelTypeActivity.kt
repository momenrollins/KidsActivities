package com.momen.babyactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
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

        SHARDStorage.initShaird(this)
        val lvl = intent.getIntExtra("lvl", 1)
        val level = if (lvl == 1) "المرحلة الأولى\nالتدريب على المهارات المهيئة للانتباه المشترك"
        else if (lvl == 2) "المرحلة الثانية\nالتدريب على الاستجابة للانتباه المشترك"
        else "المرحلة الثالثة\nالتدريب على المبادأة بالانتباه المشترك"

        levelTv.text = level
        backBtn.setOnClickListener { onBackPressed() }
        exitBtn.setOnClickListener { this.finishAffinity() }
        if (lvl == 1 || lvl == 2) {
            reportsBtn.visibility = View.VISIBLE
            reportsBtn.setOnClickListener {
                val sb = StringBuilder()
                var result = ""
                if (lvl == 1) {
                    for (i in 0 until 13) {
                        if (SHARDStorage.sharedPreferences.getInt("activity_num$i", 0) != 0) {
                            result = "النشاط رقم${i + 1}: ${
                                SHARDStorage.sharedPreferences.getInt(
                                    "activity_num$i",
                                    0
                                )
                            } "
                        } else result = " النشاط رقم${i + 1}: لا توجد اخطاء "

                        sb.append("$result \n");
                    }
                    if (SHARDStorage.sharedPreferences.getInt("drag_activity_l0", 0) != 0) {
                        result = "النشاط رقم${15}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "drag_activity_l0",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${15}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("moving_activity0", 0) != 0) {
                        result = "النشاط رقم${16}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "moving_activity0",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${16}: لا توجد اخطاء "

                    sb.append("$result \n");
                    if (SHARDStorage.sharedPreferences.getInt("moving_activity1", 0) != 0) {
                        result = "النشاط رقم${17}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "moving_activity1",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${17}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("moving_activity2", 0) != 0) {
                        result = "النشاط رقم${18}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "moving_activity2",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${18}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("color_activity_l", 0) != 0) {
                        result = "النشاط رقم${22}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "color_activity_l",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${22}: لا توجد اخطاء "

                    sb.append("$result \n");
                    SHARDStorage.AliartResult(this, sb.toString())

                } else {
                    if (SHARDStorage.sharedPreferences.getInt("level1rabbit", 0) != 0) {
                        result = "النشاط رقم${1}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level1rabbit",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${1}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("level0", 0) != 0) {
                        result =
                            "النشاط رقم${2}: ${SHARDStorage.sharedPreferences.getInt("level0", 0)} "
                    } else result = " النشاط رقم${2}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("level46", 0) != 0) {
                        result = "النشاط رقم${3}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level46",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${3}: لا توجد اخطاء "

                    sb.append("$result \n");


                    if (SHARDStorage.sharedPreferences.getInt("level47", 0) != 0) {
                        result = "النشاط رقم${4}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level47",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${4}: لا توجد اخطاء "

                    sb.append("$result \n");


                    if (SHARDStorage.sharedPreferences.getInt("level1", 0) != 0) {
                        result =
                            "النشاط رقم${5}: ${SHARDStorage.sharedPreferences.getInt("level1", 0)} "
                    } else result = " النشاط رقم${5}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("level49", 0) != 0) {
                        result = "النشاط رقم${6}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level49",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${6}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("level50", 0) != 0) {
                        result = "النشاط رقم${7}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level50",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${7}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("level51", 0) != 0) {
                        result = "النشاط رقم${8}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level51",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${8}: لا توجد اخطاء "

                    sb.append("$result \n");

                    if (SHARDStorage.sharedPreferences.getInt("level2", 0) != 0) {
                        result =
                            "النشاط رقم${9}: ${SHARDStorage.sharedPreferences.getInt("level2", 0)} "
                    } else result = " النشاط رقم${9}: لا توجد اخطاء "

                    sb.append("$result \n");


                    if (SHARDStorage.sharedPreferences.getInt("level53", 0) != 0) {
                        result = "النشاط رقم${10}: ${
                            SHARDStorage.sharedPreferences.getInt(
                                "level53",
                                0
                            )
                        } "
                    } else result = " النشاط رقم${10}: لا توجد اخطاء "

                    sb.append("$result \n");


                    SHARDStorage.AliartResult(this, sb.toString())

                }
            }
        }

        goals.setOnClickListener {
            startActivity(
                Intent(this, DisplayActivity::class.java).putExtra(
                    "index",
                    lvl + 1
                )
            )
        }
        activities.setOnClickListener {
            startActivity(Intent(this, ActivitiesActivity::class.java).putExtra("lvl", lvl))
        }
    }
}