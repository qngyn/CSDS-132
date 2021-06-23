import static org.junit.Assert.*;
import org.junit.Test;

public class HW3Test{

 //Test Point class//
  
  //Test the method get x-coordinate of the point
  //It can be tested with different points
  @Test
  public void testGetX(){
    Point p = new Point(2,4);
    assertEquals(2.0, p.getX(), 0);
  }
  
  //Test the method set the x-coordinate of the point
  //It can be tested with different points
  @Test
  public void testSetX(){
    Point p = new Point(2,4);
    p.setX(8);
    assertEquals(8.0, p.getX(),0);
  }
  
  //Test method get y-coordinate of the point
  //It can be tested with different points
  @Test 
  public void testGetY(){
    Point p = new Point(2,4);
    assertEquals(4.0, p.getY(), 0);  
  }
  
  //Test the method set the y-coorindate of the point 
  //It can be tested with different points
  @Test
  public void testSetY(){
    Point p = new Point(2,4);
    p.setY(8);
    assertEquals(8.0, p.getY(),0);
  }
  
  //Test method rotateAbout(double angle)
  //It can be tested with different points
  @Test 
  public void testRotateAbout(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(9,0);
    p1.rotateAbout(p2, Math.PI/2);
    assertEquals(9.0 , p1.getX(), 0);
    assertEquals(-9.0, p1.getY(),0);
  }
  
 //Test Line class
  
  //Test method get the first point of the line
  //it can be tested with different lines
  @Test 
  public void testGetFirstPoint(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(9,9);
    Line l1 = new Line(p1,p2);
    assertEquals(p1, l1.getFirstPoint());
  }
  
  //test method set the first point of the line
  //it can be tested with different lines
  @Test 
  public void testSetFirstPoint(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(9,9);
    Line l1 = new Line(p1,p2);
    Point p3 = new Point(3,3);
    l1.setFirstPoint(p3);
    assertEquals(p3, l1.getFirstPoint());
  }
  
  //Test  method get the second point of the line
  //it can be tested with different lines
  @Test 
  public void testGetSecondtPoint(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(9,9);
    Line l1 = new Line(p1,p2);
    assertEquals(p2, l1.getSecondPoint());
  }
  
  //Test method set the second point of the line
  //it can be tested with different lines
  @Test 
  public void testSetSecondPoint(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(9,9);
    Line l1 = new Line(p1,p2);
    Point p3 = new Point(3,3);
    l1.setSecondPoint(p3);
    assertEquals(p3, l1.getSecondPoint());
  }
  
  //Test method getLines 
  @Test
  public void testGetLines(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(9,9);
    Line l1 = new Line(p1,p2);
    Line[]array = new Line[]{l1};
    assertArrayEquals(array, l1.getLines());
  }
  
 //Test Polygon class and its subclass
  
  //Test method find the center of the polygon
  //this method doesn't apply for triangle, NGon and its subclasses (Square, EquilateralTriangle), and SnowFlakes
  //can be used with any array of points has length more than 2
  @Test
  public void testFindCenter(){
    //Test for four points
    Point p1 = new Point(-4,8);
    Point p2 = new Point(-4,-8);
    Point p3 = new Point(4,8);
    Point p4 = new Point(4,-8);
    Polygon p = new Polygon(p1,p2,p3,p4);
    assertEquals(0.0, p.findCenter().getX(),0);
    assertEquals(0.0, p.findCenter().getY(),0);
    
    //Test for five points
    Point a1 = new Point(0,0);
    Point a2 = new Point (4,6);
    Point a3 = new Point(8,7);
    Point a4 = new Point(3,9);
    Point a5 = new Point(-1,-5);
    Polygon a = new Polygon(a1,a2,a3,a4,a5);
    assertEquals(4.0, a.findCenter().getX(),0);
    assertEquals(4.5, a.findCenter().getY(),0);
  }
  
