import tictactoegame.TicTacToeGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            char currentPlayer = game.getCurrentPlayer();

            System.out.println("Current board:");
            printBoard(game);

            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                char winner = game.checkWin();
                if (winner != ' ') {
                    printBoard(game);
                    if (winner == 'D') {
                        System.out.println("It's a draw!");
                    } else {
                        System.out.println("Player " + winner + " wins!");
                    }
                    break;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    public static void printBoard(TicTacToeGame game) {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
}
