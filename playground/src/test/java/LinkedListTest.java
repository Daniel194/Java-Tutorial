import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private static LinkedList<String> list;

    @BeforeAll
    static void setUp() {
        list = new LinkedList<>();

        list.add("test1");
        list.add("test2");
        list.add("test3");
    }

    @Test
    public void listSize() {
        assertEquals(3, list.size());
    }


    @Test
    public void getListElement() {
        assertEquals("test1", list.get(0));
        assertEquals("test3", list.get(2));
        assertEquals("test2", list.get(1));
    }

}
