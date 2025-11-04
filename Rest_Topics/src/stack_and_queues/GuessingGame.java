package stack_and_queues;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

        public static void main(String[] args) {
            final int MIN_RANGE = 1;
            final int MAX_RANGE = 100;
            final int MAX_ATTEMPTS = 7;


            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int secretNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;

            boolean hasGuessedCorrectly = false;

            System.out.println("--- Welcome to Guess the Number! ---");
            System.out.println("I'm thinking of a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");
            System.out.println("--------------------------------------");

            for (int attempts = 1; attempts <= MAX_ATTEMPTS; attempts++) {
                System.out.print("Attempt #" + attempts + ": Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a whole number.");
                    scanner.next();
                    attempts--;
                    continue;
                }

                int playerGuess = scanner.nextInt();

                // --- Compare the guess to the secret number ---
                if (playerGuess < secretNumber) {
                    System.out.println("Too low!");
                } else if (playerGuess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("🎉 Congratulations, Harsh! You've guessed the number!");
                    System.out.println("The secret number was indeed " + secretNumber + ".");
                    System.out.println("You guessed it in " + attempts + " attempts.");
                    break;
                }

                int attemptsLeft = MAX_ATTEMPTS - attempts;
                if (attemptsLeft > 0) {
                    System.out.println("You have " + attemptsLeft + " attempts left.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("--------------------------------------");
                System.out.println("Sorry, you've run out of attempts.");
                System.out.println("Game over! The secret number was " + secretNumber + ".");
            }

            scanner.close();
        }


}
