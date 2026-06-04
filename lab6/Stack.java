// задание 2
package JavaLabs.lab6;

public class Stack<T> {

    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {

        if (size == data.length) {
            System.out.println("Стек переполнен!");
            return;
        }

        data[size] = element;
        size++;
    }

    public T pop() {

        if (size == 0) {
            throw new RuntimeException("Стек пуст!");
        }

        size--;

        T element = data[size];

        data[size] = null;

        return element;
    }

    public T peek() {

        if (size == 0) {
            throw new RuntimeException("Стек пуст!");
        }

        return data[size - 1];
    }
}