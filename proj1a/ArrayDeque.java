import org.junit.runner.notification.StoppedByUserException;

public class ArrayDeque<T> {
    private T[] items;
    private int first;
    private int last;
    private int size;
    private int max_size = 8;

    public ArrayDeque() {
        items = (T[]) new Object[max_size];
        first = 1;
        last = 1;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        int n = other.size();
        items = (T[]) new Object[n];
        for(int i = 0; i < n; ++i) {
            items[i] = (T) other.get(i);
        }
        size = n;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int cap) {
        T[] a = (T[]) new Object[cap];
        if(first <= last) {
            System.arraycopy(items, first, a, 1, size);
        } else {
            System.arraycopy(items, first, a, 1, size - first + 1);
            System.arraycopy(items, 0, a, size - first + 2, last + 1);
        }
        items = a;
        first = 1;
        last = size + 1;
    }

    public void printDeque() {
        if(this.isEmpty()) {
            System.out.println();
            return;
        }
        System.out.print(items[first]);
        for(int i = 1; i < size; ++i) {
            System.out.print(" " + items[(first + i) % max_size]);
        }
        System.out.println();
    }

    public void addFirst(T item) {
        if(size == max_size) {
            max_size = 2 * max_size;
            this.resize(max_size);
        }
        first = (first - 1 + max_size) % max_size;
        items[first] = item;
        size += 1;
    }

    public void addLast(T item) {
        if(size == max_size) {
            max_size = 2 * max_size;
            this.resize(max_size);
        }
        items[last] = item;
        last = (last + 1) % max_size;
        size += 1;
    }

    public T removeFirst() {
        if(this.isEmpty()) {return null;}
        T ret = items[first];
        first = (first + 1) % max_size;
        size -= 1;
        return ret;
    }

    public T removeLast() {
        if(this.isEmpty()) {return null;}
        last = (last - 1 + max_size) % max_size;
        T ret = items[last];
        size -= 1;
        return ret;
    }

    public T get(int index) {
        if(index >= size || index < 0) {return null;}
        int i = (first + index) % max_size;
        return items[i];
    }

    private T getFirst() {
        return items[first];
    }

    private T getLast() {
        return items[last - 1];
    }
}
