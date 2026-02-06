import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to the Guessing App");

        while (playAgain) {

            GameConfig obj = new GameConfig();
            obj.showRules();

            System.out.print("Enter player name: ");
            String playerName = sc.nextLine();

            int attempts = 0;
            int hintCount = 0;
            boolean isWon = false;


            while (attempts < obj.getMaxAttempts()) {

                try {
                    System.out.print("Enter your guess: ");

                    int guess = InputHandler.getValidInput(sc, obj.getMax_Num(), obj.getMin_Num());
                    attempts++;
                    String result = GuessValidator.ValidateGuess(guess, obj.getTargetNumber());

                    if ("CORRECT".equals(result)) {
                        System.out.println(" Correct Guess!");
                        isWon = true;
                        break;
                    }

                    hintCount++;
                    System.out.println(result);
                    System.out.println(HintService.generateHint(obj.getTargetNumber(), hintCount));

                }
                catch (InvalidGuessException e) {
                    System.out.println(e.getMessage());
                    GameLogger.logInvalidAttempt(e.getMessage());
                }
            }


            String resultStatus = isWon ? "WIN" : "LOSS";

            GameResult result = new GameResult(playerName, attempts, resultStatus);

            GameResultService.saveResult(result);

            System.out.println("\n========== GAME SUMMARY ==========");
            System.out.println("Player: " + playerName);
            System.out.println("Result: " + resultStatus);
            System.out.println("Attempts used: " + attempts);
            System.out.println("Correct number: " + obj.getTargetNumber());
            System.out.println("Invalid attempts: " + GameLogger.getInvalidAttempts());

            GameResultService.showPreviousResults();


            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\nThank you for playing! Exiting gracefully...");
    }
}
