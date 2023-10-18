public class DLLNode<T> extends Node<T>{

    private Node<T> prevReference;


    public DLLNode(T inData){
        super(inData);
        prevReference = null;
    }

    /**
     * Constructor with pre-defined references (experimental, use setNext instead)
     * @param inData
     * @param nextReference
     * @param prevNode
     */
    public DLLNode(T inData, DLLNode<T> nextReference, DLLNode<T> prevNode){
        super(inData, nextReference);
        this.prevReference = prevNode;
    }

    /**
     * Accessor method for previous node in the chain
     * @return the previous node reference
     */
    public Node<T> getPrevReference(){

        return prevReference;
    }

    /**
     * Mutator method for the previous node in the chain
     * @param previous what to set the previous node reference to
     */
    public void setPrevReference(Node<T> previous){
        prevReference = previous;
    }

}


