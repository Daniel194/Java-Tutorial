package strategy;

import strategy.character.Knight;
import strategy.weapon.Sword;

public class Strategy {

    public static void main(String... args) {
        strategy.character.Character knight = new Knight();
        knight.fight();
        knight.setWeapon(new Sword());
        knight.fight();
    }

}
