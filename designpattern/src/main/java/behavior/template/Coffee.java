package behavior.template;

public class Coffee extends CaffeineBeverage {
    @Override
    protected void addCondiment() {
        System.out.println("Add Condiment to Coffee !");
    }

    @Override
    protected void brew() {
        System.out.println("Brew Coffee !");
    }
}

