import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


/**
 * Class Maze represents a maze for players to navigate.
 * @author Joseph Kern
 */
public class Maze {

  private List<Location> Locations = new ArrayList<Location>();

  /**
   * AddLocation adds a new Location object to the locations ArrayList.
   * @param newLocation Location object to be added.
   */
  public void addLocation(Location newLocation){
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
   * @param maze maze object to add locations to.
   */
  public void setUpLocations(Maze maze) throws Exception{
    
    JSONParser jsonParser = new JSONParser();
    
    try (FileReader reader = new FileReader("src/BasicMaze.json")){
      // Read JSON File
      JSONObject locations = (JSONObject)jsonParser.parse(reader);
      JSONArray locationList = (JSONArray)locations.get("locations");
      // Iterate over location array
      locationList.forEach( location -> parseLocationObject((JSONObject)location, maze));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

//    // Start
//    Location start = new Location();
//    start.setChallenge("");
//    start.setDescription("You've entered the maze into a hallway.");
//    start.addOption(new Option("Turn left.", 2));
//    start.addOption(new Option("Turn right.", 1));
//
//    // Location1
//    Location location1 = new Location();
//    location1.setChallenge("");
//    location1.setDescription("You've reached a dead end.");
//    location1.addOption(new Option("Turn around", 0));
//
//    // Location2
//    Location location2 = new Location();
//    location2.setChallenge("");
//    location2.setDescription("You've reached a right turn.");
//    location2.addOption(new Option("Turn right.", 3));
//    location2.addOption(new Option("Turn around.", 0));
//
//    // Location3
//    Location location3 = new Location();
//    location3.setChallenge("");
//    location3.setDescription("You've reached a door and a path to your right.");
//    location3.addOption(new Option("Enter room.", 4));
//    location3.addOption(new Option("Turn right.", 5));
//    location3.addOption(new Option("Turn around.", 2));
//    
//    // Location4
//    Location location4 = new Location();
//    location4.setChallenge("Potion");
//    location4.setDescription("");
//    location4.addOption(new Option("Leave through the door you came in.", 3));
//    
//    // Location5
//    Location location5 = new Location();
//    location5.setChallenge("");
//    location5.setDescription("You've come to a fork in the road.");
//    location5.addOption(new Option("Turn around.", 3));
//    location5.addOption(new Option("Take the left fork.", 13));
//    location5.addOption(new Option("Take the right fork.", 6));
//    location5.addOption(new Option("Turn around.", 3));
//    
//    // Location6
//    Location location6 = new Location();
//    location6.setChallenge("");
//    location6.setDescription("You've come to a junction.");
//    location6.addOption(new Option("Take the path to your left.", 10));
//    location6.addOption(new Option("Contiinue forward.", 7));
//    location6.addOption(new Option("Turn around.", 5)); 
//    // Location7
//    Location location7 = new Location();
//    location7.setChallenge("");
//    location7.setDescription("You've come to a wall with a path to the left and the right.");
//    location7.addOption(new Option("Turn left.", 8));
//    location7.addOption(new Option("Turn right.", 9));
//    location7.addOption(new Option("Turn around.", 6));
//    
//    // Location8
//    Location location8 = new Location();
//    location8.setChallenge("");
//    location8.setDescription("You've reached a dead end.");
//    location8.addOption(new Option("Turn around.", 7));
//    
//    // Location9
//    Location location9 = new Location();
//    location9.setChallenge("");
//    location9.setDescription("You've reached a dead end.");
//    location9.addOption(new Option("Turn around.", 7));
//    
//    // Location10
//    Location location10 = new Location();
//    location10.setChallenge("");
//    location10.setDescription("There is a door infront of you and a path to your left.");
//    location10.addOption(new Option("Enter room.", 12));
//    location10.addOption(new Option("Turn left.", 11));
//    location10.addOption(new Option("Turn around.", 6));
//    
//    // Location11
//    Location location11 = new Location();
//    location11.setChallenge("");
//    location11.setDescription("You've reached a dead end.");
//    location11.addOption(new Option("Turn around.", 10));
//    
//    // Location12
//    Location location12 = new Location();
//    location12.setChallenge("Sword");
//    location12.setDescription("");
//    location12.addOption(new Option("Leave through the door you came through.", 10));
//    
//    // Location13
//    Location location13 = new Location();
//    location13.setChallenge("");
//    location13.setDescription("You've reached a corner with a path to your left..");
//    location13.addOption(new Option("Take the path to your left.", 14));
//    location12.addOption(new Option("Turn around", 5));
//    
//    // Location14
//    Location location14 = new Location();
//    location14.setChallenge("");
//    location14.setDescription("There is a path to your left and to your right.");
//    location14.addOption(new Option("Take the path to your right.", 15));
//    location14.addOption(new Option("Take the path to your left.", 19));
//    location14.addOption(new Option("Turn around", 13));
//    
//    // Location15
//    Location location15 = new Location();
//    location15.setChallenge("");
//    location15.setDescription("You've reached a corner with a path to your right.");
//    location15.addOption(new Option("Take the path to your right.", 16));
//    location15.addOption(new Option("Turn around", 14));
//    
//    // Location16
//    Location location16 = new Location();
//    location16.setChallenge("");
//    location16.setDescription("You've reached a corner with a path to your right.");
//    location16.addOption(new Option("Take the path to your right.", 17));
//    location16.addOption(new Option("Turn around", 15));
//    
//    // Location17
//    Location location17 = new Location();
//    location17.setChallenge("");
//    location17.setDescription("You've reached a corner with a path to your right.");
//    location17.addOption(new Option("Take the path to your right.", 18));
//    location17.addOption(new Option("Turn around", 16));
//    
//    // Location18
//    Location location18 = new Location();
//    location18.setChallenge("");
//    location18.setDescription("You've reached a dead end.");
//    location18.addOption(new Option("Turn around.", 17));
//    
//    // Location19
//    Location location19 = new Location();
//    location19.setChallenge("");
//    location19.setDescription("You've reached a corner with a path to your left.");
//    location19.addOption(new Option("Take the path to your left", 20));
//    location19.addOption(new Option("Turn around.", 14));
//    
//    // Location20
//    Location location20 = new Location();
//    location20.setChallenge("");
//    location20.setDescription("You come to a fork. There is a path to the left and to the right.");
//    location20.addOption(new Option("Take the path to your right.", 21));
//    location20.addOption(new Option("Take the path to your left.", 24));
//    
//    // Location21
//    Location location21 = new Location();
//    location21.setChallenge("");
//    location21.setDescription("You come to a corner with a path to your left.");
//    location21.addOption(new Option("Take the path to the left.", 22));
//    location21.addOption(new Option("Turn around.", 20));
//    
//    // Location22
//    Location location22 = new Location();
//    location22.setChallenge("");
//    location22.setDescription("You come to a corner with a pather to your left.");
//    location22.addOption(new Option("Take the path to the left.", 23));
//    location22.addOption(new Option("Turn around.", 21));
//
//    // Location23
//    Location location23 = new Location();
//    location23.setChallenge("");
//    location23.setDescription("You've reached a dead end.");
//    location23.addOption(new Option("Turn around.", 22));
//    
//    // Location24
//    Location location24 = new Location();
//    location24.setChallenge("Ghost");
//    location24.setDescription("");
//    location24.addOption(new Option("Go forward.", 25));
//    location24.addOption(new Option("Turn around.", 20));
//    
//    // Location25
//    Location location25 = new Location();
//    location25.setChallenge("");
//    location25.setDescription("You come to a fork. There is a parth to the left and to the right.");
//    location25.addOption(new Option("Take the path to the left.", 26));
//    location25.addOption(new Option("Take the path to the right.", 29));
//    location25.addOption(new Option("Turn around.", 24));
//    
//    // Location26
//    Location location26 = new Location();
//    location26.setChallenge("");
//    location26.setDescription("There is a path to your left and a path to your right.");
//    location26.addOption(new Option("Take the path to your left.", 27));
//    location26.addOption(new Option("Take the path to your right.", 28));
//    
//    // Location27
//    Location location27 = new Location();
//    location27.setChallenge("");
//    location27.setDescription("You've reached a dead end.");
//    location27.addOption(new Option("Turn around.", 26));
//    
//    // Location28
//    Location location28 = new Location();
//    location28.setChallenge("");
//    location28.setDescription("You've reached a dead end.");
//    location28.addOption(new Option("Turn around.", 26));
//    
//    // Location29
//    Location location29 = new Location();
//    location29.setChallenge("");
//    location29.setDescription("You've come to a door.");
//    location29.addOption(new Option("Enter the room.", 30));
//    location29.addOption(new Option("Turn around.", 25));
//    
//    // Location30
//    Location location30 = new Location();
//    location30.setChallenge("Minotaur");
//    location30.setDescription("");
//    location30.addOption(new Option("Leave through the door on the other side.", 31));
//    location30.addOption(new Option("Turn around.", 29));
//    
//    // Location31
//    Location location31 = new Location();
//    location31.setChallenge("");
//    location31.setDescription("You've reached a corner.");
//    location31.addOption(new Option("Take the path to the left.", 32));
//    location31.addOption(new Option("Turn around.", 30));
//    
//    // Location32
//    Location location32 = new Location();
//    location32.setChallenge("");
//    location32.setDescription("There is a path to your left and a path to your right.");
//    location32.addOption(new Option("Take the path to your left.", 33));
//    location32.addOption(new Option("Take the path to your right.", 34));
//    location32.addOption(new Option("Turn around.", 31));
//    
//    // Location33
//    Location location33 = new Location();
//    location33.setChallenge("");
//    location33.setDescription("You've reached a dead end.");
//    location33.addOption(new Option("Turn around.", 32));
//    
//    // Location34
//    Location location34 = new Location();
//    location34.setChallenge("");
//    location34.setDescription("You've reached a corner.");
//    location34.addOption(new Option("Take the path on the left", 45));
//    location34.addOption(new Option("Turn around.", 32));
//    
//    // Location35
//    Location location35 = new Location();
//    location35.setChallenge("");
//    location34.setDescription("You've reached a corner.");
//    location34.addOption(new Option("Take path to the right.", 36));
//    location34.addOption(new Option("Turn around.", 45));
//    
//    // Location36
//    Location location36 = new Location();
//    location36.setChallenge("");
//    location36.setDescription("There is a path to your left and a path to your right.");
//    location36.addOption(new Option("Take path to your left.", 37));
//    location36.addOption(new Option("Take path to your right.", 38));
//    location36.addOption(new Option("Turn around.", 35));
//    
//    // Location37
//    Location location37 = new Location();
//    location37.setChallenge("");
//    location37.setDescription("You've reach a dead end.");
//    location37.addOption(new Option("Turn around.", 36));
//    
//    // Location38
//    Location location38 = new Location();
//    location38.setChallenge("");
//    location38.setDescription("There is a path to your left and to your right.");
//    location38.addOption(new Option("Take the path to the left.", 41));
//    location38.addOption(new Option("Take the path to the right.", 39));
//    location38.addOption(new Option("Turn around.", 36));
//    
//    // Location39
//    Location location39 = new Location();
//    location39.setChallenge("");
//    location39.setDescription("You've creached a corner.");
//    location39.addOption(new Option("Take the path to your left.", 40));
//    location39.addOption(new Option("Turn around.", 38));
//    
//    // Location40
//    Location location40 = new Location();
//    location40.setChallenge("");
//    location40.setDescription("You've reached a dead end.");
//    location40.addOption(new Option("Turn around.", 39));
//    
//    // Location41
//    Location location41 = new Location();
//    location41.setChallenge("");
//    location41.setDescription("You've reached a corner.");
//    location41.addOption(new Option("Take the path to your left.", 42));
//    location41.addOption(new Option("Turn around.", 39));
//    
//    // Location42
//    Location location42 = new Location();
//    location42.setChallenge("");
//    location42.setDescription("You've reached a corner.");
//    location42.addOption(new Option("Take the path to your left.", 43));
//    location42.addOption(new Option("Turn around.", 41));
//    
//    // Location43
//    Location location43 = new Location();
//    location43.setChallenge("");
//    location43.setDescription("You've reached a door.");
//    location43.addOption(new Option("Go through the door.", 44));
//    location43.addOption(new Option("Turn around.", 42));
//    
//    // Location44
//    Location location44 = new Location();
//    location44.setChallenge("Grail");
//    location44.setDescription("");
//    location44.addOption(new Option("Go back out the door.", 43));
//    
//    // Location45
//    Location location45 = new Location();
//    location45.setChallenge("");
//    location45.setDescription("You've reached a larg oak door like the one you entered through.");
//    location45.addOption(new Option("Go through the door.", 46));
//    location45.addOption(new Option("Continue forward.", 35));
//    location45.addOption(new Option("Turn around.", 34));
//    
//    // LocationEnd
//    Location locationEnd = new Location();
//    locationEnd.setChallenge("End");
//    locationEnd.setDescription("");
//    
//    // Add Locations to Maze
//    maze.addLocation(start);
//    maze.addLocation(location1);
//    maze.addLocation(location2);
//    maze.addLocation(location3);
//    maze.addLocation(location4);
//    maze.addLocation(location5);
//    maze.addLocation(location6);
//    maze.addLocation(location7);
//    maze.addLocation(location8);
//    maze.addLocation(location9);
//    maze.addLocation(location10);
//    maze.addLocation(location11);
//    maze.addLocation(location12);
//    maze.addLocation(location13);
//    maze.addLocation(location14);
//    maze.addLocation(location15);
//    maze.addLocation(location16);
//    maze.addLocation(location17);
//    maze.addLocation(location18);
//    maze.addLocation(location19);
//    maze.addLocation(location20);
//    maze.addLocation(location21);
//    maze.addLocation(location22);
//    maze.addLocation(location23);
//    maze.addLocation(location24);
//    maze.addLocation(location25);
//    maze.addLocation(location26);
//    maze.addLocation(location27);
//    maze.addLocation(location28);
//    maze.addLocation(location29);
//    maze.addLocation(location30);
//    maze.addLocation(location31);
//    maze.addLocation(location32);
//    maze.addLocation(location33);
//    maze.addLocation(location34);
//    maze.addLocation(location35);
//    maze.addLocation(location36);
//    maze.addLocation(location37);
//    maze.addLocation(location38);
//    maze.addLocation(location39);
//    maze.addLocation(location40);
//    maze.addLocation(location41);
//    maze.addLocation(location42);
//    maze.addLocation(location43);
//    maze.addLocation(location44);
//    maze.addLocation(location45);
//    maze.addLocation(locationEnd);
//    
  }
  
  public void parseLocationObject(JSONObject location, Maze maze){    
    Location newLocation = new Location();
    
    // Get challenge
    newLocation.setChallenge((String)location.get("challenge"));
    
    // Get Description
    newLocation.setDescription((String)location.get("description"));
    
    // Get Options
    if (location.get("id") != "End") {
      JSONArray optionsArray = new JSONArray();
      optionsArray = (JSONArray)location.get("options");
      for (int i = 0; i < optionsArray.size(); i++) {
        JSONArray optionArray = new JSONArray();
        optionArray = (JSONArray) optionsArray.get(i);
        for (int j = 0; j < optionArray.size(); j++) {
          newLocation.addOption(new Option(optionArray.get(0).toString(), 
              Math.toIntExact((long) optionArray.get(1))));
        }
      }
    }
    
    // Add to the maze
    maze.addLocation(newLocation);
  }
}