  //Test method get center of the polygon
  //This method apply for all types of Polygon
  @Test
  public void testGetCenter(){
    //Test for polygon
    Point p1 = new Point(-4,8);
    Point p2 = new Point(-4,-8);
    Point p3 = new Point(4,8);
    Point p4 = new Point(4,-8);
    Polygon p = new Polygon(p1,p2,p3,p4);
    assertEquals(0.0, p.getCenter().getX(),0);
    assertEquals(0.0, p.getCenter().getY(),0);
    
    //Test for Triangle
    Triangle tr1 = new Triangle(new Point(5,5), new Point(12,8), new Point(9,9));
    assertEquals(8, (int) tr1.getCenter().getX(),0);
    assertEquals(7, (int) tr1.getCenter().getY(),0);
    
    //Test for Rectangle
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    assertEquals(0.0, r1.getCenter().getX(),0);
    assertEquals(0.0, r1.getCenter().getY(),0);
    
    //Test for NGon
    NGon penta = new NGon(new Point(1,1), 5, 10);
    assertEquals(1.0, penta.getCenter().getX(),0);
    assertEquals(1.0, penta.getCenter().getY(),0);
    
    //Test for Square
    Square s1 = new Square(new Point(1,1), 4);
    assertEquals(1.0, s1.getCenter().getX(),0);
    assertEquals(1.0, s1.getCenter().getY(),0);
    
    //Test for EquilateralTriangle
    EquilateralTriangle eq1 = new EquilateralTriangle((new Point(1,1)), 4);
    assertEquals(1.0, eq1.getCenter().getX(),0);
    assertEquals(1.0, eq1.getCenter().getY(),0);                                                                                             
  }
  
  //Test the method change the center of the polygon and mooves all the point of the polygon associating with the new center
  //Can be used for all types of polygon. 
  @Test 
  public void testSetCenter(){
    //Test for polygon - with many points
    Point p1 = new Point(-4,8);
    Point p2 = new Point(-4,-8);
    Point p3 = new Point(4,8);
    Point p4 = new Point(4,-8);
    Polygon p = new Polygon(p1,p2,p3,p4);
    p.setCenter(new Point(5,5));
    assertEquals(5.0, p.getCenter().getX(),0);
    assertEquals(5.0, p.getCenter().getY(),0);
    assertEquals("x:1.0,y:13.0; x:1.0,y:-3.0; x:9.0,y:13.0; x:9.0, y:-3.0.", p.toString());
    
    //Test for Rectangle
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    r1.setCenter(new Point(2,2));
    assertEquals(2.0, r1.getCenter().getX(),0);
    assertEquals(2.0, r1.getCenter().getY(),0);
    assertEquals("x:6.0,y:5.0; x:6.0,y:-1.0; x:-2.0,y:5.0; x:-2.0, y:-1.0.", r1.toString());
    
    //Test for Triangle - with at least three points
    Triangle tr1 = new Triangle(new Point(5,5), new Point(12,8), new Point(9,9));
    tr1.setCenter(new Point(8,8));
    assertEquals(8.0, tr1.getCenter().getX(),0);
    assertEquals(8.0, tr1.getCenter().getY(),0);
    assertEquals("x:4.333333333333334,y:5.666666666666667; x:11.333333333333334,y:8.666666666666668; x:8.333333333333334, y:9.666666666666668.", tr1.toString());
    
    //Test for NGon
    NGon penta = new NGon(new Point(1,1), 5, 10);
    penta.setCenter(new Point(0,0));
    assertEquals("x:6.881909602355868,y:0.0; x:2.1266270208801,y:6.545084971874737; x:-5.567581822058033,y:4.045084971874738; x:-5.567581822058034,y:-4.045084971874736; x:2.1266270208800986, y:-6.545084971874737.", penta.toString());
    assertEquals(0.0, penta.getCenter().getX(),0);
    assertEquals(0.0, penta.getCenter().getY(),0);
  }
  
