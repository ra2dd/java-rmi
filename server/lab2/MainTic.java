package lab2;

import java.util.List;
import java.util.Arrays;

import lab2.models.TicTacToe;

public class MainTic {
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();

        System.out.println("Turn: " + ttt.turn);
        ttt.printBoard();
        List<Integer> move = Arrays.asList(0, 1);
        System.out.println("Move valid: " + ttt.makeMove(ttt.X, move));

        System.out.println("Turn: " + ttt.turn);
        ttt.printBoard();
        System.out.println("Actions:");
        ttt.displayAvailableActions();
    }
}
