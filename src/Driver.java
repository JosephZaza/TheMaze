import java.util.Scanner;

/**
 * Class Driver runs the game Maze.
 * @author Joseph Kern
 */
public class Driver{

  /**
   * setUpMaze instantiates the Maze object for the game.
   * @return Maze object to use during the game.
   * @throws Exception 
   */
  public static Maze setUpMaze() throws Exception {
    Maze maze = new Maze();
    maze.setUpLocations(maze);
    return maze;
  }
  
  /**
   * setUpPlayer instantiates the Player object for the game.
   * @return Player object to use during the game.
   */
  public static Player setUpPlayer() {
    Player player = new Player(0);
    return player;
  }
  
  /**
   * openingScene displays the opening title scene.
   * @return String to display to the screen.
   */
  public static String openingScene() {
    String opening = "\nTHE\n" +
        "   M         M       A       ZZZZZZZZEEEEEEEEEE\n" +
        "   MM       MM      A A            Z E         \n" +
        "   M M     M M     A   A          Z  E         \n" +
        "   M  M   M  M    A     A        Z   EEEEE     \n" +
        "   M   M M   M   AAAAAAAAA      Z    E         \n" +
        "   M    M    M  A         A    Z     E         \n" +
        "   M         M A           A  Z      E         \n" +
        "   M         MA             AZZZZZZZZEEEEEEEEEE\n" +
        "\n" +
        "Please enter 1 to continue:";
    return opening;
  }
  
  /**
   * rules displays the rules of the game.
   * @return String to display to the screen.
   */
  public static String rules() {
    String rules = "\nWelcome to \"The Maze!\"\n"
        + "\n"
        + "You stand before a large oak door.\n"
        + "Do you dare enter? Do you risk your life?\n"
        + "Enter 1 to open the door and begin\n"
        + "your journey!";
    return rules;
  }
  
  /**
   * end displays the ending text of the game.
   * @return String to display to the screen.
   */
  public static String end() {
    String copyright = "\u00a9";
    String ending = "\nThank you for playing the maze.\n"
        + "\nHope you have enjoyed your adventure!\n"
        + "\n"
        + "\n"
        + "Coypright" + copyright + " Joseph Kern, 2021";
    return ending;
  }

  /**
   * getOptionNum changes the player's current position based on the option they chose.
   * @param player Player object to change location of.
   */
  public static void getOptionNum(Maze maze, Player player, int newOptNum) {
    player.setCurrentLocation(maze.retrieveLocation(player.getCurrentLocation()).
      retrieveOption(newOptNum - 1).getPlayerDestination());
  }

  public static void main(String []args) throws Exception{
    Maze maze = setUpMaze();
    Player player = setUpPlayer();
    Scanner scanner = new Scanner(System.in);
    int goToRules = 0;
    int play = 0;
       
    while (play != 1) {
      while (goToRules != 1) {
        System.out.println(openingScene());
        goToRules = scanner.nextInt();
      }
      System.out.println(rules());
      play = scanner.nextInt();
    }
    
    while (maze.retrieveLocation(player.getCurrentLocation()).getChallenge() != "End") {
      System.out.println("\n" + maze.retrieveLocation(player.getCurrentLocation()).toString(player));
      int newOptNum = scanner.nextInt();
      getOptionNum(maze, player, newOptNum);
    }
    
    System.out.println("\n" + maze.retrieveLocation(player.getCurrentLocation()).toString(player));
    System.out.println(end());
    
    scanner.close();
  }
}
