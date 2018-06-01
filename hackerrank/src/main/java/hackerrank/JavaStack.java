package hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    private static HashMap<Character, Character> pairs = new HashMap<>();

    static {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(check(input));
        }

    }

    static boolean check(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Provide a not null value !");
        }

        if (s.length() % 2 == 0) {
            return correctlyBalanced(s);
        }

        return false;
    }

    private static boolean correctlyBalanced(String s) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            try {
                execute(characters, s.charAt(i));
            } catch (Exception e) {
                return false;
            }
        }

        return characters.isEmpty();
    }


    private static void execute(Stack<Character> characters, Character c) throws Exception {
        if (characters.isEmpty()) {
            characters.push(c);
        } else if (arePairs(characters.peek(), c)) {
            characters.pop();
        } else if (!isClosedBracket(c)) {
            characters.push(c);
        } else {
            throw new Exception("Not correctly Balanced !");
        }
    }

    private static boolean arePairs(Character c1, Character c2) {
        Character pair = pairs.get(c2);
        return pair != null && pair.equals(c1);
    }

    private static boolean isClosedBracket(Character c) {
        return pairs.get(c) != null;
    }

}
