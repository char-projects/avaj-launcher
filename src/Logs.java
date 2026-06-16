package src;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Logs {
    private static BufferedWriter bw;
    private static File outputFile;

    Logs() {
        try {
            outputFile = new File("simulation.txt");
            outputFile.delete();
            if (bw == null) {
                bw = new BufferedWriter(new FileWriter(outputFile, true));
            }
        } catch (IOException e) {
            System.out.println("Error creating simulation.txt");
        }
    }

    public static void log(String output) {
        try {
            bw.write(output);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to simulation.txt");
        }
    }

    public static void closeOutputFile() {
        try {
            if (bw != null) {
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing simulation.txt");
        }
    }
}