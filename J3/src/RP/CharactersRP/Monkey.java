package RP.CharactersRP;


import RP.ItemsRP.ArmorRP.Armor;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;


public class Monkey extends Characters{
    public Monkey(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox, RP.ItemsRP.ArmorRP.Armor armor) {
        super(name, hP, carryWeight, weapon, maxHP, hitBox, armor);
    }

    public double monkeyDamage(Characters characters){
        Random rand = new Random();
        double random = rand.nextDouble(0.2);;
        return characters.getWeapon().getDamage() * (random +0.9);
    }
}
