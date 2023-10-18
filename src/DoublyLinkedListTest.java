import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {


    private DoublyLinkedList<String> list;

    @BeforeEach
    public void setUp() {

        list = new DoublyLinkedList<>();
    }

    @Test
    void checkDataAtLocation() {

        list.add("1");
        System.out.println(list.toString());
        list.add("2");
        System.out.println(list.toString());
        list.add("3");
        System.out.println(list.toString());
        System.out.println(list.getSize());
        //System.out.println(list);

        // Testing case 1

        //nodeData = checkDataAtLocation(0);
        //assert(node.getData().equals(list.checkDataAtLocation(0)));
        System.out.println("Expected data: 3" +  "Actual data: " + list.checkDataAtLocation(0));
        System.out.println("Expected data: 2" +  "Actual data: " + list.checkDataAtLocation(1));
        System.out.println("Expected data: 1"  + "Actual data: " + list.checkDataAtLocation(2));

        //System.out.println(list.checkDataAtLocation(0));
        //assertEquals("2", list.checkDataAtLocation(1));
        //assertEquals("3", list.checkDataAtLocation(2));
    }

    @Test
    void removeFromFront() {
    }

    @Test
    void removeFromBack() {
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