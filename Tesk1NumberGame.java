import java.util.Scanner;

public class Tesk1NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playAgain = playOneRound(scanner);

            System.out.print("Play again Press yes else no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    public static boolean playOneRound(Scanner scanner) {
        // Step 1: Generate a random number within the specified range
        int secretNumber = (int) (Math.random() * 100) + 1;

        // Initialize variables
        int attempts = 0;
        int maxAttempts = 10;

        // Step 2 and 3: Prompt user for guesses and provide feedback
        while (attempts < maxAttempts) {
            System.out.printf("Attempt %d/%d. Guess the number (between 1 and 100): ", attempts + 1, maxAttempts);
            int userGuess = scanner.nextInt();

            if (userGuess == secretNumber) {
                System.out.printf("Congratulations! You've guessed the number %d in %d attempts.%n", secretNumber, attempts + 1);
                return true;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Guess again.");
            } else {
                System.out.println("Too high! Guess again.");
            }

            attempts++;
        }

        System.out.printf("Sorry, you've run out of attempts. The number was %d.%n", secretNumber);
        return false;
    }
}
