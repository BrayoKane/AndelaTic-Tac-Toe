package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class _2P_MarkerSelection extends AppCompatActivity {
    public static final String OPTION = "option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__2p_marker_selection);
    }

    public void goToBoardScreen(View view) {
        int id = view.getId();

        Intent i = new Intent(_2P_MarkerSelection.this, _2P_BoardSelection.class);
        if (id == R.id.optionB) {
            i.putExtra(OPTION, 1);
        } else {
            i.putExtra(OPTION, 0);
        }

        startActivity(i);
    }

    public void goBackToModeScreen(View view) {
        Intent j = new Intent(_2P_MarkerSelection.this, GameMode.class);
        startActivity(j);
    }
}
