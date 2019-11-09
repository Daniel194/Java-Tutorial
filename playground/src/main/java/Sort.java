import java.util.Arrays;

public class Sort {

    public int[] putElementsAtTheEnd(int element, int[] ints) {
        int[] result = new int[ints.length];
        int current = 0;

        for (int anInt : ints) {
            if (anInt != element) {
                result[current++] = anInt;
            }
        }

        Arrays.fill(result, current, ints.length, element);

        return result;
    }

}
