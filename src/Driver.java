
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class Driver runs the game Maze.
 * @author Joseph Kern
 */
public class Driver extends Application {

  // Create Maze
  public static Maze maze = new Maze();
  
  // Create Player
  public static Player player = new Player(0);

  // Set up scene
  private static Text Description = new Text();
  private static Label option = new Label("Option: ");
  private static TextField optNum = new TextField();
  private static Button doOption = new Button("Submit");


  @Override
  public void start(Stage primaryStage) throws Exception {  
    maze.setUpLocations();
    
    Scene scene = new Scene(createBoard(player),300, 350);
    primaryStage.setTitle("The Maze");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * createBoard updates the screen according to the player's current position.
   * @param player Player object to check location of.
   * @return the new screen to display.
   */
  public static BorderPane createBoard(Player player) {
    Description.setText(maze.retrieveLocation(player.getCurrentLocation()).toString(player));
    Description.setStyle("-fx-text-based-color: white;");
    
    HBox hbDescription = new HBox();
    hbDescription.setPadding(new Insets(11, 12, 13, 12));
    hbDescription.getChildren().add(Description);
    hbDescription.setAlignment(Pos.CENTER);
    
    HBox hbOption = new HBox();
    hbOption.getChildren().add(option);
    option.setStyle("-fx-font-weight: bold");
    hbOption.getChildren().add(optNum);
    hbOption.getChildren().add(doOption);
    doOption.setOnAction(e -> getOptionNum(player));
    hbOption.setAlignment(Pos.CENTER);

    BorderPane wholeBoard = new BorderPane();
    wholeBoard.setPadding(new Insets(20));
    wholeBoard.setCenter(hbDescription);
    wholeBoard.setBottom(hbOption);
    wholeBoard.setStyle("-fx-background-color: black;" + "-fx-text-based-color: white;");
    
    return wholeBoard;
  }

  /**
   * getOptionNum changes the player's current position based on the option they chose.
   * @param player Player object to change location of.
   */
  public static void getOptionNum(Player player) {
    int newOptNum = Integer.parseInt(optNum.getText()) - 1;
    player.setCurrentLocation(maze.retrieveLocation(player.getCurrentLocation()).
      retrieveOption(newOptNum).getPlayerDestination());
  }

  public static void main(String []args){
    launch(args);
  }
}
