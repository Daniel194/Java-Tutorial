package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimality {
    private static final BigInteger TWO = new BigInteger("2");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();

        if (isPrime(n)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }

    private static boolean isPrime(BigInteger number) {
        if (!number.isProbablePrime(10)) {
            return false;
        }

        if (isEvenNumber(number)) {
            return false;
        }

        BigInteger i = new BigInteger("3");

        for (; i.multiply(i).compareTo(number) < 1; i = i.add(TWO)) {
            if (BigInteger.ZERO.equals(number.mod(i)))
                return false;
        }

        return true;
    }

    private static boolean isEvenNumber(BigInteger number) {
        return !TWO.equals(number) && BigInteger.ZERO.equals(number.mod(TWO));
    }

}
