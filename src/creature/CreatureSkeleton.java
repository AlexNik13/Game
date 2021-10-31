package creature;


import common.Characteristic;

public class CreatureSkeleton extends Characteristic  {
    private String name;
    private int level;

    public CreatureSkeleton(String name, int level) {
        this.name = name;
        this.level = level;
    }

    private void stat(){
        setStrength((int) (1 + level * 1));
        setAgility((int) (1 + level * 0.9));
        setConstitution((int) (1 + level * 0.9));
    }

}
