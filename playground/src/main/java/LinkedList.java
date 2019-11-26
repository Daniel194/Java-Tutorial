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
