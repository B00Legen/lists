public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> array;
    private int size;

    public MyStack() {
        array = new MyArrayList<T>();
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T peek() {
        return array.getLast();
    }

    public void push(T item) {
        array.addLast(item);
        size++;
    }

    public T pop() {
        if (size == 0)
            return null;
        T res = array.getLast();
        array.removeLast();
        size--;
        return res;
    }
}
