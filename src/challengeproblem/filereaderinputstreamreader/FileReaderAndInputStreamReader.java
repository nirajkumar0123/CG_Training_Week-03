package challengeproblem.filereaderinputstreamreader;

import java.io.*;

public class FileReaderAndInputStreamReader {
    public static void countWordsUsingFileReader(String filePath) {
        int count = 0;
        long startTime = System.nanoTime();//start time
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {

            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();//end time
        System.out.println("Count of Words is: " + count);
        System.out.println("Time taken by FileReader: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void countWordsUsingInputStreamReader(String filePath) {
        int count = 0;
        long startTime = System.nanoTime();//start time
        try (FileInputStream fi = new FileInputStream(filePath);
             InputStreamReader ir = new InputStreamReader(fi, "UTF-8");
             BufferedReader br = new BufferedReader(ir)) {

            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();//end time
        System.out.println("Time taken by InputStreamReader: " + (endTime - startTime) / 1_000_000 + " ms");
        System.out.println("Count of Words is: " + count);
    }

    public static void main(String[] args) {
        String filePath = "src/challengeproblem/filereaderinputstreamreader/output.txt";
        countWordsUsingFileReader(filePath);
        System.out.println("----------------");
        countWordsUsingInputStreamReader(filePath);
    }
}
