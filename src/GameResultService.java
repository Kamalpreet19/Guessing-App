import java.io.*;

public class GameResultService {

    private static final String FILE_NAME = "game_results.txt";

    public static void saveResult(GameResult result) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(result.toFileFormat());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving game result.");
        }
    }


    public static void showPreviousResults() {

        System.out.println("\nPrevious Game Records:");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("No previous records found.");
        }
    }
}
