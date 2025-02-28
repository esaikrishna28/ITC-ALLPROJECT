package webdriveruniversity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;

public class Filewriteclass {

    private static final String FILE_PATH = "/home/zadmin/Desktop/TESTNG/TestNGProject/milestonewrite.txt"; // Update with your path

    @Test
    public void runmenthod() {
        writeToFile("scbiudb");
        writeToFile("Here is the list of string");
        writeToFile("chjbysdgbch");
    }

    // Function to write content to a Notepad file (appending each time)
    public void writeToFile(String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH, true)); // Append mode
            writer.write(content);
            writer.newLine(); // Add a new line after writing
            System.out.println("Successfully wrote to the file: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close(); // Close the writer
                }
            } catch (IOException e) {
                System.err.println("Failed to close the writer: " + e.getMessage());
            }
        }
    }
}
