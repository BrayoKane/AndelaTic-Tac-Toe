package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class _2P_3by3 extends AppCompatActivity implements View.OnClickListener {
    boolean playerX = true;
    int turnCount = 0;

    Button button00;
    Button button01;
    Button button02;
    Button button10;
    Button button11;
    Button button12;
    Button button20;
    Button button21;
    Button button22;

    Button buttonReset, buttonQuit;

    TextView gameStateInfo;

    int[][] gameBoardStatus = new int[3][3];

    private boolean quit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__2p_3by3);

        int option = getIntent().getIntExtra(_2P_MarkerSelection.OPTION, 0);
        playerX = option == 0;

        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        buttonReset = findViewById(R.id.resetButton);
        buttonQuit = findViewById(R.id.quitButton);
        gameStateInfo = findViewById(R.id.infoGameState);

        buttonQuit.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        button00.setOnClickListener(this);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);

        initializeGameBoardStatus();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button00:
                if (playerX) {
                    button00.setText("X");
                    gameBoardStatus[0][0] = 1;
                } else {
                    button00.setText("O");

                    gameBoardStatus[0][0] = 0;
                }
                button00.setEnabled(false);
                nextTurn();
                break;

            case R.id.button01:
                if (playerX) {
                    button01.setText("X");
                    gameBoardStatus[0][1] = 1;
                } else {
                    button01.setText("O");

                    gameBoardStatus[0][1] = 0;
                }
                button01.setEnabled(false);
                nextTurn();
                break;

            case R.id.button02:
                if (playerX) {
                    button02.setText("X");
                    gameBoardStatus[0][2] = 1;
                } else {
                    button02.setText("O");

                    gameBoardStatus[0][2] = 0;
                }
                button02.setEnabled(false);
                nextTurn();
                break;

            case R.id.button10:
                if (playerX) {
                    button10.setText("X");
                    gameBoardStatus[1][0] = 1;
                } else {
                    button10.setText("O");

                    gameBoardStatus[1][0] = 0;
                }
                button10.setEnabled(false);
                nextTurn();
                break;

            case R.id.button11:
                if (playerX) {
                    button11.setText("X");
                    gameBoardStatus[1][1] = 1;
                } else {
                    button11.setText("O");

                    gameBoardStatus[1][1] = 0;
                }
                button11.setEnabled(false);
                nextTurn();
                break;

            case R.id.button12:
                if (playerX) {
                    button12.setText("X");
                    gameBoardStatus[1][2] = 1;
                } else {
                    button12.setText("O");

                    gameBoardStatus[1][2] = 0;
                }
                button12.setEnabled(false);
                nextTurn();
                break;

            case R.id.button20:
                if (playerX) {
                    button20.setText("X");
                    gameBoardStatus[2][0] = 1;
                } else {
                    button20.setText("O");

                    gameBoardStatus[2][0] = 0;
                }
                button20.setEnabled(false);
                nextTurn();
                break;

            case R.id.button21:
                if (playerX) {
                    button21.setText("X");
                    gameBoardStatus[2][1] = 1;
                } else {
                    button21.setText("O");

                    gameBoardStatus[2][1] = 0;
                }
                button21.setEnabled(false);
                nextTurn();
                break;

            case R.id.button22:
                if (playerX) {
                    button22.setText("X");
                    gameBoardStatus[2][2] = 1;
                } else {
                    button22.setText("O");

                    gameBoardStatus[2][2] = 0;
                }
                button22.setEnabled(false);
                nextTurn();
                break;

            case R.id.resetButton:
                resetBoard();
                break;
            case R.id.quitButton:
                if (quit) {
                    Intent w = new Intent(this, WelcomeScreen.class);
                    w.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(w);
                    // quit app
                    // Process.killProcess(Process.myPid());
                    return;
                }

                quit = true;
                Toast.makeText(this, "Click again to quit", Toast.LENGTH_SHORT).show();
                buttonQuit.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        quit = false;
                    }
                }, 1000);
                break;
            default:
                break;
        }
    }

    private void nextTurn() {
        turnCount++;
        playerX = !playerX;

        if (playerX) {
            setGameStateInfo("Player X's turn");
        }
        if (!playerX) {
            setGameStateInfo("Player O's turn");
        }
        if (turnCount == 9) {
            ScoreStore.draws++;
            result("The game is a DRAW!");
        }
        checkForWinner();
    }

    private void checkForWinner() {
        for (int i = 0; i < 3; i++) {
            if (gameBoardStatus[i][0] == gameBoardStatus[i][1] && gameBoardStatus[i][0] == gameBoardStatus[i][2]) {
                if (gameBoardStatus[i][0] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!\n" + "\t \t \t row " + (i + 1));
                    break;
                } else if (gameBoardStatus[i][0] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!\n" + "\t \t \t row " + (i + 1));
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameBoardStatus[0][i] == gameBoardStatus[1][i] && gameBoardStatus[0][i] == gameBoardStatus[2][i]) {
                if (gameBoardStatus[0][i] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!\n" + "\t column " + (i + 1));
                    break;
                } else if (gameBoardStatus[0][i] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!\n" + "\t column " + (i + 1));
                    break;
                }
            }
        }
        if (gameBoardStatus[0][0] == gameBoardStatus[1][1] && gameBoardStatus[0][0] == gameBoardStatus[2][2]) {
            if (gameBoardStatus[0][0] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tFirst Diagonal");
            } else if (gameBoardStatus[0][0] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tFirst Diagonal");
            }
        }
        if (gameBoardStatus[0][2] == gameBoardStatus[1][1] && gameBoardStatus[0][2] == gameBoardStatus[2][0]) {
            if (gameBoardStatus[0][2] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tSecond Diagonal");
            } else if (gameBoardStatus[0][2] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tSecond Diagonal");
            }
        }
    }

    private void enableAllButtons(boolean value) {
        button00.setEnabled(value);
        button01.setEnabled(value);
        button02.setEnabled(value);
        button10.setEnabled(value);
        button11.setEnabled(value);
        button12.setEnabled(value);
        button20.setEnabled(value);
        button21.setEnabled(value);
        button22.setEnabled(value);
    }

    private void result(String winner) {
        setGameStateInfo(winner);
        enableAllButtons(false);
    }

    public void showScoreBoard(View view) {
        //        View v = getLayoutInflater().inflate(R.layout.view_score_sheet, null);
        final ViewGroup nullParent = null;
        View v = getLayoutInflater().inflate(R.layout.view_score_sheet, nullParent);
        TextView xWin = v.findViewById(R.id.x_win);
        TextView oWin = v.findViewById(R.id.o_win);
        TextView draw = v.findViewById(R.id.draw);
        ImageButton close = v.findViewById(R.id.close_button);

        xWin.setText(String.valueOf(ScoreStore.xWins));
        oWin.setText(String.valueOf(ScoreStore.oWins));
        draw.setText(String.valueOf(ScoreStore.draws));
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(v)
                .create();
        dialog.show();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void resetBoard() {
        button00.setText("");
        button01.setText("");
        button02.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");

        enableAllButtons(true);

        playerX = true;
        turnCount = 0;

        initializeGameBoardStatus();

        setGameStateInfo("Start Again!");

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void setGameStateInfo(String text) {
        gameStateInfo.setText(text);
    }

    private void initializeGameBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoardStatus[i][j] = -1;

            }
        }
    }
}
