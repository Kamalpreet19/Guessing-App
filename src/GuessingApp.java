import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");
        GameConfig obj=new GameConfig();
        obj.showRules();


        Scanner sc=new Scanner(System.in);
        int attempts=0;

        while(attempts<obj.getMaxAttempts()){
            System.out.print("Enter your guess: ");
            int guess=sc.nextInt();
            attempts++;

            String result=GuessValidator.ValidateGuess(guess, obj.getTargetNumber());
            System.out.println(result);

            if("CORRECT".equals(result)){
                break;
            }
        }

    }
}
