package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;


public class QuestionActivity extends AppCompatActivity {
    int questionNumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        questionNumer = getIntent().getIntExtra(Utility.questionId, 0);
        //updateQuestionIdAndNumber
        Utility.question++;

        Utility.setRootView(findViewById(android.R.id.content).getRootView(), getPackageName());

        if (questionNumer == Utility.QUESTION_ONE) {
            Utility.prepareLayout(R.drawable.ghada, Utility.GAADA);

        } else if (questionNumer == Utility.QUESTION_TWO) {
            Utility.prepareLayout(R.drawable.saad, Utility.SAAD);
        } else {
            Utility.prepareLayout(R.drawable.zubaida, Utility.ZUBAIDA);
        }


    }


    public void onRadioBClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (questionNumer == Utility.QUESTION_ONE) {

            if (view.getId() == R.id.firstRadioButton && checked)
                Utility.result++;

            Utility.toNext(this, QuestionActivity.class);

        } else if (questionNumer == Utility.QUESTION_TWO) {

            if (view.getId() == R.id.secondRadioButton && checked)
                Utility.result++;

            Utility.toNext(this, QuestionActivity.class);

        } else {
            Utility.question = 1;
            if (checked && view.getId() == R.id.thirdRadioButton)

                Utility.result++;
            Utility.toNext(this, ResultActivity.class);

        }
    }


    public void onBackPressed() {
        Utility.rerunToMain(this);
    }


}
