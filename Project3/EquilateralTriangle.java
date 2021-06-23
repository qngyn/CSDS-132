/** 
* the class of Equilateral Triangle
* @author 
*/
public class EquilateralTriangle extends NGon implements RegularPolygon{ 

  /**   
  * the constructor for equilateral triangle   
  * @param center the center of the equilateral triangle   
  * @param sideLength the side length of the triangle   
  */  
  public EquilateralTriangle(Point center, double sideLength){    
    super(center, 3, sideLength);    
    setCenter(center);    
    setSideLength(sideLength);  
  }
} 
