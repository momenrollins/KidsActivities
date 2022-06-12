package com.momen.babyactivities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

public class SHARDStorage {
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;


    static void initShaird(Context context){
        sharedPreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


    }
    static void saveFaildPoints(String key,int value){
        editor.putInt(key,value);
        editor.commit();

    }
    static void AliartResult(Context context,String content){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle("عدد المحاولات الخاطئة");
        builder1.setMessage(content);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "موافق",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });



        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
