package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import static com.example.myapplication.Utility.GAADA;
import static com.example.myapplication.Utility.QUESTION_ONE;
import static com.example.myapplication.Utility.QUESTION_TWO;
import static com.example.myapplication.Utility.SAAD;
import static com.example.myapplication.Utility.ZUBAIDA;
import static com.example.myapplication.Utility.prepareLayout;
import static com.example.myapplication.Utility.question;
import static com.example.myapplication.Utility.questionId;
import static com.example.myapplication.Utility.retunToMain;
import static com.example.myapplication.Utility.setRootView;

public class QuestionActivity extends AppCompatActivity {
    int questionNumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        questionNumer = getIntent().getIntExtra(questionId, 0);
        //updateQuestionIdAndNumber
        question++;

        setRootView(findViewById(android.R.id.content).getRootView(), getPackageName());

        if (questionNumer == QUESTION_ONE) {
            prepareLayout(R.drawable.ghada, GAADA);

        } else if (questionNumer == QUESTION_TWO) {
            prepareLayout(R.drawable.saad, SAAD);
        } else {
            prepareLayout(R.drawable.zubaida, ZUBAIDA);
        }


    }


    public void onRadioBClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (questionNumer == QUESTION_ONE) {

            if (view.getId() == R.id._1 && checked)
                Utility.result++;

            Utility.toNext(this, QuestionActivity.class);

        } else if (questionNumer == QUESTION_TWO) {

            if (view.getId() == R.id._2 && checked)
                Utility.result++;

            Utility.toNext(this, QuestionActivity.class);

        } else {
            question = 1;
            if (checked && view.getId() == R.id._3)

                Utility.result++;
            Utility.toNext(this, ResultActivity.class);

        }
    }


    public void onBackPressed() {

        retunToMain(this);
    }


}
