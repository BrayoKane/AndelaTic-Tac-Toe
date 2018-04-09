package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class GameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        TextView tv = (TextView) findViewById(R.id.mode1);
        tv.setText(Html.fromHtml(getString(R.string._1p)));
        TextView tv2 = (TextView) findViewById(R.id.mode2);
        tv2.setText(Html.fromHtml(getString(R.string._1p_vs_2p)));
    }

    public void goToMarkerScreen(View view) {
        Intent i = new Intent(GameMode.this, MarkerScreen.class);
        startActivity(i);
    }


}
