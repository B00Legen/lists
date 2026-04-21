import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode<T> {
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }
    private MyNode<T> head, tail;
    private int size;

    public MyLinkedList() {
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            MyNode<T> curs = head;

            @Override
            public boolean hasNext() {
                return curs.next != null;
            }

            @Override
            public T next() {
                return (curs = curs.next).data;
            }
        };
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null)
                break;
            cur = cur.next;
        }
        if (cur != null)
            cur.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (head == null)
            add(item);
        else if (index == 0) {
            MyNode<T> newNode = new MyNode<>(item);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            MyNode<T> cur = head;
            //we put new node right after cur (which should have index - 1)
            for (int i = 0; i < index - 1; i++) { //i - position of cur node
                if (cur == null)
                    break;
                cur = cur.next; // move node to the right (position++)
            } // loop breaks when i (position) = index - 1
            if (cur != null) {
                // We add it to the right (next position)
                MyNode<T> newNode = new MyNode<>(item);
                newNode.prev = cur;
                if (cur != tail) {
                    newNode.next = cur.next;
                    (cur.next).prev = newNode;
                } else
                    tail = newNode;
                cur.next = newNode;
                size++;
            }
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        MyNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null)
                break;
            cur = cur.next;
        }
        return (cur == null ? null : cur.data);
    }

    @Override
    public T getFirst() {
        return (head == null ? null : head.data);
    }

    @Override
    public T getLast() {
        return (tail == null ? null : tail.data);
    }

    @Override
    public void remove(int index) {
        if (size == 0)
            return;
        MyNode<T> cur = head;
        for (int i = 1; i <= index; i++) {
            if (cur == null)
                break;
            cur = cur.next;
        }
        if (cur != null) {
            if (cur != head)
                (cur.prev).next = cur.next;
            if (cur != tail)
                (cur.next).prev = cur.prev;
            size--;
        }
        if (index == 0)
            head = head.next;
        if (index == size - 1)
            tail = tail.prev;
    }

    @Override
    public void removeFirst() {
        if (size == 0)
            return;
        head = head.next;
        head.prev = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0)
            return;
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    private boolean isGreater(T a, T b) {
        // Returns true if a > b
        return a.compareTo(b) > 0;
    }

    private void swap(MyNode<T> a, MyNode<T> b) {
        T temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    @Override
    public void sort() {
        for (int i = 1; i < size; i++) {
            MyNode<T> cur = head;
            for (int j = 0; j <= size - i; j++)
                if (isGreater(cur.data, (cur.next).data))
                    swap(cur, cur.next);
                else
                    cur = cur.next;
        }
    }

    @Override
    public int indexOf(Object object) {
        if (Objects.equals(head.data, object))
            return 0;
        MyNode<T> cur = head;
        for (int i = 1; i < size; i++) {
            cur = cur.next;
            if (Objects.equals(cur.data, object))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (Objects.equals(tail.data, object))
            return size - 1;
        MyNode<T> cur = tail;
        for (int i = size - 2; i >= 0; i--) {
            cur = cur.prev;
            if (Objects.equals(cur.data, object))
                return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return (indexOf(object) != -1);
    }

    @Override
    public Object[] toArray() {
        if (size == 0)
            return null;
        Object[] arr = new Object[size];
        MyNode<T> cur = head;
        for (int i = 0; i < size(); i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
}
