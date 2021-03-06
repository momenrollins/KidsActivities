package com.momen.babyactivities

import androidx.appcompat.app.AppCompatActivity
import com.momen.babyactivities.R
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_display.*
import kotlinx.android.synthetic.main.activity_display.backBtn
import kotlinx.android.synthetic.main.activity_display.exitBtn
import kotlinx.android.synthetic.main.activity_intro.*

class DisplayActivity : AppCompatActivity() {
    var images = intArrayOf(R.drawable.img_intro_1, R.drawable.img_intro_2)
    var titles = arrayListOf<String>(
        "أهداف البرنامج",
        "تعليمات البرنامج",
        "أهداف المرحلة الأولى",
        "أهداف المرحلة الثانية",
        "أهداف المرحلة الثالثة"
    )
    var desc = arrayListOf<String>(
        "يهدف البرنامج بوجه عام إلي تحسين مهارات الانتباه المشترك لدى عينة من الأطفال ذوى اضطراب طيف التوحد حيث تدريب الأطفال علي المهارات الآتية لتحسين مهارة الانتباه المشترك لديهم:\n" +
                "-\tتنمية مهارة الانتباه والتركيز البصري.\n" +
                "-\tتنمية مهارة زياده مدة التركيز البصري ( مدي الانتباه ).\n" +
                "-\tتنميه مهارة المرونه في نقل الانتباه.\n" +
                "-\tتنمية مهارة التتبع البصري (للأشياء-للإشاره بالسبابة من الآخر-لنظرة عين الآخرين).\n" +
                "-\tتنمية مهارة الاستجابة للانتباه المشترك.\n" +
                "-\tتنمية مهارة المبادأه بالانتباه المشترك.\n",
        "لكى تسير في البرنامج ما عليك إلا أن تستخدم أصبعك وتضغط به علي صورة الإجابة الصحيحة.\n" +
                "ويحتوي البرنامج علي خمسه مفاتيح لازمه للتفاعل مع البرنامج:\n" +
                "-\tمفتاح التالي: للإنتقال للشاشة التالية\n" +
                "-\tمفتاح السابق: للإنتقال للشاشة السابقة\n" +
                "-\tمفتاح تكرار: لتكرار النشاط مرة آخري\n" +
                "-\tمفتاح الرئيسية: للإنتقال للشاشة الرئيسية بالبرنامج\n" +
                "-\tمفتاح خروج: للخروج من البرنامج\n",
        "١- أن ينتبه الطفل لمثير جاذب للانتباه عندما يعرض عليه. \n" +
                "٢- أن ينتبه الطفل لمثير محايد عندما يعرض عليه.\n" +
                "٣- أن يطابق الطفل مجسم بمجسم ( تفاحه ).\n" +
                "٤- أن يطابق الطفل مجسم بمجسم ( تفاحه ) مع مشتت واحد (موزه).\n" +
                "٥- أن يطابق الطفل مجسم بمجسم ( بطه ).\n" +
                "٦- أن يطابق الطفل مجسم بمجسم ( بطه ) مع مشتت واحد (كلب).\n" +
                "٧- أن يطابق الطفل مجسم بصوره ( تفاحه ).\n" +
                "٨- أن يطابق الطفل مجسم بصوره ( تفاحه ) مع مشتت واحد (موزه).\n" +
                "٩- أن يطابق الطفل مجسم بصوره ( بطه ).\n" +
                "١٠- أن يطابق الطفل مجسم بصوره ( بطه ) مع مشتت واحد (كلب).\n" +
                "١١- أن يطابق الطفل صوره بصوره ( تفاحه ).\n" +
                "١٢- أن يطابق الطفل صوره بصوره ( تفاحه ) مع مشتت واحد (موزه).\n" +
                "١٣- أن يطابق الطفل صوره بصوره ( بطه ).\n" +
                "١٤- أن يطابق الطفل صوره بصوره ( بطه ) مع مشتت واحد (كلب).\n" +
                "١٥- أن يطابق الطفل الشكل المعروض أمامه\n" +
                "١٦- أن يمشي الطفل داخل متاهة بسيطة.\n" +
                "١٧- أن يمشي الطفل داخل متاهة متوسطة.\n" +
                "١٨- أن يمشي الطفل داخل متاهة معقدة.\n" +
                "١٩- أن يصنف الطفل مجموعات ضمنيه (حيوانات أليفه – فواكه )\n" +
                "٢٠- أن يصنف الطفل مجموعات ضمنيه (خضروات– اشكال هندسيه)\n" +
                "٢١- أن يصنف الطفل مجموعات ضمنيه ( طيور– وسائل مواصلات )\n" +
                "٢٢- أن يلون الطفل الأشكال بألوان مختلفة (أحمر-أصفر-أزرق).\n" +
                "      (الدائرة باللون الأحمر، المثلث باللون الأصفر ، المستطيل باللون الأزرق).\n" +
                "٢٣- أن ينفذ الطفل أوامر بسيطة عندما يطلب منه ذلك مثل ( حط المكعبات في الصندوق ).\n" +
                "٢٤- أن يقلد الطفل حركات كبري مثل رفع الإيد لفوق.\n",
        "١- أن يتتبع الطفل مسار لعبة تتحرك أمام عينيه بشكل أفقي (أرنب متحرك).\n" +
                "٢- أن يتتبع الطفل مثير متحرك بين شخصين ( الكره ).\n" +
                "٣- أن يتتبع الطفل الإشاره التي تصدر من الشخص الآخر مثل الإشارة باليد لأشياء قريبه \n" +
                "     ( عربية ، كوره ، مكعبات ).\n" +
                "٤- أن يتتبع الطفل الإشاره التي تصدر من الشخص الآخر مثل الإشارة باليد لأشياء بعيده \n" +
                "     ( مروحة ، نور ).\n" +
                "٥- أن يتتبع الطفل نظرة الشخص الآخر عندما ينظر إلي لعبه ما يمينا ويسارا \n" +
                "     ( شجره تفاح وبرتقال ).\n" +
                "٦- أن يستجيب الطفل بالإشاره إلي شيء ما عندما يسأله الشخص الآخر شاور على ( كورة ).\n" +
                "٧- أن يستجيب الطفل بالإشاره إلي شيء ما عندما يسأله الشخص الآخر شاور على ( كورة ) مع مشتتات.\n" +
                "٨- أن يستجيب الطفل بالنظر إلي شيء ما عندما يشير إليه شخص آخر \n" +
                "     ( سمكة داخل حوض به ماء ).\n" +
                "٩- أن يبادل الطفل الآخرين بالإبتسامة عندما يطلب منه ذلك.\n" +
                "١٠- يناوب النظر بينه وبين الشخص الآخر والمثير عندما يقول له الشخص الآخر \n" +
                "    (أنظر ويشاور علي طائره ، شجره ، عصافير ).\n",
        "١- أن يشير الطفل لأشياء قريبه منه في مجال الرؤيه بغرض جذب الانتباه \n" +
                "        (الأطفال بتلعب فى الشارع ).\n" +
                "٢- أن يشير الطفل لأشياء بعيده عنه من مجال الرؤيه بغرض جذب الإنتباه ( القطار ).\n" +
                "٣- أن يشير الطفل إلى الأشياء التى يحتاج إليها بغرض الطلب ( المرجيحة ).\n" +
                "٤- أن يتبادل الطفل النظر بينه وبين المثير والشخص الآخر عندما يريد جذب انتباه الشخص الآخر لشيء ما ( العصافير فوق الشجرة).\n" +
                "٥- أن يتبادل الطفل النظر بينه وبين الشيء الذى يريده والشخص الآخر عندما يريد شئ ما \n" +
                "       ( العربية في محل اللعب ).\n" +
                "٦- أن يبادر الطفل بمواساة شخص آخر يبدو عليه مشاعر الحزن.\n" +
                "٧- أن يشرك الطفل الآخرين في إهتماماته كأن يحضر لعبه ويضعها أمام الشخص الآخر كى يلفت انتباهه. \n" +
                "٨- أن يبدأ الطفل باللعب التبادلى كأن يرمى الكره للشخص الآخر بغرض أن يطلب منه اللعب معه.\n" +
                "٩- أن يبدأ الطفل المصافحه باليد عند دخوله مكان ما.\n" +
                "١٠- أن يبدأ الطفل بالتلويح باى عند مغادرة مكان ما.\n"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        img!!.setImageResource(images[intent.getIntExtra("index", ٠)])
        titleTv.text = titles[intent.getIntExtra("index", 0)].trim()
        descTv.text = desc[intent.getIntExtra("index", 0)].trim()
        backBtn.setOnClickListener { onBackPressed() }
        exitBtn.setOnClickListener { this.finishAffinity() }
    }
}