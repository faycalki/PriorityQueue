/**
 * @author Faycal Kilali, Dylan Kim
 * @version 1.1
 * @param <T>, a generic parameter type.
 */

public class DoublyLinkedList<T> extends LinkedList<T> implements DoublyLinkedListADT<T> {

    private DLLNode<T> head;
    private DLLNode<T> tail;

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


    /**
     * Note here the inNode only shows the visibility to the inner-class, we have to actually call the constructor and so on.
     * This adds a new node to the front of the list (this node becomes the new head node).
     * If the list is empty (head is null): You create a new node and set it as the head. Since the list is empty, this new node is both the first and last node in the list.
     * If the list is not empty: You create a new node with the current head as its reference. This new node becomes the new head, and its reference is set to the previous head, preserving the rest of the list.
     * @param inData the data pointer of the added node
     * @throws NullPointerException if inReference is null. The Exception should be caught and the method re-called with a non-null object.
     */
    @Override
    public void add(T inData) throws NullPointerException
    {
        if (inData == null){
            throw new NullPointerException("Parameterized object is null");
        }

        DLLNode<T> newNode  = new DLLNode(inData);

        if(isEmpty()){
            System.out.println("The List is empty!");
            head = newNode; // So we don't need to assign this? The head isn't a separate node, the first node is always the head node.
        }
        else{
            newNode.setNext(head);
            head = newNode;
            // Previous node's reference becomes the new node's reference, and the previous node's reference changes to the new code.
        }
        size++;
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }

        return false;
    }


    public  void addToFront(T data){
        add(data);
    }

    public  void addToBack(T data){
        size++;
    }

    public  void addAfter(T dataInsert, T dataFind){
        size++;
    }

    public  void removeFirstInstance(T data){
        size--;
    }

    public  void removeAllInstances(T data){}

    public T removeFromFront() {

        size--;
        return removeFromFront();
    }

        public T removeFromBack() {

        size--;
        return removeFromBack();
        }

    /**
     * Method borrowed from COMP-2611 made by Ada Clevinger
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if(head != null){
            DLLNode<T> curr = head;
            while(curr != null){
                //System.out.println("1");
                if (curr.getNext() == null){
                    sb.append(curr.getData());
                }
                else{
                    sb.append(curr.getData() + ", ");
                }
                curr = (DLLNode<T>) curr.getNext();
            }
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    /**
     * O(1) if we increment and decrement based on the other methods, otherwise O(n) if we traverse the LinkedList to get the size
     * @return the size of the Linked List (that is, number of nodes in the Linked List)
     */
    public int getSize(){
        if(isEmpty()){
            return 0;
        }
        return size;
    }


    }


