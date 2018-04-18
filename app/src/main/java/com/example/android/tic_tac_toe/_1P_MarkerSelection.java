package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class _1P_MarkerSelection extends AppCompatActivity {
    public static final String OPTION = "option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__1p_marker_selection);
    }

    public void goTo1pBoardScreen(View view) {
        int id = view.getId();

        Intent i = new Intent(_1P_MarkerSelection.this, _1P_BoardSelection.class);
        if (id == R.id.optionB) {
            i.putExtra(OPTION, 1);
            Toast.makeText(this, "O selected! Your computer opponent will use X", Toast.LENGTH_LONG).show();
        } else {
            i.putExtra(OPTION, 0);
            Toast.makeText(this, "X selected! Your computer opponent will use O", Toast.LENGTH_LONG).show();
        }

        startActivity(i);
    }

    public void goBackToModeScreen(View view) {
        Intent j = new Intent(_1P_MarkerSelection.this, GameMode.class);
        startActivity(j);
    }
}
