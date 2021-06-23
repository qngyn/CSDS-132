public class SnowFlake extends Polygon implements RegularPolygon {
  //create a field for base shape
  private NGon baseShape; 
  
  //create a field for number of levels for fractals
  private int numLevels;
  
    /**
     * the constructor of SnowFlakes that takes NGon as baseShape and int numLevels as 
     * @param baseShape the base shape use for fractals
     * @param numLevels the number of levels of fractals
     */
    public SnowFlake(NGon baseShape, int numLevels){
    this.baseShape = baseShape;
    this.numLevels = numLevels;
    setCenter(baseShape.getCenter());
    this.setPoints(calculatePoints(this.baseShape, numLevels));
  }
  
    /**
     * Return the number of levels of fractals
     * @return the number of levels of fractals
     */
    public int getNumLevels(){
    return this.numLevels; 
  }
  
    /**
     * Change the number of levels of fractals
     * @param newLevels the new number of fractals
     */
    public void setNumLevels(int newLevels){
    this.numLevels = newLevels;
    
  }
  
    /**
     * Return the Shape of the Base
     * @return the shape of the base 
     */
    public NGon getBaseShape(){
    return baseShape;
  }
  
    /**
     * Return an array of points makes up the corners of fractals
     * @param baseShape the base of shape use for SnowFlakes
     * @param numLevels the number of levels ofr fractals
     * @return an array of points makes up the corners of fractals
     */
    public Point[] calculatePoints(NGon baseShape, int numLevels) {
    //create a variable for counting the elements in the loop
    int counter = 0;
    
    //a variable to determine the size of the array of points of the corners.
    int size = baseShape.getLines().length*3 + baseShape.getPoints().length;
    
    //create an array of points to keeps those fractals' corners points
    Point[] newPoints=new Point[size]; ;
    
    //if the number of levels equals to zero, return the array of points of the corners of base shape.
    if (this.getNumLevels() == 0) {
      return (RegularPolygon.calculatePoints(baseShape.getCenter(), baseShape.getNumSides(), baseShape.getSideLength()));
    } 
    
    //if the number of levels different than zero, it will return an array of points of the corners of fractals
    else {
        //loop for storing the points of the fractals through each level of fractal
      for (int levels = 1; levels <= this.getNumLevels(); levels++) {
        
          //these variables helps to reset the size into a new one, and newPoints and counter in order for using the next loop of levels
        size = baseShape.getLines().length*3 + baseShape.getPoints().length;
        newPoints = new Point[size];
        counter=0;
       
        //a loop through each line of the base shape for creating three points for the fractals
        for (int i = 0; i < baseShape.getLines().length ; i++) {
          
          // an amount of increment of the points determine by the the line dividing into three 
          double incrementX = (baseShape.getLines()[i].getFirstPoint().getX() + baseShape.getLines()[i].getSecondPoint().getX()) / 3;
          double incrementY = (baseShape.getLines()[i].getFirstPoint().getY() + baseShape.getLines()[i].getSecondPoint().getY()) / 3;
          
          //the point of the increment is by the x and y cooridnate of the first point add the increment
          Point t1 = new Point(baseShape.getLines()[i].getFirstPoint().getX() + incrementX, baseShape.getLines()[i].getFirstPoint().getY() + incrementY);
          
          //this will store the point that make the top of the fractal
          t1.rotateAbout(t1, Math.PI / 3);
          Point outShape = t1;
          
          //this is the second point of the increment by adding x and y coordinate from the first increment point.
          Point t2 = new Point(t1.getX() + incrementX, t1.getY() + incrementY);

          //store those points in order to make the SnowFlakes
          newPoints[counter] = baseShape.getLines()[i].getFirstPoint();
          newPoints[counter++] = t1;
          newPoints[counter++] = outShape;
          newPoints[counter++] = t2;
          newPoints[counter++] = baseShape.getLines()[i].getSecondPoint();
          
        }
        //those points will be store in the newPoints
        baseShape.setPoints(newPoints);
      }
      //return the array of points makes up the SnowFlakes.
      return newPoints;
    }
  }

}
