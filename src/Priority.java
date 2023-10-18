
/**
 * Interface that enables a class to compare itself to other
 * objects to decide which has a greater 'priority' in the
 * context of a Priority Queue.
 * 
 * The provided generic type T represents the data type that
 * the class that implements this interface is compared against
 * for which has a greater 'priority'.
 * 
 * Often, that generic type T will be the same class that is
 * implementing this interface.
 * 
 * For example, 'class PriorityString implements Priority<PriorityString>'
 * 
 * This would enable your method from this interface to compare
 * objects of type PriorityString to other objects of type PriorityString.
 * 
 * PriorityString would be a wrapper class around a String value that
 * provides this additional Priority functionality.
 * 
 * @author Ada Clevinger
 * @version Oct 13, 2023
 */
public interface Priority<T>
{
    
    /*
     * Method to decide if the object of the class that
     * implements the Priority interface has a higher or
     * lower priority than the given object of type T.
     * 
     */
    
    public abstract boolean isMoreImportant(T other);
    
}
