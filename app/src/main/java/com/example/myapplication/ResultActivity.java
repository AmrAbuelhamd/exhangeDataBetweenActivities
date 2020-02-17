package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        textView = findViewById(R.id.resultTextView);

        String results = Utility.result + getString(R.string.max_grade);
        textView.setText(results);
    }

    public void onBackPressed() {
        Utility.rerunToMain(this);
    }

    public void goHome(View view) {
        Utility.rerunToMain(this);
    }

    public void exit(View view) {
        Utility.exit(this);

    }
}