  //Test method that rotate all the points of polygon about its center by this angle
  //this can be used for all types of polygon
  @Test
  public void testRotate(){
    //with 0 radian
    Triangle tr1 = new Triangle(new Point(5,5), new Point(12,8), new Point(9,9));
    tr1.rotate(0);
    assertEquals("x:5.0,y:5.0; x:12.0,y:8.0; x:9.0, y:9.0.", tr1.toString());
    
    //with 1 degree
    Rectangle r1 = new Rectangle(new Point(0,0), 4, 6);
    r1.rotate(Math.PI/180);
    assertEquals("x:2.964638272594607,y:2.052052609624633; x:3.034447898343741,y:-1.947338171000932; x:-3.034447898343741,y:1.947338171000932; x:-2.964638272594607, y:-2.052052609624633.", r1.toString());
    
    //with many degree
    EquilateralTriangle eq1 = new EquilateralTriangle((new Point(0,0)), 4);
    eq1.rotate(Math.PI/3);
    assertEquals("x:0.5773502691896261,y:1.0000000000000002; x:-1.154700538379252,y:3.885780586188048E-16; x:0.5773502691896255, y:-1.0000000000000009.", eq1.toString());
  }
  
  //Test method that returns an array of lines make up the polygon
  //this can be used for all polygon
  @Test
  public void testGetLinesPoly(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(5,5);
    Point p3 = new Point(4,2);
    Point p4 = new Point(2,4);
    
    //Test 1 point - no line
    Polygon poly = new Polygon (new Point(0,0));
    assertArrayEquals(null, poly.getLines());
    
    //Test 2 point - 1 line
    Line[]array = new Line[1];
    array[0] = new Line(p1,p2);
    Polygon poly2 = new Polygon(p1,p2);
    assertEquals(array[0].getFirstPoint().getX(), poly2.getLines()[0].getFirstPoint().getX(),0);
    assertEquals(array[0].getFirstPoint().getY(), poly2.getLines()[0].getFirstPoint().getY(),0);
    assertEquals(array[0].getSecondPoint().getX(), poly2.getLines()[0].getSecondPoint().getX(),0);
    assertEquals(array[0].getSecondPoint().getY(), poly2.getLines()[0].getSecondPoint().getY(),0);
    
    //Test many points - many lines
    Point x = new Point(0,0);
    Point y = new Point(1,1);
    Point z = new Point(3,5);
    Point w = new Point(4,6);
    
    Polygon p = new Polygon(x,y,z,w);
    Line[] lines = new Line[4];
    lines[0] = new Line(x,y);
    lines[1] = new Line(y,z);
    lines[2] = new Line(z,w);
    lines[3] = new Line(w,x);
    assertEquals(lines[0].getFirstPoint().getY(), p.getLines()[0].getFirstPoint().getY(),0);
    assertEquals(lines[0].getSecondPoint().getX(), p.getLines()[0].getSecondPoint().getX(),0);
    assertEquals(lines[0].getSecondPoint().getY(), p.getLines()[0].getSecondPoint().getY(),0);
    assertEquals(lines[1].getFirstPoint().getX(), p.getLines()[1].getFirstPoint().getX(),0);
    assertEquals(lines[1].getFirstPoint().getY(), p.getLines()[1].getFirstPoint().getY(),0);
    assertEquals(lines[1].getSecondPoint().getX(), p.getLines()[1].getSecondPoint().getX(),0);
    assertEquals(lines[1].getSecondPoint().getY(), p.getLines()[1].getSecondPoint().getY(),0);
    assertEquals(lines[2].getFirstPoint().getX(), p.getLines()[2].getFirstPoint().getX(),0);
    assertEquals(lines[2].getFirstPoint().getY(), p.getLines()[2].getFirstPoint().getY(),0);
    assertEquals(lines[2].getSecondPoint().getX(), p.getLines()[2].getSecondPoint().getX(),0);
    assertEquals(lines[2].getSecondPoint().getY(), p.getLines()[2].getSecondPoint().getY(),0);
    assertEquals(lines[3].getFirstPoint().getX(), p.getLines()[3].getFirstPoint().getX(),0);
    assertEquals(lines[3].getFirstPoint().getY(), p.getLines()[3].getFirstPoint().getY(),0);
    assertEquals(lines[3].getSecondPoint().getX(), p.getLines()[3].getSecondPoint().getX(),0);
    assertEquals(lines[3].getSecondPoint().getY(), p.getLines()[3].getSecondPoint().getY(),0);
    
    //Test example applying for Rectangle class - many lines
    Rectangle r1 = new Rectangle(x, 6, 8);
    assertEquals(4, r1.getLines().length,0);
    assertEquals(4.0, r1.getLines()[0].getFirstPoint().getX(),0);
    assertEquals(3.0, r1.getLines()[0].getFirstPoint().getY(),0);
    assertEquals(4.0, r1.getLines()[0].getSecondPoint().getX(),0);
    assertEquals(-3.0, r1.getLines()[0].getSecondPoint().getY(),0);
    assertEquals(4.0, r1.getLines()[1].getFirstPoint().getX(),0);
    assertEquals(-3.0, r1.getLines()[1].getFirstPoint().getY(),0);
    assertEquals(-4.0, r1.getLines()[1].getSecondPoint().getX(),0);
    assertEquals(3.0, r1.getLines()[1].getSecondPoint().getY(),0);
    assertEquals(-4.0, r1.getLines()[2].getFirstPoint().getX(),0);
    assertEquals(3.0, r1.getLines()[2].getFirstPoint().getY(),0);
    assertEquals(-4.0, r1.getLines()[2].getSecondPoint().getX(),0);
    assertEquals(-3.0, r1.getLines()[2].getSecondPoint().getY(),0);
    assertEquals(-4.0, r1.getLines()[3].getFirstPoint().getX(),0);
    assertEquals(-3.0, r1.getLines()[3].getFirstPoint().getY(),0);
    assertEquals(4.0, r1.getLines()[3].getSecondPoint().getX(),0);
    assertEquals(3.0, r1.getLines()[3].getSecondPoint().getY(),0);
  }
  
