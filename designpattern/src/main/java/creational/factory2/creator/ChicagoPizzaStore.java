package creational.factory2.creator;

import creational.factory2.product.ChicagoCheesePizza;
import creational.factory2.product.ChicagoPepperoniPizza;
import creational.factory2.product.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {

        switch (type) {
            case "cheese":
                return new ChicagoCheesePizza();
            case "pepperoni" :
                return new ChicagoPepperoniPizza();
        }

        return null;
    }
}
