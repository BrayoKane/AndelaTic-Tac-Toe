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

public class _2P_5by5 extends AppCompatActivity implements View.OnClickListener {
    boolean playerX = true;
    int turnCount = 0;

    Button button00;
    Button button01;
    Button button02;
    Button button03;
    Button button04;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button20;
    Button button21;
    Button button22;
    Button button23;
    Button button24;
    Button button30;
    Button button31;
    Button button32;
    Button button33;
    Button button34;
    Button button40;
    Button button41;
    Button button42;
    Button button43;
    Button button44;

    Button buttonReset, buttonQuit;

    TextView gameStateInfo;

    int[][] gameBoardStatus = new int[5][5];

    private boolean quit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__2p_5by5);

        int option = getIntent().getIntExtra(_2P_MarkerSelection.OPTION, 0);
        playerX = option == 0;

        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button03 = findViewById(R.id.button03);
        button04 = findViewById(R.id.button04);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        button34 = findViewById(R.id.button34);
        button40 = findViewById(R.id.button40);
        button41 = findViewById(R.id.button41);
        button42 = findViewById(R.id.button42);
        button43 = findViewById(R.id.button43);
        button44 = findViewById(R.id.button44);
        buttonReset = findViewById(R.id.resetButton);
        buttonQuit = findViewById(R.id.quitButton);
        gameStateInfo = findViewById(R.id.infoGameState);

        buttonQuit.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        button00.setOnClickListener(this);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button24.setOnClickListener(this);
        button30.setOnClickListener(this);
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);
        button34.setOnClickListener(this);
        button40.setOnClickListener(this);
        button41.setOnClickListener(this);
        button42.setOnClickListener(this);
        button43.setOnClickListener(this);
        button44.setOnClickListener(this);

        initializeGameBoardStatus();
    }

    @Override
    public void onClick(View view) {
        boolean resetButtonPressed = false;

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
                break;

            case R.id.button03:
                if (playerX) {
                    button03.setText("X");
                    gameBoardStatus[0][3] = 1;
                } else {
                    button03.setText("O");

                    gameBoardStatus[0][3] = 0;
                }
                button03.setEnabled(false);
                break;

            case R.id.button04:
                if (playerX) {
                    button04.setText("X");
                    gameBoardStatus[0][4] = 1;
                } else {
                    button04.setText("O");

                    gameBoardStatus[0][4] = 0;
                }
                button04.setEnabled(false);
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
                break;

            case R.id.button13:
                if (playerX) {
                    button13.setText("X");
                    gameBoardStatus[1][3] = 1;
                } else {
                    button13.setText("O");

                    gameBoardStatus[1][3] = 0;
                }
                button13.setEnabled(false);
                break;

            case R.id.button14:
                if (playerX) {
                    button14.setText("X");
                    gameBoardStatus[1][4] = 1;
                } else {
                    button14.setText("O");

                    gameBoardStatus[1][4] = 0;
                }
                button14.setEnabled(false);
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
                break;

            case R.id.button23:
                if (playerX) {
                    button23.setText("X");
                    gameBoardStatus[2][3] = 1;
                } else {
                    button23.setText("O");

                    gameBoardStatus[2][3] = 0;
                }
                button23.setEnabled(false);
                break;

            case R.id.button24:
                if (playerX) {
                    button24.setText("X");
                    gameBoardStatus[2][4] = 1;
                } else {
                    button24.setText("O");

                    gameBoardStatus[2][4] = 0;
                }
                button24.setEnabled(false);
                break;

            case R.id.button30:
                if (playerX) {
                    button30.setText("X");
                    gameBoardStatus[3][0] = 1;
                } else {
                    button30.setText("O");

                    gameBoardStatus[3][0] = 0;
                }
                button30.setEnabled(false);
                break;

            case R.id.button31:
                if (playerX) {
                    button31.setText("X");
                    gameBoardStatus[3][1] = 1;
                } else {
                    button31.setText("O");

                    gameBoardStatus[3][1] = 0;
                }
                button31.setEnabled(false);
                break;

            case R.id.button32:
                if (playerX) {
                    button32.setText("X");
                    gameBoardStatus[3][2] = 1;
                } else {
                    button32.setText("O");

                    gameBoardStatus[3][2] = 0;
                }
                button32.setEnabled(false);
                break;

            case R.id.button33:
                if (playerX) {
                    button33.setText("X");
                    gameBoardStatus[3][3] = 1;
                } else {
                    button33.setText("O");

                    gameBoardStatus[3][3] = 0;
                }
                button33.setEnabled(false);
                break;

            case R.id.button34:
                if (playerX) {
                    button34.setText("X");
                    gameBoardStatus[3][4] = 1;
                } else {
                    button34.setText("O");

                    gameBoardStatus[3][4] = 0;
                }
                button34.setEnabled(false);
                break;

            case R.id.button40:
                if (playerX) {
                    button40.setText("X");
                    gameBoardStatus[4][0] = 1;
                } else {
                    button40.setText("O");

                    gameBoardStatus[4][0] = 0;
                }
                button40.setEnabled(false);
                break;

            case R.id.button41:
                if (playerX) {
                    button41.setText("X");
                    gameBoardStatus[4][1] = 1;
                } else {
                    button41.setText("O");

                    gameBoardStatus[4][1] = 0;
                }
                button41.setEnabled(false);
                break;

            case R.id.button42:
                if (playerX) {
                    button42.setText("X");
                    gameBoardStatus[4][2] = 1;
                } else {
                    button42.setText("O");

                    gameBoardStatus[4][2] = 0;
                }
                button42.setEnabled(false);
                break;

            case R.id.button43:
                if (playerX) {
                    button43.setText("X");
                    gameBoardStatus[4][3] = 1;
                } else {
                    button43.setText("O");

                    gameBoardStatus[4][3] = 0;
                }
                button43.setEnabled(false);
                break;

            case R.id.button44:
                if (playerX) {
                    button44.setText("X");
                    gameBoardStatus[4][4] = 1;
                } else {
                    button44.setText("O");

                    gameBoardStatus[4][4] = 0;
                }
                button44.setEnabled(false);
                break;

            case R.id.resetButton:
                resetButtonPressed = true;
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
        if (resetButtonPressed) {
            resetBoard();
        } else {
            turnCount++;
            playerX = !playerX;

            if (playerX) {
                setGameStateInfo("Player X's turn");
            }
            if (!playerX) {
                setGameStateInfo("Player O's turn");
            }
            if (turnCount == 25) {
                ScoreStore.draws++;
                result("The game is a DRAW!");
            }
            checkForWinner();
        }
    }

    private void checkForWinner() {
        for (int i = 0; i < 5; i++) {
            if (gameBoardStatus[i][0] == gameBoardStatus[i][1] && gameBoardStatus[i][0] == gameBoardStatus[i][2] && gameBoardStatus[i][0] == gameBoardStatus[i][3] && gameBoardStatus[i][0] == gameBoardStatus[i][4]) {
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
        for (int i = 0; i < 5; i++) {
            if (gameBoardStatus[0][i] == gameBoardStatus[1][i] && gameBoardStatus[0][i] == gameBoardStatus[2][i] && gameBoardStatus[0][i] == gameBoardStatus[3][i] && gameBoardStatus[0][i] == gameBoardStatus[4][i]) {
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
        if (gameBoardStatus[0][0] == gameBoardStatus[1][1] && gameBoardStatus[0][0] == gameBoardStatus[2][2] && gameBoardStatus[0][0] == gameBoardStatus[3][3] && gameBoardStatus[0][0] == gameBoardStatus[4][4]) {
            if (gameBoardStatus[0][0] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tFirst Diagonal");
            } else if (gameBoardStatus[0][0] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tFirst Diagonal");
            }
        }
        if (gameBoardStatus[0][4] == gameBoardStatus[1][3] && gameBoardStatus[0][4] == gameBoardStatus[2][2] && gameBoardStatus[0][4] == gameBoardStatus[3][1] && gameBoardStatus[0][4] == gameBoardStatus[4][0]) {
            if (gameBoardStatus[0][4] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tSecond Diagonal");
            } else if (gameBoardStatus[0][4] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tSecond Diagonal");
            }
        }
    }

    private void enableAllButtons(boolean value) {
        button00.setEnabled(value);
        button01.setEnabled(value);
        button02.setEnabled(value);
        button03.setEnabled(value);
        button04.setEnabled(value);
        button10.setEnabled(value);
        button11.setEnabled(value);
        button12.setEnabled(value);
        button13.setEnabled(value);
        button14.setEnabled(value);
        button20.setEnabled(value);
        button21.setEnabled(value);
        button22.setEnabled(value);
        button23.setEnabled(value);
        button24.setEnabled(value);
        button30.setEnabled(value);
        button31.setEnabled(value);
        button32.setEnabled(value);
        button33.setEnabled(value);
        button34.setEnabled(value);
        button40.setEnabled(value);
        button41.setEnabled(value);
        button42.setEnabled(value);
        button43.setEnabled(value);
        button44.setEnabled(value);
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
        button03.setText("");
        button04.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button13.setText("");
        button14.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        button23.setText("");
        button24.setText("");
        button30.setText("");
        button31.setText("");
        button32.setText("");
        button33.setText("");
        button34.setText("");
        button40.setText("");
        button41.setText("");
        button42.setText("");
        button43.setText("");
        button44.setText("");

        enableAllButtons(true);

        playerX = true; //Initializing again
        turnCount = 0;  //reset number of turns back to zero

        initializeGameBoardStatus();

        setGameStateInfo("Start Again!");

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void setGameStateInfo(String text) {
        gameStateInfo.setText(text);
    }

    private void initializeGameBoardStatus() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoardStatus[i][j] = -1;

            }
        }
    }
}
