package RP.ItemsRP.UsablesRP;

import RP.ItemsRP.Items;

public class Usables extends Items {
    int amount;

    public Usables(String name, int weight, int amount) {
        super(name, weight);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
