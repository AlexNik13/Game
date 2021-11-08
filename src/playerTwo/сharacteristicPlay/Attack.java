package playerTwo.сharacteristicPlay;

import common.PartBody;

public class Attack {
    private int attack;
    private int damage;

    private double modifierAttack;
    private double modifierDamage;

    private PartBody doAttack;

    public Attack() {
        modifierAttack = 1;
        modifierDamage = 1;
    }

    public int getDamage(int strength) {
        damage = 1 + (int) (strength * 0.5 * modifierDamage);
        return damage;
    }

    public int getAttack(int level, int agility) {
        attack = (int) (((agility / 2) + (level / 3)) * modifierAttack);
        return attack;
    }

    public PartBody getDoAttack() {
        return doAttack;
    }

    public void setDoAttack(PartBody doAttack) {
        this.doAttack = doAttack;
    }
}