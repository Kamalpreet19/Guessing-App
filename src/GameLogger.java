public class GameLogger {
    private static int invalidAttempts=0;

    public static void logInvalidAttempt(String message){
        invalidAttempts++;
        System.out.println("LOG: " + message);
    }

    public static int getInvalidAttempts(){
        return invalidAttempts;
    }



}
