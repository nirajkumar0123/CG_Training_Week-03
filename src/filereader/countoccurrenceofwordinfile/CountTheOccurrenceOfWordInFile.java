package filereader.countoccurrenceofwordinfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountTheOccurrenceOfWordInFile {
    public static void main(String[] args) {
        String filePath = "src/filereader/readfilelinebyline/abc.txt";
        String target = "Hello"; //how many times this word occurs in the file
        int count = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }
            System.out.println("Target Word " + target + " occurs: " + count + " times");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
