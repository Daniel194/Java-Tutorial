package creational.factory2.creator;

import creational.factory2.product.NewYorkCheesePizza;
import creational.factory2.product.NewYorkPepperoniPizza;
import creational.factory2.product.Pizza;

public class NewYorkPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {

        switch (type) {
            case "cheese":
                return new NewYorkCheesePizza();
            case "pepperoni" :
                return new NewYorkPepperoniPizza();
        }

        return null;
    }
}
