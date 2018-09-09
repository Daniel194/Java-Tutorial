package behavior.template;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiment();
    }

    protected void pourInCup() {
        System.out.println("Pour in Cup !");
    }

    protected void boilWater() {
        System.out.println("Boil Water !");
    }

    protected abstract void addCondiment();

    protected abstract void brew();

}
