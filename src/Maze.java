import java.util.ArrayList;
import java.util.List;

/**
 * Class Maze represents a maze for players to navigate.
 * @author Joseph Kern
 */
public class Maze {

  private static List<Location> Locations = new ArrayList<Location>();

  /**
   * AddLocation adds a new Location object to the locations ArrayList.
   * @param newLocation Location object to be added.
   */
  public static void addLocation(Location newLocation){
    Locations.add(newLocation);
  }

  /**
   * RetrieveLocation finds the object stored at a specified index.
   * @param index index to retrieve the object from.
   * @return object stored at the index.
   */
  public Location retrieveLocation(int index){
    return Locations.get(index);
  }
  
  /**
   * setUpLocations builds all of the locations of the Maze.
   */
  public void setUpLocations(){
    // Start
    Location start = new Location();
    start.setChallenge("");
    start.setDescription("Welcome to the beginning of the Maze!");
    start.addOption(new Option("Turn left.", 2));
    start.addOption(new Option("Turn right.", 1));

    // Location1
    Location location1 = new Location();
    location1.setChallenge("");
    location1.setDescription("You've reached a dead end.");
    location1.addOption(new Option("Turn around", 0));

    // Location2
    Location location2 = new Location();
    location2.setChallenge("");
    location2.setDescription("You've reached a right turn.");
    location2.addOption(new Option("Turn right.", 3));
    location2.addOption(new Option("Turn around.", 0));

    // Location3
    Location location3 = new Location();
    location3.setChallenge("");
    location3.setDescription("You've reached a door and a path to your right.");
    location3.addOption(new Option("Enter room.", 4));
    location3.addOption(new Option("Turn right.", 5));
    location3.addOption(new Option("Turn around.", 2));

    // Add Locations to Maze
    Maze.addLocation(start);
    Maze.addLocation(location1);
    Maze.addLocation(location2);
    Maze.addLocation(location3);
  }
}
