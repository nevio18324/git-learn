package RP.ItemsRP.ArmorRP;

import RP.ItemsRP.Items;

public class Armor extends Items{
    int AdditionalDefense;

    public Armor(String name, int weight, int additionalDefense) {
        super(name, weight);
        AdditionalDefense = additionalDefense;
    }

    public int getAdditionalDefense() {
        return AdditionalDefense;
    }

    public void setAdditionalDefense(int additionalDefense) {
        AdditionalDefense = additionalDefense;
    }
}
