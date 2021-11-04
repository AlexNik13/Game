package creature;


import common.*;

import java.util.Random;

public class CreatureSkeleton   extends Creature  {
    public CreatureSkeleton( int level) {
        setName("Skeleton");
        setLevel(level);
        stat();
    }

    private void stat(){
        setStrength((int) (1 + getLevel() * 1));
        setAgility((int) (1 + getLevel() * 0.9));
        setConstitution((int) (1 + getLevel() * 0.9));
        int attack = (getAgility() / 2) + (getLevel() / 3);
        setAttack(attack);
        int protection = (getConstitution() / 2) + (getLevel() ) + 5;
        setProtection(protection);
        int health = getConstitution() * 5;
        setHealth(health);
    }
}
