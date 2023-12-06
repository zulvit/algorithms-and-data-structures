package heap;

import java.util.AbstractQueue;
import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> extends AbstractQueue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean add(E element) {
        maxHeap.add(element);
        return true;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E peek() {
        return maxHeap.peek();
    }

    @Override
    public E poll() {
        return maxHeap.poll();
    }
}
