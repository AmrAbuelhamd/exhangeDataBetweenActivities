package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import static com.example.myapplication.Utility.retunToMain;

public class Question_1_Activity extends AppCompatActivity {
    private int totalResults = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);


        Utility.setRootView(findViewById(android.R.id.content).getRootView(), getPackageName());
        Utility.setImageResource(R.drawable.ghada);
        Utility.setRadioButtonOptions("ghada");


    }

    public void onRadioBClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id._1:
                if (checked)
                    Utility.toNext(++totalResults, this, Question_2_Activity.class);
                break;
            default:
                Utility.toNext(totalResults, this, Question_2_Activity.class);
                break;
        }
    }


    public void onBackPressed() {

        retunToMain(this);
    }


}
