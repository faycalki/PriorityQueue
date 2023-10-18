/**
 * @author Faycal Kilali, Dylan Kim
 * @version 1.1
 * @param <T>, a generic parameter type.
 */

public class DoublyLinkedList<T> extends LinkedList<T> implements DoublyLinkedListADT<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size = 0; // to enforce O(1)


    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Retrieves the nth position node's data (position ranges from 0 to size of Linked List)
     * @param position the position to retrieve the node's data from
     * @return the data of the position node
     */
    public T checkDataAtLocation(int position) {
        //Node<T> node = traverseLinkedListToPosition(position);
        //System.out.println(node.getData());
        //return node.getData();
        return traverseLinkedListToPosition(position).getData();
    }



    }


