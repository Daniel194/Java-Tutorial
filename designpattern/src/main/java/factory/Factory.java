package factory;

import factory.creator.ChicagoPizzaStore;
import factory.creator.NewYorkPizzaStore;
import factory.creator.PizzaStore;

public class Factory {
    public static void main(String... args) {
        PizzaStore pizzaStore = new NewYorkPizzaStore();
        pizzaStore.orderPizza("cheese");

        PizzaStore pizzaStore1 = new ChicagoPizzaStore();
        pizzaStore1.orderPizza("cheese");
    }
}
