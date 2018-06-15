package factory.creator;

import factory.product.ChicagoCheesePizza;
import factory.product.ChicagoPepperoniPizza;
import factory.product.Pizza;

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
