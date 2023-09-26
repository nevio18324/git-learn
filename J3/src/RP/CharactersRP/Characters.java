package RP.CharactersRP;

import RP.ItemsRP.WeaponsRP.Weapons;

public class Characters {
    String name;
    double hP;
    int carryWeight;
    Weapons weapon;
    int maxHP;
    int hitBox;

    public Characters(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox) {
        this.name = name;
        this.hP = hP;
        this.carryWeight = carryWeight;
        this.weapon = weapon;
        this.maxHP = maxHP;
        this.hitBox = hitBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double gethP() {
        return hP;
    }

    public void sethP(double hP) {
        this.hP = hP;
    }

    public int getCarryWeight() {
        return carryWeight;
    }

    public void setCarryWeight(int carryWeight) {
        this.carryWeight = carryWeight;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHitBox() {
        return hitBox;
    }

    public void setHitBox(int hitBox) {
        this.hitBox = hitBox;
    }
    public String getCharStats(){
        return name+"\nSTATS\n   HP: "+ hP +" \n   Carryweight: "+carryWeight+" \n   Hitbox: "+hitBox+"\n   Damage: "+ weapon.getDamage();
    }
}

