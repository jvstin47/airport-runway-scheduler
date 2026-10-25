// Module: File Handling & Testing (Devika Suresh)
// Saves runway operations to a text file for permanent logging

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_NAME = "runway_log.txt";

    // Appends a new runway event to runway_log.txt
    public static boolean saveLog(String logEntry) {
        try {
            // 'true' allows appending to the file without overwriting past history
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
