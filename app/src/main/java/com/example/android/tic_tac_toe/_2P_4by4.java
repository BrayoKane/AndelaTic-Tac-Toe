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

public class _2P_4by4 extends AppCompatActivity implements View.OnClickListener {
    boolean PLAYER_X = true;
    int TURN_COUNT = 0;

    Button button00;
    Button button01;
    Button button02;
    Button button03;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button20;
    Button button21;
    Button button22;
    Button button23;
    Button button30;
    Button button31;
    Button button32;
    Button button33;

    Button buttonReset, buttonQuit;

    TextView tvState;

    int[][] boardStatus = new int[4][4];

    private boolean quit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__2p_4by4);

        int option = getIntent().getIntExtra(_2P_MarkerSelection.OPTION, 0);
        PLAYER_X = option == 0;

        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button03 = findViewById(R.id.button03);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        buttonReset = findViewById(R.id.resetButton);
        buttonQuit = findViewById(R.id.quitButton);
        tvState = findViewById(R.id.tvState);

        buttonQuit.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        button00.setOnClickListener(this);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button30.setOnClickListener(this);
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);

        initializeBoardStatus();
    }

    @Override
    public void onClick(View view) {
        boolean resetButtonPressed = false;

        switch (view.getId()) {
            case R.id.button00:
                if (PLAYER_X) {
                    button00.setText("X");
                    boardStatus[0][0] = 1;
                } else {
                    button00.setText("O");

                    boardStatus[0][0] = 0;
                }
                button00.setEnabled(false);
                break;

            case R.id.button01:
                if (PLAYER_X) {
                    button01.setText("X");
                    boardStatus[0][1] = 1;
                } else {
                    button01.setText("O");

                    boardStatus[0][1] = 0;
                }
                button01.setEnabled(false);
                break;

            case R.id.button02:
                if (PLAYER_X) {
                    button02.setText("X");
                    boardStatus[0][2] = 1;
                } else {
                    button02.setText("O");

                    boardStatus[0][2] = 0;
                }
                button02.setEnabled(false);
                break;

            case R.id.button03:
                if (PLAYER_X) {
                    button03.setText("X");
                    boardStatus[0][3] = 1;
                } else {
                    button03.setText("O");

                    boardStatus[0][3] = 0;
                }
                button03.setEnabled(false);
                break;

            case R.id.button10:
                if (PLAYER_X) {
                    button10.setText("X");
                    boardStatus[1][0] = 1;
                } else {
                    button10.setText("O");

                    boardStatus[1][0] = 0;
                }
                button10.setEnabled(false);
                break;

            case R.id.button11:
                if (PLAYER_X) {
                    button11.setText("X");
                    boardStatus[1][1] = 1;
                } else {
                    button11.setText("O");

                    boardStatus[1][1] = 0;
                }
                button11.setEnabled(false);
                break;

            case R.id.button12:
                if (PLAYER_X) {
                    button12.setText("X");
                    boardStatus[1][2] = 1;
                } else {
                    button12.setText("O");

                    boardStatus[1][2] = 0;
                }
                button12.setEnabled(false);
                break;

            case R.id.button13:
                if (PLAYER_X) {
                    button13.setText("X");
                    boardStatus[1][3] = 1;
                } else {
                    button13.setText("O");

                    boardStatus[1][3] = 0;
                }
                button13.setEnabled(false);
                break;

            case R.id.button20:
                if (PLAYER_X) {
                    button20.setText("X");
                    boardStatus[2][0] = 1;
                } else {
                    button20.setText("O");

                    boardStatus[2][0] = 0;
                }
                button20.setEnabled(false);
                break;

            case R.id.button21:
                if (PLAYER_X) {
                    button21.setText("X");
                    boardStatus[2][1] = 1;
                } else {
                    button21.setText("O");

                    boardStatus[2][1] = 0;
                }
                button21.setEnabled(false);
                break;

            case R.id.button22:
                if (PLAYER_X) {
                    button22.setText("X");
                    boardStatus[2][2] = 1;
                } else {
                    button22.setText("O");

                    boardStatus[2][2] = 0;
                }
                button22.setEnabled(false);
                break;

            case R.id.button23:
                if (PLAYER_X) {
                    button23.setText("X");
                    boardStatus[2][3] = 1;
                } else {
                    button23.setText("O");

                    boardStatus[2][3] = 0;
                }
                button23.setEnabled(false);
                break;

            case R.id.button30:
                if (PLAYER_X) {
                    button30.setText("X");
                    boardStatus[3][0] = 1;
                } else {
                    button30.setText("O");

                    boardStatus[3][0] = 0;
                }
                button30.setEnabled(false);
                break;

            case R.id.button31:
                if (PLAYER_X) {
                    button31.setText("X");
                    boardStatus[3][1] = 1;
                } else {
                    button31.setText("O");

                    boardStatus[3][1] = 0;
                }
                button31.setEnabled(false);
                break;

            case R.id.button32:
                if (PLAYER_X) {
                    button32.setText("X");
                    boardStatus[3][2] = 1;
                } else {
                    button32.setText("O");

                    boardStatus[3][2] = 0;
                }
                button32.setEnabled(false);
                break;

            case R.id.button33:
                if (PLAYER_X) {
                    button33.setText("X");
                    boardStatus[3][3] = 1;
                } else {
                    button33.setText("O");

                    boardStatus[3][3] = 0;
                }
                button33.setEnabled(false);
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
            TURN_COUNT++;
            PLAYER_X = !PLAYER_X;

            if (PLAYER_X) {
                setInfo("Player X's turn");
            }
            if (!PLAYER_X) {
                setInfo("Player O's turn");
            }
            if (TURN_COUNT == 16) {
                ScoreStore.draws++;
                result("The game is a DRAW!");
            }
            checkWinner();
        }
    }

    private void checkWinner() {
        for (int i = 0; i < 4; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2] && boardStatus[i][0] == boardStatus[i][3]) {
                if (boardStatus[i][0] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!\n" + "\t \t \t row " + (i + 1));
                    break;
                } else if (boardStatus[i][0] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!\n" + "\t \t \t row " + (i + 1));
                    break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i] && boardStatus[0][i] == boardStatus[3][i]) {
                if (boardStatus[0][i] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!\n" + "\t column " + (i + 1));
                    break;
                } else if (boardStatus[0][i] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!\n" + "\t column " + (i + 1));
                    break;
                }
            }
        }
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2] && boardStatus[0][0] == boardStatus[3][3]) {
            if (boardStatus[0][0] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tFirst Diagonal");
            } else if (boardStatus[0][0] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tFirst Diagonal");
            }
        }
        if (boardStatus[0][3] == boardStatus[1][2] && boardStatus[0][3] == boardStatus[2][1] && boardStatus[0][3] == boardStatus[3][0]) {
            if (boardStatus[0][3] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tSecond Diagonal");
            } else if (boardStatus[0][3] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tSecond Diagonal");
            }
        }
    }

    private void enableAllBoxes(boolean value) {
        button00.setEnabled(value);
        button01.setEnabled(value);
        button02.setEnabled(value);
        button03.setEnabled(value);
        button10.setEnabled(value);
        button11.setEnabled(value);
        button12.setEnabled(value);
        button13.setEnabled(value);
        button20.setEnabled(value);
        button21.setEnabled(value);
        button22.setEnabled(value);
        button23.setEnabled(value);
        button30.setEnabled(value);
        button31.setEnabled(value);
        button32.setEnabled(value);
        button33.setEnabled(value);
    }

    private void result(String winner) {
        setInfo(winner);
        enableAllBoxes(false);
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
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button13.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        button23.setText("");
        button30.setText("");
        button31.setText("");
        button32.setText("");
        button33.setText("");

        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;

        initializeBoardStatus();

        setInfo("Start Again!");

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text) {
        tvState.setText(text);
    }

    private void initializeBoardStatus() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boardStatus[i][j] = -1;

            }
        }
    }
}