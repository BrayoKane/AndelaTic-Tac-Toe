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

import butterknife.BindView;
import butterknife.ButterKnife;

public class _2P_5by5 extends AppCompatActivity implements View.OnClickListener {
    boolean playerX = true;
    int turnCount = 0;

    @BindView(R.id.button00)
    Button button00;
    @BindView(R.id.button01)
    Button button01;
    @BindView(R.id.button02)
    Button button02;
    @BindView(R.id.button03)
    Button button03;
    @BindView(R.id.button04)
    Button button04;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button12)
    Button button12;
    @BindView(R.id.button13)
    Button button13;
    @BindView(R.id.button14)
    Button button14;
    @BindView(R.id.button20)
    Button button20;
    @BindView(R.id.button21)
    Button button21;
    @BindView(R.id.button22)
    Button button22;
    @BindView(R.id.button23)
    Button button23;
    @BindView(R.id.button24)
    Button button24;
    @BindView(R.id.button30)
    Button button30;
    @BindView(R.id.button31)
    Button button31;
    @BindView(R.id.button32)
    Button button32;
    @BindView(R.id.button33)
    Button button33;
    @BindView(R.id.button34)
    Button button34;
    @BindView(R.id.button40)
    Button button40;
    @BindView(R.id.button41)
    Button button41;
    @BindView(R.id.button42)
    Button button42;
    @BindView(R.id.button43)
    Button button43;
    @BindView(R.id.button44)
    Button button44;

    @BindView(R.id.resetButton)
    Button buttonReset;
    @BindView(R.id.quitButton)
    Button buttonQuit;
    @BindView(R.id.infoGameState)
    TextView gameStateInfo;

    int[][] gameBoardStatus = new int[5][5];
    int unicodeW = 0x1F60A;
    int unicodeD = 0x1F61B;
    String emojiWin = getEmojiByUnicodeW(unicodeW);
    String emojiDraw = getEmojiByUnicodeD(unicodeD);

    private boolean quit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__2p_5by5);

        int option = getIntent().getIntExtra(_2P_MarkerSelection.OPTION, 0);
        playerX = option == 0;

        ButterKnife.bind(this);

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

    private void playerSelectCell(Cell cell, Button button) {
        button.setEnabled(false);
        if (playerX) {
            button.setText("X");
            gameBoardStatus[cell.getX()][cell.getY()] = 1;
        } else {
            button.setText("O");
            gameBoardStatus[cell.getX()][cell.getY()] = 0;
        }
        nextTurn();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button00:
                playerSelectCell(new Cell(0, 0), button00);
                break;

            case R.id.button01:
                playerSelectCell(new Cell(0, 1), button01);
                break;

            case R.id.button02:
                playerSelectCell(new Cell(0, 2), button02);
                break;

            case R.id.button03:
                playerSelectCell(new Cell(0, 3), button03);
                break;

            case R.id.button04:
                playerSelectCell(new Cell(0, 4), button04);
                break;

            case R.id.button10:
                playerSelectCell(new Cell(1, 0), button10);
                break;

            case R.id.button11:
                playerSelectCell(new Cell(1, 1), button11);
                break;

            case R.id.button12:
                playerSelectCell(new Cell(1, 2), button12);
                break;

            case R.id.button13:
                playerSelectCell(new Cell(1, 3), button13);
                break;

            case R.id.button14:
                playerSelectCell(new Cell(1, 4), button14);
                break;

            case R.id.button20:
                playerSelectCell(new Cell(2, 0), button20);
                break;

            case R.id.button21:
                playerSelectCell(new Cell(2, 1), button21);
                break;

            case R.id.button22:
                playerSelectCell(new Cell(2, 2), button22);
                break;

            case R.id.button23:
                playerSelectCell(new Cell(2, 3), button23);
                break;

            case R.id.button24:
                playerSelectCell(new Cell(2, 4), button24);
                break;

            case R.id.button30:
                playerSelectCell(new Cell(3, 0), button30);
                break;

            case R.id.button31:
                playerSelectCell(new Cell(3, 1), button31);
                break;

            case R.id.button32:
                playerSelectCell(new Cell(3, 2), button32);
                break;

            case R.id.button33:
                playerSelectCell(new Cell(3, 3), button33);
                break;

            case R.id.button34:
                playerSelectCell(new Cell(3, 4), button34);
                break;

            case R.id.button40:
                playerSelectCell(new Cell(4, 0), button40);
                break;

            case R.id.button41:
                playerSelectCell(new Cell(4, 1), button41);
                break;

            case R.id.button42:
                playerSelectCell(new Cell(4, 2), button42);
                break;

            case R.id.button43:
                playerSelectCell(new Cell(4, 3), button43);
                break;

            case R.id.button44:
                playerSelectCell(new Cell(4, 4), button44);
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
                buttonQuit.postDelayed(() -> quit = false, 1000);
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
        if (turnCount == 25 && !checkForWinner()) {
            ScoreStore.draws++;
            result("The game is a DRAW!" + emojiDraw);
        }
        checkForWinner();
    }

    public String getEmojiByUnicodeW(int unicodeW) {
        return new String(Character.toChars(unicodeW));
    }

    public String getEmojiByUnicodeD(int unicodeD) {
        return new String(Character.toChars(unicodeD));
    }

    private boolean checkForWinner() {
        for (int i = 0; i < 5; i++) {
            if (gameBoardStatus[i][0] == gameBoardStatus[i][1] && gameBoardStatus[i][0] == gameBoardStatus[i][2] && gameBoardStatus[i][0] == gameBoardStatus[i][3] && gameBoardStatus[i][0] == gameBoardStatus[i][4]) {
                if (gameBoardStatus[i][0] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!" + emojiWin + "\n" + "\t \t \t row " + (i + 1));
                    return true;
                } else if (gameBoardStatus[i][0] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!" + emojiWin + "\n" + "\t \t \t row " + (i + 1));
                    return true;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (gameBoardStatus[0][i] == gameBoardStatus[1][i] && gameBoardStatus[0][i] == gameBoardStatus[2][i] && gameBoardStatus[0][i] == gameBoardStatus[3][i] && gameBoardStatus[0][i] == gameBoardStatus[4][i]) {
                if (gameBoardStatus[0][i] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!" + emojiWin + "\n" + "\t column " + (i + 1));
                    return true;
                } else if (gameBoardStatus[0][i] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!" + emojiWin + "\n" + "\t column " + (i + 1));
                    return true;
                }
            }
        }
        if (gameBoardStatus[0][0] == gameBoardStatus[1][1] && gameBoardStatus[0][0] == gameBoardStatus[2][2] && gameBoardStatus[0][0] == gameBoardStatus[3][3] && gameBoardStatus[0][0] == gameBoardStatus[4][4]) {
            if (gameBoardStatus[0][0] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!" + emojiWin + "\n \t \tFirst Diagonal");
                return true;
            } else if (gameBoardStatus[0][0] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!" + emojiWin + "\n \t \tFirst Diagonal");
                return true;
            }
        }
        if (gameBoardStatus[0][4] == gameBoardStatus[1][3] && gameBoardStatus[0][4] == gameBoardStatus[2][2] && gameBoardStatus[0][4] == gameBoardStatus[3][1] && gameBoardStatus[0][4] == gameBoardStatus[4][0]) {
            if (gameBoardStatus[0][4] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!" + emojiWin + "\n \t \tSecond Diagonal");
                return true;
            } else if (gameBoardStatus[0][4] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!" + emojiWin + "\n \t \tSecond Diagonal");
                return true;
            }
        }
        return false;
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
        final ViewGroup nullParent = null;
        View v = getLayoutInflater().inflate(R.layout.view_score_sheet, nullParent);
        final TextView xWin = v.findViewById(R.id.x_win);
        final TextView oWin = v.findViewById(R.id.o_win);
        final TextView draw = v.findViewById(R.id.draw);
        ImageButton close = v.findViewById(R.id.close_button);
        Button reset = v.findViewById(R.id.resetScores);

        xWin.setText(String.valueOf(ScoreStore.xWins));
        oWin.setText(String.valueOf(ScoreStore.oWins));
        draw.setText(String.valueOf(ScoreStore.draws));
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(v)
                .create();
        dialog.show();

        reset.setOnClickListener(view1 -> {
            ScoreStore.xWins = 0;
            ScoreStore.oWins = 0;
            ScoreStore.draws = 0;
            xWin.setText(String.valueOf(ScoreStore.xWins));
            oWin.setText(String.valueOf(ScoreStore.oWins));
            draw.setText(String.valueOf(ScoreStore.draws));
        });

        close.setOnClickListener(view12 -> dialog.dismiss());
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

        setGameStateInfo("Play Again!");

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

    @Override
    protected void onDestroy() {
        final ViewGroup nullParent = null;
        View v = getLayoutInflater().inflate(R.layout.view_score_sheet, nullParent);
        TextView xWin = v.findViewById(R.id.x_win);
        TextView oWin = v.findViewById(R.id.o_win);
        TextView draw = v.findViewById(R.id.draw);

        ScoreStore.xWins = 0;
        ScoreStore.oWins = 0;
        ScoreStore.draws = 0;
        xWin.setText(String.valueOf(ScoreStore.xWins));
        oWin.setText(String.valueOf(ScoreStore.oWins));
        draw.setText(String.valueOf(ScoreStore.draws));
        super.onDestroy();
    }
}
