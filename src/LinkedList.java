/**
* The LLNode class is an implementation of the List ADT as a Linked List.
* The Head is at the start of the Linked List, we use it to traverse the entire LinkedList for now.
*
* @author Faycal Kilali
* @version 1.0
* 
*/
public class LinkedList<T> implements ListADT<T>, LinkedListADT<T>
{
    private Node<T> head; // Recall that this variable actually points to the node. Possibly maybe the head node should always have an objectReference of null


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
        if(isEmpty()){
        Node<T> newNode = new Node<T>(inData); // New head
        head = newNode; // So we don't need to assign this? The head isn't a separate node, the first node is always the head node.
        //head.setNext(newNode);  
        }
        else{
        Node<T> newNode = new Node<T>(inData, head);
        head = newNode;
        // Previous node's reference becomes the new node's reference, and the previous node's reference changes to the new code.
        }

    }

    /**
     * Same as add method, required due to abstract implementation of interface
     * @param inData the new node's data reference that we will add to the front of the Linked List
     * @throws NullPointerException if inData is null. The Exception should be caught and the method re-called with a non-null object.
     */
    @Override
    public void addToFront(T inData) throws NullPointerException
    {
     add(inData);   
    }

    /**
     * Adds a node to the tail of the linked list
     * @param inData the added node's data reference
     * @throws NullPointerException if inData is null. The Exception should be caught and the method re-called with a non-null object.
     */
    @Override
    public void addToBack(T inData)throws NullPointerException{
        if (inData == null){
          throw new NullPointerException("Parameterized object is null");
        }
        Node<T> currNode = traverseLinkedList(null);
        Node<T> insertNode = new Node(inData);
        currNode.setNext(insertNode);
    }


    /**
     * Adds a node after a particular node (usually between two nodes, but not necessarily between two nodes because it could be the last node)
     * @param inData, inReference
     * @throws NullPointerException if inReference is null. The Exception should be caught and the method re-called with a non-null object.
     */
    @Override
    public void addAfter(T inData, T inReference) throws NullPointerException
    {
        if (inData == null){
          throw new NullPointerException("Parameterized object is null");
        }
        Node<T> currNode = traverseLinkedList(inReference).getNext(); // Gets the reference before the addition of the node
        Node<T> insertNode = new Node<T>(inData, currNode.getNext()); // Inserts the node at the approriate place 
        currNode.setNext(insertNode); // Updates the previous node's pointer to the newly added node
    }
    
    
     /**
     * Adds a Node at a particular position
     * @param inData, inReference, inPosition
     * @throws NullPointerException if inReference is null. The Exception should be caught and the method re-called with a non-null object. IllegalArgumentException if the position is illegal.
     */
    public void addMove(T inData, T inReference, int inPosition) throws NullPointerException, IllegalArgumentException
    {
                    
        if (inPosition == 0){
            addToFront(inData);
            return;
        }
        
        if (inPosition == getSize()){
            addToBack(inData);
            return;
        }
        
        
        if (inData == null){
          throw new NullPointerException("Parameterized object is null");
        }
        
        if ( (inPosition > getSize()) || (inPosition < 0) ){
            throw new IllegalArgumentException("Illegal position in Data Structure");
        }
        
        Node<T> currNode = traverseLinkedListToPosition(inPosition); 
        Node<T> insertNode = new Node(inData);
        if (  (currNode.getNext() != null) ){
            insertNode.setNext(currNode.getNext()); // Sets the correct reference for the move we are adding so the chain isn't broken
            }
        currNode.setNext(insertNode); // Updates the previous move's pointer to the newly added move
    }
    

    /**
     * Helper method to traverse a Linked List up to the node before inReference
     * @param inReference
     * @return Node, returns the node before inReference
     */
    private Node<T> traverseLinkedList(T inReference) throws NullPointerException{
        if (isEmpty() == true){
            throw new NullPointerException();
        }
        Node<T> currNode = head;
        while (currNode.getNext() != inReference){
            currNode = currNode.getNext();
        }
        return currNode;
    }
    
    /**
     * Helper method to traverse a Linked List up to the position of inPosition inclusive (assuming the head node is at position 0, and incrementing towards more nodes). This requires that a LinkedList has at least one element in it already.
     * @Param inPosition the position starting from the head node
     * @return Node, returns the node at the inPosition'th position.
     */
    public Node<T> traverseLinkedListToPosition(int inPosition) throws IllegalArgumentException{
        
        // No position when LL is empty
        if (isEmpty()){
            throw new IllegalStateException("Linked list is empty.");
        }
        
        if ( (inPosition > getSize()) || (inPosition < 0) ){
            throw new IllegalArgumentException("Illegal position in Data Structure. Position must be positive and must be smaller than size of Data Structure. Maximal position is " + getSize() + ", received" + inPosition);
        }
        
        int curPosition = 0;
        Node<T> currNode = head;
        while (currNode != null){
            if (inPosition == curPosition){
            return currNode;
            }
            currNode = currNode.getNext();
            curPosition++;
        }
        return currNode;
    }

    /**
     * Removes the whole first node from the Linked List
     * This accesses the referenced node's reference, hence traversing exactly two nodes forward from the head node in order to connect the node before the inReference node with the node that comes after inReference.
     * This should not return a null value. Rather, the exception EmptyListException should be thrown. The user can recover from that by ensuring they are removing from a non-empty list
     * @return the removed node, or null if no node to be removed
     */

    @Override
    public T remove(){
       //Node traversedListByOne = head.getNext().getNext();
       if (isEmpty() == false){
        Node<T> currNode = head;
        head = head.getNext();
        
        // Returning the removed node's data
        return currNode.getData();
        }

        return null; // better to throw an exception instead
    }

    /**
     * Same as remove method, again duplication due to interface method requirement
     */
    @Override
    public T removeFromFront(){
        return remove();
    }

    /**
     * Removes the tail node from the Linked List
     */
    @Override
    public T removeFromBack(){
        Node<T> currNode = traverseLinkedList(null);
        Node<T> prevNode = traverseLinkedList(currNode.getData());
        prevNode.setNext(null);
        return currNode.getData();
    }



    /**
     * Removes the first instance of an object reference. Removes currentNode by substituting previousNode with the reference of the node after currentNode, where currentNode has the value we wish to remove.
     * @throws IllegalArgumentException if instance is not found
     */
    @Override
    public void removeFirstInstance(T value) throws IllegalArgumentException{

 

        boolean performedAction = false;
        Node<T> currentNode = head.getNext();
        Node<T> previousNode=head;
        while(currentNode.getData() != value){
            previousNode  = currentNode;
            currentNode = currentNode.getNext();
            performedAction = true;
        }
        if (performedAction == false){
          throw new IllegalArgumentException("Passed-in argument value does not exist in Linked List.");
        }
        previousNode.setNext(currentNode.getNext());
    }

        /**
     * Removes all the instance of an object reference. Removes currentNode by substituting previousNode with the reference of the node after currentNode, where currentNode has the value we wish to remove.
     * @throws IllegalArgumentException if instance is not found
     */
    @Override
    public void removeAllInstances(T value) throws IllegalArgumentException{


        Node<T> currentNode = head.getNext();
        Node<T> previousNode=head;
        boolean performedAction = false;

 

        while (currentNode != null){
        while(currentNode.getData() != value){
            previousNode  = currentNode;
            currentNode = currentNode.getNext();
            performedAction = true;
        }
        previousNode.setNext(currentNode.getNext());
        }
        if (performedAction == false){
          throw new IllegalArgumentException("Passed-in argument value does not exist in Linked List.");
        }


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

        int size = 0;
        Node<T> currentNode = head;
        while(currentNode !=null){
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty(){
        if (head == null){
            return true;
        }

        return false;
    }

        /**
         * Method borrowed from COMP-2611 made by Ada Clevinger
         */    
        @Override
        public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if(head != null){
            Node<T> curr = head;
            while(curr != null){

                if (curr.getNext() == null){
                    sb.append(curr.getData());
                }
                else{
                    sb.append(curr.getData() + ", ");
                }
                curr = curr.getNext();
            }
        }
        sb.append("]");

        return sb.toString();
    }


    /**
     * Accessor method for the Head Node
     * @return returns the Head Node
     */
    public Node<T> getHeadData(){
            return head;
    }
 

}