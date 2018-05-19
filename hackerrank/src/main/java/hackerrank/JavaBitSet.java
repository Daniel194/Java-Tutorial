package hackerrank;

import java.util.BitSet;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class JavaBitSet {
    private static final Scanner in = new Scanner(System.in);
    private static BitSet bs1;
    private static BitSet bs2;
    private static String command;
    private static Integer pos1;
    private static Integer pos2;

    public static void main(String[] args) {
        instantiateSets();
        Integer n = in.nextInt();
        for (int i = 0; i < n; i++) {
            executeInstructions();
        }
    }

    private static void instantiateSets() {
        Integer n = in.nextInt();
        bs1 = new BitSet(n);
        bs2 = new BitSet(n);
    }

    private static void executeInstructions() {
        readInstruction();
        executeInstruction();
        printBitSet();
    }

    private static void readInstruction() {
        command = in.next();
        pos1 = in.nextInt();
        pos2 = in.nextInt();
    }

    private static void executeInstruction() {
        switch (command) {
            case "AND":
                executeOperand(BitSet::and);
                break;
            case "OR":
                executeOperand(BitSet::or);
                break;
            case "XOR":
                executeOperand(BitSet::xor);
                break;
            case "FLIP":
                executeOperand((bs1, bs2) -> bs1.flip(pos2));
                break;
            case "SET":
                executeOperand((bs1, bs2) -> bs1.set(pos2));
                break;
            default:
                break;
        }
    }

    private static void executeOperand(BiConsumer<BitSet, BitSet> consumer) {
        if (pos1.equals(1)) {
            consumer.accept(bs1, bs2);
        } else {
            consumer.accept(bs2, bs1);
        }
    }

    private static void printBitSet() {
        System.out.println(bs1.cardinality() + " " + bs2.cardinality());
    }

}
