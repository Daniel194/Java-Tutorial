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
                updateHead(node);
            }

            size++;

            return node;
        }

        private void updateHead(Node<K, V> node) {
            HEAD.setPrevious(node);
            node.setNext(HEAD);
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
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> previous;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
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
    }
}
