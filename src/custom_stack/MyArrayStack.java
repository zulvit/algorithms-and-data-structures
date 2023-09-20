package custom_stack;

import java.util.Arrays;

public class MyArrayStack<T> {
    private T[] elements;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public MyArrayStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T element) {
        if (element == null) {
            throw new NullPointerException("Element is empty");
        }
        if (size >= elements.length) {
            ensureCapacity();
        } else {
            elements[size++] = element;
        }
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        } else {
            T result = elements[--size];
            elements[size] = null;
            return result;
        }
    }

    public int search(T element) {
        if (element == null) {
            throw new NullPointerException("Search element is null");
        }
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public T peek() throws Exception {
        if (size <= 0) {
            throw new Exception("Stack is empty");
        }
        return elements[size];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    private void ensureCapacity() {
        elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
