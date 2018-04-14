package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class _1P_3by3 extends AppCompatActivity implements View.OnClickListener {
    private static List<Cell> ALL_CELLS = new ArrayList<>(9);

    static {
        ALL_CELLS.add(new Cell(0, 0));
        ALL_CELLS.add(new Cell(0, 1));
        ALL_CELLS.add(new Cell(0, 2));
        ALL_CELLS.add(new Cell(1, 0));
        ALL_CELLS.add(new Cell(1, 1));
        ALL_CELLS.add(new Cell(1, 2));
        ALL_CELLS.add(new Cell(2, 0));
        ALL_CELLS.add(new Cell(2, 1));
        ALL_CELLS.add(new Cell(2, 2));
    }

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
    private String playerMarker, computerMarker;
    private boolean playerTurn = true;
    private boolean quit = false;

    private Set<Cell> selectedCells = new HashSet<>(9);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__1p_3by3);

        int option = getIntent().getIntExtra(_2P_MarkerSelection.OPTION, 0);
        playerMarker = option == 0 ? "X" : "O";
        computerMarker = playerMarker.equals("X") ? "O" : "X";

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

    private void playerSelectCell(Cell cell, Button button) {
        if (!playerTurn) return;

        button.setText(playerMarker);
        gameBoardStatus[cell.getX()][cell.getY()] = playerMarker.equals("X") ? 1 : 0;
        selectedCells.add(cell);
        button.setEnabled(false);
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

            case R.id.button10:
                playerSelectCell(new Cell(1, 0), button10);
                break;

            case R.id.button11:
                playerSelectCell(new Cell(1, 1), button11);
                break;

            case R.id.button12:
                playerSelectCell(new Cell(1, 2), button12);
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
        playerTurn = !playerTurn;

        setGameStateInfo((playerTurn)
                ? "Your turn"
                : "Computer's turn");

        if (turnCount == 9) {
            ScoreStore.draws++;
            result("The game is a DRAW!");
        }
        boolean gameWon = checkForWinner();

        // computer selection
        if (!gameWon && !playerTurn)
            computerSelectCell();
    }

    private void computerSelectCell() {
        if (playerTurn) return;

        gameStateInfo.postDelayed(new Runnable() {
            @Override
            public void run() {
                Set<Integer> tried = new HashSet<>();
                for (; ; ) {

                    if (selectedCells.size() == ALL_CELLS.size())
                        break;

                    int next = 1 + new Random(System.currentTimeMillis()).nextInt(8);
                    if (tried.contains(next))
                        continue;

                    tried.add(next);
                    Cell nextCell = ALL_CELLS.get(next);
                    if (selectedCells.contains(nextCell))
                        continue;

                    Button button = getButtonForCell(nextCell);
                    if (button == null)
                        break;

                    selectedCells.add(nextCell);
                    button.setEnabled(false);
                    button.setText(computerMarker);
                    gameBoardStatus[nextCell.getX()][nextCell.getY()] = computerMarker.equals("X") ? 1 : 0;

                    break;
                }

                nextTurn();
            }
        }, 750);
    }

    @Nullable
    private Button getButtonForCell(Cell cell) {
        if (cell.getX() == 0 && cell.getY() == 0) {
            return button00;
        } else if (cell.getX() == 0 && cell.getY() == 1) {
            return button01;
        } else if (cell.getX() == 0 && cell.getY() == 2) {
            return button02;
        } else if (cell.getX() == 1 && cell.getY() == 0) {
            return button10;
        } else if (cell.getX() == 1 && cell.getY() == 1) {
            return button11;
        } else if (cell.getX() == 1 && cell.getY() == 2) {
            return button12;
        } else if (cell.getX() == 2 && cell.getY() == 0) {
            return button20;
        } else if (cell.getX() == 2 && cell.getY() == 1) {
            return button21;
        } else if (cell.getX() == 2 && cell.getY() == 2) {
            return button22;
        }
        return null;
    }

    private boolean checkForWinner() {
        for (int i = 0; i < 3; i++) {
            if (gameBoardStatus[i][0] == gameBoardStatus[i][1] && gameBoardStatus[i][0] == gameBoardStatus[i][2]) {
                if (gameBoardStatus[i][0] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!\n" + "\t \t \t row " + (i + 1));
                    return true;
                } else if (gameBoardStatus[i][0] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!\n" + "\t \t \t row " + (i + 1));
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameBoardStatus[0][i] == gameBoardStatus[1][i] && gameBoardStatus[0][i] == gameBoardStatus[2][i]) {
                if (gameBoardStatus[0][i] == 1) {
                    ScoreStore.xWins++;
                    result("Winner : Player X!\n" + "\t column " + (i + 1));
                    return true;
                } else if (gameBoardStatus[0][i] == 0) {
                    ScoreStore.oWins++;
                    result("Winner : Player O!\n" + "\t column " + (i + 1));
                    return true;
                }
            }
        }
        if (gameBoardStatus[0][0] == gameBoardStatus[1][1] && gameBoardStatus[0][0] == gameBoardStatus[2][2]) {
            if (gameBoardStatus[0][0] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tFirst Diagonal");
                return true;
            } else if (gameBoardStatus[0][0] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tFirst Diagonal");
                return true;
            }
        }
        if (gameBoardStatus[0][2] == gameBoardStatus[1][1] && gameBoardStatus[0][2] == gameBoardStatus[2][0]) {
            if (gameBoardStatus[0][2] == 1) {
                ScoreStore.xWins++;
                result("Winner : Player X!\n \t \tSecond Diagonal");
                return true;
            } else if (gameBoardStatus[0][2] == 0) {
                ScoreStore.oWins++;
                result("Winner : Player O!\n \t \tSecond Diagonal");
                return true;
            }
        }

        return false;
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
        selectedCells.clear();

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

        playerTurn = true;
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
