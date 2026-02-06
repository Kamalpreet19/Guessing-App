import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing App");

        GameConfig obj = new GameConfig();
        obj.showRules();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        int hintCount = 0;

        while (attempts < obj.getMaxAttempts()) {
            try {
                System.out.print("Enter your guess: ");
                int guess = InputHandler.getValidInput(sc, obj.getMax_Num(), obj.getMin_Num());

                attempts++;
                String result = GuessValidator.ValidateGuess(guess, obj.getTargetNumber());

                if ("CORRECT".equals(result)) {
                    System.out.println("Correct Guess!");
                    break;
                }

                hintCount++;

                System.out.println(result);
                System.out.println(HintService.generateHint(obj.getTargetNumber(), hintCount));

            }
            catch (InvalidGuessException e) {
                System.out.println(e.getMessage());
                GameLogger.logInvalidAttempt(e.getMessage());
                continue;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("The correct number was: " + obj.getTargetNumber());
        System.out.println("Invalid attempts: " + GameLogger.getInvalidAttempts());

    }
}
