import java.util.Scanner;
import java.util.TreeMap;

public class Collections {

    private static boolean isAnagram(String a, String b) {
        a = a.toUpperCase();
        b = b.toUpperCase();

        TreeMap<Character, Integer> aFrequency = getFrequency(a);
        TreeMap<Character, Integer> bFrequency = getFrequency(b);

        return aFrequency.equals(bFrequency);
    }

    private static TreeMap<Character, Integer> getFrequency(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            map.merge(c, 1, (val1, val2) -> val + 1);
        }

        return map;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = "anagramm";
        String b = "marganaa";
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

}
