package player;

import common.Characteristic;

import java.io.Serializable;

public class Player extends Characteristic implements Serializable {
    private RasaPlayer rasa;
    private TypePlayer type;

    private int freeStatPoints;


    public Player(String name, RasaPlayer rasa, TypePlayer type) {
        setName(name);
        this.rasa = rasa;
        this.type = type;
        stat();
    }

    private void stat(){

        int attack = (getAgility() / 2) + (getLevel() / 3);
        setAttack(attack);
        int protection = (getConstitution() / 2) + (getLevel() / 10) + 10;
        setProtection(protection);
        int damage = (int) (1 + getStrength() * 0.5) ;
        setDamage(damage);
        int health = getConstitution() * 5 + 10;
        setHealth(health);
    }


    @Override
    public void printCharacteristic(){
        super.printCharacteristic();

        System.out.printf("%-13s: %d\n", "Свободных очков характеристик: " , getFreeStatPoints());
    }

    public int getFreeStatPoints() {
        return freeStatPoints;
    }

    public void setFreeStatPoints(int freeStatPoints) {
        this.freeStatPoints = freeStatPoints;
    }
}
