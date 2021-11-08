package common;

//TODO Добавить золото монстрам и кошелек герою
public class Purse {
    private int gold;
    private int silver;

    public Purse(int gold, int silver) {
        this.gold = gold;
        this.silver = silver;
    }

    public Purse(int silver) {
        this.silver = silver;
        recalculateMani();
    }

    @Override
    public String toString() {
        return "Золото " + gold + " серебро " + getSilver();
    }

    private void recalculateMani(){
        if (silver > 99){
            gold += silver / 100;
            silver = silver % 100;
        }
    }

    public void spendMani(int gold, int silver ){
        if(!isEnoughMoney( gold, silver )){
            System.out.println("Недостаточно денег");
            return;
        }

        this.gold -= gold;

        if (this.silver < silver){
            this.gold--;
            this.silver = this.silver + 100 - silver;

        }else {
            this.silver -= silver;
        }
    }

    public void addPurse (Purse purse){
        this.gold += purse.getGold();
        this.silver += purse.getSilver();
        recalculateMani();
    }

    public boolean isEnoughMoney(int gold, int silver ){
        if((this.gold * 100 + this.silver) < (gold * 100 + silver)){
            return false;
        }
        return true;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void addSilver(int silver) {
        this.silver += silver;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }
}
