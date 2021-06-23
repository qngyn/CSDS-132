import java.util.Random;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** HW5 project mimics the Game 2048 with extra function of moving diagonally
  * @author 
  * This class use to run the Game 2048
  */
public class SlidingTiles extends Application {
  //private field for 2D button array
  private Button[][] buttonArray ;
  
  //private field for 2D int array
  private int[][] array;
  
  //private field for text label
  private Text label = new Text(" Score: ");
  
  //private field for font to set for the button and the text label
  private final Font font = new Font("Rockwell", 20);
  private final Font buttonFont = new Font("Rockwell",12);
  
  /**
   * The constructor of SlidingTiles class
   */
  public SlidingTiles(){
  }
  
  /**
   * Shifting every elements in a row to the left if there is any 0 between them
   * @param array is the array has row needs to shift to the left
   * @param row is the row will has its elements shift to the left if there is any 0 between them
   */
  private void toLeft(int[][]array,int row){
    
    //index for the column in each row
    int j = 0; 
    
    //while loop to loop through every column in a row and slide left if there is "0" between the row
    while (j < array[row].length - 1){
      
      //if the current element is the current column 0 and the next element is not zero than slide it to the left
      if (array[row][j] == 0 && array[row][j+1] != 0){
        array[row][j] = array[row][j+1];
        
        //set the next element into 0
        array[row][j+1] = 0; 
        
        //set it back to the first column
        j = 0;
      }
      
      //increment the column for continuing checking
      else
        j++;
    }
  }
  
  /**
   * Sliding and merging properly to the left
   * @param array is the array has a row need to shift and merge when sliding to the left
   * @param row is the rows has elements need to shift and merge same elements when sliding to the left
   * @return a array has an indicated row that already slide and merge properly to the left 
   */
  public int[][] slideLeft(int[][] array, int row){
    
    //slide all the element in the input row to the left 
    toLeft(array, row); 
    
    //index of the column in each row
    int j = 0;
    
    //loop through every column this the input row for merge lefty properly and slide after merge lefty
    while (j < array[row].length - 1) {
      
      //if the current element and the its next element are the same, it will merge
      if (array[row][j] != 0 && array[row][j+1] == array[row][j]){
        array[row][j] *= 2; 
        
        //the next element set to 0
        array[row][j+1] = 0; 
        
        //slide after merge
        toLeft(array, row);
      }
      
      //increment the column in the row
      else
        j++;
    }
    return array;
  }
  
  /**
   * Sliding and merging properly to the right
   * @param array an int input array that has row needs to sliding and merging to the right
   * @param row is the row has elements needs to sliding and merging to the right
   * @return a array has an indicated row that already slide and merge properly to the right 
   */
  public int[][] slideRight(int[][] array, int row){
    //this loop to reverse the elements in an indicated row 
    for (int i = 0; i < array[row].length/2; i++){
      int save = array[row][i];
      array[row][i] = array[row][array[row].length - i - 1];
      array[row][array[row].length - i - 1] = save;
    }
    
    //using the slideLeft to merge and slide properly
    slideLeft(array, row);
    
    //loop to reverse the row again and now it slides right
    for (int i = 0; i < array[row].length/2; i++){
      int save = array[row][i];
      array[row][i] = array[row][array[row].length - i - 1];
      array[row][array[row].length - i - 1] = save;
    }
    
    return array;
  }
  
  /**
   * Shifting every elements up in a column if there is any 0 between them
   * @param array is the array has column needs to shift to the left
   * @param column is the row will has its elements goes up if there is any 0 between them
   */
  private void toUp(int[][]array, int column) {
    //index for the row, start at the first row
    int i = 0; 
    
    //while loop to loop through every row in a column and slide up if there is "0" between the row till the last element
    while (i < array.length - 1) {
      //if the current element is 0 and the element after it is non-zero, shifiting up 
      if (array[i][column] == 0 && array[i+1][column] != 0){
        //set the current element equals the element after it  
        array[i][column] =  array[i+1][column]; 
        
        //set the element after the current element into 0
        array[i + 1][column] = 0; 
        
        //set the pointer back to the starting point
        i = 0; 
      }
      
      //increment the starting point for checking next element in the column 
      else {
        i++;
      }
    }
  }
  
