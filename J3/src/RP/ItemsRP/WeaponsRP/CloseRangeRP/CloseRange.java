package RP.ItemsRP.WeaponsRP.CloseRangeRP;

import RP.ItemsRP.WeaponsRP.Weapons;

public class CloseRange extends Weapons {
    int additionalDefense;

    public CloseRange(String name, int weight, int damage, int baseDamage, int additionalDefense) {
        super(name, weight, damage, baseDamage);
        this.additionalDefense = additionalDefense;
    }

    public int getAdditionalDefense() {
        return additionalDefense;
    }

    public void setAdditionalDefense(int additionalDefense) {
        this.additionalDefense = additionalDefense;
    }
}
