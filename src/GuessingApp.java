import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");
        GameConfig obj=new GameConfig();
        obj.showRules();


        Scanner sc=new Scanner(System.in);
        int attempts=0;
        int hintCount=0;

        while(attempts<obj.getMaxAttempts()){
            System.out.print("Enter your guess: ");
            int guess=sc.nextInt();
            attempts++;

            String result=GuessValidator.ValidateGuess(guess, obj.getTargetNumber());


            if("CORRECT".equals(result)){
                System.out.println(result);
                break;
            }

            hintCount++;
            String hint=HintService.generateHint(obj.getTargetNumber(), hintCount);
                System.out.println(hint);

                System.out.println(result);
            }

        System.out.println();
        System.out.println("Game Over!");
        System.out.println("The correct number was: " +
                obj.getTargetNumber());

    }



    }

