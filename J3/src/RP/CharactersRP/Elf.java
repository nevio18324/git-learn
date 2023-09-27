package RP.CharactersRP;

import RP.CharactersRP.ElfMagicsRP.ElfMagic;
import RP.ItemsRP.ArmorRP.Armor;
import RP.ItemsRP.WeaponsRP.LongRangeRP.Bow;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;

import static RP.Definer.*;

public class Elf extends Characters {
    ElfMagic spell;

    public Elf(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox, RP.ItemsRP.ArmorRP.Armor armor, ElfMagic spell) {
        super(name, hP, carryWeight, weapon, maxHP, hitBox, armor);
        this.spell = spell;
    }

    public double elfDamage(Elf characters){
        Random rand = new Random();
        double random = rand.nextDouble(0.2);
        if (characters.getWeapon() instanceof Bow) {
            if (characters.getSpell() == null){
                return (characters.getWeapon().getDamage() * (random + 0.9) * 1.5);
            }else {
                return (characters.getWeapon().getDamage() * (random + 0.9) + (elf.getSpell().getEffect() / 2)) * 1.5;
            }
        }else if(characters.getSpell() == null){
            return characters.getWeapon().getDamage() * (random + 0.9);
        }else {
            return characters.getWeapon().getDamage() * (random + 0.9) + (elf.getSpell().getEffect() / 2);
        }
    }

    public ElfMagic getSpell() {
        return spell;
    }
}
