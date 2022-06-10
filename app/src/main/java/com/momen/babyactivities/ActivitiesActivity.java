package com.momen.babyactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ActivitiesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MaterialButton backBtn;
    MaterialButton exitBtn;
    RecyclerView.LayoutManager layoutManager;
    ActivitiesAdapter activitiesAdapter;
    int lvl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.activity_recycler);
        backBtn=findViewById(R.id.backBtn);
        exitBtn=findViewById(R.id.exitBtn);
        GridLayoutManager lm = new GridLayoutManager(this, 2) {
            @Override
            protected boolean isLayoutRTL() {
                return true;
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivitiesActivity.this.finishAffinity();
            }
        });
        lvl = getIntent().getIntExtra("lvl", 1);
        ArrayList<String> titles = new ArrayList<>();
        if (lvl == 1)
        titles.addAll(Arrays.asList("( نشاط ١ ) ينتبه الطفل لمثير جاذب للانتباه عندما يعرض عليه. ", "( نشاط ٢ ) ينتبه الطفل لمثير غير جاذب عندما يعرض عليه.", "( نشاط ٣ ) يطابق مجسم بمجسم ( تفاحه ).", "( نشاط ٤ ) يطابق مجسم بمجسم ( تفاحه ) مع مشتت واحد (موزه).", "( نشاط ٥ ) يطابق مجسم بمجسم ( بطه ).", "( نشاط ٦ ) يطابق مجسم بمجسم ( بطه ) مع مشتت واحد (كلب).", "( نشاط ٧ ) يطابق مجسم بصوره ( تفاحه ).", "( نشاط ٨ ) يطابق مجسم بصوره ( تفاحه ) مع مشتت واحد (موزه).", "( نشاط ٩ ) يطابق مجسم بصوره ( بطه ).", "( نشاط ١٠ ) يطابق مجسم بصوره ( بطه ) مع مشتت واحد (كلب).", "( نشاط ١١ ) يطابق صوره بصوره ( تفاحه ).", "( نشاط ١٢ ) يطابق صوره بصوره ( تفاحه ) مع مشتت واحد (موزه).", "( نشاط ١٣ ) يطابق صوره بصوره ( بطه ).", "( نشاط ١٤ ) يطابق صوره بصوره ( بطه ) مع مشتت واحد (كلب).", "( نشاط ١٥ ) يطابق الشكل المعروض أمامه"
                , "( نشاط ١٦ ) يمشي داخل متاهة بسيطة.", "( نشاط ١٧ ) يمشي داخل متاهة متوسطة.", "( نشاط ١٨ ) يمشي داخل متاهة معقدة.", "( نشاط ١٩ ) يصنف مجموعات ضمنيه (حيوانات أليفه – فواكه )", "( نشاط ٢٠ ) يصنف مجموعات ضمنيه (خضروات– اشكال هندسيه) ",
                "( نشاط ٢١ ) يصنف مجموعات ضمنيه ( طيور– وسائل مواصلات )", "( نشاط ٢٢ ) يلون الأشكال بألوان مختلفة (أحمر-أصفر-أزرق)." + "(الدائرة باللون الأحمر، المثلث باللون الأصفر ، المستطيل باللون الأزرق).\n", "( نشاط ٢٣ ) ينفذ أوامر بسيطة عندما يطلب منه ذلك مثل ( حط المكعبات في الصندوق ).\n"
                , "( نشاط ٢٤ ) يقلد حركات كبري مثل رفع الإيد لفوق."));
        else if (lvl == 2) {
            titles.addAll(Arrays.asList("( نشاط ١ ) يتتبع مسار لعبة تتحرك أمام عينيه بشكل أفقي (أرنب متحرك).", "( نشاط ٢ ) يتتبع مثير متحرك بين شخصين ( الكره ).", "( نشاط ٣ ) يتتبع الإشاره التي تصدر من الشخص الآخر مثل الإشارة باليد لأشياء قريبه \n" +
                    "( عربية ، كوره ، مكعبات ).\n", "( نشاط ٤ ) يتتبع الإشاره التي تصدر من الشخص الآخر مثل الإشارة باليد لأشياء بعيده \n" +
                    "( مروحة ، نور ).\n", "( نشاط ٥ ) يتتبع  نظرة الشخص الآخر عندما ينظر إلي لعبه ما يمينا ويسارا \n" +
                    "( شجره تفاح وبرتقال ).\n", "( نشاط ٦ ) يستجيب بالإشاره إلي شيء ما عندما يسأله الشخص الآخر شاور على ( كورة ).", "( نشاط ٧ ) يستجيب بالإشاره إلي شيء ما عندما يسأله الشخص الآخر شاور على ( كورة )  مع مشتتات.", "( نشاط ٨ ) يستجيب بالنظر إلي شيء ما عندما يشير إليه شخص آخر \n" +
                    "( سمكة داخل حوض به ماء ).\n", "( نشاط ٩ ) يبادل الآخرين بالإبتسامة عندما يطلب منه ذلك.", "( نشاط ١٠ ) يناوب النظر بينه وبين الشخص الآخر والمثير عندما يقول له الشخص الآخر \n" +
                    "(أنظر ويشاور علي طائره ، شجره ، عصافير ).\n"));
        } else {
            titles.addAll(Arrays.asList("( نشاط ١ ) يشير لأشياء قريبه منه في مجال الرؤيه بغرض جذب الانتباه \n" +
                            "(الأطفال بتلعب فى الشارع ).\n", "( نشاط ٢ ) يشير لأشياء بعيده عنه من مجال الرؤيه بغرض جذب الإنتباه ( القطار ).", "( نشاط ٣ ) يشير إلى الأشياء التى يحتاج إليها بغرض الطلب ( المرجيحة ).", "( نشاط ٤ ) يتبادل النظر بينه وبين المثير والشخص الآخر عندما يريد جذب انتباه الشخص الآخر لشيء ما ( العصافير فوق الشجرة).",
                    "( نشاط ٥ ) يتبادل النظر بينه وبين الشيء الذى يريده والشخص الآخر عندما يريد شئ ما \n" +
                            "( العربية في محل اللعب ).\n", "( نشاط ٦ ) يبادر بمواساة شخص آخر يبدو عليه مشاعر الحزن.", "( نشاط ٧ ) يشرك الآخرين في إهتماماته كأن يحضر لعبه ويضعها أمام الشخص الآخر كى يلفت انتباهه. ", "( نشاط ٨ ) يبدأ باللعب التبادلى كأن يرمى الكره للشخص الآخر بغرض أن يطلب منه اللعب معه.", "( نشاط ٩ ) يبدأ المصافحه باليد عند دخوله مكان ما.", "( نشاط ١٠ ) يبدأ بالتلويح باى عند مغادرة مكان ما."));
        }
        activitiesAdapter = new ActivitiesAdapter(lvl, titles);
        recyclerView.setAdapter(activitiesAdapter);
        activitiesAdapter.setOnItemClickListener(position ->
        {
            if (lvl == 1) {
                if (position <= 13)
                    startActivity(new Intent(this, MainActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position == 14)
                    startActivity(new Intent(this, DragActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", 0));
                else if (position <= 17)
                    startActivity(new Intent(this, MovingActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position <= 20)
                    startActivity(new Intent(this, TasneefActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position == 21)
                    startActivity(new Intent(this, ColorActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else if (position == 22)
                    startActivity(new Intent(this, CollectSquaresActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", position));
                else
                    startActivity(new Intent(this, PlayVideoActivity.class)
                            .putExtra("lvl", lvl).putExtra("actvtyNum", 0));
            } else if (lvl == 2) {
                if (position == 0) startActivity(new Intent(this, RabbitJump.class));
                else if (position == 1)
                    startActivity(new Intent(this, BoyandGirl_45.class).putExtra("actvtyNum", 0));
                else if (position == 2)
                    startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 46));
                else if (position == 3)
                    startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 47));
                else if (position == 4)
                    startActivity(new Intent(this, BoyandGirl_45.class).putExtra("actvtyNum", 1));
                else if (position == 5)
                    startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 49));
                else if (position == 6)
                    startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 50));
                else if (position == 7)
                    startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 51));
                else if (position == 8)
                    startActivity(new Intent(this, BoyandGirl_45.class).putExtra("actvtyNum", 2));
                else
                    startActivity(new Intent(this, BressBall_L49.class).putExtra("actvtyNum", 53));
            } else {
                startActivity(new Intent(this, PlayVideoActivity.class)
                        .putExtra("lvl", lvl).putExtra("actvtyNum", position + 1));
            }
        });
    }
}