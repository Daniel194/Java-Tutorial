package interview;

import org.junit.jupiter.api.Test;

class LinkedListAddTest {

    @Test
    public void test() {
        LinkedList first = new LinkedList();
        LinkedList second = new LinkedList();

        first.push(9);
        first.push(9);
        first.push(9);

        second.push(8);
        second.push(1);

        LinkedListAdd add = new LinkedListAdd(first, second);

        System.out.println(add.addLists());
    }

}
