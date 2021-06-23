/**
 * The class of Triangle shape extends from Polygon
 * @author
 */
public class Triangle extends Polygon {
  //a field to store first point
  private Point p1;
  
  //a field to store second point
  private Point p2;
  
  //a field to store thrid point
  private Point p3; 
  
  /**
   * the constructor of the triangle 
   * @param p1 the first point of the triangle
   * @param p2 the second point of the triangle
   * @param p3 the third point of the triangle
   */
  public Triangle(Point p1, Point p2, Point p3){
    //pass this into the polygon
    super(p1,p2,p3);
    
    //set the center of the triangle
    this.setCenter(Triangle.calculateCenterPoint(p1,p2,p3));
  }
  
  /**
   * Return the center of the Triangle based on the points make up the triangle
   * @param p1 the first point of the triangle
   * @param p2 the second point of the triangle
   * @param p3 the third point of the triangle
   * @return the center of triangle
   */
  public static Point calculateCenterPoint(Point p1, Point p2, Point p3){
    //a variable for storing the x cooridnate of the third point    
    double x1 = p3.getX();
    //a variable for storing the y cooridnate of the third point 
    double y1 = p3.getY(); 
    
    //a variable for storing the x cooridnate of middle point of the side triangle make by the first and second point
    double x2 = (p1.getX() + p2.getX())/2;
    
    //a variable for storing the y cooridnate of middle point of the side triangle make by the first and second point
    double y2 = (p1.getY() + p2.getY())/2;
    
    //a variable for storing the x cooridnate of the first point   
    double x3 = p1.getX();
    
    //a variable for storing the y cooridnate of the third point   
    double y3 = p1.getY(); 
    
    //a variable for storing the x cooridnate of middle point of the side triangle make by the third and second point
    double x4 = (p2.getX() + p3.getX())/2;
    
    //a variable for storing the y cooridnate of middle point of the side triangle make by the third and second point
    double y4 = (p2.getY() + p3.getY())/2;
    
    //a variable for the x coordinate of the center
    double x = ((x1*y2 - y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
    
    //a variable for the y coordinate of the center
    double y = ((x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));  
    
    //create a center point based on the x and y coordinate
    Point newCenter = new Point(x,y);
    
    //return the center
    return newCenter;
  }
}
