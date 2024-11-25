import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            int lineCount = 0, wordCount = 0, charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                System.out.println("Content in file: ");

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();

                }
            } catch (IOException e) {
                System.out.println("Error opening file" + e.getMessage());
            }
            System.out.println("Summary of report: ");
            System.out.println("File name: " + file.getName());
            System.out.println("Line count: " + lineCount);
            System.out.println("Character count: " + charCount);
            System.out.println("Number of words: " + wordCount);
        } else {
            System.out.println("No file selected");
        }

    }
}
