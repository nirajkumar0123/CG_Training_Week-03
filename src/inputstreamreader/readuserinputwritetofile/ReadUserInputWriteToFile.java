package inputstreamreader.readuserinputwritetofile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputWriteToFile {
    public static void main(String[] args) {
        String filePath = "src/inputstreamreader/readuserinputwritetofile/output.txt";

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) { // FileWriter for writing to file

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) { // Read user input
                fw.write(input + "\n"); // Write input to file with newline
            }

            System.out.println("User input successfully written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
