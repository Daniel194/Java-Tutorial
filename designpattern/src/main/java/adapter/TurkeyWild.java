package adapter;

public class TurkeyWild implements Turkey {
    @Override
    public void gobble() {
        System.out.print("Gobble gobble !");
    }

    @Override
    public void fly() {
        System.out.print("I'm flying short distance !");
    }
}
