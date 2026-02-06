import java.util.Scanner;

public class InputHandler {
    public static int getValidInput(Scanner sc,int max, int min) throws InvalidGuessException {
        if(!sc.hasNextInt()){
            sc.next();
            throw new InvalidGuessException("Invalid input! Enter numeric value only");
        }

        int guess=sc.nextInt();

        if(guess<min || guess>max){
            throw new InvalidGuessException("Enter number between " + min + " and " + max);
        }

        return guess;
    }
}
