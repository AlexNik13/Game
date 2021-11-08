package playerTwo.сharacteristicPlay;

public class PlayerCharacteristic {
    private int strength;
    private int agility;
    private int constitution;




    public PlayerCharacteristic() {
        this.strength = 1;
        this.agility = 1;
        this.constitution = 1;
    }

    public int getStrength() {
        return strength;
    }


    public int getAgility() {
        return agility;
    }



    public int getConstitution() {
        return constitution;
    }

    public void addStrength() {
        this.strength += 1;
    }


    public void addAgility() {
        this.agility += 1;
    }

    public void addConstitution() {
        this.constitution += 1;
    }



}