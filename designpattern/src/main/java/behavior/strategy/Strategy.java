package behavior.strategy;

import behavior.strategy.character.Knight;
import behavior.strategy.weapon.Sword;

public class Strategy {

    public static void main(String... args) {
        behavior.strategy.character.Character knight = new Knight();
        knight.fight();
        knight.setWeapon(new Sword());
        knight.fight();
    }

}
