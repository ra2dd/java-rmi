package lab2;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import lab2.models.TicTacToe;

public class MainTic {
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Tic Tac Toe.");

        while(true) {
            System.out.println("Turn: " + ttt.turn);
            ttt.printBoard();
            ttt.displayAvailableActions();

            System.out.println("Enter move: ");
            String moveInput = scanner.nextLine();
            List<Integer> move = Arrays.asList(
                Integer.parseInt(String.valueOf(moveInput.charAt(0))), 
                Integer.parseInt(String.valueOf(moveInput.charAt(1)))
            );

            if (ttt.makeMove(ttt.turn, move) == false) {
                System.out.println("You provided wrong move try again.");
                continue;
            } 

            if (ttt.checkWinner() == ttt.X) {
                ttt.printBoard();
                System.out.println(ttt.X + " won!");
                break;
            } else if (ttt.checkWinner() == ttt.O) {
                ttt.printBoard();
                System.out.println(ttt.O + " won!");
                break;
            }

            if (ttt.checkNoActions()) {
                ttt.printBoard();
                System.out.println("No more moves, end!");
                break;
            }

        }
        scanner.close();
    }
}
