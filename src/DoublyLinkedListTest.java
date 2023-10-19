

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DoublyLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DoublyLinkedListTest



{



    private DoublyLinkedList<String> list;
    private Node<String> node;
    private Node<String> nextNode;
    private Node<String> nextNextNode;

    /**
     * Default constructor for test class DoublyLinkedListTest
     */
    public DoublyLinkedListTest()
    {



    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        list = new DoublyLinkedList<>();

        node = new Node<String>("1");
        nextNode = new Node<String>("2");
        nextNextNode = new Node<String>("3");
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


    @Test
    public void checkDataAtLocation() {

        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.toString());
        System.out.println(list.getSize());
        //System.out.println(list);


        // Testing case 1
        assert(nextNextNode.getData().equals(list.checkDataAtLocation(0)));
        System.out.println("Expected data: 3, " +  "actual data: " + list.checkDataAtLocation(0));
        System.out.println("Expected data: 2," +  " actual data: " + list.checkDataAtLocation(1));
        System.out.println("Expected data: 1,"  + " actual data: " + list.checkDataAtLocation(2));

        //System.out.println(list.checkDataAtLocation(0));
        assertEquals(nextNode.getData(), list.checkDataAtLocation(1));
        assertEquals(node.getData(), list.checkDataAtLocation(2));
    }

    @Test
    void removeFromFront() {
    }

    @Test
    void removeFromBack() {
    }

    @Test
    void addAfter(){
        list.addAfter(node.getData(), node);
        list.addAfter("2", node);
        list.addAfter("3", node);
        list.addAfter("4", node.getNext());
        list.addAfter("5", list.getHeadData().getNext());
        System.out.println(list.toString());
        System.out.println(list.getSize());
    }

}
