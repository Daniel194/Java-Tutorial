package adapter;

public class Adapter {

    public static void main(String... args) {
        test(new MallardDuck());
        test(new TurkeyAdapter(new TurkeyWild()));
    }

    private static void test(Duck duck) {
        duck.fly();
        duck.quack();
    }

}
