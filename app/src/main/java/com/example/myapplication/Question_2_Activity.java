package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import static com.example.myapplication.Utility.RESULTS;
import static com.example.myapplication.Utility.SAAD;
import static com.example.myapplication.Utility.retunToMain;

public class Question_2_Activity extends AppCompatActivity {
    private int totalResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        Utility.setRootView(findViewById(android.R.id.content).getRootView(), getPackageName());
        Utility.setImageResource(R.drawable.saad);
        Utility.setRadioButtonOptions(SAAD);


        Intent i = getIntent();
        totalResults = i.getIntExtra(RESULTS, 0);
    }

    public void onRadioBClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id._2:
                if (checked)
                    Utility.toNext(++totalResults, this, Question_3_Activity.class);
                break;
            default:
                Utility.toNext(totalResults, this, Question_3_Activity.class);
                break;
        }
    }

    public void onBackPressed() {

        retunToMain(this);
    }


}
