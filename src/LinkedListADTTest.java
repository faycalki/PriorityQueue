

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Scaffold test class for implementations of the LinkedListADT interface.
 *
 * @author Ada Clevinger
 * @version Sep 29, 2023
 */
public class LinkedListADTTest
{
    
    private LinkedListADT<String> list;
    
    public LinkedListADTTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     * 
     * Note that initially this will cause an error; why is this?
     * How do we 'fix' the error?
     */
    @BeforeEach
    public void setUp()
    {
        list = new LinkedList<String>();
    }
    
    @Test
    public void testAddToFront(){
        
    }
    
    @Test
    public void testAddToBack(){
        
    }
        
    @Test
    public void testRemoveFromFront(){
        
    }
        
    @Test
    public void testRemoveFromBack(){
        
    }
               
    @Test
    public void testAddAfter(){
        
    }
                 
    @Test
    public void testRemoveFirstInstance(){
        
    }
                
    @Test
    public void testRemoveAllInstances(){
        
    }
                
    @Test
    public void testToString(){
        
    }
        
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
