package interview;

public class LinkedListAdd {
    private Node current;

    private LinkedList first;
    private LinkedList second;
    private LinkedList result;

    private int carry;

    public LinkedListAdd(LinkedList first, LinkedList second) {
        if (first.size() < second.size()) {
            this.first = second;
            this.second = first;
        } else {
            this.first = first;
            this.second = second;
        }

        result = new LinkedList();
    }

    private void addSameSize(Node n, Node m) {
        if (n == null) {
            return;
        }

        addSameSize(n.next, m.next);

        int sum = n.val + m.val + carry;
        carry = sum / 10;
        sum = sum % 10;

        result.push(sum);
    }

    private void propagateCarry(Node node) {
        if (node == current) {
            return;
        }

        propagateCarry(node.next);

        int sum = carry + node.val;
        carry = sum / 10;
        sum %= 10;

        result.push(sum);
    }

    LinkedList addLists() {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.size() == second.size()) {
            addSameSize(first.getHead(), second.getHead());
        } else {
            current = first.getNode(first.size() - second.size());

            addSameSize(current, second.getHead());
            propagateCarry(first.getHead());
        }

        if (carry > 0) {
            result.push(carry);
        }

        return result;
    }
}

class LinkedList {
    private Node head;
    private int size = 0;

    void push(int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;

        size++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        while (head != null) {
            stringBuilder.append(head.val).append(" ");
            head = head.next;
        }

        return stringBuilder.toString();
    }

    int size() {
        return size;
    }

    Node getHead() {
        return head;
    }

    Node getNode(int index) {
        Node temp = head;
        Node current = null;

        while (index-- >= 0) {
            current = temp;
            temp = temp.next;
        }

        return current;
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
