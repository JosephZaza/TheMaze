import java.util.ArrayList;
import java.util.List;

/**
 * C Location represents a location in the maze.
 * @author Joseph Kern
 */
public class Location {

  private String Challenge;
  private String Description;
  private List<Option> Options = new ArrayList<Option>();

  /**
   * setChallenge stores a string naming the challenge at a location.
   * @param challenge string representing the challenge.
   */
  public void setChallenge(String challenge){
    Challenge = challenge;
  }

  /**
   * setDescription stores a string describing the location.
   * @param description string describing the location.
   */
  public void setDescription(String description) {
    Description = description;
  }

  /**
   * addOption stores a new string describing an option in the Options ArrayList.
   * @param option string describing an option.
   */
  public void addOption(Option option) {
    Options.add(option);
  }

  /**
   * getChallenge retrieves the string stored in Challenge.
   * @return string stored in Challenge.
   */
  public String getChallenge() {
    return Challenge;
  }

  /**
   * getDescription retrieves the string stored in Description.
   * @return string stored in Description.
   */
  public String getDescription(){
    return Description;
  }

  /**
   * RetrieveLocation finds the object stored at a specified index.
   * @param index index to retrieve the object from.
   * @return object stored at the index.
   */
  public Option retrieveOption(int index){
    return Options.get(index);
  }

  public void setNewCurrentLocation(int optionNum, Player player) {
    int pickedOption = optionNum;
    int newCurrentLocation = 0;
    player.setCurrentLocation(newCurrentLocation);
  }

  public String toString(Player player) {
    String output = getDescription() + "\n\n";
    if (getChallenge() != "") {
      switch(getChallenge()) {
        case "Potion":
          output += "You entered a dark room. In the corner of the room there is a potion. You retrieve it.\n\n";
          player.setHasPotion(true);
          break;
        case "Sword":
          output += "You find an ancient sword lying on the floor and pick it up.\n\n";
          player.setHasSword(true);
          break;
        case "Ghost":
          if (!player.getHasPotion()){
            output += "You are confronted by a ghost who sees you. It strikes at you and "
                                + "you are sent to beginning of the Maze!\n\n";
            player.setCurrentLocation(0);
            return output;
          }
          else {
            output += "You are confronted by a ghost but since you have the potion you " +
                                "are able to avoid its attacks and pass safely by.\n\n";
          }
        case "Minotaur":
          if (!player.getHasSword()) {
            output += "You are confronted by a massive Minotaur. Without any type of " +
                                "weapon you are useless to confront it and are sent back to the " +
                                "start of the Maze!\n\n";
            player.setCurrentLocation(0);
            return output;
          }
          else {
            output += "You are confronted by a massive Minotaur. You pull out the sword " +
                                "you found and are able to fight off the beast. " +
                                "You pass by safely.\n\n";
          }
          break;
        case "Grail":
          output += "You have found a secret treasure at the h eart of the Maze. Legend " +
                              "has told of the magic this grail possesses. You take it with you.\n\n";
          player.setHasGrail(true);
          break;
        case "End":
          if (!player.getHasGrail()) {
            output += "You have made it to the end, and because you found the secret treasure at " +
                        "the heart of the Maze you will be rewarded an extra 100 points. " +
                        "Congratulations brave hero!\n\n";
          }
          else {
            output += "You have made it to the end. Legend speaks of a secret treasure at the " +
                        "heart of the Maze. It is a shame you were unable to find it. " +
                        "Congratulations brave hero!\n\n";
          }
          return output;
      }
    }

    output += "==========================================\n";

    for (int i = 0; i < Options.size(); i++){
      int optNum = i + 1;
      output += "Option " + optNum + ": " + Options.get(i).getOptionDescription() + "\n";
    }

    if (getChallenge() != "End") {
      output += "\nPlease enter the number of the option you wish to do.\nOption: ";
    }

    return output;
  }
}
