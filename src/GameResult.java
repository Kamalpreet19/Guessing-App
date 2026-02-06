import java.sql.SQLOutput;

public class GameResult {
    private String playerName;
    private int attempts;
    private String result;


    public GameResult(String playerName, int attempts, String result){
        this.playerName=playerName;
        this.attempts=attempts;
        this.result=result;
    }

    public String toFileFormat(){
        return playerName + "," + attempts + "," + result;
    }
}
