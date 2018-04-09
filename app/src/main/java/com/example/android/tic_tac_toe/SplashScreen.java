package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int SPLASH_TIME_OUT = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcomeScrnIntent = new Intent(SplashScreen.this, WelcomeScreen.class);
                startActivity(welcomeScrnIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
