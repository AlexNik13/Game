package creature;

import common.Characteristic;

public abstract class Creature extends Characteristic {
    private boolean live = true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    @Override
    public void takingDamage(int damage){
        super.takingDamage(damage);
        if(getHealth() <= 0 ){
            live = false;
        }
    }
}
