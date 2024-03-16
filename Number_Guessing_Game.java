import java.util.Random;
import java.util.Scanner;

public class Number_Guessing_Game {
    public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(max - min + 1) + min;
        int Attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + min + " and " + max + ". Can you guess it?");
        
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int Guess = scanner.nextInt();
            Attempts++;
            
            if (Guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (Guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number in " + Attempts + " attempts.");
            }
        }
        
        scanner.close();
    }
}
