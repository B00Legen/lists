import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>{
    private Object[] array;
    private int size = 0, cap = 1;

    public MyArrayList() {
        array = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index + 1 < size();
            }

            @Override
            public T next() {
                return get(++index);
            }
        };
    }

    @Override
    public void add(T item) {
        if (size == 0) {
            array = new Object[1];
            array[size++] = item;
        } else if (size == cap) {
            cap *= 2;
            Object[] array2 = new Object[cap];
            System.arraycopy(array, 0, array2, 0, size);
            array2[size++] = item;
            array = array2;
        } else
            array[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index >= 0 && index < size)
            array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            return;
        if (size == 0)
            array[size++] = item;
        else if (size == cap) {
            cap *= 2;
            Object[] array2 = new Object[cap];
            System.arraycopy(array, 0, array2, 0, index);
            array2[index] = item;
            System.arraycopy(array, index, array2, index + 1, size - index);
            size++;
            array = array2;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = item;
            size++;
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
        if (index >= 0 && index < size)
            return (T) array[index];
        else
            return null;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast(){
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    private boolean isGreater(T a, T b) {
        // Returns true if a > b
        return a.compareTo(b) > 0;
    }

    private void swap(int a, int b) {
        T temp = get(a);
        array[a] = get(b);
        array[b] = temp;
    }

    @Override
    public void sort() {
        for(int i = 0; i < size; i++) {
            int pos = 0;
            for (int j = 1; j < size - i; j++)
                if (isGreater(get(j), get(pos)))
                    pos = j;
            swap(pos, size - i - 1);
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++)
            if (get(i) == object)
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--)
            if (get(i) == object)
                return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public void clear() {
        size = 0;
        cap = 1;
        array = null;
    }

    @Override
    public int size() {
        return size;
    }
}
