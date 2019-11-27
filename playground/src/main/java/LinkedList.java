public class LinkedList<S> {
    private int size;
    private Node<S> HEAD;
    private Node<S> TAIL;


    public void add(S value) {
        size++;

        if (HEAD == null) {
            initHeadAndTail(value);
        } else {
            incrementTail(value);
        }
    }

    private void incrementTail(S value) {
        Node<S> node = createNode(value);
        TAIL.setNext(node);
        TAIL = node;
    }

    private void initHeadAndTail(S value) {
        Node<S> node = createNode(value);
        HEAD = node;
        TAIL = node;
    }

    private Node<S> createNode(S value) {
        Node<S> node = new Node<>();
        node.setValue(value);
        node.setPrevious(TAIL);

        return node;
    }

    public int size() {
        return size;
    }

    public S get(int index) {
        Node<S> current = HEAD;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    public boolean contains(S value) {
        return getNode(value) != null;
    }

    public boolean remove(S value) {
        Node<S> node = getNode(value);

        if (node == null) {
            return false;
        }

        updateNext(node);
        updatePrevious(node);

        size--;

        return true;
    }

    private Node<S> getNode(S value) {
        Node<S> node = HEAD;

        while (node != null) {
            if (node.getValue().equals(value)) {
                return node;
            }

            node = node.getNext();
        }

        return null;
    }

    private void updateNext(Node<S> node) {
        Node<S> next = node.getNext();

        if (next != null) {
            next.setPrevious(node.getPrevious());
        }

        if (HEAD == node) {
            HEAD = next;
        }

        node.setNext(null);
    }

    private void updatePrevious(Node<S> node) {
        Node<S> previous = node.getPrevious();

        if (previous != null) {
            previous.setNext(node.getNext());
        }

        if (TAIL == node) {
            TAIL = previous;
        }

        node.setPrevious(null);
    }

    public int indexOf(S value) {
        Node<S> node = HEAD;
        int index = 0;

        while (node != null) {
            if (node.getValue().equals(value)) {
                return index;
            }

            node = node.getNext();
            index++;
        }

        return -1;
    }


    static private class Node<S> {
        private S value;
        private Node<S> next;
        private Node<S> previous;

        S getValue() {
            return value;
        }

        void setValue(S value) {
            this.value = value;
        }

        Node<S> getNext() {
            return next;
        }

        public void setNext(Node<S> next) {
            this.next = next;
        }

        public Node<S> getPrevious() {
            return previous;
        }

        void setPrevious(Node<S> previous) {
            this.previous = previous;
        }
    }
}
