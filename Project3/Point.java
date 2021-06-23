/**
 * The class of 2-dimensional Point
 * @author 
 */
public class Point {
  //private field for store x
  private double x; 
  
  //private field for store y
  private double y; 
  
  
  /**
   * the constructor
   * @param x a double number for x-coordinate of the point
   * @param y a double number for y-coordinate of the point
   */
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  
  /**
   * Returns the x-coordinate of the point
   * @return the x-coordinate of the point
   */
  public double getX(){
    return x;
  }
  
  /**
   * changes the x coordinate of the point
   * @param x set a different double number for x-coordinate of the point 
   */
  public void setX(double x){
    this.x = x;
  }
  
  /**
   * Returns the y-coordinate of the point
   * @return the y-coordinate of the point
   */
  public double getY(){
    return y;
  }
  
  /**
   * Changes the y-coordinate of the point
   * @param y change the y-coordinate to this double number
   */
  public void setY(double y){
    this.y = y;
  }
  
  /**
   * Rotate the point and set the results to be this point's new coordinate
   * @param rotation rotate the point about this rotation point
   * @param angle rotate the point about the rotation point by this angle in radians
   */
  public void rotateAbout(Point rotation, double angle){
    //a varaible  to subtract the this point's x-coordinate by the input point rotation's x-coordinate
    double subX = this.getX() - rotation.getX();
    
    //a varaible  to subtract the this point's y-coordinate by the input point rotation's y-coordinate
    double subY = this.getY() - rotation.getY();
    
    //a variable to calculate the new x-coordination of this point
    double rotX = (subX*Math.cos(angle) - subY*Math.sin(angle)) + rotation.getX();
    
    //a variable to calculate the new y-coordination of this point
    double rotY = (subX*Math.sin(angle) + subY*Math.cos(angle)) + rotation.getY();
    
    //set the new coordination into the x and y of this point
    this.setX(rotX);
    this.setY(rotY);   
  }   
}
