package creature;

import common.Characteristic;
import common.Purse;

public abstract class Creature extends Characteristic {
    private boolean live = true;

    private int silver;
    private Purse purse;


    public Purse getPurse(){
        return purse;
    }

    public void setSilver(int level){
        silver = (int) (Math.random() * (100 + level*10));
        purse = new Purse(silver) ;
    }

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
