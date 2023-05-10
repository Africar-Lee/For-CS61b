import java.util.Iterator;
import java.util.Map;

public class AList<Item> {
    private Item[] items;
    private int size;

    /** create an empty list. */
    public AList() {
        items = (Item[])new Object[100];
        size = 0;
    }

    /** resize the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[])new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size <= items.length) {
            resize(size * 2);
        }
        items[size-1] = x;
        size += 1;
    }

    /** Get the last item of the list. */
    public Item getLast() {
        return items[size-1];
    }

    /** Get the 'index'th item of the list. */
    public Item get(int index) {
        return items[index];
    }

    /** Return the size of Alist. */
    public int size() {
        return size;
    }

    /** Remove the last item of the list. */
    public Item removeLast() {
        Item x = items[size-1];
        items[size-1] = null;
        size -= 1;
        return x;
    }
}