  /**
   * Sliding and merging properly upward between elements in a column of an array
   * @param array an int input array that has column needs to sliding and merging upward
   * @param column is the row has elements needs to sliding and merging properly upward
   * @return an array with a indicated column has its elements sliding and merging upwardproperly
   */
  public int[][] slideUp(int[][] array, int column){
    //sliding all the elements up if there is any 0 between those elements 
    toUp(array, column);
    
    //starting point for looping 
    int i = 0; 
    
    //this loop will merge and sliding all the elements properly
    while (i < array.length - 1){
      //checking if the current element and the element after it in a a column is the same or not
      if (array[i][column] != 0  && array[i][column] == array[i+1][column]) {
        //if they are the same, merging it together
        array[i][column] *= 2;
        
        //set the element after the current element to 0
        array[i+1][column] = 0;
        
        //sliding up to get the next element in the column
        toUp(array, column);
      }
      
      //if the current and the element after it in a column is not the same, increment to the next element
      else 
        i++;
    }
    
    //return the array with indicated column has element shifting and merging properly
    return array;
  }
  
  /**
   * Sliding and merging properly downward between elements in a column of an array
   * @param array an int input array that has column needs to sliding and merging downward
   * @param column is the row has elements needs to sliding and merging properly downward
   * @return an array with a indicated column has its elements sliding and merging downward properly 
   */
  public int[][] slideDown (int[][] array, int column){
    //loop to reverse the indicated column 
    for (int i = 0; i < array.length/2; i++){
      int save = array[i][column];
      array[i][column] = array[array.length - i- 1][column];
      array[array.length - i - 1][column] = save;
    }
    
    //slide the column up
    slideUp(array, column);
    
    //;oop to reverse the indicated column again so it now slides down
    for (int i = 0; i < array.length/2; i++){
      int save = array[i][column];
      array[i][column] = array[array.length - i- 1][column];
      array[array.length - i - 1][column] = save;
    }
    
    //return the array
    return array;
  }
  
  /**
   * 
   * @param array is the 2D int array need to slide up all elements to top right 
   * @return a 2D array with elements slides up to the top right corner
   */
  public int[][] slideUpRight(int[][] array){
    //number of rows
    int numRow = array.length; 
    
    //number of columns
    int numCol = array[0].length;
    
    /*the maximum elements available diagonally based on number of rows and columns
     it depends on which side is the smaller number
     */
    int maxElements  = numRow <= numCol ? numRow:numCol;
    
    //starting point to loop 
    int currentRow = 0;
    int currentCol = 0;
    
    //loop will stop after loop the last row
    while (currentRow < numRow) {
      //create a 1-row 2D array to store the element in diagonal direction  
      int[][] storeElements = new int[1][maxElements];
      
      //create 1D array to hold the index of row and column 
      int[] storeRowIndex = new int[numRow];
      int[] storeColIndex = new int[numCol];
      
      // use inside the loop to keep track the index of row and column when loop
      int rowIndex = currentRow; 
      int colIndex = currentCol;
      
      //keep track the position of the current element
      int pointer = 0;
      
      // this loop will store element diagonally based on the starting point to slide up right later
      while (rowIndex < numRow && colIndex > -1){
        storeElements[0][pointer] = array[rowIndex][colIndex];
        storeRowIndex[pointer] = rowIndex;
        storeColIndex[pointer] = colIndex;
        
        //increase the row index and decrease the column index after each time looping
        rowIndex++;
        colIndex--;
        
        //increase the pointer to the next element in the diagonal array
        pointer++;
      }
      
      //slide of the element to the left
      slideLeft(storeElements,0);
      
      //start loop at the first element in the array
      int counter = 0; 
      
      //turning back the diagonal array based on the store index of row and column
      for (int m = 0, n = 0; m < storeRowIndex.length && n < storeColIndex.length; m++, n++){
        array[storeRowIndex[m]][storeColIndex[n]] = storeElements[0][counter];
        counter++;
      }
      
      //increase the column in the same row and limit the number of column loop in each row to avoid loop number of times for each diagonal elements
      if (currentCol + 1 < numCol){
        currentCol++;
      }
      
      //if there is no more columns to loop in one row, goes to the next row
      else{
        currentRow++; 
      }
    }
    
    //return the array
    return array;
  }
  
