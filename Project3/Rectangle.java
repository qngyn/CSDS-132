/**
 * The class for the Rectangle extends from the Polygon
 * @author 
 */
public class Rectangle extends Polygon{
  //a private field for store height
  private double height;
  
  //a private field for store width
  private double width;
  
  /**
   * the constructor for the rectangle
   * @param center the center of the rectangle
   * @param height the height of rectangle
   * @param width the width of rectangle
   */
  public Rectangle(Point center, double height, double width){
    //pass to the constructor of the Polygon
    super(Rectangle.calculatePoints(center, height, width));
    this.width = width;
    this.height = height;
    
    //set the input point as the center of the rectangle
    setCenter(center);
  }
  
  /**
   * Returns the array of 4 points make up the Rectangle by calculating
   * @param center the current center of the rectangle
   * @param height the height of the rectangle
   * @param width the width of rectangle
   * @return the array of 4 points make up the Rectangle
   */
  public static Point[] calculatePoints(Point center, double height, double width){
    //create an array of points to store points
    Point[] recPoints;
    
    //variable to store the x-coordination of the right of the rectangle
    double rightX = center.getX() + width/2;
    
    //variable to store the x-coordinate of the left of the rectangle
    double leftX = center.getX() - width/2;
    
    //variable to store the upper y-coordinate of the rectangle
    double upperY = center.getY() + height/2;
    
    //variable to store the lower y-coordinate of the rectangle
    double bottomY = center.getY() - height/2;
    
    //create point represent the upper right point of rectangle
    Point upperRight = new Point(rightX, upperY);
    
    //create point present the bottom right point of rectangle
    Point bottomRight = new Point(rightX, bottomY );
    
    //create point represent the upper left point of rectagle
    Point upperLeft = new Point(leftX, upperY);
    
    //create point present the bottom left point of rectangle
    Point bottomLeft = new Point(leftX, bottomY);
    
    //store all the points into the array of points of rectangle
    recPoints = new Point[]{ upperRight, bottomRight, upperLeft, bottomLeft};
    
    //return the array of points of rectangle
    return recPoints;
  }
  
  /**
   * Return the width of Rectangle
   * @return the width of rectangle
   */
  public double getWidth(){
    return width;
  }
  
  /**
   * Change the current width to the new width
   * @param newWidth the new input double width for the rectangle
   */
  public void setWidth(double newWidth){
    this.width = newWidth;
  }
  
  /**
   * Returns the height of Rectangle
   * @return
   */
  public double getHeight(){
    return height;
  }
  
  /**
   * Change the current height to the new height
   * @param newHeight the new input double height for the rectangle
   */
  public void setHeight(double newHeight){
    this.height = newHeight;
  }  
}
