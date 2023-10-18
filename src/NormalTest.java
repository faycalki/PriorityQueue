public class NormalTest {
    public static void main(String args[]){


        DoublyLinkedList<DLLNode<String>> list = new DoublyLinkedList<>();
        DLLNode<String> node = new DLLNode<String>("1");
        DLLNode<String> nextNode = new DLLNode<String>("2");
        DLLNode<String> nextNextNode = new DLLNode<String>("3");
        list.addToFront(node);
        list.addToFront(nextNode);
        list.addToFront(nextNextNode);
        node.setNext(nextNode);
        nextNode.setNext(nextNextNode);
        nextNode.setPrevReference(node);
        nextNextNode.setPrevReference(nextNode);
        System.out.println(list.toString());
        System.out.println(list.checkDataAtLocation(1));



        //System.out.println(list.toString());

    }
}
