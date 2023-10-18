
public class Node<T>{
    private T data; // Node's reference to its inner data
    private Node<T> reference; // Reference to the next node


    /**
 * Constructor for objects of class Node with null reference
 * @param inData the reference of the object that the Node's data will hold as a pointer.
 */
public Node(T inData)
        {
        data = inData;
        reference = null;
        }

/**
 * Constructor for objects of class Node
 * @param inData the object to direct the pointer to
 * @param inNode the next node to direct the pointer to in the chain of nodes
 */
public Node(T inData, Node inNode)
        {
        data = inData;
        reference = inNode;
        }

public Node<T> getNext(){
        return reference;
        }

protected void setNext(Node<T> node){
        reference = node;
        }

public T getData(){
        return data;
        }

private void setData(T inData){
        data = inData;
        }

        }