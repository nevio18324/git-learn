package RP.ItemsRP.WeaponsRP;

import RP.ItemsRP.Items;

public class Weapons extends Items {
    public int damage;
    public int baseDamage;

    public Weapons(String name, int weight, int damage, int baseDamage) {
        super(name, weight);
        this.damage = damage;
        this.baseDamage = baseDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}
