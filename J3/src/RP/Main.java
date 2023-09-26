package RP;

import RP.CharactersRP.*;
import RP.ItemsRP.Items;
import RP.ItemsRP.UsablesRP.PotionsRP.*;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.*;
import java.util.logging.*;

import static RP.Game.*;
import static RP.HPUpdater.endOfRound;
import static RP.Inventory.*;
import static RP.Definer.*;

public class Main {
    public static Logger logger = Logger.getLogger(Game.class.getName());
    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("mylog.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        charSelection();
        int selectedChar = 0;
        boolean running = true;
        while (running) {
            String proof = scanner.nextLine();
            selectedChar = scannerChecker(selectedChar,"^[0-" + (allCharacter().size()-1)+ "]",proof);
            if (selectedChar != -1){
                break;
            }
        }
        inv.add(allCharacter().get(selectedChar).getWeapon());
        logger.fine("Chosen Character: " + allCharacter().get(selectedChar).getName());
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            running = true;
            int generator = rand.nextInt(5);
            while (running) {
                generator = rand.nextInt(5);
                if (generator != selectedChar) {
                    break;
                }
            }
            difficulty++;
            fight(selectedChar, generator);
            int selectedAction = 0;
            bossFight = true;
            int round = 0;
            while (bossFight) {
                if (round == 20) {
                    if (allCharacter().get(selectedChar).gethP() > allCharacter().get(generator).gethP()) {
                        System.out.println("Winner is:\n" + allCharacter().get(selectedChar).getName());
                    } else {
                        System.out.println("Winner is:\n" + allCharacter().get(generator).getName());
                    }
                }
                round++;
                System.out.println("Runde  " + round + "\n");
                while (running) {
                    String proof = scanner.nextLine();
                    selectedAction = scannerChecker(selectedAction, "^[1-5]", proof);
                    if (selectedAction != -1){
                        break;
                    }
                }
                action(selectedChar, selectedAction, generator);
                while (changingWeapon) {
                    int weaponToEquip = 0;
                    while (running) {
                        String proof = scanner.nextLine();
                        weaponToEquip = scannerChecker(weaponToEquip, "[0-" + inv.size() + "]", proof);
                        if (weaponToEquip != -1){
                            break;
                        }
                    }
                    changeWeapon((Weapons) inv.get(weaponToEquip), selectedChar);
                    actionRepeater(selectedChar);
                    changingWeapon = false;
                    int selectedPotion = 0;
                    while (usingPotions) {
                        while (running) {
                            String checker = scanner.nextLine();
                            selectedPotion = scannerChecker(selectedPotion, "\\D", checker);
                            if (selectedPotion != -1){
                                break;
                            }
                        }
                        potionsSorter((Potions) inv.get(selectedPotion), selectedChar);
                        inv.remove(selectedPotion);
                        bossAttack(selectedChar, generator);
                    }
                }
                if (!(allCharacter().get(selectedChar) instanceof Monkey)) {
                    while (wonOrLose) {
                        Items toAdd = reward(selectedChar);
                        int selectedOption = 0;
                        while (!running) {
                            String proof = scanner.nextLine();
                            selectedOption = scannerChecker(selectedOption, "\\D", proof);
                            if (selectedOption != -1){
                                break;
                            }
                        }
                        game.addingOrNot(toAdd, selectedOption);
                        while (removing) {
                            String action = scanner.nextLine();
                            switch (action.toLowerCase()) {
                                case "y":
                                    invRemover(selectedChar);
                                    running = true;
                                    int itemToRemove = 0;
                                    String proof = "";
                                    while (running) {
                                        proof = scanner.nextLine();
                                        itemToRemove = scannerChecker(itemToRemove, "[0-" + inv.size() + "]", proof);
                                        if (itemToRemove != -1){
                                            break;
                                        }
                                    }
                                    removeItem(toAdd, selectedChar, itemToRemove);
                                    break;
                                case "n":
                                    removing = false;
                                    break;
                                default:
                                    System.out.println("Invalid");
                            }
                        }
                        wonOrLose = false;
                    }
                }
                for (int y = 0; y < inv.size(); y++) {
                    logger.fine(inv.get(y).getName());
                }
                endOfRound(generator, selectedChar);
            }
        }
    }
    public static int scannerChecker(int selectedOption,String regex, String toCheck){
        if (!(toCheck.matches(regex))) {
            System.out.println("Invalid");
        } else {
            selectedOption = Integer.parseInt(toCheck);
            return selectedOption;
        }
        return -1;
    }
}
