import java.util.Scanner;

public class Regex {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "Hello, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!";

        String[] splits = s.split("[ '?,@._!]");

        System.out.println(splits.length);

        for(String split : splits) {
            System.out.println(split);
        }

        scan.close();
    }

}
