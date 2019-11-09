import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    public Sort sort = new Sort();

    @Test
    public void sameArray() {
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{}), new int[]{});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{0}), new int[]{0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{0, 0}), new int[]{0, 0});
    }

    @Test
    public void twoElements() {
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{0, 1}), new int[]{1, 0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{1, 0}), new int[]{1, 0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{1, 2}), new int[]{1, 2});
    }

    @Test
    public void threeElements() {
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{1, 0, 0}), new int[]{1, 0, 0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{0, 1, 0}), new int[]{1, 0, 0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{0, 0, 1}), new int[]{1, 0, 0});

        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{0, 1, 1}), new int[]{1, 1, 0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{1, 2, 0}), new int[]{1, 2, 0});
        assertArrayEquals(sort.putElementsAtTheEnd(0, new int[]{1, 0, 2}), new int[]{1, 2, 0});
    }

    @Test
    public void complicateTest() {
        assertArrayEquals(sort.putElementsAtTheEnd(5, new int[]{7, 8, 5, 2, 5, 9, 0}), new int[]{7, 8, 2, 9, 0, 5, 5});
    }

}
