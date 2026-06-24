# Avaj Launcher

An aircraft simulation program in Java based on a [UML class diagram](https://github.com/char-projects/avaj-launcher/blob/main/avaj_uml.png) using Observer, Singleton, and Factory design patterns.

___

### Input file
The program takes exactly one argument from the command line. This argument is the name of a text file
containing the scenario that needs to be simulated. I provided [src/scenario.txt](https://github.com/char-projects/avaj-launcher/blob/main/src/scenario.txt) an example file.

The first line of the file contains a positive integer. This number represents how many
times the simulation runs, which is also the number of times a weather change is triggered.

Each subsequent line describes an aircraft that will be part of the simulation, using this
format: TYPE NAME LONGITUDE LATITUDE HEIGHT.
___

### Simulation
- Types of aircraft: BALLOON, HELICOPTER, JETPLANE
- Types of weather: RAIN, FOG, SUN, SNOW
- Each 3-dimensional point has its own weather
___

### Output file
Executing the program will generate a log file (simulation.txt) that describes the outcome of the simulation.
___

### Compile with

``` bash
find * -name "*.java" > sources.txt
```
``` bash
javac @sources.txt
```
``` bash
java src.Simulation src/scenario.txt
```
