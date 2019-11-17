import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashSetTest {

    @Test
    public void initCapacity() {
        HashSet<String> hashSet = new HashSet<>(15);
    }

    @Test
    public void addElement() {
        HashSet<String> hashSet = new HashSet<>();

        Assertions.assertTrue(hashSet.add("test"));
        Assertions.assertFalse(hashSet.add("test"));
    }

    @Test
    public void removeElement() {
        HashSet<String> hashSet = new HashSet<>();

        Assertions.assertTrue(hashSet.add("test"));

        Assertions.assertTrue(hashSet.remove("test"));
        Assertions.assertFalse(hashSet.remove("test"));
    }


    @Test
    public void size() {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("test");
        Assertions.assertEquals(1, hashSet.size());

        hashSet.add("test");
        Assertions.assertEquals(1, hashSet.size());

        hashSet.add("test1");
        Assertions.assertEquals(2, hashSet.size());

        hashSet.remove("test1");
        Assertions.assertEquals(1, hashSet.size());

        hashSet.remove("test1");
        Assertions.assertEquals(1, hashSet.size());

        hashSet.remove("test");
        Assertions.assertEquals(0, hashSet.size());
    }

    @Test
    public void contains() {
        HashSet<String> hashSet = new HashSet<>();

        Assertions.assertFalse(hashSet.contains("test"));

        hashSet.add("test");
        Assertions.assertTrue(hashSet.contains("test"));

        hashSet.remove("test");
        Assertions.assertFalse(hashSet.contains("test"));
    }

    @Test
    public void testIterator() {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("test1");
        hashSet.add("test2");
        hashSet.add("test3");
        hashSet.add("test4");
        hashSet.add("test5");

        for (String s : hashSet) {
            System.out.println(s);
        }
    }

}
