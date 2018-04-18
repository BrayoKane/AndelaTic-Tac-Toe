package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_scrn);
    }

    public void goToAboutScreen(View view) {
        Intent i = new Intent(WelcomeScreen.this, AboutActivity.class);
        startActivity(i);
    }

    public void goToModeScreen(View view) {
        Intent j = new Intent(WelcomeScreen.this, GameMode.class);
        startActivity(j);
    }
}
