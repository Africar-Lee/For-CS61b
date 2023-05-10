public class ArrayDeque<Item> {
    private final class AList<Item> {
        public Item[] items;
        public int head;
        public int tail;
        public int size;
        public int max_size = 8;

        /**
         * create an empty list.
         */
        public AList() {
            items = (Item[]) new Object[max_size];
            tail = 0;
            head = 1;
            size = 0;
        }

        /**
         * resize the underlying array to the target capacity.
         */
        private void resize(int capacity) {
            Item[] a = (Item[]) new Object[capacity];
            if (head < tail) {
                System.arraycopy(items, head, a, 0, size);
            } else {
                System.arraycopy(items, head, a, 0, size - head);
                System.arraycopy(items, 0, a, size - head, tail + 1);
            }
            items = a;
            head = 0;
            tail = size - 1;
        }

        /**
         * Inserts X into the back of the list.
         */
        public void addLast(Item x) {
            if (size == max_size) {
                resize(size * 2);
                max_size = size * 2;
            }
            tail = (tail + 1) % max_size;
            items[tail] = x;
            size += 1;
        }

        public void addFirst(Item x) {
            if (size == max_size) {
                max_size = max_size * 2;
                resize(max_size);
            }
            head = ((head + max_size - 1) % max_size);
            items[head] = x;
            size += 1;
        }

        /**
         * Get the last item of the list.
         */
        public Item getLast() {
            return items[tail];
        }

        public Item getFirst() {
            return items[head];
        }

        /**
         * Get the 'index'th item of the list.
         */
        public Item get(int index) {
            return items[(head + index) % max_size];
        }

        /**
         * Return the size of Alist.
         */
        public int size() {
            return size;
        }

        /**
         * Remove the last item of the list.
         */
        public Item removeLast() {
            Item x = items[tail];
            items[tail] = null;
            size -= 1;
            tail = ((tail + max_size - 1) % max_size);
            return x;
        }

        public Item removeFirst() {
            Item x = items[head];
            items[head] = null;
            size -= 1;
            head = ((head + 1) % max_size);
            return x;
        }

        public void printOutAList() {
            for (int i = 0; i < size; ++i) {
                System.out.print(items[((i + head) % max_size)] + " ");
            }
            System.out.println();
        }
    }

    private AList sentinel;
    private int size;

    /**
     * create an empty ArrayDeque.
     */
    public ArrayDeque() {
        sentinel = new AList();
        size = sentinel.size;
    }

    /**
     * create an AD from another AD.
     */
    public ArrayDeque(ArrayDeque other) {
        sentinel = new AList();
        sentinel.resize(other.sentinel.max_size);
        size = other.size;
        System.arraycopy(other.sentinel.items, 0, sentinel.items, 0, size);
        sentinel.head = other.sentinel.head;
        sentinel.tail = other.sentinel.tail;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * Add item to AD head.
     */
    public void addFirst(Item it) {
        sentinel.addFirst(it);
        size += 1;
    }

    public void addLast(Item it) {
        sentinel.addLast(it);
        size += 1;
    }

    public Item getFirst() {
        return (Item) sentinel.getFirst();
    }

    public Item getLast() {
        return (Item) sentinel.getLast();
    }

    public Item get(int index) {
        return (Item) sentinel.get(index);
    }

    public Item removeFirst() {
        size -= 1;
        return (Item) sentinel.removeFirst();
    }

    public Item removeLast() {
        size -= 1;
        return (Item) sentinel.removeLast();
    }

    public void printDeque() {
        sentinel.printOutAList();
    }
}
