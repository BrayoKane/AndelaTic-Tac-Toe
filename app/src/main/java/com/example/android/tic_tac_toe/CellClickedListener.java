package com.example.android.tic_tac_toe;

public interface CellClickedListener {
    void onClicked(String player, Coordinate coordinate);

    public class Coordinate {
        public int x, y;
    }
}
