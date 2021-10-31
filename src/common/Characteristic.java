package common;

public class Characteristic  {
    private int strength;
    private int agility;
    private int constitution;

    private double maxHealth ;
    private double health ;
    private double damageModifier;
    private int freeStatPoints;

    public Characteristic() {
        strength = 1;
        agility = 1;
        constitution = 1;
        damageModifier = 1;
    }

    public void health(){
        health = 10 + (constitution * 5);
    }


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }
}
