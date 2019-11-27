import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private static LinkedList<String> list;

    @BeforeEach
    void setUp() {
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

    @Test
    public void containElement() {
        assertTrue(list.contains("test1"));
        assertFalse(list.contains("test"));
    }

    @Test
    public void indexOfElement() {
        assertEquals(0, list.indexOf("test1"));
        assertEquals(2, list.indexOf("test3"));
        assertEquals(1, list.indexOf("test2"));
        assertEquals(-1, list.indexOf("test"));
    }

    @Test
    public void removeElement() {
        assertTrue(list.remove("test1"));
        assertEquals(2, list.size());

        assertFalse(list.remove("test1"));
        assertEquals(2, list.size());
    }


}
