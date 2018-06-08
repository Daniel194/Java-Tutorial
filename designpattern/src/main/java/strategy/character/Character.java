package strategy.character;

import strategy.weapon.Weapon;

public abstract class Character {
    protected Weapon weapon;

    public abstract void fight();

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