  //this test method return the array of points make up the polygon 
  //can be sued for any types of polygon
  @Test
  public void testGetPoints(){
    //Test Polygon
    Polygon p = new Polygon(new Point(-4,8), new Point(-4,-8), new Point(4,8), new Point(4,-8), new Point(0,0));
    assertEquals(-4.0,p.getPoints()[0].getX(),0);
    assertEquals(8.0, p.getPoints()[0].getY(),0);
    assertEquals(-4.0, p.getPoints()[1].getX(),0);
    assertEquals(-8.0, p.getPoints()[1].getY(),0);
    assertEquals(4.0, p.getPoints()[2].getX(),0);
    assertEquals(8.0, p.getPoints()[2].getY(),0);
    assertEquals(4.0, p.getPoints()[3].getX(),0);
    assertEquals(-8.0, p.getPoints()[3].getY(),0);
    assertEquals(0.0, p.getPoints()[4].getX(),0);
    assertEquals(0.0, p.getPoints()[4].getY(),0);
    
    //Test Rectangle 
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    assertEquals(4.0,r1.getPoints()[0].getX(),0);
    assertEquals(3.0, r1.getPoints()[0].getY(),0);
    assertEquals(4.0, r1.getPoints()[1].getX(),0);
    assertEquals(-3.0, r1.getPoints()[1].getY(),0);
    assertEquals(-4.0, r1.getPoints()[2].getX(),0);
    assertEquals(3.0, r1.getPoints()[2].getY(),0);
    assertEquals(-4.0, r1.getPoints()[3].getX(),0);
    assertEquals(-3.0, r1.getPoints()[3].getY(),0);
    
    //Test Triangle
    Triangle tr1 = new Triangle(new Point(5,5), new Point(12,8), new Point(9,9));
    assertEquals(5.0,tr1.getPoints()[0].getX(),0);
    assertEquals(5.0, tr1.getPoints()[0].getY(),0);
    assertEquals(12.0,tr1.getPoints()[1].getX(),0);
    assertEquals(8.0, tr1.getPoints()[1].getY(),0);
    assertEquals(9.0, tr1.getPoints()[2].getX(),0);
    assertEquals(9.0, tr1.getPoints()[2].getY(),0);
    
    //Test EquilateralTriangle
    EquilateralTriangle eq1 = new EquilateralTriangle((new Point(0,0)), 4);
    assertEquals(1, (int) eq1.getPoints()[0].getX(),0);
    assertEquals(0.0, eq1.getPoints()[0].getY(),0);
    assertEquals(0, (int) eq1.getPoints()[1].getX(),0);
    assertEquals(1, (int) eq1.getPoints()[1].getY(),0);
    assertEquals(0, (int) eq1.getPoints()[2].getX(),0);
    assertEquals(-1, (int) eq1.getPoints()[2].getY(),0);
  }
  
