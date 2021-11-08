package playerTwo.сharacteristicPlay;

public class Attack {
    private int attack;
    private int damage;

    private double modifierAttack;
    private double modifierDamage;

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
}