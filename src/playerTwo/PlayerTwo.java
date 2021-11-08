package playerTwo;

import playerTwo.сharacteristicPlay.*;

public class PlayerTwo  extends Level{

    private PlayerCharacteristic characteristic;
    private Attack attack;
    private Health health;
    private Protection protection;

    public PlayerTwo() {
        characteristic = new PlayerCharacteristic();
        attack = new Attack();
        health = new Health(characteristic.getConstitution());
        protection = new Protection();
    }

    public int getDamage(){
        int damage = attack.getDamage(characteristic.getStrength());
        return damage;
    }

    public int getAttack() {
        int attack = this.attack.getAttack(getLevel(), characteristic.getAgility());
        return attack;
    }

    public int getProtection(){
        int protection = this.protection.getProtection(getLevel(), characteristic.getConstitution());
        return protection;
    }



}
