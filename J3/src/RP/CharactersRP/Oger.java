package RP.CharactersRP;

import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;

import static RP.Definer.*;

public class Oger extends Characters {
    public Oger(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox) {
        super(name, hP, carryWeight, weapon, maxHP, hitBox);
    }
    public double ogerDamage(Characters characters) {
        Random rand = new Random();
        double random = rand.nextDouble(0.2);
        if (characters.gethP() <= characters.getMaxHP() / 4) {
            return characters.getWeapon().getDamage() * (random + 0.9) * 3;
        } else {
            return oger.getWeapon().getDamage() * (random + 0.9);
        }
    }
}
