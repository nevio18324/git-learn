package RP;

import RP.CharactersRP.Oger;
import RP.ItemsRP.Items;
import RP.ItemsRP.UsablesRP.*;
import RP.ItemsRP.UsablesRP.PotionsRP.DamagePotion;
import RP.ItemsRP.UsablesRP.PotionsRP.HealPotion;
import RP.ItemsRP.UsablesRP.PotionsRP.Potions;
import RP.ItemsRP.UsablesRP.RingsRP.Rings;
import RP.ItemsRP.WeaponsRP.Weapons;
import java.util.*;

import static RP.Definer.*;
import static RP.Inventory.inv;
import static RP.Inventory.invAdder;
import static RP.Main.*;
public class Game {

    public static void charSelection(){
        System.out.println("Choose ur Character");
        for (int i = 0; i < allCharacter().size(); i++) {
            System.out.println( i + " = " + allCharacter().get(i).getCharStats()+"\n");
        }
    }








    public static void fight(int selectedChar, int generator) {
        Random rand= new Random();
        System.out.println(allCharacter().get(selectedChar).getName());
        System.out.println(allCharacter().get(generator).getCharStats()+"\n Is ur Enemy");
        logger.fine(allCharacter().get(generator).getName()+"  Is ur Enemy");
        int randomWeapon = rand.nextInt(allWeapons().size());
        allCharacter().get(generator).setWeapon(allWeapons().get(randomWeapon));
        System.out.println();
        System.out.println(allCharacter().get(selectedChar).getCharStats()+"\nChoose Action \n 1 = Attack\n 2 = Use Potion\n 3 = Show inventory\n 4 = Change Weapon\n 5 = Forfeit");
    }
    public static void actionRepeater(int selectedChar){
        System.out.println(allCharacter().get(selectedChar).getCharStats()+"\n");
        System.out.println("Choose Action \n 1 = Attack\n 2 = Use Potion\n 3 = Show inventory\n 4 = Change Weapon\n 5 = Forfeit");
    }







    public static void bossAttack(int selectedChar,int generator){
        System.out.println(allCharacter().get(generator).getCharStats()+"\n");
        Random random = new Random();
        int action = random.nextInt(2);
        switch (action){
            case 0:
                System.out.println("\nU got Attacked");
                logger.fine("\nU got Attacked");
                hpUpdater.updateHP(damageCalc.damageCalc(allCharacter().get(generator)), selectedChar);
                if (allCharacter().get(selectedChar).gethP() <= 0){
                    System.out.println("\nU LOST");
                    logger.fine("\nU LOST");
                    System.exit(0);
                }else {
                    System.out.println("Your New HP" + allCharacter().get(selectedChar).gethP()+"\n");
                    logger.fine("Your New HP" + allCharacter().get(selectedChar).gethP());
                }
                actionRepeater(selectedChar);
                break;
            case 1:
                int randomPotion = random.nextInt(allPotions().size());
                potionsSorter(allPotions().get(randomPotion),generator);
                actionRepeater(selectedChar);
                break;
        }
    }

    public static void action(int selectedChar, int selectedAction, int generator){
        switch (selectedAction){
            case 1:
                hpUpdater.updateBossHP(damageCalc.damageCalc(allCharacter().get(selectedChar)), generator);
                logger.fine("Attack");
                if (allCharacter().get(generator).gethP() <= 0){
                    System.out.println("U won");
                    logger.fine("U won");
                    wonOrLose = true;
                    bossFight = false;
                    break;
                }else {
                    System.out.println("Boss New HP" + allCharacter().get(generator).gethP());
                    logger.fine("Boss New HP" + allCharacter().get(generator).gethP());
                }
                bossAttack(selectedChar,generator);
                break;
            case 2:
                for (int i = 0; i < allPotions().size(); i++) {
                    for (int j = 0; j < inv.size(); j++) {
                        if (allPotions().get(i).getName().equals(inv.get(j).getName())) {
                            System.out.println(j + " = " + allPotions().get(i).getName());
                            usingPotions = true;
                        }
                    }
                }
                if (usingPotions){
                    break;
                }
                System.out.println("U have no potions");
                logger.fine("U have no potions");
                actionRepeater(selectedChar);
                break;
            case 3:
                System.out.println("Name Weight Amount");
                for (int i = 0; i < inv.size(); i++) {
                    System.out.println(inv.get(i).getName()+" "+inv.get(i).getWeight()+" "+ ((Usables)inv.get(i)).getAmount());
                }
                System.out.println(allCharacter().get(selectedChar).getWeapon().getName());
                actionRepeater(selectedChar);
                break;
            case 4:
                System.out.println("Which Weapon do u wanna Equip");
                for (int i = 0; i < inv.size(); i++) {
                    if (inv.get(i) instanceof Weapons){
                        System.out.println(i+" = "+inv.get(i).getName());
                    }
                    changingWeapon = true;
                }

                break;

            case 5:
                logger.fine("Forfeit");
                System.out.println("Never Back down never What");
                actionRepeater(selectedChar);
                break;

            default:
                System.out.println("Invalid Action");
                actionRepeater(selectedChar);
                break;
        }
    }
    public static void changeWeapon(Weapons weapons, int selectedChar){
        allCharacter().get(selectedChar).setWeapon(weapons);
    }








