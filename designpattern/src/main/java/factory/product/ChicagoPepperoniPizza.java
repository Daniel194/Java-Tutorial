package factory.product;

public class ChicagoPepperoniPizza extends Pizza {
    public ChicagoPepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza !";
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza square !");
    }

}
