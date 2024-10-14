import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1; // Generate number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The number was " + numberToGuess + ".");
            }

            // Calculate score based on attempts used
            totalScore += guessedCorrectly ? (MAX_ATTEMPTS - attempts) : 0;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}