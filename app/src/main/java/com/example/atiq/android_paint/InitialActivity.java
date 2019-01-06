package com.example.atiq.android_paint;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InitialActivity extends AppCompatActivity {


    private static int SPLASh_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(InitialActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASh_TIME_OUT);
    }
}
