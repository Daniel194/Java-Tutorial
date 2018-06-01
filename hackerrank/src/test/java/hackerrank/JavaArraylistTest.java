package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaArraylistTest {

    @Test
    public void hasElement() {
        Assert.assertEquals("ERROR!", JavaArraylist.getElement(0, 0, getArrayList()));
        Assert.assertEquals("1", JavaArraylist.getElement(0, 0, getArrayList(new Integer[]{1})));
        Assert.assertEquals("2", JavaArraylist.getElement(1, 1, getArrayList(new Integer[]{1, 2, 3},
                new Integer[]{1, 2, 3})));
    }

    @Test
    public void convertStringToIntegersTest() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), JavaArraylist.convertStringToIntegers("1 2 3 4 5"));
    }

    private ArrayList<List<Integer>> getArrayList(Integer[]... integersList) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();

        for (Integer[] integers : integersList) {
            list.add(Arrays.asList(integers));
        }

        return list;
    }


}
