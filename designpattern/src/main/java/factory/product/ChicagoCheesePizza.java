package factory.product;

public class ChicagoCheesePizza extends Pizza {
    public ChicagoCheesePizza() {
        name = "Chicago Style Cheese Pizza !";
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza square !");
    }
}
