import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * A class to represent a linked list as database for storing data as nodes. The database is Iterable to indicate that we can iterate the data in the database
 * @author 
 * @param <T> generic type
 */
public class Database<T extends DatabaseType<T>> implements Iterable<T> {
  
  //the first node of the database list, or null if the list is empty
  private LLNode<T> firstNode;
  
  //the hash table for storing different indexes avaiable to fast sort the data
  private Hashtable<String, ArrayList<T>> dataIndex = new Hashtable<String, ArrayList<T>>(); 
  
  //numElements indidcate the current number of elements stored in the database
  private int numElements = 0; 
  
  /**
   * Creates an initially empty linked list
   */
  public Database(){
    firstNode = null;
  }
  
  /**
   * Get the number of elements currently stored in the database list
   * @return the number of elements currently stored in the database list
   */
  protected int getNumElements(){
    return numElements;
  }
  
  /**
   * Set the number of elements currently stored in the database list and only be used in other methods
   * @param numElements the number of elements currently stored in the database list would be set to this numElements
   */
  private void setNumElements(int numElements){
    this.numElements = numElements;
  }
  
  /**
   * Returns the first node
   * @return the first node
   */
  protected LLNode<T> getFirstNode(){
    return firstNode;
  }
  
  /**
   * Changes the front node, only use in other methods. Cannot access outside this class
   * @param node node the node that will be the first node of the new linked list
   */
  private void setFirstNode(LLNode<T> node){
    firstNode = node;
  }
  
    /**
     * check if the database list contains any data
     * @return true if there is no data in the database lsit
     */
    public boolean isEmpty() { 
    return (getFirstNode() == null);  
  }
  
    /**
     * Returns a hashtable
     * @return a hashtable
     */
    protected Hashtable<String, ArrayList<T>> getIndexes(){
    return dataIndex;
  }
  
  /** 
   * Add an element to the front of the database list
   * @param element an element that would be added to the front of database list
   */
  public void add(T element){
    //add the node containe the element before the first node of the list
    setFirstNode(new LLNode<T>(element, getFirstNode()));
    
    //increasing the number of element after add each node
    setNumElements(getNumElements() + 1);
    
    //clear the hashtable 
    getIndexes().clear();
  }
  
  /**
   * Delete all of the nodes that have the elements that are the same as input element
   * @param element element is the element that is deleted
   */
  public void delete (T element){
    //pointer for loop through every node in the database list, starts from the fisrt node
    LLNode<T> pointer = getFirstNode(); 
    
    //for updating the node during the delete process 
    LLNode<T> previousNode = null;
    
    //the loop works for delete a node and it only works if there is node in the list
    while (pointer != null){
      
      //check when the pointer has the same element as the input element or not//
      if (pointer.getElement().equals(element)){
        
        /*check as if this pointer is the first node or not.
         If it is the first node then it will set the next node to be the first node
         */ 
        if (previousNode == null) {
          setFirstNode(pointer.getNext());
        }
        
        /*if the pointer was not the first node, it will be skipped 
         by having the next node of this pointer's previous node to be the pointer's next node         
         */
        else {
          previousNode.setNext(pointer.getNext());
        }
        
        //the number of element reduce by one after each node removes
        setNumElements(getNumElements()-1);
      }
      
      //if the pointer doesn't have the same element as input element, store the pointer to the previous node and check the next one
      else {
        previousNode = pointer;
      }
      
      //after check the current pointer, the next pointer should be checked    
      pointer = pointer.getNext();
    }
    
    //clear the hash table 
    getIndexes().clear();
  }
  
  /**
   * Returns the number currently stored in the database
   * @return the number currently stored in the database
   */
  public int size(){
    
    //return by using the current numElements with it get method
    return getNumElements();
  }
  
  /**
   * Look up a value in the database list and put them into a database list for return
   * @param value value is the value to look up
   * @param comp comp is the comparator to compare the two values
   * @return a database list that contains the value in the database list
   */
  public LinkedList<T> lookupInList(T value, Comparator<T> comp){
    //create a database list for return 
    LinkedList<T> compList = new LinkedList<T>(); 
    
    // a pointer that use inside the loop. Starts from the first node of the 
    LLNode<T> pointer = getFirstNode();
    
    //loop through every node for comparison with the input element 
    while (pointer != null){
      
      //when the node has the element matched the input element, add it into the database list
      if(comp.compare(pointer.getElement(), value) == 0){
        compList.add(pointer.getElement());
      } 
      
      //check the next node
      pointer = pointer.getNext();
    }
    
    //return the linked list
    return compList;
  }    
  
