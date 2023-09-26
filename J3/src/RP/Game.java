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
    public static void rules(){
        System.out.println("    Dwarf Damage Calculation :\n" +
                "        Damage is calculated based on the character's weapon and a random factor.\n" +
                "        The damage is a random value between 90% and 110% of the character's weapon damage.\n" +
                "\n" +
                "    Elf Damage Calculation :\n" +
                "        Damage calculation depends on the Elf's weapon, random factor, and spell.\n" +
                "        If the Elf has a bow and no spell, the damage is 150% of the weapon damage.\n" +
                "        If the Elf has a bow and a spell, the damage is 150% of the weapon damage plus half of the spell's effect.\n" +
                "        If the Elf has any other weapon, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "\n" +
                "    Goblin Damage Calculation :\n" +
                "        Damage calculation depends on the character's weapon and a random factor.\n" +
                "        If the Goblin has a bow, the damage is 150% of the weapon damage.\n" +
                "        If the Goblin has any other weapon, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "\n" +
                "    Human Damage Calculation :\n" +
                "        Damage is calculated based on the Human's weapon and a random factor.\n" +
                "        The damage is a random value between 90% and 110% of the Human's weapon damage.\n" +
                "\n" +
                "    Monkey Damage Calculation :\n" +
                "        Damage calculation depends on the character's weapon, random factor, and whether the weapon is a LifeStealBanana.\n" +
                "        If the Monkey has a LifeStealBanana, it can potentially steal HP from the opponent.\n" +
                "        If the Monkey has a DodgeBanana, it can potentially Dodge the Enemies attack.\n" +
                "        The Monkey cannot get any Rewards u get one Banana as a Weapon\n"+
                "        The Monkey gains HP based on the damage dealt by the weapon.\n" +
                "        It can't go above his Max HP.\n" +
                "\n" +
                "    Ogre Damage Calculation :\n" +
                "        Damage calculation depends on the Ogre's weapon, random factor, and current HP.\n" +
                "        If the Oger's HP is at or below 25% of the maximum HP, the damage is tripled.\n" +
                "        Otherwise, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "\n" +
                "    Troll Damage Calculation :\n" +
                "        Damage calculation depends on the character's weapon and a random factor.\n" +
                "        If the Troll has a Club, the damage is doubled.\n" +
                "        If the Troll has any other weapon, the damage is a random value between 90% and 110% of the weapon damage.");
        System.out.println("If u read them press Enter");
    }


    public static void charSelection(){
        System.out.println("Choose ur Character");
        for (int i = 0; i < allCharacter().size(); i++) {
            System.out.println( i + " = " + allCharacter().get(i).getCharStats()+"\n");
        }
    }









    public static void fight(int selectedChar, int generator) {
        Random rand= new Random();
        clearScreen();
        int randomWeapon = rand.nextInt(allWeapons().size());
        allCharacter().get(generator).setWeapon(allWeapons().get(randomWeapon));
        System.out.println(allCharacter().get(generator).getCharStats()+"\n   Base Damage "+ damageCalc.damageCalc(allCharacter().get(generator)));
        logger.fine(allCharacter().get(generator).getCharStats()+"\n   Base Damage "+ damageCalc.damageCalc(allCharacter().get(generator)));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Vallah film heute");
        }
        clearScreen();
        System.out.println();
        System.out.println(allCharacter().get(selectedChar).getCharStats()+"\n   Base Damage "+ damageCalc.damageCalc(allCharacter().get(selectedChar))+"\nChoose Action \n 1 = Attack\n 2 = Use Potion\n 3 = Show inventory\n 4 = Change Weapon\n 5 = Drop Something \n 6 = Forfeit");
    }
    public static void actionRepeater(int selectedChar){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Vallah film heute");
        }
        clearScreen();
        System.out.println(allCharacter().get(selectedChar).getCharStats()+"\n   Base Damage "+ damageCalc.damageCalc(allCharacter().get(selectedChar))+"\nChoose Action \n 1 = Attack\n 2 = Use Potion\n 3 = Show inventory\n 4 = Change Weapon\n 5 = Drop Something \n 6 = Forfeit");
    }







    public static void bossAttack(int selectedChar,int generator){
        System.out.println(allCharacter().get(generator).getCharStats()+"\n");
        Random random = new Random();
        int action = random.nextInt(2);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Vallah film heute");
        }
        clearScreen();
        switch (action){
            case 0:
                System.out.println("\nU got Attacked");
                logger.fine("\nU got Attacked");
                hpUpdater.updateHP(damageCalc.damageCalc(allCharacter().get(generator)), selectedChar,generator);
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
                if (counter != 2) {
                    int randomPotion = random.nextInt(allPotions().size());
                    potionsSorter(allPotions().get(randomPotion), generator);
                    actionRepeater(selectedChar);
                    counter++;
                }else {
                    bossAttack(selectedChar,generator);
                }
                break;
        }
    }

    public static void action(int selectedChar, int selectedAction, int generator){
        switch (selectedAction){
            case 1:
                clearScreen();
                hpUpdater.updateBossHP(damageCalc.damageCalc(allCharacter().get(selectedChar)), generator,selectedChar);
                logger.fine("Attack");
                if (allCharacter().get(generator).gethP() <= 0){
                    System.out.println("U won");
                    logger.fine("U won");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Vallah film heute");
                    }
                    clearScreen();
                    wonOrLose = true;
                    break;
                }else {
                    System.out.println("Boss New HP" + allCharacter().get(generator).gethP());
                    logger.fine("Boss New HP" + allCharacter().get(generator).gethP());
                }
                bossAttack(selectedChar,generator);
                break;
            case 2:
                clearScreen();
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
                clearScreen();
                System.out.println("Name Weight");
                inv.forEach(inv -> System.out.println(inv.getName()+" "+ inv.getWeight()));
                System.out.println(allCharacter().get(selectedChar).getWeapon().getName());
                actionRepeater(selectedChar);
                break;
            case 4:
                clearScreen();
                System.out.println("Which Weapon do u wanna Equip");
                inv.stream()
                        .
                for (int i = 0; i < inv.size(); i++) {
                    if (inv.get(i) instanceof Weapons){
                        System.out.println(i+" = "+inv.get(i).getName());

                    }
                    changingWeapon = true;
                }

                break;
            case 5:
                clearScreen();
                removing = true;
                break;

            case 6:
                clearScreen();
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
