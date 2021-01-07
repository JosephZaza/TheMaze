import java.util.ArrayList;
import java.util.List;

/**
 * Class Option represents an option for the player to make at each location.
 * @author Joseph Kern
 */
public class Option {

  private String OptionDescription;
  private int PlayerDestination;

  /**
   * Constructor for the Option object.
   * @param newDescription String to be stored in OptionDescription.
   * @param newDestination value to be stored in PlayerDestination.
   */
  public Option(String newDescription, int newDestination){
    OptionDescription = newDescription;
    PlayerDestination = newDestination;
  }

  /**
   * GetOptionDescription retrieves the String stored in OptionDescription.
   * @return String stored in OptionDescription.
   */
  public String getOptionDescription() {
    return OptionDescription;
  }

  /**
   * GetOptionDescription retrieves the value stored in PlayerDestination.
   * @return value stored in PlayerDestination.
   */
  public int getPlayerDestination() {
    return PlayerDestination;
  }
}
