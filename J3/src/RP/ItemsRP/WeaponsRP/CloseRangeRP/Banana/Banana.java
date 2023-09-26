package RP.ItemsRP.WeaponsRP.CloseRangeRP.Banana;

import RP.ItemsRP.WeaponsRP.CloseRangeRP.CloseRange;

public class Banana extends CloseRange{
    int amount;

    public Banana(String name, int weight, int damage, int baseDamage, int additionalDefense, int amount) {
        super(name, weight, damage, baseDamage, additionalDefense);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
