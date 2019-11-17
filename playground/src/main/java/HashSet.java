import java.util.Iterator;

public class HashSet<S> implements Iterable<S> {
    private final int capacity;
    private S[][] elements;
    private int size;

    public HashSet() {
        this(16);
    }

    public HashSet(int capacity) {
        this.capacity = capacity;
        elements = (S[][]) new Object[capacity][];
    }

    public boolean add(S s) {
        int index = calculateIndex(s);

        if (elements[index] == null) {
            elements[index] = (S[]) new Object[capacity];
        }

        return add(elements[index], s);
    }

    private boolean add(S[] element, S s) {
        int i = 0;

        while (element[i] != null && !element[i].equals(s)) {
            i++;
        }

        if (element[i] == null) {
            element[i] = s;
            size++;
            return true;
        }

        return false;
    }

    public boolean remove(S s) {
        int index = calculateIndex(s);

        if (elements[index] == null) {
            return false;
        }

        return remove(elements[index], s);
    }

    private boolean remove(S[] element, S s) {
        int i = 0;

        while (!s.equals(element[i++]) && i < capacity) ;

        if (!s.equals(element[--i])) {
            return false;
        }

        element[i] = null;
        size--;

        return true;
    }

    public int size() {
        return size;
    }

    public boolean contains(S s) {
        int index = calculateIndex(s);
        S[] element = elements[index];

        if (element == null) {
            return false;
        }

        for (S e : element) {
            if (s.equals(e)) {
                return true;
            }
        }

        return false;
    }

    private int calculateIndex(S s) {
        return s.hashCode() % capacity;
    }

    @Override
    public Iterator<S> iterator() {
        return new HashSetIterator<S>(capacity, size, elements);
    }
}


class HashSetIterator<S> implements Iterator<S> {
    private final int capacity;
    private S[][] elements;
    private int size;

    private int currentColumn;
    private int currentRow = -1;

    public HashSetIterator(int capacity, int size, S[][] elements) {
        this.capacity = capacity;
        this.elements = elements;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    @Override
    public S next() {

        for (int i = currentRow + 1; elements[currentColumn] != null && i < elements[currentColumn].length; i++) {
            if (elements[currentColumn][i] != null) {
                currentRow = i;
                size--;
                return elements[currentColumn][i];
            }
        }

        currentRow = -1;

        updateColumn();
        return next();
    }

    private void updateColumn() {
        for (int i = currentColumn + 1; i < capacity; i++) {
            if (elements[i] != null) {
                currentColumn = i;
                return;
            }
        }
    }
}
