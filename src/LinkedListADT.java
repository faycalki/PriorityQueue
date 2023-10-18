
/**
 * Interface that describes a bevvie of methods related to
 * the functioning of a LinkedList.
 *
 * @author Ada Clevinger
 * @version Sep 29, 2023
 */
public interface LinkedListADT<T>
{
    
    public abstract void addToFront(T data);
    
    public abstract void addToBack(T data);
    
    public abstract T removeFromFront();
    
    public abstract T removeFromBack();
    
    public abstract void addAfter(T dataInsert, T dataFind);
    
    public abstract void removeFirstInstance(T data);
    
    public abstract void removeAllInstances(T data);
    
    public abstract String toString();
    
}
