package src;
import src.weather.WeatherTower;
import src.aircraft.AircraftFactory;
import src.aircraft.Flyable;
import src.aircraft.Coordinates;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
    private Logs logs = new Logs();
    private static WeatherTower tower;
    private static AircraftFactory factory;
    private static int numSimulations;
    
    private Simulation() {}

    public static void getAircrafts(String filename) throws Exceptions {
        tower = new WeatherTower();
        factory = AircraftFactory.getInstance();
        File myObj = new File(filename);
        try (Scanner myReader = new Scanner(myObj)) {
            int i = 2;
            String input;
            // Skip first line
            if (myReader.hasNextLine()) {
                input = myReader.nextLine();
            }
            while (myReader.hasNextLine()) {
                input = myReader.nextLine();
                String[] splitInput = input.split(" ");
                try {
                    Coordinates coords = new Coordinates(Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), Integer.parseInt(splitInput[4]));
                    Flyable aircraft = factory.newAircraft(splitInput[0], splitInput[1], coords);
                    if (aircraft != null) {
                        aircraft.registerTower(tower);
                    }
                } catch (NumberFormatException nfe) {
                    throw new Exceptions("The coordinates in line " + i + " have to be numeric");
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new Exceptions("Input file not found :( Try again!");
        }
    }
    
    public static void startSimulation(String filename) throws Exceptions {
        Simulation simulation = new Simulation();
        Logs.log("The simulation will run " + Simulation.numSimulations + " times.\n");

        Simulation.getAircrafts(filename);

        for (int count = 0; count < Simulation.numSimulations; count++) {
            Logs.log(String.format("\n%d:\n", (count + 1)));
            tower.changeWeather();
        }
        // tower.logFinalCoordinates();
        Logs.closeOutputFile();
    }

    public static void parseInput(String filename) throws Exceptions {
        // Check if input file exists
        File myObj = new File(filename);
        try (Scanner myReader = new Scanner(myObj)) {
            // Read the file line by line
            // First line
            String input;
            if (myReader.hasNextLine()) {
                input = myReader.nextLine();
                try {
                    Simulation.numSimulations = Integer.parseInt(input);
                } catch (NumberFormatException nfe) {
                    throw new Exceptions("The first line of the file should (only) contain a positive integer");
                }
            }
            // Other lines
            int i = 2;
            while (myReader.hasNextLine()) {
                input = myReader.nextLine();
                String[] splitInput = input.split(" ");
                if (splitInput.length == 5) {
                    try {
                        int longitude = Integer.parseInt(splitInput[2]);
                        int latitude = Integer.parseInt(splitInput[3]);
                        int height = Integer.parseInt(splitInput[4]);
                        if (longitude >= 1000 || latitude >= 1000) {
                            throw new Exceptions("Longitude / latitude cannot exceed 1000 [line " + i + "]");
                        }
                    } catch (NumberFormatException nfe) {
                        throw new Exceptions("The coordinates in line " + i + " have to be numeric");
                    }
                } else {
                    throw new Exceptions("Wrong number of arguments in line " + i);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new Exceptions("Input file not found :( Try again!");
        }
    }

    // Main function
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                Simulation.parseInput(args[0]);
                Simulation.startSimulation(args[0]);
            } catch (Exceptions e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        } else {
            System.err.println("Wrong number of arguments");
        }
    }
}