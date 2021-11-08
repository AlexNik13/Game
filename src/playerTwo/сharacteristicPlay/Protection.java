package playerTwo.сharacteristicPlay;

import common.PartBody;

public class Protection {
    private int protection;
    private PartBody doProtection;

    public int getProtection(int level, int constitution) {
        protection = (constitution / 2) + (level / 10) + 5;
        return protection;
    }

    public PartBody getDoProtection() {
        return doProtection;
    }

    public void setDoProtection(PartBody doProtection) {
        this.doProtection = doProtection;
    }
}
