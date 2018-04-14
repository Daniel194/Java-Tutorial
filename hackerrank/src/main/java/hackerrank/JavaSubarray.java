package hackerrank;

import java.util.Scanner;

public class JavaSubarray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(countNegativeSubarray(a));
    }


    public static int countNegativeSubarray(int... a) {
        int sumNeg = 0;

        for (int i = 1; i <= a.length; i++) {
            sumNeg += countNegativeSubarray(a, i);
        }

        return sumNeg;
    }

    private static int countNegativeSubarray(int[] a, int seize) {
        int count = 0;

        for (int i = 0; i <= a.length - seize; i++) {
            count += negativeSubarray(a, i, i + seize);
        }

        return count;
    }


    private static int negativeSubarray(int[] a, int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += a[i];
        }

        return negativeNumber(sum);
    }

    private static int negativeNumber(int a) {
        if (a < 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
