/**
 * The abstract class for all polygon types
 * @author 
 */
public class Polygon {
  //a private field for center point//
  private Point center;
  
  //a private field for array of points//
  private Point[] polygonPoints;
  
  //a private field for array of lines//
  private Line[] polygonLines;
  
  /**
   * The constructor of Polygon holds the points of polygon and its center
   * @param points an array of points has length larger than 2 representing the points make up the polygon
   */
  public Polygon(Point...points) {
    
    this.polygonPoints = points;
    this.polygonLines = getLines();
    if(!(this instanceof Triangle || this instanceof NGon || this instanceof SnowFlake)){
      this.center = findCenter();
    }
    
  }
  
  /**
   * Find the center of the arbitrary polygon
   * @return the center of polygon
   */
  public Point findCenter(){
    //create variable for storing points after the llopo 
    double minX = this.getPoints()[0].getX();
    double maxX = minX;
    double minY = this.getPoints()[0].getY();
    double maxY = minY;
    
    //this loop will go through each point of the polygon to compare them and getting the lowest and highest point of the polygon
    for (int i = 0; i < getPoints().length - 1; i++){
      //store the x-coordination of this point if it is smaller than the other point's x-coordinate
      if (getPoints()[i].getX() < minX){
        minX = getPoints()[i].getX();
      }
      
      //store the x-coordination of this point if it is larger than the other point's x-coordinate
      if(getPoints()[i].getX() > maxX){
        maxX = getPoints()[i].getX();
      }
      
      //store the y-coordination of this point if it is smaller than the other point's y-coordinate
      if (getPoints()[i].getY() < minY){
        minY = getPoints()[i].getY();
      }
      
      //store the y-coordination of this point if it is larger than the other point's y-coordinate
      if (getPoints()[i].getY() > maxY){
        maxY = getPoints()[i].getY();
      } 
    }
    
    //calculation the coordination of the center of the polygon
    double centerX = (minX + maxX)/2;
    double centerY = (minY + maxY)/2; 
    
    //set the center of the polygon for returning.
    Point center = new Point(centerX, centerY);
    return center;
  }
  
  /**
   * Returns the center of the Polygon 
   * @return
   */
  public Point getCenter(){
    return center;
  }
  
  /**
   * Changes the center of the Polygon and moves all the point of the polygon according to the new center
   * @param newCenter the input point for set the new center
   */
  public void setCenter(Point newCenter){
    
    //only moving all the point when there exists a center before that
    if (this.getCenter() !=null){
      
      //variable for using in the loop 
      //calculate the distance different between the old and new center by using theirs x and y coordinate
      double deltaX = newCenter.getX() - this.getCenter().getX();
      double deltaY = newCenter.getY() - this.getCenter().getY();
      
      //loop through each point of polygon and move it based on the center
      for (int i = 0; i < getPoints().length; i++){
        
        //move the point by its x-coordinate
        getPoints()[i].setX(getPoints()[i].getX() + deltaX);
        
        //move the point by its y-coordinate
        getPoints()[i].setY(getPoints()[i].getY() + deltaY);
      }   
    }
    //set the input point to as the center
    this.center = newCenter;
  }
  
  /**
   * Rotate all the points of polygon about its center by this angle
   * @param angle presenting the angle for rotate the points
   */
  public void rotate(double angle){
    
    //loop through each point of the polygon and rotate it
    for (int i = 0; i < getPoints().length; i++) {
      getPoints()[i].rotateAbout(getCenter(), angle);
    }
  }
  
  /**
   * Returns an array of lines make up the polygon
   * @return an array of lines make up the polygon
   */
  public Line[] getLines(){  
    
    //if there is 1 points, no line can be create so return null
    if (this.getPoints().length <= 1){
      return null;
    }
    
    //if there is 2 points, only one line can create by using those points as it endpoints. 
    else if(this.getPoints().length ==2){
      
      //create an array to store the line 
      Line[] lineArray = new Line[1];
      lineArray[0] = new Line(this.getPoints()[0], this.getPoints()[1]);
      
      //store the line array to the polygonLines
      polygonLines = lineArray;
    }
    
    //if there is more than 2 points 
    else if (this.getPoints().length > 2){
      
      //create an array to store the lines
      Line[] lineArray = new Line[this.getPoints().length];
      
      //loop through each point and create the point by using that current point and its next point until the next last point
      for (int i = 0; i < this.getPoints().length -1; i++){
        
        //store the create line into the array
        lineArray[i] = new Line(this.getPoints()[i], this.getPoints()[i+1]);
      }
      
      //store the line make up by the last point and first point to the current line array
      lineArray[lineArray.length-1] = new Line(this.getPoints()[this.getPoints().length-1], this.getPoints()[0]);
      
      //store the array to the polygonLines
      polygonLines = lineArray;
    }
    
    //return the array of lines 
    return polygonLines;  
  }
  

  /**
   * return an array of points make up the polygoon
   * @return an array of points make up the polygon
   */
  public Point[] getPoints(){
    return polygonPoints;
  }
  
  /**
   * Store an array of points into the polygon
   * @param points an array of points needed to be stored
   */
  public void setPoints(Point...points){
    this.polygonPoints = points;
  }
  
  @Override
  /**
   * Return a string representing the x and y coordinate of points make up the polygon
   * @return a string of x and y coordination
   */
  public String toString(){
    StringBuilder builder = new StringBuilder(); 
    for (int i = 0; i < getPoints().length; i++){
      if ( i < getPoints().length -1) {
        builder.append("x:" + getPoints()[i].getX() + ",");
        builder.append("y:"+ getPoints()[i].getY() + "; ");
      }
      
      if (i == getPoints().length -1){
        builder.append("x:" + getPoints()[i].getX() + ", ");
        builder.append("y:"+ getPoints()[i].getY() + ".");
      }
    }
    return builder.toString();
  }
}
