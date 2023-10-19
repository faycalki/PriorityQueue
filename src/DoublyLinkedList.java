/**
 * @author Faycal Kilali, Dylan Kim
 * @version 1.1
 * @param <T>, a generic parameter type.
 */

public class DoublyLinkedList<T> extends LinkedList<T> implements DoublyLinkedListADT<T> {


    public Node<T> tail;
    //public Node<T> currNode;

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



    @Override
    public void addAfter(T inData, Node<T> inReference) throws NullPointerException{
        if (inData == null){
            throw new NullPointerException("Parameterized object is null");
        }


        if(head == null){
            add(inData);
            return;
        }

        /*


        else if(getHeadData().getNext() == inReference){
            currNode = getHeadData();
            Node<T> newNode = new Node(inData, getHeadData().getNext());
            newNode.getNext().setPrevReference(newNode);
            getHeadData().setNext(newNode);
            newNode.setPrevReference(getHeadData());
            return;
        }
        */

        //System.out.println(getHeadData());
        //System.out.println("1");

        //currNode = traverseLinkedList(inReference).getNext(); // Gets the reference before the addition of the node
        Node<T> insertNode = new Node<T>(inData);
        Node<T> currNode = traverseLinkedList(inReference); // Acquires the reference of the node before inReference node or before null

        // There are two cases. One where we are bounded by inReference, in which case the following applies. One where we are bounded by Null
        // but not by inReference, in which case, we add to the end of the list.

        // Case where we are bounded by inReference
        if (currNode.getNext() != null){
            currNode = currNode.getNext(); // now our node is at position inReference.
        }

        // Check if position after inReference exists or is null
        if (currNode.getNext() != null)
        {
            insertNode.setNext(currNode.getNext());
            insertNode.setData(inData);
        }
        else{
            // Case where there is a null after after currNode
            insertNode.setData(inData);
        }

        currNode.setNext(insertNode); // Updates the previous node's pointer to the newly added node



        // Additions
        insertNode.setPrevReference(currNode);

        if ((insertNode.getNext()) != null){
            insertNode.getNext().setPrevReference(insertNode);
        }
    }





}


