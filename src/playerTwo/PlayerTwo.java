package playerTwo;

import common.PartBody;
import common.Purse;
import playerTwo.сharacteristicPlay.*;

public class PlayerTwo  {

    private PlayerCharacteristic characteristic;
    private Attack attack;
    private Health health;
    private Protection protection;
    private Purse purse;
    private Level level;
    private String name;

    public PlayerTwo(String name) {
        this.name = name;
        characteristic = new PlayerCharacteristic();
        attack = new Attack();
        health = new Health(characteristic.getConstitution());
        protection = new Protection();
        level = new Level();
        purse = new Purse(0,0);
    }


    public void printCharacteristic(){
        System.out.println("Имя: " + name + " Уровень: " + level.getLevel());
        System.out.printf("%-13s: %d\n", "Сила" , characteristic.getStrength());
        System.out.printf("%-13s: %d\n", "Ловкость", characteristic.getAgility());
        System.out.printf("%-13s: %d\n", "Телосложение" , characteristic.getConstitution());
        System.out.printf("%-13s: %d\n", "Здоровье" , health.getHealth());
        System.out.printf("%-6s: +%d . %-7s: +%d\n", "Атака" , getAttack() , "Защита" , getProtection());
        System.out.printf("%-13s: %d\n", "Урон" ,getDamage());
        System.out.printf("%-13s: %d\n", "Опыт:" , level.getExperience());
        System.out.printf("%-13s: %d\n", "Свободных очков характеристик:" , level.getFreeStatPoints());
        System.out.println(purse.toString());
    }

    public void receiveDamageHealth(int damageHealth){
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
        int attack = this.attack.getAttack(level.getLevel(), characteristic.getAgility());
        return attack;
    }

    public int getProtection(){
        int protection = this.protection.getProtection(level.getLevel(), characteristic.getConstitution());
        return protection;
    }

    public void addStrength(){
        if(level.getFreeStatPoints() > 0){
            characteristic.addStrength();
            level.minusFreeStatPoints();
        }
    }

    public void addAgility(){
        if(level.getFreeStatPoints() > 0){
            characteristic.addAgility();
            level.minusFreeStatPoints();
        }
    }

    public void addConstitution(){

        if(level.getFreeStatPoints() > 0){
            characteristic.addConstitution();
            level.minusFreeStatPoints();
            health.updateHealth(characteristic.getConstitution());
        }
    }

    public void updateHealth(){
        health.updateHealth(characteristic.getConstitution());
    }

    public int getFreeStatPoints(){
        return level.getFreeStatPoints();
    }

    public int getLevel(){
        return level.getLevel();
    }

    public int getHealth(){
        return health.getHealth();
    }

    public void addExperience(int experience ){
        level.addExperience(experience);
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
