import java.util.*;

/**
 * an interface for types that are databases
 * @author
 * @param <T> Generic type
 */
public interface DatabaseType<T> {
  
  /**
   * returns a Comparator based on the String trait
   * @param trait is String trait to  o
   * @return a Comparator based on the trait
   */
  public abstract Comparator<T> getComparatorByTrait(String trait);
}
