package RP;

import RP.CharactersRP.*;
import java.util.Random;
public class DamageCalc {
    static Random rand = new Random();
    static double random = rand.nextDouble(0.2);
    public double damageCalc(Characters characters) {
        if (characters.getWeapon() == null) {
            return 1;
        }
        if (characters instanceof Elf) {
            return ((Elf) characters).elfDamage((Elf) characters);
        }else if (characters instanceof Dwarf){
            return ((Dwarf)characters).dwarfDamage((Dwarf) characters);
        }else if (characters instanceof Oger) {
            return ((Oger)characters).ogerDamage((Oger)characters);
        } else if (characters instanceof Goblin) {
            return ((Goblin)characters).goblinDamage((Goblin) characters);
        } else if (characters instanceof Troll) {
            return ((Troll)characters).trollDamage((Troll) characters);
        } else if (characters instanceof Human) {
            return ((Human)characters).humanDamage((Human) characters);
        }else if (characters instanceof Monkey){
            return ((Monkey)characters).monkeyDamage((Monkey) characters);
        }
        return 1;
    }







}
