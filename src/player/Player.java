package player;

import common.Characteristic;
import common.NewLevel;

import java.io.Serializable;

public class Player extends Characteristic implements Serializable {
    private RasaPlayer rasa;
    private TypePlayer type;
    private int experience;
    private int freeStatPoints;

    public Player(String name, RasaPlayer rasa, TypePlayer type) {
        setName(name);
        this.rasa = rasa;
        this.type = type;
        recalculateCharacteristic();
    }

    public void recalculateCharacteristic(){

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
        checkLevelUp();
        super.printCharacteristic();

        System.out.printf("%-13s: %d\n", "Опыт:" , getExperience());
        System.out.printf("%-13s: %d\n", "Свободных очков характеристик:" , getFreeStatPoints());
    }

    public int getFreeStatPoints() {
        return freeStatPoints;
    }

    public void setFreeStatPoints(int freeStatPoints) {
        this.freeStatPoints = freeStatPoints;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        checkLevelUp();
    }

    private void checkLevelUp() {
        if(experience > NewLevel.experienceLevelUp.get(getLevel())){
            levelUp();
        }
    }

    private void levelUp() {
        System.out.println("\n--== Поздравляю. Level UP !!! ==--\n");
        addLevel();
        freeStatPoints += 3;
        recalculateCharacteristic();
    }

    public void addStrength(){
        if(freeStatPoints > 0){
            addStrength(1);
            freeStatPoints--;
            recalculateCharacteristic();
        }
    }

    public void addAgility(){
        if(freeStatPoints > 0){
            addAgility(1);
            freeStatPoints--;
            recalculateCharacteristic();
        }
    }

    public void addConstitution(){
        if(freeStatPoints > 0){
            addConstitution(1);
            freeStatPoints--;
            recalculateCharacteristic();
        }
    }
}
