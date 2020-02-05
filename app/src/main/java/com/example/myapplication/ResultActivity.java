package com.example.myapplication;

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

        textView.setText(Utility.result + "/3");
        Utility.result = 0;
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
