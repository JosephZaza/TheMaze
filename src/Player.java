/**
 * Class Player represents a player for the game.
 * @author Joseph Kern
 */
public class Player {

  private int CurrentLocation;
  private boolean HasPotion;
  private boolean HasSword;
  private boolean HasGrail;

  /**
   * Constructor for class Player.
   * @param newLocation value to store in CurrentLocation.
   */
  public Player(int newLocation){
    setCurrentLocation(newLocation);
    setHasGrail(false);
    setHasPotion(false);
    setHasSword(false);
  }

  /**
   * setCurrentLocation stores a value in CurrentLocation.
   * @param currentLocation value to store in CurrentLocation.
   */
  public void setCurrentLocation(int currentLocation) {
    CurrentLocation = currentLocation;
  }

  /**
   * setHasPotion sets HasPotion to true or false.
   * @param hasPotion value to set HasPotion to.
   */
  public void setHasPotion(boolean hasPotion) {
    HasPotion = hasPotion;
  }

  /**
   * setHasSword sets HasSword to true or false.
   * @param hasSword value to set HasSword to.
   */
  public void setHasSword(boolean hasSword) {
    HasSword = hasSword;
  }

  /**
   * setHasGrail sets HasGrail to true or false.
   * @param hasGrail value to set HasGrail to.
   */
  public void setHasGrail(boolean hasGrail) {
    HasGrail = hasGrail;
  }

  /**
   * getCurrentLocation retrieves the value of CurrentLocation
   * @return value stored in CurrentLocation.
   */
  public int getCurrentLocation() {
    return CurrentLocation;
  }

  /**
   * getHasPotion retrieves the status of HasPotion.
   * @return status of HasPotion.
   */
  public boolean getHasPotion() {
    return HasPotion;
  }

  /**
   * getHasSword retrieves the status of HasSword.
   * @return status of HasSword.
   */
  public boolean getHasSword() {
    return HasSword;
  }

  /**
   * getHasGrail retrieves the status of HasGrail.
   * @return status of HasGrail.
   */
  public boolean getHasGrail() {
    return HasGrail;
  }
}
