package factory.creator;

import factory.product.NewYorkCheesePizza;
import factory.product.NewYorkPepperoniPizza;
import factory.product.Pizza;

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