  /**
   * 
   * @param array the input int array to slide all its element to the top left corner
   * @return an int array with all its elements slides up to the top left corner
   */
  public int[][] slideUpLeft(int[][]array){
    //reverse the columns of int array
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length/2; j++) {
        int save = array[i][j]; 
        array[i][j] = array[i][array[i].length - j - 1];
        array[i][array[i].length - j - 1] = save;
      }
    }  
    
    //slide the current in array by using slideUpRight method
    slideUpRight(array);
    
    //reverse the columns of the current in array so now its slide to the top corner left 
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length/2; j++) {
        int save = array[i][j]; 
        array[i][j] = array[i][array[i].length - j - 1];
        array[i][array[i].length - j - 1] = save;
      }
    }  
    
    //retrun the int array with elements slide down left
    return array;
  }
  
  /**
   * Slide all the elements in the array to the down left direction (diagonally)
   * @param array the input int array to slide all its element to the bottom left corner
   * @return an array that has its element slides down left;
   */
  public int[][] slideDownLeft(int[][]array){
    //reverse all rows in the 2D int array  
    for(int j = 0; j < array[0].length; j++){
      for(int i = 0; i < array.length/2; i++) {
        int save = array[i][j];
        array[i][j] = array[array.length - i - 1][j];
        array[array.length - i - 1][j] = save;
      }
    }
    
    //slide the array to the top corner of the left
    slideUpLeft(array);
    
    //reverse all the rows again so now its slide to the bottom left
    for(int j = 0; j < array[0].length; j++){
      for(int i = 0; i < array.length/2; i++) {
        int save = array[i][j];
        array[i][j] = array[array.length - i - 1][j];
        array[array.length - i - 1][j] = save;
      }
    }
    
    //return the int arrayy has its element slide to the bottom left
    return array;
  }
  
  /**
   * Slide all the elements in the array to the down right direction (diagonally)
   * @param array  the input int array to slide all its element to the bottom right corner
   * @return an array that has its element slides down right;
   */
  public int[][] slideDownRight(int[][] array){
    //loop throught the 2D int array to reverse all the rows
    for(int j = 0; j < array[0].length; j++){
      for(int i = 0; i < array.length/2; i++) {
        int save = array[i][j];
        array[i][j] = array[array.length - i - 1][j];
        array[array.length - i - 1][j] = save;
      }
    }
    
    //slide all the elements to the top corner right
    slideUpRight(array);
    
    //loop to reverse the rows in the 2D int array again so now its slide to the bottom right
    for(int j = 0; j < array[0].length; j++){
      for(int i = 0; i < array.length/2; i++) {
        int save = array[i][j];
        array[i][j] = array[array.length - i - 1][j];
        array[array.length - i - 1][j] = save;
      }
    }
    
    //return the int array has all the element slide to the bottom right
    return array;
  }
  
  
  /**
   * 
   * @param array is the array need to add 1 randomly to it
   */
  public void addOne(int[][] array) {
    //variables to count the index that is zero
    int blank = 0; 
    
    //loop through the 2D array to count 
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length; j++){
        if (array[i][j] == 0){
          blank += 1;
        }
      }
    }
    
    //generating random index
    Random random = new Random();
    int rand = random.nextInt(blank);
    
    //set back the blank to 0 to count
    blank = 0;
    
    //putting 1 randomly if at the certain index, it is 0. 
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length; j++){
        if (array[i][j] == 0){
          blank++;
          if (blank == rand){
            array[i][j] = 1;
          }
        }
      }
    }
  }
  
  /** 
   * update the elements in the board to pass into the button and the color of the button
   */
  private void update(){
    
    //loop through the 2D int array
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[0].length; j++){
        buttonArray[i][j].setText(Integer.toString(array[i][j]));
      }
    }
    
    //extra credits part
    //this loop would assign the corresponding color for each button with specific number
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[0].length; j++){
        
        //depending on the text of the button, it will set the color corresponds to it
        //starting from the number 512 to the bigger number than 512, the text of button will set to have white color 
        switch (array[i][j]) {
          case 0:
            buttonArray[i][j].setStyle("-fx-background-color: #ffffff;");
            break;
            
          case 1:
            buttonArray[i][j].setStyle("-fx-background-color: #f9f0f0");
            break;
            
          case 2:
            buttonArray[i][j].setStyle("-fx-background-color: #f7eaea");
            break;
            
          case 4:
            buttonArray[i][j].setStyle("-fx-background-color: #f0d8d8;");
            break;
            
          case 8:
            buttonArray[i][j].setStyle("-fx-background-color: #eccccc");
            break;
            
          case 16:
            buttonArray[i][j].setStyle("-fx-background-color: #e6baba");
            break;
            
          case 32:
            buttonArray[i][j].setStyle("-fx-background-color: #dfa9a8");
            break;
            
          case 64:
            buttonArray[i][j].setStyle("-fx-background-color: #d89796");
            break;
            
          case 128:
            buttonArray[i][j].setStyle("-fx-background-color: #d28584");
            break;
            
          case 256:
            buttonArray[i][j].setStyle("-fx-background-color: #cb7372");
            break;
            
          case 512:
            buttonArray[i][j].setStyle("-fx-background-color: #c56260");
            buttonArray[i][j].setTextFill(Color.web("#ffffff"));
            break;
            
          case 1024:
            buttonArray[i][j].setStyle("-fx-background-color: #be504e");
            buttonArray[i][j].setTextFill(Color.web("#ffffff"));
            break;
            
          case 2048:
            buttonArray[i][j].setStyle("-fx-background-color: #b34341");
            buttonArray[i][j].setTextFill(Color.web("#ffffff"));
            break;
            
          case 4096:
            buttonArray[i][j].setStyle("-fx-background-color: #9b3a38");
            buttonArray[i][j].setTextFill(Color.web("#ffffff"));
            break;
            
          default:
            buttonArray[i][j].setStyle("-fx-background-color: #893331");
            buttonArray[i][j].setTextFill(Color.web("#ffffff"));
            break;
        }
        
      }
    }
    
    //this will update the current score of the game
    label.setText("Score: " + getScore(array));
  }
  
  /**
   * Get the score by summing all the elements in the int array
   * @param array the input in array
   * @return the sum of all element in the array
   */
  private int getScore(int[][] array){
    int currentScore = 0;
    //loop through every element in the array and add it together
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length; j++){
        currentScore += array[i][j];
      }
    }
    //return the current score
    return currentScore;
  }
  
  /** 
   * Overrides the start method of Application to create the GUI with 2D button array in the center of the pane
   * @param primaryStage the JavaFX main window
   * @throws java.lang.Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception{
    //Access the parameters from the main
    //variables use to create the 2D button array and 2D int array for the game
    int length; 
    int width; 
    
    try { 
      
      //if nothing is put when running, set to default as 4 rows and 4 columns
      if (this.getParameters().getRaw().isEmpty()){
        width = 4;
        length = 4;
      }
      
      //for else, the board will create based on the input number
      else{
        width = Character.getNumericValue(this.getParameters().getRaw().get(0).charAt(0));
        length = Character.getNumericValue(this.getParameters().getRaw().get(1).charAt(0));
      }
      
      //create a 2D button array and 2D int array corresponds to what the parameters from the main
      //rows first, columns after
      buttonArray = new Button[width][length];
      array = new int[width][length];
    }
    
    //handle errors
    catch (Exception e){
      System.err.println("Please put 2 proper integer");
    }
    
    //create a grid pane
    GridPane grid = new GridPane();
    
    //set the board to the center
    grid.setAlignment(Pos.CENTER);
    
    //set the distance between the button
    grid.setVgap(5);
    grid.setHgap(5);
    
    //set the name for the game 
    primaryStage.setTitle("2048"); 
    
    //put the 2D button array to gridpane with appropriate number, color
    for (int i = 0; i < buttonArray.length; i++){
      for (int j = 0; j < buttonArray[i].length; j++){
        buttonArray[i][j] = new Button();
        buttonArray[i][j].setText("0");
        buttonArray[i][j].setStyle("-fx-background-color: #ffffff;");
        //set the min size for the button array
        buttonArray[i][j].setMinSize(60,60);
        buttonArray[i][j].setFont(buttonFont);
        //add button into gridpane, column first, row after
        grid.add(buttonArray[i][j], j, i);
      }
    }
    
    //set the appropriate button that have actions for clicking
    //update the board and add one after each click
    
    //all the button at the farmost to the left, except the top and the last one, has action to slide left
    for (int i = 1; i < buttonArray.length - 1; i++){
      buttonArray[i][0].setOnAction(
                                    (e) -> {
        for (int j = 0; j < array.length; j++){
          slideLeft(array, j);
        }
        addOne(array);
        update();
      });
    }
    
    //all the button at the farmost to the right, except the top and the last one, has action to slide right
    for (int i = buttonArray.length - 2; i > 0; i--){
      buttonArray[i][buttonArray[i].length - 1].setOnAction(
                                                            (e) -> {
        for (int j = 0; j < array.length; j++){
          slideRight(array, j);
        }
        addOne(array);
        update();
      });
    }
    
    //all the button at the top, except the first and the last one, has action to slide up
    for (int j = 1; j < buttonArray[0].length -1; j++){
      buttonArray[0][j].setOnAction(
                                    (e) -> {
        for (int i = 0; i < array[0].length; i++){
          slideUp(array,i);
        }
        addOne(array);
        update();
        
      });
    }
    
    //all the button at the bottom, except the first and the last one, has action to slide down
    for (int j = 0; j < buttonArray[0].length - 1; j++){
      buttonArray[buttonArray.length - 1][j].setOnAction(
                                                         (e) -> {
        for (int i = 0; i < array[0].length; i++){
          slideDown(array,i);
        }
        addOne(array);
        update();
      });
    }
    
    //a button on the  bottom corner right has the action to slide down right
    buttonArray[buttonArray.length -1][buttonArray[0].length - 1].setOnAction(
                                                                              (e) -> {
      slideDownRight(array);
      addOne(array);
      update();
    });
    
    //a button on the bottom corner left has the action to slide down left
    buttonArray[buttonArray.length -1][0].setOnAction(
                                                      (e) -> {
      slideDownLeft(array);
      addOne(array);
      update();
    });
    
    //a button on the top corner right has the action to slide up right
    buttonArray[0][buttonArray[0].length-1].setOnAction(
                                                        (e) -> {
      slideUpRight(array);
      addOne(array);
      update();
    });
    
    //a button on the top corner left has the action to slide up left
    buttonArray[0][0].setOnAction(
                                  (e) -> {
      slideUpLeft(array);
      addOne(array);
      update();
    });
    
    //set the font of the label of the score 
    label.setFont(font);
    
    //create a border pane to add everything together
    BorderPane borderPane = new BorderPane();
    
    //add the gridpane that holds the button array in the center
    borderPane.setCenter(grid);
    
    //add the label that update the score on the top 
    borderPane.setTop(label);
    
    //set background color or the border pane
    borderPane.setStyle("-fx-background-color:#ece5dd");
    
    //create a scene contains the borderpane. The size of the scene depends on the 2D int array
    Scene scene = new Scene(borderPane, array.length*100, array[0].length*100);
    
    //add the scene to the  the stage and show it
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * The method to launch the program.
   * @param args  The command line arguments.  The arguments are passed on to the JavaFX application.
   */
  public static void main(String[] args){
    Application.launch(args);
  }
  
  /** React to a button click:  depends on the button
    * @param e  information about the button click event that occurred
    */
  private class BasicClick implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      Button b = (Button)e.getSource(); 
    }
  }
} 
            
        
