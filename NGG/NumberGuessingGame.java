import java.util.*;

public class NumberGuessingGame {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1;  // random number between 1 and 100

        System.out.println("Welcome to Number Guessing Game!\n");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.print("Enter your choice: ");

        int level = sc.nextInt();
        int chances;

        if (level == 1) {
            chances = 10;
            System.out.println("You selected Easy level. You have 10 chances.");
        } else if (level == 2) {
            chances = 5;
            System.out.println("You selected Medium level. You have 5 chances.");
        } else if (level == 3) {
            chances = 3;
            System.out.println("You selected Hard level. You have 3 chances.");
        } else {
            System.out.println("Invalid choice. Exiting game.");
            return;
        }

        int attempts = 0;
        boolean guessed = false;

        while (chances > 0) {
            System.out.print("\nEnter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("🎉 Congratulations! You guessed the correct number in " + attempts + " attempt(s).");
                guessed = true;
                break;
            } else if (guess > secretNumber) {
                System.out.println("❌ Incorrect! The number is less than " + guess + ".");
            } else {
                System.out.println("❌ Incorrect! The number is greater than " + guess + ".");
            }
            chances--;
            System.out.println("Remaining chances: " + chances);
        }

        if (!guessed) {
            System.out.println("\n😢 You've used all your chances. The correct number was: " + secretNumber);
        }

        sc.close();
    }
}
