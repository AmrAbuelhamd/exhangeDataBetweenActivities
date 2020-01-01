package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.myapplication.Utility.retunToMain;

public class ResultActivity extends AppCompatActivity {
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        textView = findViewById(R.id.textView3);

        Intent i = getIntent();
        int totalResults = i.getIntExtra("results", 0);

        textView.setText(totalResults + "/3");
    }

    public void onBackPressed() {
        retunToMain(this);
    }

    public void goHome(View view) {
        retunToMain(this);
    }

    public void exit(View view) {
        Utility.exit(this);

    }
}
