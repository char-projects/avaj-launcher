package src;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
    private Logs logs = new Logs();
    private static WeatherTower tower;
    private static int numSimulations;
    
    private Simulation() {}

    public static void parseFirstInputLine (String firstLine) {
        try {
            Logs.log("The simulation will run " + firstLine + " times.\n");
            Simulation.numSimulations = Integer.parseInt(firstLine);
        } catch (NumberFormatException nfe) {
            System.out.println("The first line of the file should (only) contain a positive integer");
        }
    }

    public static void getAircrafts(String[] splitInput, int i) {
        try {
            Flyable aircraft = AircraftFactory.newAircraft(splitInput[0], splitInput[1], Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), Integer.parseInt(splitInput[4]));
            if (aircraft != null) {
                aircraft.registerTower(tower);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("The coordinates in line " + i + " have to be numeric");
        }
    }

    public static void parseInputLine(Scanner myReader) {
        int i = 2;
        while (myReader.hasNextLine()) {
            String input = myReader.nextLine();
            String[] splitInput = input.split(" ");
            if (splitInput.length == 5) {
                Simulation.getAircrafts(splitInput, i);
            } else {
                System.out.println("Wrong number of arguments in line " + i);
            }
            i++;
        }
    } 

    public static void readInputFile(String filename) {
        tower = new WeatherTower();
        // Check if input file exists
        File myObj = new File(filename);
        try (Scanner myReader = new Scanner(myObj)) {
            // Read the file line by line
            if (myReader.hasNextLine()) {
                String input = myReader.nextLine();
                Simulation.parseFirstInputLine(input);
            }
            Simulation.parseInputLine(myReader);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }
    }

    // Main function
    public static void main(String[] args) {
        if (args.length == 1) {
            Simulation simulation = new Simulation();
            Simulation.readInputFile(args[0]);
            for (int count = 0; count < Simulation.numSimulations; count++) {
                Logs.log(String.format("\nWeather change number %d\n", (count + 1)));
                tower.changeWeather();
            }
        } else {
            System.out.println("Wrong number of arguments");
        }
        Logs.closeOutputFile();
    }
}