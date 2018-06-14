package decorator;

public class Whip extends CondimentDecorator {
    private Beverage beverage;

    Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .1 + beverage.cost();
    }
}
