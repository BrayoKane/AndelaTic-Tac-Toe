package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MarkerScreen extends AppCompatActivity {
    public static final String OPTION = "option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_screen);
    }

    public void goToBoardScreen(View view) {
        int id = view.getId();

        Intent i = new Intent(MarkerScreen.this, BoardSelection.class);
        if (id == R.id.optionB) {
            i.putExtra(OPTION, 1);
        } else {
            i.putExtra(OPTION, 0);
        }

        startActivity(i);
    }

    public void goBackToModeScreen(View view) {
        Intent j = new Intent(MarkerScreen.this, GameMode.class);
        startActivity(j);
    }
}
