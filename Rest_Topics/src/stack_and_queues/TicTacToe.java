package stack_and_queues;

import java.util.Scanner;
import java.util.InputMismatchException;


public class TicTacToe {

    private static char[][] board = new char[3][3];

    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgainResponse;

        do {
            initializeBoard();
            currentPlayer = 'X';
            boolean gameIsOver = false;

            System.out.println("--- Welcome to Tic-Tac-Toe! ---");
            System.out.println("Player X starts. Enter a number from 1 to 9 to make your move.");

            while (!gameIsOver) {
                printBoard();
                playerMove(scanner);

                if (checkWinner()) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins! Congratulations!");
                    gameIsOver = true;
                }
                else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw! The game is over.");
                    gameIsOver = true;
                }
                else {
                    switchPlayer();
                }
            }

            // Ask the players if they want to play another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgainResponse = scanner.next();

        } while (playAgainResponse.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }


    public static void initializeBoard() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) (count + '0');
                count++;
            }
        }
    }


    public static void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }


    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void playerMove(Scanner scanner) {
        int move;
        while (true) {
            try {
                System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
                move = scanner.nextInt();

                if (move >= 1 && move <= 9) {
                    int row = (move - 1) / 3;
                    int col = (move - 1) % 3;

                    // Check if the chosen cell is already taken
                    if (board[row][col] == 'X' || board[row][col] == 'O') {
                        System.out.println("This position is already taken! Try again.");
                    } else {
                        board[row][col] = currentPlayer;
                        break; // Valid move, exit loop
                    }
                } else {
                    System.out.println("Invalid move! Please enter a number between 1 and 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
    }


    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }
}
