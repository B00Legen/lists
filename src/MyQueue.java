public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;
    private int size;

    public MyQueue() {

    }

    public boolean empty(){
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T peek() {
        return list.getFirst();
    }

    public void enqueue(T item) {
        list.addLast(item);
        size++;
    }

    public T dequeue() {
        if (size == 0)
            return null;
        T res = list.getFirst();
        list.removeFirst();
        size--;
        return res;
    }
}