    public static void potionsSorter(Potions potions, int selectedChar){
        usingPotions = false;
        System.out.println("Trank Genommen " +potions.getName());
        logger.fine("Trank Genommen " +potions.getName());
        if (potions instanceof HealPotion){
            usingHealPotion(potions,selectedChar);
        } else if (potions instanceof DamagePotion){
            usingDamagePotion(potions,selectedChar);
        }
    }
    public static void usingHealPotion(Potions potions, int selectedChar){
        if (allCharacter().get(selectedChar).gethP()+potions.getAmount() > allCharacter().get(selectedChar).getMaxHP()){
            System.out.println(allCharacter().get(selectedChar).getName()+" hat nun "+(allCharacter().get(selectedChar).getMaxHP()-allCharacter().get(selectedChar).gethP())+" mehr Lebem");
            logger.fine(allCharacter().get(selectedChar).getName()+" hat nun "+(allCharacter().get(selectedChar).getMaxHP()-allCharacter().get(selectedChar).gethP())+" mehr Leben");
            allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).getMaxHP());
        }else {
            System.out.println(allCharacter().get(selectedChar).getName()+" hat nun "+potions.getAmount()+" mehr Leben");
            logger.fine(allCharacter().get(selectedChar).getName()+" hat nun "+potions.getAmount()+" mehr Leben");
            allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).gethP()+potions.getAmount());
        }
        System.out.println(allCharacter().get(selectedChar).getName()+" New HP "+allCharacter().get(selectedChar).gethP());
        logger.fine(allCharacter().get(selectedChar).getName()+" New HP "+allCharacter().get(selectedChar).gethP());
    }
    public static void usingDamagePotion(Potions potions, int selectedChar){
        allCharacter().get(selectedChar).getWeapon().setDamage(allCharacter().get(selectedChar).getWeapon().getDamage()+potions.getAmount());
        System.out.println(allCharacter().get(selectedChar).getName()+" hat nun "+potions.getAmount()+" mehr Damage\n");
        logger.fine(allCharacter().get(selectedChar).getName()+" hat nun "+potions.getAmount()+" mehr Damage");
    }










    public static Items reward(int selectedChar) {
        Random rand = new Random();
        int randomType = rand.nextInt(2);
        switch (randomType) {
            case 0:
                int randomItem = rand.nextInt(allItems().size());
                allItems().get(randomItem);
                System.out.println("Do u want this " + allItems().get(randomItem).getName() + " Weight " + allItems().get(randomItem).getWeight() + "\n 1 = yes 2 = no");
                logger.fine("Do u want this " + allItems().get(randomItem).getName() + " Weight " + allItems().get(randomItem).getWeight() + "\n 1 = yes 2 = no");
                return allItems().get(randomItem);
            case 1:
                int randomWeapon = rand.nextInt(allWeapons().size());
                allWeapons().get(randomWeapon);
                System.out.println("Do u want this " + allWeapons().get(randomWeapon).getName() + " Damage " + allWeapons().get(randomWeapon).getDamage() + " Weight " + allWeapons().get(randomWeapon).getWeight() + "\n 1 = yes 2 = no");
                logger.fine("Do u want this " + allWeapons().get(randomWeapon).getName() + " Damage " + allWeapons().get(randomWeapon).getDamage() + " Weight " + allWeapons().get(randomWeapon).getWeight() + "\n 1 = yes 2 = no");
                return allWeapons().get(randomWeapon);
        }
        return null;
    }
    public void addingOrNot(Items item, int selectedAction){
        switch (selectedAction){
            case 1:
                if (item instanceof Rings) {
                    if (allCharacter().get(selectedAction) instanceof Oger) {
                        System.out.println("Deine FInger waren zu fett nun hast du einen Finger weniger und kein Ring :(");
                        allCharacter().get(selectedAction).setMaxHP(allCharacter().get(selectedAction).getMaxHP() - 10);
                        break;
                    }
                }
                logger.fine("Added Item");
                invAdder(item,selectedAction);
                break;
            default:
                logger.fine("Not added Item");
                break;
        }
    }
}
