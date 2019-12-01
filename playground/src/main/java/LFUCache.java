import java.util.HashMap;

public class LFUCache<K, V> {
    private final int capacity;
    private HashMap<K, Node<K, V>> cache;
    private LikedList<K, V> likedList;

    public LFUCache() {
        this(16);
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        likedList = new LikedList<>();
    }


    public boolean add(K key, V value) {
        if (likedList.size() == capacity) {
            removeLastValue();
        }

        cache.put(key, likedList.add(key, value));

        return true;
    }

    public V get(K key) {
        Node<K, V> node = cache.get(key);

        if (node == null) {
            return null;
        }

        node.increaseUsage();
        likedList.update(node);

        return node.getValue();
    }

    private void removeLastValue() {
        Node<K, V> node = likedList.removeTail();
        cache.remove(node.getKey());
    }

    private static class LikedList<K, V> {
        private Node<K, V> HEAD;
        private int size;

        Node<K, V> add(K key, V value) {
            Node<K, V> node = new Node<>(key, value);

            if (HEAD == null) {
                HEAD = node;
            } else {
                update(node);
            }

            size++;

            return node;
        }

        private void updateHead(Node<K, V> node) {
            HEAD.setPrevious(node);
            node.setNext(HEAD);
            node.setPrevious(null);
            HEAD = node;
        }

        Node<K, V> removeTail() {
            Node<K, V> current = HEAD;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.getPrevious().setNext(null);
            current.setPrevious(null);

            size--;

            return current;
        }

        int size() {
            return size;
        }

        public void update(Node<K, V> node) {
            Node<K, V> newNext = findNewNextNode(node);

            deleteNode(node);

            if (newNext == HEAD) {
                updateHead(node);
                return;
            }

            if (newNext == null) {
                addToTail(node);
                return;
            }

            replaceNodeInNewPlace(node, newNext);
        }

        private void deleteNode(Node<K, V> node) {
            Node<K, V> previous = node.getPrevious();
            Node<K, V> next = node.getNext();

            if (previous != null) {
                previous.setNext(next);
            }

            if (next != null) {
                next.setPrevious(previous);
            }
        }

        private Node<K, V> findNewNextNode(Node<K, V> node) {
            Node<K, V> newNext = HEAD;

            while (newNext != null && newNext.usage() > node.usage()) {
                newNext = newNext.getNext();
            }

            return newNext;
        }

        private void replaceNodeInNewPlace(Node<K, V> node, Node<K, V> newNext) {
            Node<K, V> newPrevious = newNext.getPrevious();

            node.setPrevious(newPrevious);
            node.setNext(newNext);

            newPrevious.setNext(node);
            newNext.setPrevious(node);
        }

        private void addToTail(Node<K, V> node) {
            Node<K, V> current = HEAD;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(node);
            node.setPrevious(current);
        }
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        private int usage;

        private Node<K, V> next;
        private Node<K, V> previous;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.usage = 1;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        Node<K, V> getNext() {
            return next;
        }

        void setNext(Node<K, V> next) {
            this.next = next;
        }

        Node<K, V> getPrevious() {
            return previous;
        }

        void setPrevious(Node<K, V> previous) {
            this.previous = previous;
        }

        void increaseUsage() {
            usage++;
        }

        int usage() {
            return usage;
        }
    }
}
