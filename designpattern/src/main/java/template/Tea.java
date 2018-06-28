package template;

public class Tea extends CaffeineBeverage {
    @Override
    protected void addCondiment() {
        System.out.println("Add Condiment to Tea !");
    }

    @Override
    protected void brew() {
        System.out.println("Brew Tea !");
    }
}
