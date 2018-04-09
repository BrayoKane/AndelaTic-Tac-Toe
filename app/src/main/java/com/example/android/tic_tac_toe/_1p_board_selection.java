package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class _1p_board_selection extends AppCompatActivity {
    private int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__1p_board_selection);

        option = getIntent().getIntExtra(MarkerScreen.OPTION, 0);

        TextView tv4 = findViewById(R.id._1p_3by3);
        tv4.setText(Html.fromHtml(getString(R.string._1p_3_x_3)));
        TextView tv5 = findViewById(R.id._1p_4by4);
        tv5.setText(Html.fromHtml(getString(R.string._1p_4_x_4)));
        TextView tv6 = findViewById(R.id._1p_5by5);
        tv6.setText(Html.fromHtml(getString(R.string._1p_5_x_5)));

    }

    public void goTo1p_3by3(View view) {
        Intent i = new Intent(_1p_board_selection.this, _1P_3by3.class);
        i.putExtra(MarkerScreen.OPTION, option);
        startActivity(i);
    }

    public void goTo1p_4by4(View view) {
        Intent j = new Intent(_1p_board_selection.this, _1P_4by4.class);
        j.putExtra(MarkerScreen.OPTION, option);
        startActivity(j);
    }

    public void goTo1p_5by5(View view) {
        Intent k = new Intent(_1p_board_selection.this, _1P_5by5.class);
        k.putExtra(MarkerScreen.OPTION, option);
        startActivity(k);
    }

    public void goBackToMarkerScreen(View view) {
        Intent l = new Intent(_1p_board_selection.this, MarkerScreen.class);
        l.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(l);
    }
}
