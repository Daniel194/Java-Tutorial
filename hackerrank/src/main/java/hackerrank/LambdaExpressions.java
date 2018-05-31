package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    static PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    static PerformOperation isPrime() {
        return a -> {
            for (int divisor = 2; divisor <= a / 2; divisor++) {
                if (a % divisor == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    static PerformOperation isPalindrome() {
        return a -> {
            String normal = Integer.toString(a);
            String reverse = new StringBuilder(normal).reverse().toString();
            return normal.equals(reverse);
        };
    }
}

public class LambdaExpressions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            System.out.println(executeCommand(br.readLine().trim()));
        }
    }

    private static String executeCommand(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int ch = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        switch (ch) {
            case 1 :
                return MyMath.checker(MyMath.isOdd(), num) ? "ODD" : "EVEN";
            case 2:
                return MyMath.checker(MyMath.isPrime(), num) ? "PRIME" : "COMPOSITE";
            case 3:
                return MyMath.checker(MyMath.isPalindrome(), num) ? "PALINDROME" : "NOT PALINDROME";
            default:
                return "";
        }
    }
}
