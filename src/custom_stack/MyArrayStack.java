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
