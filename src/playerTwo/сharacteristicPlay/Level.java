package playerTwo.сharacteristicPlay;

import common.NewLevel;

import java.util.HashMap;
import java.util.Map;

public class Level {
    private int level;
    private int experience;
    private int freeStatPoints;
    public static Map<Integer, Integer> experienceLevelUp = new HashMap<>();

    static {
        experienceLevelUp.put(1, 9);
        experienceLevelUp.put(2, 19);
        experienceLevelUp.put(3, 49);
        experienceLevelUp.put(4, 99);
        experienceLevelUp.put(5, 149);
        experienceLevelUp.put(6, 199);
        experienceLevelUp.put(7, 250);
        experienceLevelUp.put(8, 350);
    }

    public Level() {
        this.level = 1;
    }

    private void checkLevelUp() {
        if(experience > experienceLevelUp.get(level)){
            System.out.println("\nLEVEL UP\n");
            levelUp();
        }
    }

    public int getLevel() {
        return level;
    }

    public void levelUp(){
        this.freeStatPoints += 3;
        level++;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        checkLevelUp();
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
