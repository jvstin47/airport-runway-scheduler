import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_NAME = "runway_log.txt";

    public static boolean saveLog(String logEntry) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(logEntry + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
            return false;
        }
    }
}
