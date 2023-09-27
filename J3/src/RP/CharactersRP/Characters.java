package RP.CharactersRP;

import RP.DamageCalc;
import RP.ItemsRP.ArmorRP.Armor;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.ArrayList;

public class Characters {
    String name;
    double hP;
    int carryWeight;
    Weapons weapon;
    int maxHP;
    int hitBox;
    Armor Armor;

    public Characters(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox, Armor armor) {
        this.name = name;
        this.hP = hP;
        this.carryWeight = carryWeight;
        this.weapon = weapon;
        this.maxHP = maxHP;
        this.hitBox = hitBox;
        this.Armor = armor;
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

    public Armor getArmor() {
        return Armor;
    }

    public void setArmor(Armor armor) {
        Armor = armor;
    }
    public String getCharStats(){
        if (getArmor() != null) {
            return name+"\nStats:\n   HP " + hP + "\n   CarryWeight " + carryWeight + "\n   HitBox " + hitBox + "\n   Armor " + getArmor().getName()+"   Defense "+getArmor().getAdditionalDefense();
        }
        return name+ "\nStats:\n   HP " + hP + "\n   CarryWeight " + carryWeight + "\n   HitBox " + hitBox + "\n   Armor No Armor";
    }

    public ArrayList<Characters> AllCharacter(){
        ArrayList<Characters> allChars = new ArrayList<>();
        allChars.add(this);
        System.out.println("afaf");
        return allChars;
    }
}

