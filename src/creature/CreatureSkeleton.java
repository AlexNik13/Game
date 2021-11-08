package creature;

import java.util.Random;

public class CreatureSkeleton extends Creature {
    public CreatureSkeleton(int level) {
        setName("Skeleton");
        setLevel(levelCreature(level));
        stat();
        setSilver(level);
    }

    private int levelCreature(int level){
        Random rbd = new Random();
        int random;
        if(level > 1){
            random = rbd.nextInt(3);

            switch (random){
                case 0: return level -1;
                case 1: return level;
                case 2: return level + 1;
            }

        }else {
            random = rbd.nextInt(2);
            if (random == 0) {
                return 1;
            }else {
                return 2;
            }
        }
        return level;
    }

    private void stat() {


        setStrength((int) (1 + getLevel() * 1));
        setAgility((int) (1 + getLevel() * 0.9));
        setConstitution((int) (1 + getLevel() * 0.9));
        int attack = (getAgility() / 2) + (getLevel() / 3);
        setAttack(attack);
        int protection = (getConstitution() / 2) + (getLevel()) + 3;
        setProtection(protection);
        int health = getConstitution() * 5;
        setHealth(health);
    }
}
