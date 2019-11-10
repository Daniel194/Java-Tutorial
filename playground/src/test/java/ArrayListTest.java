import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test
    public void testSize() {
        list.add("test");
        list.add("test");
        list.add("test");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testGet() {
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assertEquals(list.get(0), "test1");
        assertEquals(list.get(1), "test2");
        assertEquals(list.get(2), "test3");
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            list.add("test");
        }
    }

    @Test
    public void testIsEmpty() {
        ArrayList list = new ArrayList();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        list.add("test");

        assertTrue(list.contains("test"));
        assertFalse(list.contains("aaaaa"));
    }

    @Test
    public void testRemove() {
        list.add("test10");
        list.add("test11");
        list.add("test12");
        list.add("test13");
        list.add("test14");

        list.remove("test12");

        assertEquals(4, list.size());
        assertFalse(list.contains("test12"));
    }

    @Test
    public void testIndexOf() {
        list.add("test10");
        list.add("test11");
        list.add("test12");
        list.add("test13");
        list.add("test14");

        assertEquals(2, list.indexOf("test12"));
    }

}
