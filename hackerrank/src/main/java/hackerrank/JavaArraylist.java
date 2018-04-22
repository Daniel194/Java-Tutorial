package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class JavaArraylist {
    private static final Scanner in = new Scanner(System.in);
    private static Integer n;

    public static void main(String... args) {
        readN();
        ArrayList<List<Integer>> lists = readData();
        readN();
        ArrayList<List<Integer>> indexes = readData();
        printResult(lists, indexes);
    }

    private static void readN() {
        n = in.nextInt();
        in.nextLine();
    }

    private static void printResult(ArrayList<List<Integer>> lists, ArrayList<List<Integer>> indexes) {
        for (List<Integer> index : indexes) {
            System.out.println(getElement(index.get(0) - 1, index.get(1), lists));
        }
    }

    private static ArrayList<List<Integer>> readData() {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            lists.add(convertStringToIntegers(in.nextLine().replaceAll("\n", "")));
        }

        return lists;
    }

    static List<Integer> convertStringToIntegers(String string) {
        List<Integer> integers = new ArrayList<Integer>();

        for (String s : string.split(" ")) {
            if (!s.isEmpty()) {
                integers.add(Integer.valueOf(s));
            }
        }

        return integers;
    }

    static String getElement(int i, int j, ArrayList<List<Integer>> list) {
        if (list.size() > i && list.get(i).size() > j) {
            return list.get(i).get(j).toString();
        }

        return "ERROR!";
    }
}
