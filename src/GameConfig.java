import java.util.Random;

public class GameConfig {
    private final int Max_Num=100;
    private final int Min_Num=1;
    private final int hints =3;
    private final int maxAttempts=7;


    int targetNumber;


    public GameConfig() {
        Random rand = new Random();
        this.targetNumber = rand.nextInt(Max_Num - Min_Num) + Min_Num;

    }


    public int getMaxAttempts(){
        return maxAttempts;
    }

    public int gethints(){
        return hints;
    }

    public int getTargetNumber(){
        return targetNumber;
    }


    public void showRules(){
        System.out.println("Guess a number between " + Min_Num + " and " + Max_Num);
        System.out.println("You have " + maxAttempts + " attempts");
        System.out.println("Hints will be provided after wrong guesses.");
    }




}
