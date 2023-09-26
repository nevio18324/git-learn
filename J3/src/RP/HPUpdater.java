package RP;

import RP.CharactersRP.Monkey;
import RP.ItemsRP.UsablesRP.RingsRP.ProtectionRing;
import RP.ItemsRP.UsablesRP.RingsRP.Rings;
import RP.ItemsRP.UsablesRP.Usables;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.Banana.DodgeBanana;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.Banana.LifeStealBanana;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.CloseRange;

import java.util.Random;

import static RP.Definer.*;
import static RP.Inventory.inv;
import static RP.Main.logger;

public class HPUpdater {
    static Random rand = new Random();


    public void updateHP(double damage, int selectedChar, int generator){
        int chanceOfHit = rand.nextInt(5);
        double newHp = 0;
        if (allCharacter().get(selectedChar).getHitBox()*2 < chanceOfHit) {
            System.out.println("Miss");
            logger.fine("He missed");
            return;
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
                    logger.fine("U dodged");
                    return;
                }
            }
        }
        if (allCharacter().get(generator).getWeapon() instanceof LifeStealBanana){
            if (allCharacter().get(generator).gethP()+damage/3> allCharacter().get(generator).getMaxHP()){
                System.out.println("Boss Healed by "+ (allCharacter().get(generator).getMaxHP()-allCharacter().get(generator).gethP()));
                allCharacter().get(generator).sethP(allCharacter().get(generator).getMaxHP());
            }else {
                System.out.println("Boss Healed by "+ damage/3);
                allCharacter().get(generator).sethP(allCharacter().get(generator).gethP() + damage/3);
            }
        }
        if (allCharacter().get(selectedChar).getWeapon() instanceof CloseRange){
            CloseRange closeRange = (CloseRange) allCharacter().get(selectedChar).getWeapon();
            newHp -= closeRange.getAdditionalDefense();
        }
        allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).gethP()-newHp);
    }
    public void updateBossHP(double damage, int generator,int selectedChar){
        int chanceOfHit = rand.nextInt(5);
        double newHp = 0;
        if (allCharacter().get(generator).getHitBox()*2 < chanceOfHit) {
            System.out.println("Miss");
            logger.fine("U missed");
            return;
        }else {
            newHp += damage;
        }
        if (allCharacter().get(generator) instanceof Monkey){
            if (allCharacter().get(generator).getWeapon() instanceof DodgeBanana){
                int chanceOfDodge = rand.nextInt(100);
                DodgeBanana dodgeBanana = (DodgeBanana) allCharacter().get(generator).getWeapon();
                if (dodgeBanana.getAmount() >= chanceOfDodge){
                    System.out.println("Dodged\n");
                    logger.fine("He dodged");
                    return;
                }
            }
        }
        if (allCharacter().get(selectedChar).getWeapon() instanceof LifeStealBanana){
            if (allCharacter().get(selectedChar).gethP()+damage/3> allCharacter().get(selectedChar).getMaxHP()){
                System.out.println("U Healed by "+ (allCharacter().get(selectedChar).getMaxHP()-allCharacter().get(selectedChar).gethP()));
                allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).getMaxHP());
            }else {
                System.out.println("U Healed by "+ damage/3);
                allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).gethP() + damage/3);
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
