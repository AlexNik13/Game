package playerTwo;

import common.PartBody;
import common.Purse;
import playerTwo.сharacteristicPlay.*;

public class PlayerTwo  extends Level{

    private PlayerCharacteristic characteristic;
    private Attack attack;
    private Health health;
    private Protection protection;
    private Purse purse;

    private String name;

    public PlayerTwo() {
        characteristic = new PlayerCharacteristic();
        attack = new Attack();
        health = new Health(characteristic.getConstitution());
        protection = new Protection();
        purse = new Purse(0,0);
    }

    public void printCharacteristic(){
        System.out.println("Имя: " + name + " Уровень: " + getLevel());
        System.out.printf("%-13s: %d\n", "Сила" , characteristic.getStrength());
        System.out.printf("%-13s: %d\n", "Ловкость", characteristic.getAgility());
        System.out.printf("%-13s: %d\n", "Телосложение" , characteristic.getConstitution());
        System.out.printf("%-13s: %d\n", "Здоровье" , health.getHealth());
        System.out.printf("%-6s: +%d . %-7s: +%d\n", "Атака" , getAttack() , "Защита" , getProtection());
        System.out.printf("%-13s: %d\n", "Урон" ,getDamage());
        System.out.printf("%-13s: %d\n", "Опыт:" , getExperience());
        System.out.printf("%-13s: %d\n", "Свободных очков характеристик:" , getFreeStatPoints());
        System.out.println(purse.toString());
    }

    public void receiveDamage(int damageHealth){
        health.receiveDamage(damageHealth);
    }

    public void addMani(Purse purse){
        this.purse.addPurse(purse);
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

    //возможно эти 4 действия лучше ввести в батл. чтобы еще облегчить класс.
    public PartBody getDoAttack() {
        return attack.getDoAttack();
    }

    public void setDoAttack(PartBody doAttack) {
       attack.setDoAttack(doAttack);
    }

    public PartBody getDoProtection() {
        return protection.getDoProtection();
    }

    public void setDoProtection(PartBody doProtection) {
        protection.setDoProtection(doProtection);
    }

}
