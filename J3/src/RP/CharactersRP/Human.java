package RP.CharactersRP;

import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;

public class Human extends Characters {
    public Human(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox) {
        super(name, hP, carryWeight, weapon, maxHP, hitBox);
    }
    public double humanDamage(Characters characters){
        Random rand = new Random();
        double random = rand.nextDouble(0.2);
        return characters.getWeapon().getDamage() * (random +0.9);
    }
}
