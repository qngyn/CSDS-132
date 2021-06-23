import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The iterator for the database class
 * @author 
 */
public class DatabaseIterator<S> implements Iterator<S> {
    
    //keeps track of where we are in the database list
    private LLNode<S> nodeptr; 
    
    /**
     * create an iterator that starts at the input node
     * @param firstNode the node where the iteration of the database list begins
     */
    public DatabaseIterator(LLNode<S> firstNode){
        nodeptr = firstNode;
    }
    
    /**
     * Return true if there are more elements in this iteration of the database list
     * @return if there are more elements in the database list
     */
    @Override
    public boolean hasNext() {
        return nodeptr != null;
    }
    
    /**
     * Returns the next element in the database list
     * @return the next element in the database list
     * @throws NoSuchElementException if there are no more element when next is called
     */
    @Override
    public S next() throws NoSuchElementException {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        
        S save = nodeptr.getElement();
        nodeptr = nodeptr.getNext();
        return save;
    }
}
