package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class JavaSubarrayTest {

    @Test
    public void countNegativeSubarray() {
        assertEquals(0, 1, 2, 3, 4);
        assertEquals(1, -1, 2, 3, 4);
        assertEquals(3, -1, -2, 3, 4);
        assertEquals(4, -1, 2, -3, 4);
        assertEquals(3, -1, 2, 3, -4);
        assertEquals(9, 1 ,-2, 4, -5, 1);
    }

    private void assertEquals(int negativeSubarrays, int... a) {
        Assert.assertEquals(JavaSubarray.countNegativeSubarray(a), negativeSubarrays);
    }

}
