import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.control.Label;
import java.util.Arrays;

/** A JUnit test case SldingTiles class.
  * Every method starting with the word "test" will be called when running
  * the test with JUnit.
  * @author 
  */
public class SlidingTilesTest extends TestCase {
  SlidingTiles test = new SlidingTiles();
 
  /**
   * Test slideLeft method, of SlidingTiles class
   */
  @Test
  public void testSlideLeft() { 
    //Test 0 
    //no element/no row
    int[][] a1 = {{}};
    test.slideLeft(a1,0);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}};
    test.slideLeft(a2,0);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
    //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideLeft(a2,0);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element/one row 
    int[][] a4 = {{0,0,1}};
    test.slideLeft(a4,0);
    int[][] a5 = {{1,0,0}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    
    //Test many elements/many rows
    int[][] array = {{1,1,1,1}, {2,1,1,0}, {1,1,2,0},{1,0,0,0},{0,0,1,0}, {0,0,0,1}};
    
    test.slideLeft(array,0);
    test.slideLeft(array,1);
    int[][] a6 = {{2,2,0,0}};
    assertEquals(Arrays.toString(a6[0]), Arrays.toString(array[0]));
    assertEquals(Arrays.toString(a6[0]), Arrays.toString(array[1]));
    
    test.slideLeft(array,2);
    int[][] a7 = {{4,0,0,0}};
    assertEquals(Arrays.toString(a7[0]), Arrays.toString(array[2]));
    
    int[][] a8 = {{1,0,0,0}};
    
    //Test First
    test.slideLeft(array,3);
    assertEquals(Arrays.toString(a8[0]), Arrays.toString(array[3]));
    
    //Test middle
    test.slideLeft(array,4);
    assertEquals(Arrays.toString(a8[0]), Arrays.toString(array[4]));
     
     //Test last
    test.slideLeft(array,5);
    assertEquals(Arrays.toString(a8[0]), Arrays.toString(array[5]));
  }
     
  /**
   * Test slideRight method, of SlidingTiles class
   */
  @Test
  public void testSlideRight(){
    //Test 0 
    //no element/no row
    int[][] a1 = {{}};
    test.slideRight(a1,0);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}};
    test.slideRight(a2,0);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
    //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideRight(a2,0);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element/one row
    int[][] a4 = {{1,0,0}};
    test.slideRight(a4,0);
    int[][] a5 = {{0,0,1}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    //Test many elements/many rows
    int[][] array = {{1,1,1,1}, {0,1,1,2}, {2,1,1,0},{1,0,0,0},{0,0,1,0}, {0,0,0,1}};
    
    test.slideRight(array,0);
    test.slideRight(array,1);
    int[][] a6 = {{0,0,2,2}};
    assertEquals(Arrays.toString(a6[0]), Arrays.toString(array[0]));
    assertEquals(Arrays.toString(a6[0]), Arrays.toString(array[1]));
    
    test.slideRight(array,2);
    int[][] a7 = {{0,0,0,4}};
    assertEquals(Arrays.toString(a7[0]), Arrays.toString(array[2]));
    
    int[][] a8 = {{0,0,0,1}};
    
    //Test first
    test.slideRight(array,3);
    assertEquals(Arrays.toString(a8[0]), Arrays.toString(array[3]));
    
    //Test middle
    test.slideRight(array,4);
    assertEquals(Arrays.toString(a8[0]), Arrays.toString(array[4]));
     
     //Test last
    test.slideRight(array,5);
    assertEquals(Arrays.toString(a8[0]), Arrays.toString(array[5]));
    
  }
  
  /**
   * Test slideUp method, of SlidingTiles class
   */
  @Test
  public void testSlideUp(){
    //Test 0 
    //no element/no colummn
    int[][] a1 = {{}};
    test.slideUp(a1,0);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}, {0,0,0,0}};
    test.slideUp(a2,0);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
    //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideUp(a2,0);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element
    int[][] a4 = {{0,0,0},{0,0,1}};
    test.slideUp(a4,2);
    int[][] a5 = {{0,0,1},{0,0,0}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    int[][] extra = {{0}, {1}, {1}};
    test.slideUp(extra, 0);
    int[][] extraResult = {{2},{0},{0}};
    assertEquals(Arrays.deepToString(extraResult), Arrays.deepToString(extra));
    
    
    //Test many 
    int[][] array = {{1,1,2,0},{1,1,1,0},{1,0,0,1},{1,2,1,0}};
    
    test.slideUp(array,0);
    int[][] a6 = {{2,1,2,0},{2,1,1,0},{0,0,0,1},{0,2,1,0}};
    assertEquals(Arrays.deepToString(a6), Arrays.deepToString(array));
    
    test.slideUp(array,1);
    int[][] a7 = {{2,4,2,0},{2,0,1,0},{0,0,0,1},{0,0,1,0}};
    assertEquals(Arrays.deepToString(a7), Arrays.deepToString(array));
    
    test.slideUp(array,2);
    int[][] a8 = {{2,4,2,0},{2,0,2,0},{0,0,0,1},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a8), Arrays.deepToString(array));
    
    test.slideUp(array,3);
    int[][] a9 = {{2,4,2,1},{2,0,2,0},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a9), Arrays.deepToString(array));
    
    int[][] array1 = {{1,0,0}, {0,1,0}, {0,0,1}};
    
    //Test first
    test.slideUp(array1,0);
    int[][] a10 = {{1,0,0}, {0,1,0}, {0,0,1}};
    assertEquals(Arrays.deepToString(a10), Arrays.deepToString(array1));
    
    //Test middle
    test.slideUp(array1,1);
    int[][] a11 = {{1,1,0}, {0,0,0}, {0,0,1}};
    assertEquals(Arrays.deepToString(a11), Arrays.deepToString(array1));
    
    //Test last
    test.slideUp(array1,2);
    int[][] a12 = {{1,1,1}, {0,0,0}, {0,0,0}};
     assertEquals(Arrays.deepToString(a12), Arrays.deepToString(array1));
  }
  
  /**
   * Test slideDown method, of SlidingTiles class
   */
  @Test
  public void testSlideDown(){
    //Test 0 
    //no element
    int[][] a1 = {{}};
    test.slideDown(a1,0);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}, {0,0,0,0}};
    test.slideDown(a2,0);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
    //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideDown(a2,0);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element
    int[][] a4 = {{0,1,0},{0,0,0}};
    test.slideDown(a4,1);
    int[][] a5 = {{0,0,0},{0,1,0}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    //Test many 
    int[][] array = {{1,2,0,0},{1,1,1,0},{1,0,1,1},{1,1,2,0}};
    
    test.slideDown(array,0);
    int[][] a6 = {{0,2,0,0},{0,1,1,0},{2,0,1,1},{2,1,2,0}};
    assertEquals(Arrays.deepToString(a6), Arrays.deepToString(array));
    
    test.slideDown(array,1);
    int[][] a7 = {{0,0,0,0},{0,0,1,0},{2,0,1,1},{2,4,2,0}};
    assertEquals(Arrays.deepToString(a7), Arrays.deepToString(array));
    
    test.slideDown(array,2);
    int[][] a8 = {{0,0,0,0},{0,0,0,0},{2,0,2,1},{2,4,2,0}};
    assertEquals(Arrays.deepToString(a8), Arrays.deepToString(array));
    
    test.slideDown(array,3);
    int[][] a9 = {{0,0,0,0},{0,0,0,0},{2,0,2,0},{2,4,2,1}};
    assertEquals(Arrays.deepToString(a9), Arrays.deepToString(array));
    
    int[][] array1 = {{1,0,0}, {0,1,0}, {0,0,1}};
    
    //Test first
    test.slideDown(array1,0);
    int[][] a10 = {{0,0,0}, {0,1,0}, {1,0,1}};
    assertEquals(Arrays.deepToString(a10), Arrays.deepToString(array1));
    
    //Test middle
    test.slideDown(array1,1);
    int[][] a11 = {{0,0,0}, {0,0,0}, {1,1,1}};
    assertEquals(Arrays.deepToString(a11), Arrays.deepToString(array1));
    
    //Test last
    test.slideDown(array1,2);
    int[][] a12 = {{0,0,0}, {0,0,0}, {1,1,1}};
     assertEquals(Arrays.deepToString(a12), Arrays.deepToString(array1));
  }
    
  /**
   * Test slideUpRight method, of SlidingTiles class
   */
  @Test
  public void slideUpRight(){
    //Test 0 
    int[][] a1 = {{}};
    test.slideUpRight(a1);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}, {0,0,0,0}};
    test.slideUpRight(a2);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
     //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideUpRight(a2);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element
    int[][] a4 = {{0,1,0},{0,0,0}};
    test.slideUpRight(a4);
    int[][] a5 = {{0,0,0},{0,0,1}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    //Test many
    int [][] array ={{0,0,2,1},{1,1,1,1},{1,1,1,0},{1,2,0,0}};
    test.slideUpRight(array);
    int[][] a6 ={{0,1,2,2},{0,2,2,4},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a6), Arrays.deepToString(array));
    
    test.slideUpRight(array);
    int[][]a7 = {{0,1,4,4},{0,0,0,4},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a7), Arrays.deepToString(array));
    
    //Test first
    int [][] a8 ={{0,1,0,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    test.slideUpRight(array);
    assertEquals(Arrays.deepToString(a8), Arrays.deepToString(a8));
    
    int [][] a9 ={{0,1,0,1},{0,0,1,0},{0,0,0,0},{0,0,0,0}};
    test.slideUpRight(array);
    int [][] a10 ={{0,1,0,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a10), Arrays.deepToString(a9));
    
    
    //Test middle
    int [][] a11 ={{0,0,0,0},{0,0,1,0},{0,1,0,0},{0,0,0,0}};
    test.slideUpRight(array);
    int [][] a12 ={{0,0,0,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a12), Arrays.deepToString(a11));
    
    
    //Test last
    int [][] a13 ={{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,1,1}};
    test.slideUpRight(array);
    int [][] a14 ={{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
    assertEquals(Arrays.deepToString(a13), Arrays.deepToString(a14));
  }
  
  /**
   * Test slideUpLeft method, of SlidingTiles class
   */
  @Test
  public void slideUpLeft(){
     //Test 0 
    int[][] a1 = {{}};
    test.slideUpLeft(a1);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}, {0,0,0,0}};
    test.slideUpLeft(a2);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
     //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideUpLeft(a2);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element
    int[][] a4 = {{0,1,0},{0,0,0}};
    test.slideUpLeft(a4);
    int[][] a5 = {{1,0,0},{0,0,0}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    //Test many
    int [][] array ={{1,1,0,0},{2,1,1,2},{0,1,1,2},{0,1,1,1}};
    test.slideUpLeft(array);
    int[][] a6 ={{2,4,2,0},{2,2,0,0},{1,2,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a6), Arrays.deepToString(array));
    
    test.slideUpLeft(array);
    int[][]a7 = {{4,4,2,0},{4,0,0,0},{1,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a7), Arrays.deepToString(array));
    
    //Test first
    int [][] a8 ={{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    test.slideUpLeft(array);
    assertEquals(Arrays.deepToString(a8), Arrays.deepToString(a8));
    
    int [][] a9 ={{0,1,0,1},{0,0,1,0},{0,0,0,0},{0,0,0,0}};
    test.slideUpLeft(array);
    int [][] a10 ={{0,2,0,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a10), Arrays.deepToString(a9));
    
    
    //Test middle
    int [][] a11 ={{0,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,0}};
    test.slideUpLeft(array);
    int [][] a12 ={{2,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a12), Arrays.deepToString(a11));
    
    
    //Test last
    int [][] a13 ={{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,1,1}};
    test.slideUpLeft(array);
    int [][] a14 ={{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
    assertEquals(Arrays.deepToString(a13), Arrays.deepToString(a14));
  }
  
  /**
   * Test slideDownRight method, of SlidingTiles class
   */
  @Test
  public void slideDownRight(){
     //Test 0 
    int[][] a1 = {{}};
    test.slideDownRight(a1);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}, {0,0,0,0}};
    test.slideDownRight(a2);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
     //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideDownRight(a2);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element
    int[][] a4 = {{0,1,0},{0,0,0}};
    test.slideDownRight(a4);
    int[][] a5 = {{0,0,0},{0,0,1}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    //Test many
    int [][] array ={{1,1,1,0},{2,1,1,0},{0,1,1,2},{0,0,1,1}};
    test.slideDownRight(array);
    int[][] a6 ={{0,0,0,0},{0,0,2,1},{0,0,0,4},{0,0,4,4}};
    assertEquals(Arrays.deepToString(a6), Arrays.deepToString(array));
    
    test.slideDownRight(array);
    int[][]a7 = {{0,0,0,0},{0,0,0,1},{0,0,2,2},{0,0,4,2}};
    assertEquals(Arrays.deepToString(a7), Arrays.deepToString(array));
    
    //Test first
    int [][] a8 ={{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    test.slideDownRight(array);
    int [][] a9 ={{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
    assertEquals(Arrays.deepToString(a9), Arrays.deepToString(a8));
    
    //Test middle
     int [][] a10 ={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
    test.slideDownRight(array);
    int [][] a11 ={{0,0,0,0},{0,0,0,1},{0,0,0,1},{0,0,1,1}};
    assertEquals(Arrays.deepToString(a11), Arrays.deepToString(a9));
    
    //Test last
    int [][] a12 ={{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,1,1}};
    test.slideDownRight(array);
    assertEquals(Arrays.deepToString(a12), Arrays.deepToString(a12));
  }
  
  /**
   * Test slideDownLeft method, of SlidingTiles class
   */
  @Test
  public void slideDownLeft(){
    //Test 0 
    int[][] a1 = {{}};
    test.slideDownLeft(a1);
    assertEquals(Arrays.deepToString(a1), Arrays.deepToString(a1));
    
    //all zero element
    int[][] a2 ={{0,0,0,0}, {0,0,0,0}};
    test.slideDownLeft(a2);
    assertEquals(Arrays.deepToString(a2), Arrays.deepToString(a2));
    
     //Test 1 
    //only one element
    int[][] a3 = {{1}};
    test.slideDownLeft(a2);
    assertEquals(Arrays.deepToString(a3), Arrays.deepToString(a3));
    
    //one non-zero element
    int[][] a4 = {{0,1,0},{0,0,0}};
    test.slideDownLeft(a4);
    int[][] a5 = {{1,0,0},{0,0,0}};
    assertEquals(Arrays.deepToString(a5), Arrays.deepToString(a4));
    
    //Test many
    int [][] array ={{0,1,2,1},{0,1,1,4},{1,1,1,1},{1,2,0,0}};
    test.slideDownLeft(array);
    int[][] a6 ={{0,0,0,0},{1,0,0,0},{4,2,2,0},{2,2,1,0}};
    assertEquals(Arrays.deepToString(a6), Arrays.deepToString(array));
    
    test.slideDownLeft(array);
    int[][]a7 = {{0,0,0,0},{1,0,0,0},{4,0,0,0},{4,4,1,0}};
    assertEquals(Arrays.deepToString(a7), Arrays.deepToString(array));
    
    //Test first
    int [][] a8 ={{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    test.slideDownLeft(array);
    int [][] a9 ={{1,0,0,0},{1,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertEquals(Arrays.deepToString(a9), Arrays.deepToString(a8));
    
    //Test middle
     int [][] a10 ={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
    test.slideDownLeft(array);
    int [][] a11 ={{0,0,0,0},{1,0,0,0},{1,0,0,0},{1,1,0,0}};
    assertEquals(Arrays.deepToString(a11), Arrays.deepToString(a9));
    
    //Test last
    int [][] a12 ={{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,1,1}};
    test.slideDownLeft(array);
    assertEquals(Arrays.deepToString(a12), Arrays.deepToString(a12));
  }
}
