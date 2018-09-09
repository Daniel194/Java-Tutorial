package behavior.strategy.character;

public class Knight extends Character {
    @Override
    public void fight() {
        if (this.weapon == null) {
            System.out.println("No weapon set !");
        } else {
            this.weapon.useWeapon();
        }
    }
}