  //Test setPoints method
    
  //this test method toString()
  //this method return array of string the represent the x and y coordinate of each point make up the polygon 
  @Test 
  public void testToString(){
    Triangle tr1 = new Triangle(new Point(5,5), new Point(12,8), new Point(9,9));
    assertEquals("x:5.0,y:5.0; x:12.0,y:8.0; x:9.0, y:9.0.", tr1.toString());
    
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    assertEquals("x:4.0,y:3.0; x:4.0,y:-3.0; x:-4.0,y:3.0; x:-4.0, y:-3.0.",r1.toString());
  }
  
 //Test Rectangle specific 
  
  //Test method return the width of Rectangle
  @Test
  public void testGetWidthRec(){
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    assertEquals(8.0, r1.getWidth(),0);
  }
  
  //Test method change the width of Rectangle into a new width
  @Test
  public void testSetWidthRec(){
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    r1.setWidth(18);
    assertEquals(18.0, r1.getWidth(),0);
  }
  
  //Test method return the height of Rectangle
  @Test 
  public void testGetHeightRec(){
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    assertEquals(6.0, r1.getHeight(),0);
  }
  
  //Test method change the height of Rectangle into a new height
  public void testSetHeightRec(){
    Rectangle r1 = new Rectangle(new Point(0,0), 6,8);
    r1.setHeight(7);
    assertEquals(7.0, r1.getHeight(),0);
  }
  
  //test method return the array of 4 points make up the Rectangle by calculating
  //It can accept different inputs of points, width, and height
  @Test 
  public void testCalculatePoints(){
    Rectangle.calculatePoints(new Point(2,4), 6,8);
    assertEquals(6.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[0].getX(),0);
    assertEquals(7.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[0].getY(),0);
    assertEquals(6.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[1].getX(),0);
    assertEquals(1.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[1].getY(),0);
    assertEquals(-2.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[2].getX(),0);
    assertEquals(7.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[2].getY(),0);
    assertEquals(-2.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[3].getX(),0);
    assertEquals(1.0, Rectangle.calculatePoints(new Point(2,4), 6,8)[3].getY(),0);
    
    Rectangle.calculatePoints(new Point(1,1), 9,8);
    assertEquals(5.0, Rectangle.calculatePoints(new Point(1,1), 9,8)[0].getX(),0);
    assertEquals(5.5, Rectangle.calculatePoints(new Point(1,1), 9,8)[0].getY(),0);
    assertEquals(5.0, Rectangle.calculatePoints(new Point(1,1), 9,8)[1].getX(),0);
    assertEquals(-3.5, Rectangle.calculatePoints(new Point(1,1), 9,8)[1].getY(),0);
    assertEquals(-3.0, Rectangle.calculatePoints(new Point(1,1), 9,8)[2].getX(),0);
    assertEquals(5.5, Rectangle.calculatePoints(new Point(1,1), 9,8)[2].getY(),0);
    assertEquals(-3.0, Rectangle.calculatePoints(new Point(1,1), 9,8)[3].getX(),0);
    assertEquals(-3.5, Rectangle.calculatePoints(new Point(1,1), 9,8)[3].getY(),0);
  }
  
