package playerTwo.сharacteristicPlay;

public class Health {
    private int health;

    public Health(int constitution) {
        this.health = constitution * 5 + 10;
    }

    public void updateHealth(int constitution) {
        health = constitution * 5 + 10;
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damageHealth){
        health -= damageHealth;
    }
}
