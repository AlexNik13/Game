package common;

import java.io.Serializable;

//TODO разделить на 2 класса
public class Characteristic implements Serializable {
    private String name;
    private int strength;
    private int agility;
    private int constitution;
    private int level;

    private int attack;
    private int protection;
    private int damage;

    private int health;
    private double damageModifier;
    private double protectionModifier;

    private PartBody doAttack;
    private PartBody doProtection;

    public Characteristic() {
        strength = 1;
        agility = 1;
        constitution = 1;
        level = 1;
        protectionModifier = 1;
        damageModifier = 1;
    }

    public void takingDamage(int damage){
        health -= damage;
    }

    public void printCharacteristic(){
        System.out.println("Имя: " + name + " Уровень: " + level);
        System.out.printf("%-13s: %d\n", "Сила" , getStrength());
        System.out.printf("%-13s: %d\n", "Ловкость", getAgility());
        System.out.printf("%-13s: %d\n", "Телосложение" , getConstitution());
        System.out.printf("%-13s: %d\n", "Здоровье" , getHealth());
        System.out.printf("%-6s: +%d . %-7s: +%d\n", "Атака" , getAttack() , "Защита" , getProtection());
        System.out.printf("%-13s: %d\n", "Урон" ,getDamage());
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

    public void addConstitution(int add) {
        constitution += add;
    }

    public void addStrength(int add) {
        strength += add;
    }

    public void addAgility(int add) {
        agility += add;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getDamage() {

        int damage =(int) (strength * damageModifier);

        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartBody getDoAttack() {
        return doAttack;
    }

    public void setDoAttack(PartBody doAttack) {
        this.doAttack = doAttack;
    }

    public PartBody getDoProtection() {
        return doProtection;
    }

    public void setDoProtection(PartBody doProtection) {
        this.doProtection = doProtection;
    }

    protected void addLevel(){
        level++;
    }
}
