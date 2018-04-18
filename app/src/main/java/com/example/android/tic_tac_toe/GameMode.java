package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        TextView tv = findViewById(R.id.mode1);
        tv.setText(Html.fromHtml(getString(R.string._1p)));
        TextView tv2 = findViewById(R.id.mode2);
        tv2.setText(Html.fromHtml(getString(R.string._1p_vs_2p)));
    }

    public void goTo1pMarkerScreen(View view) {
        Intent i = new Intent(GameMode.this, _1P_MarkerSelection.class);
        Toast.makeText(this, "1 Player mode selected ", Toast.LENGTH_LONG).show();
        startActivity(i);

    }

    public void goToMarkerScreen(View view) {
        Intent j = new Intent(GameMode.this, _2P_MarkerSelection.class);
        Toast.makeText(this, "2 Player mode selected ", Toast.LENGTH_LONG).show();
        startActivity(j);
    }


}
