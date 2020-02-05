package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Utility {

    final static String ZUBAIDA = "zubayda";
    final static String SAAD= "saad";
    final static String GAADA= "ghada";
    final static String RESULTS = "results";
    private static View mRootView;
    private static String mPackName;

    public static void setRootView(View rootView, String packName) {
        mRootView = rootView;
        mPackName = packName;
    }

    static public void setImageResource(int resource) {
        ImageView imageView;

        imageView = mRootView.findViewById(R.id.imageView);
        imageView.setImageResource(resource);

    }

    public static void setRadioButtonOptions(String x) {

        RadioButton rb1, rb2, rb3;
        TextView question;
        rb1 = mRootView.findViewById(R.id._1);
        rb2 = mRootView.findViewById(R.id._2);
        rb3 = mRootView.findViewById(R.id._3);
        question = mRootView.findViewById(R.id.question);

        int resourceId0 = mRootView.getResources().getIdentifier(x + "_0", "string", mPackName);
        int resourceId1 = mRootView.getResources().getIdentifier(x + "_1", "string", mPackName);
        int resourceId2 = mRootView.getResources().getIdentifier(x + "_2", "string", mPackName);
        int resourceId3 = mRootView.getResources().getIdentifier(x + "_3", "string", mPackName);

        question.setText(resourceId0);
        rb1.setText(resourceId1);
        rb2.setText(resourceId2);
        rb3.setText(resourceId3);

    }


    public static void toNext(int x, Context context, final Class<? extends Activity> ActivityToOpen) {
        Intent myIntent = new Intent(context, ActivityToOpen);
        myIntent.putExtra("results", x);
        context.startActivity(myIntent);
    }


    static void retunToMain(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void exit(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
