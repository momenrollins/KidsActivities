package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MovingActivity extends AppCompatActivity {

    ImageView img;
    ArrayList<matahaModel> pointArrayList = new ArrayList();
    ArrayList<Double> toleranceArrayListx = new ArrayList();
    ArrayList<Double> toleranceArrayListy = new ArrayList();
    private TextView fResult;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving);

        Log.d("TAG", "onCreate: " + Environment.getExternalStorageDirectory());
        pointArrayList.add(new matahaModel(256.0, 281.0));
        pointArrayList.add(new matahaModel(256.0, 281.0));
        pointArrayList.add(new matahaModel(256.0, 281.0));
        pointArrayList.add(new matahaModel(256.0, 281.0));
        pointArrayList.add(new matahaModel(259.0, 281.0));
        pointArrayList.add(new matahaModel(261.0, 282.0));
        pointArrayList.add(new matahaModel(264.0, 283.0));
        pointArrayList.add(new matahaModel(268.0, 285.0));
        pointArrayList.add(new matahaModel(270.0, 286.0));
        pointArrayList.add(new matahaModel(274.0, 287.0));
        pointArrayList.add(new matahaModel(277.0, 288.0));
        pointArrayList.add(new matahaModel(282.0, 290.0));
        pointArrayList.add(new matahaModel(286.0, 291.0));
        pointArrayList.add(new matahaModel(289.0, 293.0));
        pointArrayList.add(new matahaModel(292.0, 294.0));
        pointArrayList.add(new matahaModel(293.0, 295.0));
        pointArrayList.add(new matahaModel(297.0, 296.0));
        pointArrayList.add(new matahaModel(301.0, 298.0));
        pointArrayList.add(new matahaModel(304.0, 299.0));
        pointArrayList.add(new matahaModel(307.0, 300.0));
        pointArrayList.add(new matahaModel(310.0, 303.0));
        pointArrayList.add(new matahaModel(314.0, 304.0));
        pointArrayList.add(new matahaModel(318.0, 306.0));
        pointArrayList.add(new matahaModel(322.0, 307.0));
        pointArrayList.add(new matahaModel(325.0, 308.0));
        pointArrayList.add(new matahaModel(329.0, 309.0));
        pointArrayList.add(new matahaModel(332.0, 311.0));
        pointArrayList.add(new matahaModel(336.0, 312.0));
        pointArrayList.add(new matahaModel(340.0, 314.0));
        pointArrayList.add(new matahaModel(344.0, 315.0));
        pointArrayList.add(new matahaModel(349.0, 317.0));
        pointArrayList.add(new matahaModel(354.0, 318.0));
        pointArrayList.add(new matahaModel(359.0, 319.0));
        pointArrayList.add(new matahaModel(365.0, 321.0));
        pointArrayList.add(new matahaModel(370.0, 323.0));
        pointArrayList.add(new matahaModel(376.0, 325.0));
        pointArrayList.add(new matahaModel(382.0, 326.0));
        pointArrayList.add(new matahaModel(386.0, 327.0));
        pointArrayList.add(new matahaModel(389.0, 328.0));
        pointArrayList.add(new matahaModel(394.0, 332.0));
        pointArrayList.add(new matahaModel(398.0, 335.0));
        pointArrayList.add(new matahaModel(402.0, 337.0));
        pointArrayList.add(new matahaModel(409.0, 339.0));
        pointArrayList.add(new matahaModel(415.0, 342.0));
        pointArrayList.add(new matahaModel(421.0, 344.0));
        pointArrayList.add(new matahaModel(425.0, 347.0));
        pointArrayList.add(new matahaModel(430.0, 348.0));
        pointArrayList.add(new matahaModel(436.0, 351.0));
        pointArrayList.add(new matahaModel(442.0, 353.0));
        pointArrayList.add(new matahaModel(450.0, 355.0));
        pointArrayList.add(new matahaModel(456.0, 357.0));
        pointArrayList.add(new matahaModel(462.0, 359.0));
        pointArrayList.add(new matahaModel(469.0, 362.0));
        pointArrayList.add(new matahaModel(476.0, 363.0));
        pointArrayList.add(new matahaModel(484.0, 365.0));
        pointArrayList.add(new matahaModel(492.0, 366.0));
        pointArrayList.add(new matahaModel(500.0, 367.0));
        pointArrayList.add(new matahaModel(508.0, 369.0));
        pointArrayList.add(new matahaModel(516.0, 370.0));
        pointArrayList.add(new matahaModel(523.0, 372.0));
        pointArrayList.add(new matahaModel(529.0, 373.0));
        pointArrayList.add(new matahaModel(537.0, 374.0));
        pointArrayList.add(new matahaModel(545.0, 377.0));
        pointArrayList.add(new matahaModel(553.0, 379.0));
        pointArrayList.add(new matahaModel(561.0, 382.0));
        pointArrayList.add(new matahaModel(569.0, 385.0));
        pointArrayList.add(new matahaModel(577.0, 389.0));
        pointArrayList.add(new matahaModel(585.0, 393.0));
        pointArrayList.add(new matahaModel(592.0, 396.0));
        pointArrayList.add(new matahaModel(599.0, 399.0));
        pointArrayList.add(new matahaModel(607.0, 402.0));
        pointArrayList.add(new matahaModel(616.0, 405.0));
        pointArrayList.add(new matahaModel(622.0, 406.0));
        pointArrayList.add(new matahaModel(628.0, 409.0));
        pointArrayList.add(new matahaModel(636.0, 411.0));
        pointArrayList.add(new matahaModel(644.0, 413.0));
        pointArrayList.add(new matahaModel(651.0, 415.0));
        pointArrayList.add(new matahaModel(657.0, 418.0));
        pointArrayList.add(new matahaModel(664.0, 420.0));
        pointArrayList.add(new matahaModel(672.0, 423.0));
        pointArrayList.add(new matahaModel(678.0, 424.0));
        pointArrayList.add(new matahaModel(686.0, 426.0));
        pointArrayList.add(new matahaModel(695.0, 428.0));
        pointArrayList.add(new matahaModel(703.0, 429.0));
        pointArrayList.add(new matahaModel(715.0, 433.0));
        pointArrayList.add(new matahaModel(727.0, 435.0));
        pointArrayList.add(new matahaModel(739.0, 440.0));
        pointArrayList.add(new matahaModel(749.0, 442.0));
        pointArrayList.add(new matahaModel(766.0, 445.0));
        pointArrayList.add(new matahaModel(779.0, 448.0));
        pointArrayList.add(new matahaModel(792.0, 451.0));
        pointArrayList.add(new matahaModel(801.0, 454.0));
        pointArrayList.add(new matahaModel(810.0, 456.0));
        pointArrayList.add(new matahaModel(817.0, 457.0));
        pointArrayList.add(new matahaModel(825.0, 458.0));
        pointArrayList.add(new matahaModel(833.0, 460.0));
        pointArrayList.add(new matahaModel(843.0, 463.0));
        pointArrayList.add(new matahaModel(852.0, 467.0));
        pointArrayList.add(new matahaModel(860.0, 469.0));
        pointArrayList.add(new matahaModel(869.0, 471.0));
        pointArrayList.add(new matahaModel(877.0, 472.0));
        pointArrayList.add(new matahaModel(884.0, 472.0));
        pointArrayList.add(new matahaModel(892.0, 473.0));
        pointArrayList.add(new matahaModel(900.0, 475.0));
        pointArrayList.add(new matahaModel(908.0, 475.0));
        pointArrayList.add(new matahaModel(915.0, 477.0));
        pointArrayList.add(new matahaModel(923.0, 477.0));
        pointArrayList.add(new matahaModel(933.0, 478.0));
        pointArrayList.add(new matahaModel(940.0, 479.0));
        pointArrayList.add(new matahaModel(949.0, 480.0));
        pointArrayList.add(new matahaModel(956.0, 482.0));
        pointArrayList.add(new matahaModel(964.0, 482.0));
        pointArrayList.add(new matahaModel(971.0, 483.0));
        pointArrayList.add(new matahaModel(980.0, 484.0));
        pointArrayList.add(new matahaModel(989.0, 484.0));
        pointArrayList.add(new matahaModel(999.0, 484.0));
        pointArrayList.add(new matahaModel(1007.0, 484.0));
        pointArrayList.add(new matahaModel(1014.0, 484.0));
        pointArrayList.add(new matahaModel(1021.0, 485.0));
        pointArrayList.add(new matahaModel(1030.0, 485.0));
        pointArrayList.add(new matahaModel(1040.0, 486.0));
        pointArrayList.add(new matahaModel(1048.0, 486.0));
        pointArrayList.add(new matahaModel(1056.0, 486.0));
        pointArrayList.add(new matahaModel(1063.0, 486.0));
        pointArrayList.add(new matahaModel(1073.0, 486.0));
        pointArrayList.add(new matahaModel(1081.0, 486.0));
        pointArrayList.add(new matahaModel(1088.0, 486.0));
        pointArrayList.add(new matahaModel(1095.0, 488.0));
        pointArrayList.add(new matahaModel(1102.0, 488.0));
        pointArrayList.add(new matahaModel(1108.0, 488.0));
        pointArrayList.add(new matahaModel(1117.0, 488.0));
        pointArrayList.add(new matahaModel(1124.0, 488.0));
        pointArrayList.add(new matahaModel(1133.0, 488.0));
        pointArrayList.add(new matahaModel(1141.0, 488.0));
        pointArrayList.add(new matahaModel(1148.0, 489.0));
        pointArrayList.add(new matahaModel(1155.0, 489.0));
        pointArrayList.add(new matahaModel(1162.0, 489.0));
        pointArrayList.add(new matahaModel(1168.0, 489.0));
        pointArrayList.add(new matahaModel(1177.0, 489.0));
        pointArrayList.add(new matahaModel(1185.0, 489.0));
        pointArrayList.add(new matahaModel(1192.0, 489.0));
        pointArrayList.add(new matahaModel(1200.0, 489.0));
        pointArrayList.add(new matahaModel(1208.0, 489.0));
        pointArrayList.add(new matahaModel(1215.0, 489.0));
        pointArrayList.add(new matahaModel(1221.0, 489.0));
        pointArrayList.add(new matahaModel(1229.0, 489.0));
        pointArrayList.add(new matahaModel(1235.0, 489.0));
        pointArrayList.add(new matahaModel(1243.0, 489.0));
        pointArrayList.add(new matahaModel(1252.0, 488.0));
        pointArrayList.add(new matahaModel(1259.0, 487.0));
        pointArrayList.add(new matahaModel(1268.0, 487.0));
        pointArrayList.add(new matahaModel(1276.0, 486.0));
        pointArrayList.add(new matahaModel(1283.0, 486.0));
        pointArrayList.add(new matahaModel(1291.0, 486.0));
        pointArrayList.add(new matahaModel(1298.0, 485.0));
        pointArrayList.add(new matahaModel(1305.0, 485.0));
        pointArrayList.add(new matahaModel(1313.0, 484.0));
        pointArrayList.add(new matahaModel(1322.0, 484.0));
        pointArrayList.add(new matahaModel(1330.0, 484.0));
        pointArrayList.add(new matahaModel(1337.0, 482.0));
        pointArrayList.add(new matahaModel(1346.0, 482.0));
        pointArrayList.add(new matahaModel(1354.0, 480.0));
        pointArrayList.add(new matahaModel(1361.0, 480.0));
        pointArrayList.add(new matahaModel(1370.0, 478.0));
        pointArrayList.add(new matahaModel(1382.0, 478.0));
        pointArrayList.add(new matahaModel(1389.0, 478.0));
        pointArrayList.add(new matahaModel(1397.0, 478.0));
        pointArrayList.add(new matahaModel(1405.0, 476.0));
        pointArrayList.add(new matahaModel(1413.0, 473.0));
        pointArrayList.add(new matahaModel(1421.0, 471.0));
        pointArrayList.add(new matahaModel(1429.0, 471.0));
        pointArrayList.add(new matahaModel(1435.0, 470.0));
        pointArrayList.add(new matahaModel(1444.0, 470.0));
        pointArrayList.add(new matahaModel(1452.0, 470.0));
        pointArrayList.add(new matahaModel(1460.0, 469.0));
        pointArrayList.add(new matahaModel(1469.0, 468.0));
        pointArrayList.add(new matahaModel(1477.0, 468.0));
        pointArrayList.add(new matahaModel(1482.0, 468.0));
        pointArrayList.add(new matahaModel(1487.0, 467.0));
        pointArrayList.add(new matahaModel(1493.0, 467.0));
        pointArrayList.add(new matahaModel(1498.0, 467.0));
        pointArrayList.add(new matahaModel(1506.0, 466.0));
        pointArrayList.add(new matahaModel(1514.0, 465.0));
        pointArrayList.add(new matahaModel(1519.0, 465.0));
        pointArrayList.add(new matahaModel(1525.0, 465.0));
        pointArrayList.add(new matahaModel(1533.0, 465.0));
        pointArrayList.add(new matahaModel(1538.0, 464.0));
        pointArrayList.add(new matahaModel(1542.0, 462.0));
        pointArrayList.add(new matahaModel(1547.0, 460.0));
        pointArrayList.add(new matahaModel(1551.0, 460.0));
        pointArrayList.add(new matahaModel(1555.0, 460.0));
        pointArrayList.add(new matahaModel(1558.0, 460.0));
        pointArrayList.add(new matahaModel(1563.0, 459.0));
        pointArrayList.add(new matahaModel(1567.0, 457.0));
        pointArrayList.add(new matahaModel(1572.0, 458.0));
        pointArrayList.add(new matahaModel(1575.0, 458.0));
        pointArrayList.add(new matahaModel(1580.0, 458.0));
        pointArrayList.add(new matahaModel(1583.0, 458.0));
        pointArrayList.add(new matahaModel(1587.0, 457.0));
        pointArrayList.add(new matahaModel(1592.0, 457.0));
        pointArrayList.add(new matahaModel(1596.0, 456.0));
        pointArrayList.add(new matahaModel(1599.0, 456.0));
        pointArrayList.add(new matahaModel(1604.0, 456.0));
        pointArrayList.add(new matahaModel(1607.0, 456.0));
        pointArrayList.add(new matahaModel(1608.0, 456.0));
        pointArrayList.add(new matahaModel(1610.0, 455.0));
        pointArrayList.add(new matahaModel(1612.0, 455.0));
        pointArrayList.add(new matahaModel(1614.0, 455.0));
        pointArrayList.add(new matahaModel(1616.0, 455.0));
        pointArrayList.add(new matahaModel(1618.0, 455.0));
        pointArrayList.add(new matahaModel(1619.0, 455.0));
        pointArrayList.add(new matahaModel(1620.0, 455.0));
        pointArrayList.add(new matahaModel(1621.0, 455.0));
        pointArrayList.add(new matahaModel(1623.0, 455.0));
        pointArrayList.add(new matahaModel(1625.0, 455.0));
        pointArrayList.add(new matahaModel(1627.0, 455.0));
        pointArrayList.add(new matahaModel(1629.0, 455.0));
        pointArrayList.add(new matahaModel(1630.0, 455.0));
        pointArrayList.add(new matahaModel(1631.0, 455.0));
        pointArrayList.add(new matahaModel(1633.0, 455.0));
        pointArrayList.add(new matahaModel(1637.0, 455.0));
        pointArrayList.add(new matahaModel(1640.0, 455.0));
        pointArrayList.add(new matahaModel(1642.0, 455.0));
        pointArrayList.add(new matahaModel(1644.0, 455.0));
        pointArrayList.add(new matahaModel(1645.0, 455.0));
        pointArrayList.add(new matahaModel(1647.0, 455.0));
        pointArrayList.add(new matahaModel(1649.0, 455.0));
        pointArrayList.add(new matahaModel(1652.0, 455.0));
        pointArrayList.add(new matahaModel(1657.0, 454.0));
        pointArrayList.add(new matahaModel(1659.0, 453.0));
        pointArrayList.add(new matahaModel(1661.0, 453.0));
        pointArrayList.add(new matahaModel(1664.0, 453.0));
        pointArrayList.add(new matahaModel(1666.0, 453.0));
        pointArrayList.add(new matahaModel(1669.0, 453.0));
        pointArrayList.add(new matahaModel(1674.0, 453.0));
        pointArrayList.add(new matahaModel(1676.0, 453.0));
        pointArrayList.add(new matahaModel(1678.0, 453.0));
        pointArrayList.add(new matahaModel(1681.0, 453.0));
        pointArrayList.add(new matahaModel(1683.0, 453.0));
        pointArrayList.add(new matahaModel(1686.0, 453.0));
        pointArrayList.add(new matahaModel(1688.0, 453.0));
        pointArrayList.add(new matahaModel(1690.0, 453.0));
        pointArrayList.add(new matahaModel(1692.0, 453.0));
        pointArrayList.add(new matahaModel(1693.0, 453.0));
        pointArrayList.add(new matahaModel(1695.0, 453.0));
        pointArrayList.add(new matahaModel(1698.0, 453.0));
        pointArrayList.add(new matahaModel(1700.0, 453.0));
        pointArrayList.add(new matahaModel(1704.0, 453.0));
        pointArrayList.add(new matahaModel(1707.0, 453.0));
        pointArrayList.add(new matahaModel(1709.0, 453.0));
        pointArrayList.add(new matahaModel(1710.0, 453.0));
        pointArrayList.add(new matahaModel(1711.0, 453.0));
        pointArrayList.add(new matahaModel(1713.0, 453.0));
        pointArrayList.add(new matahaModel(1714.0, 453.0));
        pointArrayList.add(new matahaModel(1715.0, 453.0));
        pointArrayList.add(new matahaModel(1716.0, 453.0));
        pointArrayList.add(new matahaModel(1717.0, 453.0));
        pointArrayList.add(new matahaModel(1718.0, 453.0));
        pointArrayList.add(new matahaModel(1719.0, 453.0));
        pointArrayList.add(new matahaModel(1720.0, 453.0));
        pointArrayList.add(new matahaModel(1720.0, 453.0));
        pointArrayList.add(new matahaModel(1720.0, 455.0));
        pointArrayList.add(new matahaModel(1718.0, 457.0));
        pointArrayList.add(new matahaModel(1717.0, 458.0));
        pointArrayList.add(new matahaModel(1716.0, 461.0));
        pointArrayList.add(new matahaModel(1716.0, 461.0));
        img = findViewById(R.id.btn);
        initView();

        double tolerance = Math.sqrt(
                Math.pow(img.getWidth(), 2.5) + Math.pow(
                        img.getHeight(),
                        2.5
                )

        );
        for(int x=0 ;x<pointArrayList.size();x++){

            if (pointArrayList.get(x).x<= tolerance && pointArrayList.get(x).y<= tolerance){
                toleranceArrayListx.add(pointArrayList.get(x).x);
                toleranceArrayListy.add(pointArrayList.get(x).y);
            }

        }


        img.setOnTouchListener(new View.OnTouchListener() {
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {



                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        img.setX((int) (StartPT.x + event.getX() - DownPT.x));
                        img.setY((int) (StartPT.y + event.getY() - DownPT.y));
                        StartPT.set(img.getX(), img.getY());
                        // generateNoteOnSD(MovingActivity.this,"points","pointArrayList.add(new matahaModel(" + img.getX() + ", " + img.getY() + "));");


                      /*  if (toleranceArrayListx.contains(img.getX()) && toleranceArrayListy.contains(img.getY())){
                            fResult.setText("شااااااااااطر");
                        }else {
                            fResult.setText("حاااااااول تاااانى");

                        }*/

                        if (isPointOnLine(new PointF(pointArrayList.get(0).x, pointArrayList.get(0).y), new PointF(pointArrayList.get(pointArrayList.size() - 1).x, pointArrayList.get(pointArrayList.size() - 1).y), new PointF(img.getX(), img.getY()))) {
                            fResult.setText("شااااااااااطر");

                        } else {
                            fResult.setText("حاااااااول تاااانى");
                        }
//                        if (!pointArrayList.contains(new matahaModel(img.getX(), img.getY()))){
//                            Log.d("TAG", "onTouch: Wrong Roude");
//                        }

//                        System.out.println("pointArrayList.add(new matahaModel(" + img.getX() + ", " + img.getY() + "));");
                        break;
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(event.getX(), event.getY());
                        StartPT.set(img.getX(), img.getY());
                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private float width = 100;


    public boolean isPointOnLine(PointF lineStaPt, PointF lineEndPt, PointF point) {
        final float EPSILON = width;
        if (Math.abs(lineStaPt.x - lineEndPt.x) < EPSILON) {
            // We've a vertical line, thus check only the x-value of the point.
            return (Math.abs(point.x - lineStaPt.x) < EPSILON);
        } else {
            double m = (lineEndPt.y - lineStaPt.y) / (lineEndPt.x - lineStaPt.x);
            double b = lineStaPt.y - m * lineStaPt.x;
            return (Math.abs(point.y - (m * point.x + b)) < EPSILON);
        }
    }


    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            String rootPath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/MyFolder/";
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        fResult = (TextView) findViewById(R.id.f_result);
    }

    private class matahaModel {
        double x;
        double y;

        public matahaModel(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public matahaModel(double x) {
            this.x = x;
        }



        public matahaModel() {
        }
    }
}

class PointF {
    public double x = 0;
    public double y = 0;

    public PointF() {
    }

    ;

    public PointF(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public void set(float _x, float _y) {
        x = _x;
        y = _y;
    }

}