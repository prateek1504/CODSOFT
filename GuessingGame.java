import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int score = 0;
        boolean continuePlaying = true;

        while (continuePlaying) {
            int numberToGuess = rand.nextInt(100) + 1;
            int tries = 0;
            int maxTries = 5;

            System.out.println("I've picked a number between 1 and 100. Can you guess what it is?");

            while (tries < maxTries) {
                System.out.print("Make your guess: ");

                // Validate input to ensure it's an integer
                while (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer between 1 and 100.");
                    input.next(); // Clear invalid input
                    System.out.print("Make your guess: ");
                }
                
                int playerGuess = input.nextInt();
                input.nextLine(); // Clear the newline character after the integer input

                tries++;

                if (playerGuess == numberToGuess) {
                    System.out.println("Well done! You've guessed the number " + numberToGuess + " in " + tries + " tries.");
                    score++;
                    break;
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again!");
                } else {
                    System.out.println("Your guess is too high. Try again!");
                }
            }

            if (tries == maxTries) {
                System.out.println("You've used all your attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Would you like to play another round? (yes/no): ");
            String response = input.nextLine().trim();
            continuePlaying = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + score);

        input.close();
    }
}
