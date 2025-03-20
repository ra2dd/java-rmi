package lab2_ttt.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class TicTacToe {
    public String X = "X";
    public String O = "O";
    private String EMPTY = null;
    private int boardSize = 3;
    public String[][] board;
    public String turn;


    public TicTacToe() {
        String[][] initialState = {
            {this.EMPTY, this.EMPTY, this.EMPTY},
            {this.EMPTY, this.EMPTY, this.EMPTY},
            {this.EMPTY, this.EMPTY, this.EMPTY}
        };
        this.board = initialState;
        this.turn = this.X;
    }


    private HashSet<List<Integer>> avaliableActions() {
        HashSet<List<Integer>> actions = new HashSet<List<Integer>>();
        for (int row = 0; row < this.boardSize; row++) {
            for (int col = 0; col < this.boardSize; col++) {
                if (this.board[row][col] != this.X 
                        && this.board[row][col] != this.O 
                        && this.board[row][col] == this.EMPTY) {
                    List<Integer> action = Arrays.asList(row, col);
                    actions.add(action);
                }
            }
        }
        return actions;
    }


    public String getAvailableActions() {
        String ac = "";
        HashSet<List<Integer>> actions = this.avaliableActions();
        for (List<Integer> action: actions) {
            for (Integer place: action) {
                ac += place;
            }
            ac += " ";
        }
        return ac + "\n";
    }


    public String getBoard() {
        String bd = "";
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                bd += this.board[i][j] == this.EMPTY ? " " : this.board[i][j];
                if (j < this.board[i].length - 1) {
                    bd += " | ";
                }
            }
            bd += "\n";
            if (i < this.board.length - 1) {
                bd += "---------\n";
            }
        }
        return bd;
    }


    public void printBoard() {
        System.out.println(this.getBoard());
    }


    private boolean moveValid(String player, List<Integer> move) {
        if (player != this.X && player != this.O) {
            return false;
        }

        if (this.turn != player) {
            return false;
        }

        if (move.size() != 2) {
            return false;
        }

        if (!(move.get(0) instanceof Integer)
                || !(move.get(1) instanceof Integer)) {
            return false;
        }

        if (this.avaliableActions().contains(move)) {
            return true;
        } else {
            return false;
        }
    }

    
    public boolean makeMove(String player, List<Integer> move) {
        // Check if move is valid
        if (this.moveValid(player, move) == false) {
            return false;
        }

        // Make move on board
        this.board[move.get(0)][move.get(1)] = player;
        
        // Set next player turn
        if (player == this.X) {
            this.turn = this.O;
        } else if (player == this.O) {
            this.turn = this.X;
        }

        return true;
    }


    public String checkWinner() {
        // Check cols
        for (String[] row: this.board) {
            String last_figure = "no_figure";
            int win_counter = 0;
            for (String col: row) {
                if (last_figure == col && col != null) {
                    win_counter += 1;
                }

                if (win_counter == 2) {
                    return col;
                }

                last_figure = col;
            }
        }

        // Check rows
        for (int row = 0; row < this.boardSize; row++) {
            String last_figure = "no_figure";
            int win_counter = 0;
            for (int col = 0; col < this.boardSize; col++) {
                if (last_figure == this.board[col][row] 
                        && this.board[col][row] != null) {
                    win_counter += 1;
                }

                if (win_counter == 2) {
                    return this.board[col][row];
                }

                last_figure = this.board[col][row];
            }
        }
        
        // Check diagonals
        if (this.board[0][0] == this.board[1][1] 
                && this.board[0][0] == this.board[2][2] 
                && this.board[0][0] != null) {
            return this.board[0][0];
        }
        if (this.board[2][0] == this.board[1][1] 
                && this.board[2][0] == this.board[0][2] 
                && this.board[2][0] != null) {
            return this.board[2][0];
        }

        return null;
    }


    public boolean checkNoActions() {
        if (this.avaliableActions().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
