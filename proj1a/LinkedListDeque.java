public class LinkedListDeque<T> {
    private class DLNode {
        public T item;
        public DLNode prev;
        public DLNode next;

        public DLNode() {
            item = null;
            prev = this;
            next = this;
        }

        public DLNode(T it) {
            item = it;
            next = this;
            prev = this;
        }

        public DLNode(DLNode other) {
            item = other.item;
            next = this;
            prev = this;
        }

        public T get(int index) {
            if (index == 0) return item;
            return this.next.get(index - 1);
        }
    }

    private DLNode first;
    private DLNode last;
    private DLNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new DLNode();
        first = sentinel;
        last = sentinel;
        size = 0;
    }

    public LinkedListDeque(T it) {
        sentinel = new DLNode();
        sentinel.next = new DLNode(it);
        sentinel.prev = sentinel.next;
        first = sentinel.next;
        last = sentinel.prev;
        size = 1;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new DLNode(other.sentinel);
        first = sentinel;
        last = sentinel;
        size = 0;
        if (other.isEmpty()) return;
        DLNode p2o = other.first;
        while (p2o != other.sentinel) {
            this.addLast(p2o.item);
            p2o = p2o.next;
        }
        first = sentinel.next;
        last = sentinel.prev;
        size = other.size();
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        first.prev = new DLNode(item);
        sentinel.next = first.prev;
        first.prev.prev = sentinel;
        first.prev.next = first;
        size += 1;

        first = sentinel.next;
        last = sentinel.prev;
    }

    public void addLast(T item) {
        last.next = new DLNode(item);
        sentinel.prev = last.next;
        last.next.prev = last;
        last.next.next = sentinel;
        size += 1;

        first = sentinel.next;
        last = sentinel.prev;
    }

    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println();
            return;
        }
        DLNode p = first;
        System.out.print(p.item);
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(" " + p.item);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (this.isEmpty()) return null;
        T ret = first.item;

        sentinel.next = first.next;
        first = first.next;
        first.prev = sentinel;

        size -= 1;

        last = sentinel.prev;

        return ret;
    }

    public T removeLast() {
        if (this.isEmpty()) return null;
        T ret = last.item;

        sentinel.prev = last.prev;
        last = last.prev;
        last.next = sentinel;

        size -= 1;
        first = sentinel.next;

        return ret;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        DLNode p = sentinel;
        for (int i = 0; i <= index; ++i) {
            p = p.next;
        }
        if (p == sentinel) return null;
        return p.item;
    }
    public T getRecursive(int index) {
        return first.get(index);
    }
}
