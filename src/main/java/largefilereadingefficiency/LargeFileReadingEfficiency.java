package largefilereadingefficiency;

import java.io.*;

public class LargeFileReadingEfficiency {
    static void readUsingFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {

            while (br.readLine() != null) {
            }
        } catch (IOException e) {
            System.out.println("Error while reading file " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("FileReader Time: " + (endTime - startTime) + " ms");
    }

    static void readUsingInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileInputStream fi = new FileInputStream(filePath);
             InputStreamReader ir = new InputStreamReader(fi, "UTF-8");
             BufferedReader br = new BufferedReader(ir)) {

            while (br.readLine() != null) {
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        String file1MB = "src/main/java/largefilereadingefficiency/output1mb.txt";
        String file100MB = "src/main/java/largefilereadingefficiency/output100.txt";
        String file500MB = "src/main/java/largefilereadingefficiency/output500.txt";

        System.out.println("\nReading 1MB File:");
        readUsingFileReader(file1MB);
        readUsingInputStreamReader(file1MB);

        System.out.println("\nReading 100MB File:");
        readUsingFileReader(file100MB);
        readUsingInputStreamReader(file100MB);

        System.out.println("\nReading 500MB File:");
        readUsingFileReader(file500MB);
        readUsingInputStreamReader(file500MB);
    }
}
