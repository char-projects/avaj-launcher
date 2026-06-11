import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
    private static void printParsedLine (String[] line) {
        String[] aircrafts = {"TYPE", "NAME", "LONGITUDE", "LATITUDE", "HEIGHT"};
        for (int i = 0; i < line.length; i++) {
            System.out.print(aircrafts[i] + ": " + line[i] + "  "); 
        }
        System.out.println();
    }

    private static void parseFirstInputLine (String firstLine) {
        try {
            Integer.parseInt(firstLine);
            System.out.println("The simulation will run " + firstLine + " times");
        } catch (NumberFormatException nfe) {
            System.out.println("The first line of the file should (only) contain a positive integer");
        }
    }

    private static void parseInput(int lineNumber, String input) {
        String[] splitInput = input.split(" ");
        if (splitInput.length == 5) {
            try {
                for (int i = 0; i < splitInput.length; i++) {
                    if (i > 1) {
                        Integer.parseInt(splitInput[i]);
                        
                    }
                }
                Simulation.printParsedLine(splitInput);
            } catch (NumberFormatException nfe) {
                System.out.println("The coordinates in line " + lineNumber + " have to be numeric");
            }
        } else {
            System.out.println("Wrong number of arguments in line " + lineNumber);
        }
    }

    private static void readInputFile(String filename) {
        // Check if input file exists
        File myObj = new File(filename);
        try (Scanner myReader = new Scanner(myObj)) {
            // Read the file line by line
            if (myReader.hasNextLine()) {
                String input = myReader.nextLine();
                Simulation.parseFirstInputLine(input);
            }
            int i = 2;
            while (myReader.hasNextLine()) {
                String input = myReader.nextLine();
                Simulation.parseInput(i, input);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }
    }

    private static void createSimulationFile() {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt");
            myWriter.write("Test test test");
            myWriter.close();
            System.out.println("Successfully wrote to the output file!!");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // Main function
    public static void main(String[] args) {
        if (args.length == 1) {
            Simulation.readInputFile(args[0]);
            Simulation.createSimulationFile();
        } else {
            System.out.println("Wrong number of arguments");
        }
    }
}