 //Test NGon specific - use for NGon, Square, and EquilateralTriangle 
  
  //Test method that return the number of sides make up the NGon
  @Test
  public void testGetNumSides(){
    NGon penta = new NGon(new Point(0,0), 5, 7);
    assertEquals(5, penta.getNumSides());
    
    Square sq1 = new Square(new Point(0,0),4);
    assertEquals(4, sq1.getNumSides());
    
    EquilateralTriangle et1 = new EquilateralTriangle(new Point(0,0), 5);
    assertEquals(3, et1.getNumSides());
  }
  
  //Test method that return the side length of the n-gon
  @Test
  public void testGetSideLength(){
    NGon penta = new NGon(new Point(0,0), 5, 7);
    assertEquals(7.0, penta.getSideLength(),0);
    
    Square sq1 = new Square(new Point(0,0),4);
    assertEquals(4.0, sq1.getSideLength(),0);
    
    EquilateralTriangle et1 = new EquilateralTriangle(new Point(0,0), 5);
    assertEquals(5.0, et1.getSideLength(),0);
  }
  
  //Test method set the new side length of n-gon
  @Test
  public void testSetSideLength(){
    NGon penta = new NGon(new Point(0,0), 5, 7);
    penta.setSideLength(10);
    assertEquals(10.0, penta.getSideLength(),0);
    
    Square sq1 = new Square(new Point(0,0),4);
    sq1.setSideLength(5);
    assertEquals(5.0, sq1.getSideLength(),0);
    
    EquilateralTriangle et1 = new EquilateralTriangle(new Point(0,0), 5);
    et1.setSideLength(6);
    assertEquals(6.0, et1.getSideLength(),0);
  }
  
 //Test for Square specific
  //Test method return the side length of Square
  @Test
  public void testGetWidthSq(){
    Square sq1 = new Square(new Point(0,0),4);
    assertEquals(4.0, sq1.getWidth(),0);
  }
  
  //Test method set the new side length of the Square
  @Test
  public void testSetWidth(){
    Square sq1 = new Square(new Point(0,0),4);
    sq1.setWidth(18);
    assertEquals(18.0, sq1.getWidth(),0);
    assertEquals(18.0, sq1.getHeight(),0);
  }
  
  //Test method return the side length of Square
  @Test 
  public void testGetHeight(){
    Square sq1 = new Square(new Point(0,0),4);
    assertEquals(4.0, sq1.getHeight(),0);
  }
  
  //Test method set the new side length of the Square
  public void testSetHeight(){
    Square sq1 = new Square(new Point(0,0),4);
    sq1.setHeight(7);
    assertEquals(7.0, sq1.getHeight(),0);
    assertEquals(7.0, sq1.getWidth(),0);
  }
  
 //Test SnowFlake specific
  @Test
  public void testGetBaseShape(){
    SnowFlake sf1 = new SnowFlake(new Square(new Point(0,0), 4), 0);
  }
  
  //test the method return the number of levels of fractals
  public void testGetNumLevels(){
    SnowFlake sf1 = new SnowFlake(new Square(new Point(0,0), 4), 0);
    assertEquals(0, sf1.getNumLevels(),0);
  }
  
  //test the method change the number of levels of fractals
  public void testSetNumLevels(){
    SnowFlake sf1 = new SnowFlake(new Square(new Point(0,0), 4), 0);
    sf1.setNumLevels(2);
    assertEquals(2, sf1.getNumLevels(),0);
  }
  
  //test the method calculate the number of points after the fractal
  public void calculatePoints(){
    SnowFlake sf1 = new SnowFlake(new Square(new Point(0,0), 4), 2);
    assertEquals(64, sf1.getPoints().length,0);
  }
    
    
}

