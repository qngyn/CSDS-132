/**
 * a class of n-gon extends from the polygon
 * @author 
 */
public class NGon extends Polygon implements RegularPolygon{

  //a field for number of sides of n-gon
  private int numSides; 
  
  // a field for the side length of n-gon
  private double sideLength;
  
    /**
     *
     * @param center
     * @param numSides
     * @param sideLength
     */
    public NGon(Point center, int numSides, double sideLength){
    super(RegularPolygon.calculatePoints(center, numSides, sideLength));
    this.numSides = numSides;
    this.sideLength = sideLength;
    setCenter(center);
  }
  
    /**
     * Return the side length of n-gon
     * @return the side length of n-gon
     */
    public double getSideLength(){
    return this.sideLength;
  }
  
    /**
     * set the new length for the n-gon
     * @param newLength
     */
    public void setSideLength(double newLength){
    this.sideLength = newLength;
    setPoints(RegularPolygon.calculatePoints(getCenter(), getNumSides(), sideLength));
  }    
  
    /**
     * Returns the number of sides of the n-gon
     * @return the number of sides of the n-gon
     */
    public int getNumSides(){
    return this.numSides;
  }
}
