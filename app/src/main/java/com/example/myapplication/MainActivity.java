package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reset the values
        Utility.result = 0;
        Utility.question = 1;
        if(Utility.firstStart++==1)
            Toast.makeText(this, R.string.click_to_show_hint, Toast.LENGTH_SHORT).show();

    }

    public void startTheTest(View view) {
        Intent myIntent = new Intent(this, QuestionActivity.class);
        myIntent.putExtra(Utility.questionId, Utility.question);
        this.startActivity(myIntent);
    }

    public void getHInt(View view) {
        Toast.makeText(this, R.string.answers_hint, Toast.LENGTH_SHORT).show();
    }

    public void exit(View view) {
        Utility.exit(this);
    }
}
