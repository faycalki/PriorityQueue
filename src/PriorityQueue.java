/**
 * Priority Queue Implementation using Doubly Linked Lists as the underlying Queue uses a Doubly Linked List.
 * @implSpec the type T is a subtype of Priority
 * @param <T>
 */
public class PriorityQueue<T extends Priority<T>> extends Queue<T> implements PriorityQueueADT<T> {

    Queue<T> tempQueue;
    public PriorityQueue(){
        tempQueue = new Queue<T>();
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {

        if (size() == 0){
            super.enqueue(element);
            return;
        }

        if (isFull()){
            throw new QueueOverflowException("Queue is full");
        }

        boolean priorityFound = false;
        int originalSize = size();
        int priorityPosition = 0;
        for (int currentPosition = 0; currentPosition < originalSize; currentPosition++){
            try {
                T frontElement = dequeue(); // We remove the current front-most element in the Queue (Dequeue)
                tempQueue.enqueue(frontElement); // Add to the back of the temporary queue

                /*
                 * Track position of current placement (should be currentPosition)
                 * Remove all remaining elements in the Queue (placing them one by one in the temporary queue)
                 * Add all the elements prior to currentPosition from the temporary queue to the priority queue
                 * Add the passed-in argument element to the priority queue
                 * Add the remaining elements from the temporary queue to the priority queue
                 */

                if (element.isMoreImportant(frontElement) == true && priorityFound == false) {
                    priorityFound = true;
                    priorityPosition = currentPosition;
                }
            }
            catch(QueueUnderflowException e){
                System.err.println("Unexpected QueueUnderflow Exception");
            }
        }

        if (priorityFound == true) {
            // Add the elements up to the priority position as they were back to the queue
            for (int k = 0; k < priorityPosition; k++){
                try {
                    super.enqueue(tempQueue.dequeue());
                } catch (QueueUnderflowException e) {
                    throw new RuntimeException(e);
                }
            }
            // Add the priority element
            super.enqueue(element);

            // Add the remaining elements
        for (int i = priorityPosition; i < originalSize; i++){
            try {
                super.enqueue(tempQueue.dequeue());
            } catch (QueueUnderflowException e) {
                throw new RuntimeException(e);
            }
        }
    }
        // If the actual parameter is no more important than any element in the queue, execute the following
        else{
            for (int position = 0; position < originalSize; position++){
                try {
                    super.enqueue(tempQueue.dequeue()); // regain the order
                } catch (QueueUnderflowException e) {
                    throw new RuntimeException(e);
                }
            }
            super.enqueue(element); // it is obligatory that the element must be of same or less priority than the last element in the queue.
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        try {
            return super.dequeue();
        }
        catch (QueueUnderflowException e) {
            //throw new PriQueueUnderflowException("Unexpected PriQueueUnderflowException");
            throw new QueueUnderflowException("Unexpected QueueUnderflowException");
        }
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

}
