package inputstreamreader.convertbytestreamtocharstream;

import java.io.*;

public class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with your file path

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