  /**
   * Return a database list contains all the database nodes elements that matched the input value 
   * @param value value is the value used for comparison
   * @param index an array list contains elements that use for comparison
   * @param comp comp is the comparator use to compare the two values
   * @return a database list that has all elements from the array list that has the value matched the input value
   */
  public LinkedList<T> lookupInIndex(T value, ArrayList<T> index, Comparator<T> comp){
    
    // create a database list for return 
    LinkedList<T> compList = new LinkedList<T>();
    
    // search for the index of the element in the arraylist that matched the input value
    int search = Collections.binarySearch(index, value, comp);
    
    //loop through goes through the array list and add the elements into the database list
    for(T element: index) {
      
      //if there is an existed elements, then it would be added into 
      if(comp.compare(element, value) == 0) {
        compList.add(element);
      }
    }
    
    //return the linked list
    return compList;
  }
  
  /**
   * sorted the array list and stored it into the hashtable according to the corresponding trait (name/phoneNumber/email)
   * @param trait trait is the trait (name/phoneNumber/email) to sort the dat
   */
  public void makeIndex(String trait){
    //if there is no data in the database list, then this method does nothing
    if (isEmpty()){
    }
    
    /* if there is data in the data list, it will copy all the data into the array list
     * then it will sort the data and store it to the hashtable based on the trait (name/phoneNumber/email)
     */
    else {
      //the array list to store the data from the database list
      ArrayList<T> index = new ArrayList<T>(size());
      
      //presenting the first node
      LLNode<T> pointer = getFirstNode();
      
      //retrieve the comparator
      Comparator<T> comp = pointer.getElement().getComparatorByTrait(trait);
      
      //iterator for the database list
      Iterator<T> it = this.iterator(); 
      
      //loop add each data from database to the arraylist
      for (T i: this){
        index.add(i);
      }
      
      //sorting the data in the array list according to the trait
      Collections.sort(index, comp);
      
      //store the sorted array list into the hash table
      getIndexes().put(trait, index);
    }
  }
  
  /**
   * Looks up a value in the hashtable based on the input trait and returns a LinkedList
   * @param trait is the trait (name/phoneNumber/email) to search for 
   * @param value is the value as the key matches the input trait
   * @return the LinkedList that contains data which match trait's value
   */
  public LinkedList<T> lookup (String trait, T value){
    //list to store the matched data from the hashtable
    LinkedList<T> list = new LinkedList<T>();
    
    //if the database is empty
    if(isEmpty()){
      return list;
    }
    
    //compare the data 
    Comparator<T> comp = value.getComparatorByTrait(trait);
    
    //if there is a data matched, call lookupIndex method to return a LinkedList stores data match the trait's value
    if (getIndexes().get(trait) != null){
      return lookupInIndex(value, getIndexes().get(trait), comp);
    }
    
    //if there is no data matched, return the linkedlist from lookupInList method
    else {
      return lookupInList(value, comp);
    }
  }
  
  /**
   * Return an ArrayList by the input trait with index
   * if the index exists in the hashtable, it will be return. Otherwise, it will be sorted by the makeIndex method
   * @param trait the trait used to return an orrdered an ArrayList
   * @return an orderred ArrayList based on trait
   */
  public ArrayList<T> getList(String trait){
    ArrayList<T> alist = new ArrayList<T>();
    //if there is no data in the database list, then it will return an empty arraylist
    if (isEmpty()){
      return alist;
    }
    
    //if an index for corresponding trait (name/phoneNumber/email) exits in hashtable, then return the hashtable
    if (getIndexes().get(trait) != null ){
      return getIndexes().get(trait);
    }
    
    /* if an index for correspoding trait does not exist in hashtable,
     * then create an index for it by makeIndex method and return the hashtable
     */
    else {
      this.makeIndex(trait);
      return getIndexes().get(trait);
    }
  }
  
  /** 
   * Returns an iterator that iterates, or loops, over the data of the list
   * @return an iterator for the linked list
   */
  @Override
  public DatabaseIterator<T> iterator() {
    return new DatabaseIterator<>(getFirstNode());
  }
}
