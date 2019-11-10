import java.util.Arrays;

public class ArrayList<T> {
    private static int CAPACITY = 16;

    private int size;
    private T[] elements;


    public ArrayList() {
        elements = (T[]) new Object[CAPACITY];
    }

    public void add(T test) {
        if (size >= elements.length) {
            this.elements = increaseSize();
        }

        elements[size++] = test;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        return elements[i];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T object) {
        return this.indexOf(object) >= 0;
    }

    public boolean remove(T object) {
        int index = indexOf(object);

        if (index >= 0) {
            this.elements = eliminateElement(index);
            size--;
            return true;
        }

        return false;
    }

    public int indexOf(T object) {
        if (object == null) {
            return -1;
        }

        for (int i = 0; i < elements.length; i++) {
            if (object.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    private T[] eliminateElement(int position) {
        T[] first = Arrays.copyOfRange(elements, 0, position);
        T[] second = Arrays.copyOfRange(elements, position + 1, this.elements.length);

        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);

        return result;
    }

    private T[] increaseSize() {
        return Arrays.copyOf(this.elements, this.elements.length + CAPACITY);
    }
}
