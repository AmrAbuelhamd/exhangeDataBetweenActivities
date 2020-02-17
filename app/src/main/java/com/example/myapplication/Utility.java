package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Utility {
    static int firstStart = 1;
    final static String ZUBAIDA = "zubayda";
    final static String SAAD= "saad";
    final static String GAADA= "ghada";
    final static int QUESTION_ONE = 1;
    final static int QUESTION_TWO = 2;
    static int result = 0;
    static String questionId = "question";
    static int question = 1;


    private static View mRootView;
    private static String mPackName;


    public static void setRootView(View rootView, String packName) {
        mRootView = rootView;
        mPackName = packName;
    }

    private static void setImageResource(int resource) {
        ImageView imageView;

        imageView = mRootView.findViewById(R.id.imageView);
        imageView.setImageResource(resource);

    }

    public static void setRadioButtonOptions(String actorName) {

        RadioButton rb1, rb2, rb3;
        TextView question;
        rb1 = mRootView.findViewById(R.id.firstRadioButton);
        rb2 = mRootView.findViewById(R.id.secondRadioButton);
        rb3 = mRootView.findViewById(R.id.thirdRadioButton);
        question = mRootView.findViewById(R.id.question);

        Resources res = mRootView.getResources();
        int questionDetails = res.getIdentifier(actorName, "array", mPackName);
        String[] arrayOfQuestionAndAnswers = res.getStringArray(questionDetails);

        question.setText(arrayOfQuestionAndAnswers[0]);//first is always the question
        rb1.setText(arrayOfQuestionAndAnswers[1]);
        rb2.setText(arrayOfQuestionAndAnswers[2]);
        rb3.setText(arrayOfQuestionAndAnswers[3]);

    }


    public static void toNext(Context context, final Class<? extends Activity> ActivityToOpen) {
        Intent myIntent = new Intent(context, ActivityToOpen);
        myIntent.putExtra(Utility.questionId, Utility.question);
        context.startActivity(myIntent);
    }


    static void rerunToMain(Context context) {
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

    public static void prepareLayout(int drawable, String actorNAme) {
        setImageResource(drawable);
        setRadioButtonOptions(actorNAme);
    }
}
