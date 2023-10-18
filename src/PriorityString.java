
/**
 * Example class that implements the Priority interface
 * and sets the generic type T to be its own class type
 * so that the 'isMoreImportant' method can compare objects
 * of type PriorityString to other objects of the same type.
 * 
 * Note that this lexographical ordering is only one way to implement
 * priority logic; we could also have a custom class that directly
 * takes an integer value that is its priority, or incorporate a
 * means of measuring time of entry to the PriorityQueue.
 *
 * @author Ada Clevinger
 * @version Oct 13, 2023
 */
public class PriorityString implements Priority<PriorityString>
{
    
    private String value;
    
    public PriorityString(String in){
        value = in;
    }
    
    /*
     * Method that implements the abstract method 'isMoreImportant'
     * with the chosen generic type this class defines to be PriorityString.
     * 
     * Method of deciding important is lexocographical ordering.
     * 
     * Would be easier to call value.compareTo(otherString)
     * but it doesn't hurt to know the granular way that
     * we would compare an object such as a String.
     * 
     */
    
    public boolean isMoreImportant(PriorityString other){
        String otherString = other.getValue();
        int length = value.length();
        if(otherString.length() < length){
            length = otherString.length();
        }
        for(int i = 0; i < length; i++){
            if(value.charAt(i) > otherString.charAt(i)){
                return true;
            }
            else if(value.charAt(i) < otherString.charAt(i)){
                return false;
            }
        }
        if(value.length() > otherString.length()){
            return true;
        }
        return false;
    }
    
    public String getValue(){
        return value;
    }
        
    /*
     * Method that shows an example of the output results for comparing
     * a PriorityString object containing "apple" to objects containing
     * "banana", "acid", and "apples".
     * 
     * Tests should be put into their own separate test class, so this
     * is not an example to follow, but it makes it easy to display the
     * behavior going on here for the comparisons we're doing.
     * 
     */
    
    public void testThisClass(){
        PriorityString test = new PriorityString("apple");
        System.out.println(test.isMoreImportant(new PriorityString("banana")));
        System.out.println(test.isMoreImportant(new PriorityString("acid")));
        System.out.println(test.isMoreImportant(new PriorityString("apples")));
        
    }
    
}
