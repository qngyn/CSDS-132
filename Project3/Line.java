/**
 * The class line of for 2D segment
 * @author 
 */
public class Line {
  //a private field for first point x-coordinate
  private double x1;
  
  //a private field for first point y-cooridnate
  private double y1;
  
  //a private field for second point x-coordinate
  private double x2;
  
  //a private field for second point y-coordinate
  private double y2;
  
  //a private field for the first point
  private Point firstPoint = new Point(x1, y1);
  
  //a private field for the second point
  private Point secondPoint = new Point(x2 , y2);
  
  /**
   * The constructor that takes four double values representing the coordinate of the endpoints of the Line. 
   * @param x1 the first point's x-coordinate
   * @param y1 the first point's y-coordinate
   * @param x2 the second point's x-coordinate
   * @param y2 the second point's y-coordinate
   */
  public Line(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    
  }
  
  /**
   * the constructor that takes two points representing the coordination of the endpoints of the line. 
   * @param firstPoint the first point of the line
   * @param secondPoint the second point of the line
   */
  public Line(Point firstPoint, Point secondPoint){
    this.firstPoint =  firstPoint;
    this.secondPoint = secondPoint; 
  }
  
  /**
   * Returns the first point of the line
   * @return the first point of the line
   */
  public Point getFirstPoint(){
    return this.firstPoint;
  }
  
  /**
   * Changes the first point of the line
   * @param firstPoint change the current first point of the line to the new input point 
   */
  public void setFirstPoint(Point firstPoint){
    this.firstPoint = firstPoint;
  }
  
  /**
   * return the second point of the line
   * @return the second point of the line
   */
  public Point getSecondPoint(){
    return this.secondPoint;
  }
  
  /**
   * Changes the second point of the line 
   * @param secondPoint change the current second point of the line to the new input point
   */
  public void setSecondPoint(Point secondPoint){
    this.secondPoint = secondPoint;
  }
  
  /**
   * Returns the array containing a line
   * @return the array containing a line
   */
  public Line[] getLines(){
    //create a lineArray to store the line make by two input points
    Line[] lineArray = new Line[]{this}; 
    return lineArray;
  }
}
