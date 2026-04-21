public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> array;
    private int size;

    private int leftChildOf(int index) {
        int res = index * 2 + 1;
        if (res >= size)
            return -1;
        return res;
    }

    private int rightChildOf(int index) {
        int res = index * 2 + 2;
        if (res >= size)
            return -1;
        return res;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int id1, int id2) {
        T temp = array.get(id1);
        array.set(id1, array.get(id2));
        array.set(id2, temp);
    }

    private boolean isGreater(int id1, int id2) {
        T a = array.get(id1);
        T b = array.get(id2);
        // returns true if a > b
        return a.compareTo(b) > 0;
    }

    private void heapify(int id) {
        int lid = leftChildOf(id), rid = rightChildOf(id);
        if (rid != -1) {
            int id2 = (isGreater(lid, rid) ? rid : lid);
            if (isGreater(id, id2)) {
                swap(id, id2);
                heapify(id2);
            }
        } else if (lid != -1) {
            if (isGreater(id, lid)) {
                swap(id, lid);
                heapify(lid);
            }
        }
    }

    private void traverseUp(int index) {
        int par = parentOf(index);
        if (par == index)
            return;
        if (isGreater(par, index)) {
            swap(par, index);
            traverseUp(par);
        }
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T getMin() {
        return array.getFirst();
    }

    public T extractMin() {
        if (size == 0)
            return null;
        T res = array.getFirst();
        swap(0, size - 1);
        array.removeLast();
        heapify(0);
        size--;
        return res;
    }

    public void insert(T item) {
        array.addLast(item);
        traverseUp(size++);
    }
}
