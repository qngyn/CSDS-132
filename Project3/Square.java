/**
 * the Square class 
 * @author 
 */
public class Square extends NGon implements RegularPolygon{
  
  /**
   * the constructor of the square
   * @param center the center of the square
   * @param sideLength the side length of the square
   */
  public Square(Point center, double sideLength){
    super(center, 4, sideLength); 
    setCenter(center);
  }
  
  /**
   * return the side length of the square
   * @return the side length of the square
   */
  public double getWidth(){
    return super.getSideLength();
  }
  
  /**
   * set the side length of the square
   * @param newSideLength the new side length of the square
   */
  public void setWidth(double newSideLength){
    super.setSideLength(newSideLength);
  }
  
  /**
   * return the side length of the square
   * @return the side length of the square
   */
  public double getHeight(){
    return super.getSideLength();
  }
  
  /**
   * set the side length of the square
   * @param newSideLength the new side length of the square
   */
  public void setHeight(double newSideLength){
    super.setSideLength(newSideLength);
  }  
}
    
