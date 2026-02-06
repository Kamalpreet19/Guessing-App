import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing App");

        GameConfig obj = new GameConfig();
        obj.showRules();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String playerName=sc.nextLine();

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


                System.out.println(HintService.generateHint(obj.getTargetNumber(), hintCount));
                System.out.println(result);

            }
            catch (InvalidGuessException e) {
                System.out.println(e.getMessage());
                GameLogger.logInvalidAttempt(e.getMessage());
                continue;
            }
        }

        String resultStatus = (attempts < obj.getMaxAttempts()) ? "WIN" : "LOSS";
        GameResult result = new GameResult(playerName, attempts, resultStatus);
        GameResultService.saveResult(result);


        System.out.println("\nGame Over!");
        System.out.println("The correct number was: " + obj.getTargetNumber());
        System.out.println("Invalid attempts: " + GameLogger.getInvalidAttempts());

    }
}
