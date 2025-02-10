package largefilereadingefficiency;

import java.io.*;

public class LargeFileGenerator {
    public static void main(String[] args) {
        String filePath = "src/main/java/largefilereadingefficiency/output1mb.txt";
        long fileSizeInMB = 1; // Target size in MB
        long fileSizeInBytes = fileSizeInMB * 1024 * 1024; // Convert MB to Bytes
        String sampleText = "This is a sample line of text for testing purposes 500 mb.\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            long currentSize = 0;
            while (currentSize < fileSizeInBytes) {
                writer.write(sampleText);
                currentSize += sampleText.length();
            }
            System.out.println("File created: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
