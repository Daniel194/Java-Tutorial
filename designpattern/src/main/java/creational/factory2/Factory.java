package creational.factory2;

import creational.factory2.creator.ChicagoPizzaStore;
import creational.factory2.creator.NewYorkPizzaStore;
import creational.factory2.creator.PizzaStore;

public class Factory {
    public static void main(String... args) {
        PizzaStore pizzaStore = new NewYorkPizzaStore();
        pizzaStore.orderPizza("cheese");

        PizzaStore pizzaStore1 = new ChicagoPizzaStore();
        pizzaStore1.orderPizza("cheese");
    }
}
