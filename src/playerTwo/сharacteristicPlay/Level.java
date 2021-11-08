package playerTwo.сharacteristicPlay;

public class Level {
    private int level;
    private int experience;
    private int freeStatPoints;


    public Level() {
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp(){
        this.freeStatPoints += 3;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public int getExperience() {
        return experience;
    }

    public int getFreeStatPoints() {
        return freeStatPoints;
    }

    public void minusFreeStatPoints() {
        freeStatPoints--;
    }

}
