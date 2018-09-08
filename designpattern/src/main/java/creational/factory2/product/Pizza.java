package creational.factory2.product;

public abstract class Pizza {
    String name;

    public void prepare() {
        System.out.println("Prepare " + name);
    }

    public void bake() {
        System.out.println("Bake 25 minutes !");
    }

    public void cut() {
        System.out.println("Cutting pizza !");
    }

    public void box() {
        System.out.println("Boxing pizza !");
    }
}
