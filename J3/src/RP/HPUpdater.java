package RP;

import RP.CharactersRP.Monkey;
import RP.ItemsRP.UsablesRP.RingsRP.ProtectionRing;
import RP.ItemsRP.UsablesRP.RingsRP.Rings;
import RP.ItemsRP.UsablesRP.Usables;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.Banana.DodgeBanana;

import java.util.Random;

import static RP.Definer.*;
import static RP.Inventory.inv;
import static RP.Main.logger;

public class HPUpdater {
    static Random rand = new Random();


    public void updateHP(double damage, int selectedChar){
        int chanceOfHit = rand.nextInt(5);
        double newHp = 0;
        if (allCharacter().get(selectedChar).getHitBox()*2 < chanceOfHit) {
            System.out.println("Miss");
            logger.fine("He missed");
        }else {
            newHp += damage;
        }
        for (int i = 0; i < inv.size(); i++) {
            if (inv.get(i) instanceof ProtectionRing) {
                if (inv.get(i) instanceof Rings) {
                    newHp -= ((Usables)inv.get(i)).getAmount();
                }
            }
        }
        if (allCharacter().get(selectedChar) instanceof Monkey){
            if (allCharacter().get(selectedChar).getWeapon() instanceof DodgeBanana){
                int chanceOfDodge = rand.nextInt(100);
                DodgeBanana dodgeBanana = (DodgeBanana) allCharacter().get(selectedChar).getWeapon();
                if (dodgeBanana.getAmount() >= chanceOfDodge){
                    System.out.println("Dodged");
                    newHp = 0;
                    logger.fine("U dodged");
                }
            }
        }
        allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).gethP()-newHp);
    }
    public void updateBossHP(double damage, int generator){
        int chanceOfHit = rand.nextInt(5);
        double newHp = 0;
        if (allCharacter().get(generator).getHitBox()*2 < chanceOfHit) {
            System.out.println("Miss");
            logger.fine("U missed");
        }else {
            newHp += damage;
        }
        if (allCharacter().get(generator) instanceof Monkey){
            if (allCharacter().get(generator).getWeapon() instanceof DodgeBanana){
                int chanceOfDodge = rand.nextInt(100);
                DodgeBanana dodgeBanana = (DodgeBanana) allCharacter().get(generator).getWeapon();
                if (dodgeBanana.getAmount() >= chanceOfDodge){
                    System.out.println("Dodged\n");
                    newHp = 0;
                    logger.fine("He dodged");
                }
            }
        }
        allCharacter().get(generator).sethP(allCharacter().get(generator).gethP()-newHp);
    }
    public static void endOfRound(int generator, int selectedChar){
        allCharacter().get(generator).sethP(allCharacter().get(generator).getMaxHP());
        allCharacter().get(generator).getWeapon().setDamage(allCharacter().get(generator).getWeapon().getBaseDamage());
        allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).getMaxHP());
    }
}
