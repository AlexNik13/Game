package playerTwo.сharacteristicPlay;

public class Protection {
    private int protection;

    public int getProtection(int level, int constitution) {
        protection = (constitution / 2) + (level / 10) + 5;
        return protection;
    }


}
