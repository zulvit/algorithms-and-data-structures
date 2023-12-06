package heap;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private ArrayList<E> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        E temp = heap.get(index);
        while (index > 0 && temp.compareTo(heap.get(parent(index))) > 0) {
            heap.set(index, heap.get(parent(index)));
            index = parent(index);
        }
        heap.set(index, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public E peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    protected E poll() {
        if (heap.isEmpty()) {
            return null;
        }
        E result = heap.get(0);
        E lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return result;
    }

    private void heapifyDown(int index) {
        int childIndex;
        E temp = heap.get(index);
        while (kthChild(index, 1) < heap.size()) {
            childIndex = maxChild(index);
            if (childIndex != -1 && temp.compareTo(heap.get(childIndex)) < 0) {
                heap.set(index, heap.get(childIndex));
                index = childIndex;
            } else {
                break;
            }
        }
        heap.set(index, temp);
    }


    private int kthChild(int i, int k) {
        return 2 * i + k;
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);

        // Проверяем, есть ли правый ребенок
        if (rightChild < heap.size()) {
            // Если есть оба ребенка, сравниваем их и возвращаем индекс большего
            return heap.get(leftChild).compareTo(heap.get(rightChild)) > 0 ? leftChild : rightChild;
        } else if (leftChild < heap.size()) {
            // Если есть только левый ребенок, возвращаем его индекс
            return leftChild;
        } else {
            // Если нет детей, возвращаем -1 (индикатор отсутствия детей)
            return -1;
        }
    }

}