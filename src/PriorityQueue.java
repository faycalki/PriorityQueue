public class PriorityQueue<T extends Priority> implements PriorityQueueADT<T> {
    @Override
    public void enqueue(T element) throws PriQueueOverflowException {

    }

    @Override
    public T dequeue() throws PriQueueUnderflowException {
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
}
