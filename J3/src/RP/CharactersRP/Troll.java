package RP.CharactersRP;

import RP.ItemsRP.ArmorRP.Armor;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.Club;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;

import static RP.Definer.*;

public class Troll extends Characters {
    public Troll(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox, RP.ItemsRP.ArmorRP.Armor armor) {
        super(name, hP, carryWeight, weapon, maxHP, hitBox, armor);
    }

    public double trollDamage(Characters characters) {
        Random rand = new Random();
        double random = rand.nextDouble(0.2);
        if (troll.getWeapon() instanceof Club) {
            return (troll.getWeapon().getDamage() * (random + 0.9)) * 2;
        } else {
            return troll.getWeapon().getDamage() * (random + 0.9);
        }
    }
}
