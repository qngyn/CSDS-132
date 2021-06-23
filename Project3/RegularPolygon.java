/**
 * an interface for the regular polygon
 * @author 
 */
public interface RegularPolygon {
  
  /**
   * returns an array of points make up the regular polygon
   * @param center the center of regular polygon
   * @param numSides the number of sides of the regular polygon
   * @param sideLength the side length of the regular polygon
   * @return an array of numSides points make up the regular polygon
   */
  public static Point[] calculatePoints(Point center, int numSides, double sideLength){
    //create an array for store the numSides points
    Point[] nGonPoints = new Point[numSides];
    
    //a variable for the radius of the regular polygon
    double radius = sideLength/(2*Math.tan(Math.PI/numSides));
    
    //a loop for storing the points of the regular polygon by calculating each x and y coordination and store it into the array
    for (int i = 0; i < numSides; i++){
      nGonPoints[i] = new Point(radius*Math.cos((2*Math.PI*i)/numSides)+center.getX(), radius*Math.sin((2*Math.PI*i)/numSides) +center.getY());
    }
    
    //return the stored numSides's points array
    return nGonPoints;
  }
}
