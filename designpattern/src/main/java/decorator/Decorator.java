package decorator;

public class Decorator {

    public static void main(String... args) {
        Beverage beverage1 = new Expresso();
        display(beverage1);

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        display(beverage2);

        Beverage beverage3 = new Expresso();
        beverage3 = new Whip(beverage3);
        beverage3 = new Mocha(beverage3);
        display(beverage3);

    }


    private static void display(Beverage beverage) {
        System.out.println(beverage.getDescription() + "   $" + beverage.cost());
    }

}
