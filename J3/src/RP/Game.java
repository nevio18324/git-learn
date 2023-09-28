package RP;

import RP.CharactersRP.*;
import RP.ItemsRP.ArmorRP.Armor;
import RP.ItemsRP.ArmorRP.HeavyArmor;
import RP.ItemsRP.ArmorRP.LightArmor;
import RP.ItemsRP.Items;
import RP.ItemsRP.UsablesRP.PotionsRP.DamagePotion;
import RP.ItemsRP.UsablesRP.PotionsRP.HealPotion;
import RP.ItemsRP.UsablesRP.PotionsRP.Potions;
import RP.ItemsRP.UsablesRP.RingsRP.Rings;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;
import java.util.stream.IntStream;

import static RP.Definer.*;
import static RP.Inventory.inv;
import static RP.Inventory.invAdder;
import static RP.Main.clearScreen;
import static RP.Main.logger;

public class Game {
    public static String sword = sword();
    public static void menu(){
        System.out.println("""
                 _ __ ___   ___ _ __  _   _\s
                | '_ ` _ \\ / _ \\ '_ \\| | | |
                | | | | | |  __/ | | | |_| |
                |_| |_| |_|\\___|_| |_|\\__,_|\n\n
              
                1 = Start Fight                                            
                                                                             
                2 = Spam to pull the sword out
                                            
                3 = Exit Game(Ur life will be Meaningless)                   
                                                                             
                4 = Read Rules                                         
                                                                                                   
                """+sword+stone);
    }
    public static void menuAction(String action){
        switch (action){
            case "1":
                charSelection();
                menuActive = false;
                break;
            case "2":
                clearScreen();
                count++;
                sword += "\n            ||";
                if (count == 9){
                    sword += "\n            |/";
                }
                if (count == 10){
                    clearScreen();
                    System.out.println("One must imagine sisyphus happy");
                    System.out.println("\n" +
                            "      ,-'\"\"\"`-.\n" +
                            "    ,'         `.\n" +
                            "   /        `    \\\n" +
                            "  (    /          )\n" +
                            "  |             \" |\n" +
                            "  (               )\n" +
                            " `.\\\\          \\ /\n" +
                            "   `:.     , \\ ,\\ _\n" +
                            "     `:-.___,-`-.{\\)\n" +
                            "       `.        |/ \\\n" +
                            "         `.        \\ \\\n" +
                            "           `-.     _\\,)\n" +
                            "              `.  |,-||\n" +
                            "                `.|| ||\n");
                    count = 0;
                    sword = sword();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("Vallah film heute");
                    }
                }
                clearScreen();
                break;
            case "3":
                clearScreen();
                System.out.println("Theres No Leaving u Twat");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Vallah film heute");
                }
                break;
            case "4":
                clearScreen();
                rules();
                menuActive = false;
            default:
                System.out.println("Invalid");
                break;
        }
    }
    public static void rules() {
        System.out.println(
                "    Dwarf Damage Calculation :\n" +
                "        Damage is calculated based on the character's weapon and a random factor.\n" +
                "        The damage is a random value between 90% and 110% of the character's weapon damage.\n" +
                "        The Dwarf can wear any Armor\n" +
                "\n" +
                "    Elf Damage Calculation :\n" +
                "        Damage calculation depends on the Elf's weapon, random factor, and spell.\n" +
                "        If the Elf has a bow and no spell, the damage is 150% of the weapon damage.\n" +
                "        If the Elf has a bow and a spell, the damage is 150% of the weapon damage plus half of the spell's effect.\n" +
                "        If the Elf has any other weapon, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "        U start with the Elfspell and for each Boss u survive ur spell gains 10 Damage but u cant get Usables only Weapons.\n" +
                "        The Elf can wear light Armor.\n" +
                "\n" +
                "    Goblin Damage Calculation :\n" +
                "        Damage calculation depends on the character's weapon and a random factor.\n" +
                "        If the Goblin has a bow, the damage is 150% of the weapon damage.\n" +
                "        If the Goblin has any other weapon, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "        The Goblin can wear light Armor\n" +
                "\n" +
                "    Human Damage Calculation :\n" +
                "        Damage is calculated based on the Human's weapon and a random factor.\n" +
                "        The damage is a random value between 90% and 110% of the Human's weapon damage.\n" +
                "        The Human can wear any Armor.\n" +
                "\n" +
                "    Monkey Damage Calculation :\n" +
                "        Damage calculation depends on the character's weapon, random factor, and whether the weapon is a LifeStealBanana.\n" +
                "        If the Monkey has a LifeStealBanana, it can potentially steal HP from the opponent.\n" +
                "        If the Monkey has a DodgeBanana, it can potentially Dodge the Enemies attack.\n" +
                "        The Monkey cannot get any Rewards u get one Banana as a Weapon\n" +
                "        The Monkey gains HP based on the damage dealt by the weapon if u have the LifeSteal Banana.\n" +
                "        It can't go above his Max HP.\n" +
                "        The Monkey cant wear Armor.\n" +
                "\n" +
                "    Ogre Damage Calculation :\n" +
                "        Damage calculation depends on the Ogre's weapon, random factor, and current HP.\n" +
                "        If the Oger's HP is at or below 25% of the maximum HP, the damage is tripled.\n" +
                "        Otherwise, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "        The Ogre can get Critical Damage\n" +
                "        The Ogre can wear any Armor.\n" +
                "\n" +
                "    Troll Damage Calculation :\n" +
                "        Damage calculation depends on the character's weapon and a random factor.\n" +
                "        If the Troll has a Club, the damage is doubled.\n" +
                "        If the Troll has any other weapon, the damage is a random value between 90% and 110% of the weapon damage.\n" +
                "        The Troll cant wear Armor.\n" +
                "\n"+
                    "FIGHT RULES\n" +
                        "The Boss gets an random Weapon.\n" +
                        "The Boss gets a Random Armor depending on what his Character can Wear.\n" +
                        "U get Nothing other than ur Startersword.\n" +
                        "Foreach bossfight u win u will get a random Reward depending on ur Character");
        System.out.println("If u read them press Enter");
    }


    public static void charSelection() {
        System.out.println("Choose ur Character");
        for (int i = 0; i < allCharacter().size(); i++) {
            System.out.println(i + " = " + allCharacter().get(i).getCharStats() + "\n");
        }
    }


    public static void fight(int selectedChar, int generator) {
        boolean nonValidArmor = true;
        counter = 0;
        Random rand = new Random();
        clearScreen();
        if (!(allCharacter().get(generator) instanceof Monkey)) {
            int randomWeapon = rand.nextInt(allWeapons().size());
            allCharacter().get(generator).setWeapon(allWeapons().get(randomWeapon));
        }
        int randomArmor = rand.nextInt(allArmors().size());
        if (!(allCharacter().get(generator) instanceof Monkey || allCharacter().get(generator) instanceof Troll)) {
            if (allCharacter().get(generator) instanceof Elf || allCharacter().get(generator) instanceof Goblin) {
                while (nonValidArmor) {
                    randomArmor = rand.nextInt(allArmors().size());
                    if (allArmors().get(randomArmor) instanceof LightArmor) {
                        allCharacter().get(generator).setArmor(allArmors().get(randomArmor));
                        nonValidArmor = false;
                    }
                }
            } else {
                allCharacter().get(generator).setArmor(allArmors().get(randomArmor));
            }
        }
        System.out.println(allCharacter().get(generator).getCharStats() + "\n   Base Damage " + damageCalc.damageCalc(allCharacter().get(generator)));
        logger.fine(allCharacter().get(generator).getCharStats() + "\n   Base Damage " + damageCalc.damageCalc(allCharacter().get(generator)));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Vallah film heute");
        }
        clearScreen();
        System.out.println();
        System.out.println("Runde " + round + "\n" + allCharacter().get(selectedChar).getCharStats() + "\n   Base Damage " + damageCalc.damageCalc(allCharacter().get(selectedChar)) + "\nChoose Action \n 1 = Attack\n 2 = Use Potion\n 3 = Show inventory\n 4 = Change Weapon\n 5 = Drop Something \n 6 = Unequip or Equip Armor \n 7 = Forfeit");
    }

    public static void actionRepeater(int selectedChar) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Vallah film heute");
        }
        clearScreen();
        System.out.println("Runde " + round + "\n" + allCharacter().get(selectedChar).getCharStats() + "\n   Base Damage " + damageCalc.damageCalc(allCharacter().get(selectedChar)) + "\nChoose Action \n 1 = Attack\n 2 = Use Potion\n 3 = Show inventory\n 4 = Change Weapon\n 5 = Drop Something \n 6 = Unequip or Equip Armor \n 7 = Forfeit");
    }

    public static void bossStats(int selectedChar, int generator) {
        System.out.println(allCharacter().get(generator).getCharStats() + "\n   Base Damage "  + damageCalc.damageCalc(allCharacter().get(generator)));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Vallah film heute");
        }
        bossAttack(selectedChar, generator);
    }

    public static void bossAttack(int selectedChar, int generator) {
        Random random = new Random();
        int action = random.nextInt(2);
        if (action == 1) {
            if (allCharacter().get(selectedChar).gethP() < damageCalc.damageCalc(allCharacter().get(generator))) {
                action = 0;
            }
        } else if (action == 0 && counter != 2 && allCharacter().get(selectedChar).gethP() > damageCalc.damageCalc(allCharacter().get(generator)) && damageCalc.damageCalc(allCharacter().get(selectedChar)) > allCharacter().get(generator).gethP()) {
            action = 1;
        } else if (action == 0 && counter != 2 && allCharacter().get(selectedChar).gethP() > damageCalc.damageCalc(allCharacter().get(generator)) && damageCalc.damageCalc(allCharacter().get(selectedChar)) > allCharacter().get(generator).gethP() && allCharacter().get(selectedChar).gethP() < damageCalc.damageCalc(allCharacter().get(generator))) {
            action = 0;
        }
        round++;
        clearScreen();
        switch (action) {
            case 0:
                System.out.println("\nU got Attacked");
                logger.fine("\nU got Attacked");
                hpUpdater.updateHP(damageCalc.damageCalc(allCharacter().get(generator)), selectedChar, generator);
                if (allCharacter().get(selectedChar).gethP() <= 0) {
                    System.out.println("""
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⢀⣤⣤⣤⣶⣶⣷⣤⣀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣶⣶⠀⠀⠀⠀⣠⣾⣿⣿⡇⠀⣿⣿⣿⣿⠿⠛⠉⠉⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⠀⠀⠀⠀⠀⢀⣿⣿⣶⡀⠀⠀⠀⠀⠀⣾⣿⣿⣿⡄⠀⢀⣴⣿⣿⣿⣿⠁⢸⣿⣿⣿⣀⣤⡀⠀⠀⠀
                            ⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⣼⣿⣿⣿⣧⠀⠀⠀⠀⢰⣿⣿⣿⣿⣇⣠⣿⣿⣿⣿⣿⡏⢠⣿⣿⣿⣿⣿⡿⠗⠂⠀⠀
                            ⠀⠀⠀⣰⣾⣿⣿⠟⠛⠉⠉⠉⠉⠋⠀⠀⠀⣰⣿⣿⣿⣿⣿⣇⣠⣤⣤⣿⣿⣿⢿⣿⣿⣿⣿⢿⣿⣿⡿⠀⣼⣿⣿⡟⠉⠁⢀⣀⡄⠀⠀
                            ⠀⢀⣾⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣴⣿⣿⣿⣿⡿⣿⣿⣿⡏⠈⢿⣿⣿⠏⣾⣿⣿⠃⢠⣿⣿⣿⣶⣶⣿⣿⣿⡷⠦⠀
                            ⢠⣾⣿⡿⠀⠀⠀⣀⣠⣴⣶⣿⣿⡷⠀⣠⣿⣿⣿⣿⡿⠟⣿⣿⣿⣠⣿⣿⣿⠀⠀⠀⠀⠁⢸⣿⣿⡏⠀⣼⣿⣿⣿⠿⠛⠛⠉⠀⠀⠀⠀
                            ⢸⣿⣿⠣⣴⣾⣿⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⠋⠁⠀⠀⠸⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠸⠿⠿⠀⠀⠛⠛⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            ⠸⣿⣿⣆⣉⣻⣭⣿⣿⣿⡿⠋⠀⠀⢿⣿⡿⠁⠀⠀⠀⠀⠀⠹⠟⠛⠛⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            ⠀⠙⠿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣶⣶⣶⣶⣦⣄⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣷⠄⣤⣤⣤⣤⣶⣾⣷⣴⣿⣿⣿⣿⠿⠿⠛⣻⣿⣿⣷⡄
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣄⠀⣶⣶⣤⡀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠋⢠⣿⣿⣿⠿⠛⠋⠉⠛⣿⣿⣿⠏⢀⣤⣾⣿⣿⡿⠋⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⠓⢹⣿⣿⣷⠀⠀⠀⠀⢀⣶⣿⡿⠁⠀⣾⣿⣿⣟⣠⣤⠀⠀⢸⣿⣿⣿⣾⣿⣿⣿⡟⠋⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⡿⠛⠉⠸⣿⣦⡈⣿⣿⣿⡇⠀⠀⣰⣿⣿⡿⠁⠀⢸⣿⣿⣿⣿⣿⠿⠷⢀⣿⣿⣿⣿⡿⠛⣿⣿⣿⡀⠀⠀⠀
                            ⠀⠀⠀⠀⢀⣼⣿⣿⡿⠋⠀⠀⠀⠀⣿⣿⣧⠘⣿⣿⣿⡀⣼⣿⣿⡟⠀⠀⢀⣿⣿⣿⠋⠁⠀⣀⣀⣼⣿⣿⡟⠁⠀⠀⠘⣿⣿⣧⠀⠀⠀
                            ⠀⠀⠀⠀⣼⣿⣿⡟⠀⠀⠀⠀⠀⣠⣿⣿⣿⠀⢹⣿⣿⣿⣿⣿⡟⠀⠀⠀⣼⣿⣿⣷⣶⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠸⣿⣿⡆⠀⠀
                            ⠀⠀⠀⠀⢹⣿⣿⣇⠀⠀⢀⣠⣴⣿⣿⣿⡿⠀⠈⣿⣿⣿⣿⡟⠀⠀⠀⢰⣿⣿⣿⠿⠟⠛⠉⠁⠸⢿⡟⠀⠀⠀⠀⠀⠀⠀⠘⠋⠁⠀⠀
                            ⠀⠀⠀⠀⠈⢻⣿⣿⣿⣾⣿⣿⣿⣿⣿⠟⠁⠀⠀⠸⣿⣿⡿⠁⠀⠀⠀⠈⠙⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠉⠛⠿⠿⠿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            """);
                    logger.fine("\nU LOST");
                    System.exit(0);
                } else {
                    System.out.println("Your New HP" + allCharacter().get(selectedChar).gethP() + "\n");
                    logger.fine("Your New HP" + allCharacter().get(selectedChar).gethP());
                }
                actionRepeater(selectedChar);
                round++;
                break;
            case 1:
                if (counter != 2) {
                    int randomPotion = random.nextInt(allPotions().size());
                    if (damageCalc.damageCalc(allCharacter().get(selectedChar)) > allCharacter().get(generator).gethP()) {
                        randomPotion = allPotions().indexOf(healPotions);
                    }
                    if (randomPotion == allPotions().indexOf(healPotions)) {
                        if (allCharacter().get(generator).gethP() > allCharacter().get(generator).getMaxHP() - allPotions().get(randomPotion).getAmount()) {
                            randomPotion = allPotions().indexOf(damagePotions);
                        }
                    }
                    potionsSorter(allPotions().get(randomPotion), generator);
                    actionRepeater(selectedChar);
                    counter++;
                } else {
                    bossAttack(selectedChar, generator);
                }
                round++;
                break;
        }
    }

    public static void action(int selectedChar, int selectedAction, int generator) {
        switch (selectedAction) {
            case 1:
                clearScreen();
                hpUpdater.updateBossHP(damageCalc.damageCalc(allCharacter().get(selectedChar)), generator, selectedChar);
                logger.fine("Attack");
                if (allCharacter().get(generator).gethP() <= 0) {
                    System.out.println("""
                              _   _          __          __              \s
                             | | | |    o O O\\ \\     / / ___    _ _   \s
                             | |_| |   o      \\ \\/\\/ / / _ \\  | ' \\  \s
                              \\___/   TS__[O]  \\_/\\_/  \\___/  |_||_| \s
                            _|""\"""| {======|_|""\"""|_|""\"""|_|""\"""|\s
                            "`-0-0-'./o--000'"`-0-0-'"`-0-0-'"`-0-0-'""");
                    logger.fine("U won");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Vallah film heute");
                    }
                    clearScreen();
                    wonOrLose = true;
                    break;
                } else {
                    System.out.println("Boss New HP" + allCharacter().get(generator).gethP());
                    logger.fine("Boss New HP" + allCharacter().get(generator).gethP());
                    bossStats(selectedChar, generator);
                }
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
                if (usingPotions) {
                    break;
                }
                System.out.println("U have no potions");
                logger.fine("U have no potions");
                actionRepeater(selectedChar);
                break;
            case 3:
                clearScreen();
                System.out.println("Name Weight");
                inv.forEach(inv -> System.out.println(inv.getName() + " " + inv.getWeight()));
                actionRepeater(selectedChar);
                break;
            case 4:
                clearScreen();
                System.out.println("Which Weapon do u wanna Equip");
                IntStream.range(0, inv.size())
                        .filter(i -> inv.get(i) instanceof Weapons)
                        .forEach(i -> {
                            String weaponName = inv.get(i).getName();
                            System.out.println(i + " = " + weaponName);
                        });
                changingWeapon = true;
                break;
            case 5:
                clearScreen();
                removing = true;
                break;
            case 6:
                clearScreen();
                if (allCharacter().get(selectedChar).getArmor() != null) {
                    System.out.println(allCharacter().get(selectedChar).getArmor().getName());
                } else {
                    System.out.println("No Armor equiped");
                }
                IntStream.range(0, inv.size())
                        .filter(i -> inv.get(i) instanceof Armor)
                        .forEach(i -> {
                            String weaponName = inv.get(i).getName();
                            System.out.println(i + " = " + weaponName);
                        });
                changingArmor = true;
                break;
            case 7:
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

    public static void changeWeapon(Weapons weapons, int selectedChar) {
        allCharacter().get(selectedChar).setWeapon(weapons);
    }


    public static void potionsSorter(Potions potions, int selectedChar) {
        usingPotions = false;
        System.out.println("Trank Genommen " + potions.getName());
        logger.fine("Trank Genommen " + potions.getName());
        if (potions instanceof HealPotion) {
            usingHealPotion(potions, selectedChar);
        } else if (potions instanceof DamagePotion) {
            usingDamagePotion(potions, selectedChar);
        }
    }

    public static void usingHealPotion(Potions potions, int selectedChar) {
        if (allCharacter().get(selectedChar).gethP() + potions.getAmount() > allCharacter().get(selectedChar).getMaxHP()) {
            System.out.println(allCharacter().get(selectedChar).getName() + " hat nun " + (allCharacter().get(selectedChar).getMaxHP() - allCharacter().get(selectedChar).gethP()) + " mehr Lebem");
            logger.fine(allCharacter().get(selectedChar).getName() + " hat nun " + (allCharacter().get(selectedChar).getMaxHP() - allCharacter().get(selectedChar).gethP()) + " mehr Leben");
            allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).getMaxHP());
        } else {
            System.out.println(allCharacter().get(selectedChar).getName() + " hat nun " + potions.getAmount() + " mehr Leben");
            logger.fine(allCharacter().get(selectedChar).getName() + " hat nun " + potions.getAmount() + " mehr Leben");
            allCharacter().get(selectedChar).sethP(allCharacter().get(selectedChar).gethP() + potions.getAmount());
        }
        System.out.println(allCharacter().get(selectedChar).getName() + " New HP " + allCharacter().get(selectedChar).gethP());
        logger.fine(allCharacter().get(selectedChar).getName() + " New HP " + allCharacter().get(selectedChar).gethP());
    }

    public static void usingDamagePotion(Potions potions, int selectedChar) {
        allCharacter().get(selectedChar).getWeapon().setDamage(allCharacter().get(selectedChar).getWeapon().getDamage() + potions.getAmount());
        System.out.println(allCharacter().get(selectedChar).getName() + " hat nun " + potions.getAmount() + " mehr Damage\n");
        logger.fine(allCharacter().get(selectedChar).getName() + " hat nun " + potions.getAmount() + " mehr Damage");
    }


    public static Items reward(int selectedChar) {
        Random rand = new Random();
        int randomType = rand.nextInt(3);
        if (allCharacter().get(selectedChar) instanceof Elf) {
            randomType = rand.nextInt(2) + 1;
            ((Elf) allCharacter().get(selectedChar)).getSpell().setEffect(((Elf) allCharacter().get(selectedChar)).getSpell().getEffect() + 10);
        }
        if (allCharacter().get(selectedChar) instanceof Troll) {
            randomType = rand.nextInt(2);
        }
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
                if (allWeapons().get(randomWeapon) == allCharacter().get(selectedChar).getWeapon()) {
                    reward(selectedChar);
                }
                System.out.println("BIGGER WEAPONS");
                System.out.println("""
                        ,*******************************************************************************
                        ,**************************************************,,,,,,***********************
                        ,*********************************************.....,,,,,,,,,********************
                        ,******************************************* ..  ..  .,..,,...,*****************
                        ,*******************************************        ..,.,......,,***************
                        ,********************************************. .......     ....,****************
                        ,*********************************************,.,,,,,,........******************
                        ,*********************************************..,,,,,,.......*******************
                        ,*********************************************,.,,,,,,*(*,.,********************
                        ,************************************************,*(%%%#(/((**/*****************
                        ,****************************************/(###%%/***,*%%%#####(*****************
                        ,***********************************/#############*****/###((####*.,************
                        ,*********************************/#######((/***///..   .*#((((##(**/***********
                        ,********************************(######((/*,..*//(...*,,,(//(((((,.,,**********
                        ,*****************************/####%####(//...,,**/*...    *//////,,.,**********
                        ,**************************/(########((//*....,,,,,,,.     ,,**///....,,********
                        ,*************************(((((##((///*,......,,,,,...      .,,,...    .********
                        ,***********************((((((((//*,,...,.....,,,,,,.            ....  .,,******
                        ,*********************////////*,....,**,,......,,,,.   ...          ......******
                        ,********************,,,***,,,..**,....,.......,,,.    . ..              .******
                        ,********************,,...,,...,**,....                                  ,******
                        ,********************,,,..........,*,.                               ..  *******
                        ,*********************,,,,,,........ ...                                .*******
                        ,**********************,,,,..........  .                               .********
                        ,************************,,.........                                ..,*********
                        ,************************. ........, .                              ..**********
                        ,**************************,,.,..,,.....                           ..***********
                        ,****************************...,,. .                              ,************
                        ,****************************,......   .                             ***********
                        ,********************************.... .,                             ***********
                        ,********************************.......                ,,..          .*********
                        ,********************************,..                   .,******..  .,,,.********
                        ,*******************************,    ,*.               ..,,,,,,,*..,,,,,,*******
                        ,*******************************  ..                   ........,,,.......*******
                        ,******************************  .,                    ..................,******
                        ,******************************  ,*..        ..        ........  ..     .,******
                        ,******************************, **  .    ..,**          ......  ..    ..,******
                        ,*********************************       .      .,,**,,,,,.........  ....*******
                        ,********************************.       .   ..    .,****,..,....       ********
                        """);
                System.out.println("Do u want this " + allWeapons().get(randomWeapon).getName() + " Damage " + allWeapons().get(randomWeapon).getDamage() + " Weight " + allWeapons().get(randomWeapon).getWeight() + "\n 1 = yes 2 = no");
                logger.fine("Do u want this " + allWeapons().get(randomWeapon).getName() + " Damage " + allWeapons().get(randomWeapon).getDamage() + " Weight " + allWeapons().get(randomWeapon).getWeight() + "\n 1 = yes 2 = no");
                return allWeapons().get(randomWeapon);
            case 2:

                int randomArmor = rand.nextInt(allArmors().size());
                boolean nonValidArmor = true;
                while (nonValidArmor) {
                    if (allArmors().get(randomArmor) instanceof HeavyArmor && allCharacter().get(selectedChar) instanceof Elf || allCharacter().get(selectedChar) instanceof Goblin) {
                        randomArmor = rand.nextInt(allArmors().size());
                    } else {
                        nonValidArmor = false;
                    }
                }
                System.out.println("Do u want this " + allArmors().get(randomArmor).getName() + " Defense " + allArmors().get(randomArmor).getAdditionalDefense() + " Weight " + allArmors().get(randomArmor).getWeight() + "\n 1 = yes 2 = no");
                return allArmors().get(randomArmor);

        }
        return null;
    }

    public void addingOrNot(Items item, int selectedAction, int selectedChar) {
        switch (selectedAction) {
            case 1:
                if (item instanceof Rings) {
                    if (allCharacter().get(selectedChar) instanceof Oger) {
                        System.out.println("Deine FInger waren zu fett nun hast du einen Finger weniger und kein Ring :(");
                        allCharacter().get(selectedChar).setMaxHP(allCharacter().get(selectedChar).getMaxHP() - 10);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            System.out.println("Vallah film heute");
                        }
                        break;
                    }
                }
                logger.fine("Added Item");
                invAdder(item, selectedChar);
                break;
            default:
                logger.fine("Not added Item");
                break;
        }
    }
}
