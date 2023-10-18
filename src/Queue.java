/**
 * Linked-List based implementation of a Queue.
 * @param <T>
 */

public class Queue<T> implements QueueADT<T>, QueuePlusADT<T> {

    @Override
    public void enqueue(T element) throws QueueOverflowException {

    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void resetFront() {

    }

    @Override
    public void changeSize(int newMaxSize) throws InsufficientSizeException {

    }
}
