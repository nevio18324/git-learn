package RP;

import RP.CharactersRP.Monkey;
import RP.ItemsRP.Items;
import RP.ItemsRP.UsablesRP.PotionsRP.Potions;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.*;

import static RP.Definer.*;
import static RP.Game.*;
import static RP.HPUpdater.endOfRound;
import static RP.Inventory.*;

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
        while (menuActive) {
            menu();
            menuAction(scanner.nextLine());
        }
        int selectedChar = 0;
        boolean running = true;
        while (running) {
            String proof = scanner.nextLine();
            selectedChar = scannerChecker(selectedChar, "[0-" + (allCharacter().size() - 1) + "]", proof);
            if (selectedChar != -1) {
                break;
            }
        }
        inv.add(allCharacter().get(selectedChar).getWeapon());
        logger.fine("Chosen Character: " + allCharacter().get(selectedChar).getName());
        clearScreen();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            running = true;
            int generator = rand.nextInt(7);
            while (running) {
                generator = rand.nextInt(7);
                if (generator != selectedChar) {
                    break;
                }
            }
            difficulty++;
            fight(selectedChar, generator);
            int selectedAction = 0;
            bossFight = true;
            while (bossFight) {
                while (running) {
                    String proof = scanner.nextLine();
                    selectedAction = scannerChecker(selectedAction, "^[1-6]", proof);
                    if (selectedAction != -1) {
                        break;
                    }
                }
                action(selectedChar, selectedAction, generator);












                while (changingWeapon) {
                    int weaponToEquip = 0;
                    while (running) {
                        String proof = scanner.nextLine();
                        weaponToEquip = scannerChecker(weaponToEquip, "[0-" + inv.size() + "]", proof);
                        if (weaponToEquip != -1) {
                            break;
                        }
                    }
                    changeWeapon((Weapons) inv.get(weaponToEquip), selectedChar);
                    clearScreen();
                    actionRepeater(selectedChar);
                    changingWeapon = false;
                }









                int selectedPotion = 0;
                while (usingPotions) {
                    while (running) {
                        System.out.println("Exit to quit");
                        String checker = scanner.nextLine();
                        if (checker.equalsIgnoreCase("exit")){
                            running = false;
                            break;
                        }
                        selectedPotion = scannerChecker(selectedPotion, "[0-" + inv.size() + "]", checker);
                        if (selectedPotion != -1) {
                            break;
                        }
                    }
                    if (!running){
                        running = true;
                        usingPotions = false;
                        break;
                    }
                    potionsSorter((Potions) inv.get(selectedPotion), selectedChar);
                    inv.remove(selectedPotion);
                    bossStats(selectedChar, generator);
                }
                int selectedOption = -1;
                Items toAdd = null;










                int selectedArmor = 0;
                while (changingArmor) {
                    while (running) {
                        System.out.println("Exit to quit");
                        String checker = scanner.nextLine();
                        if (checker.equalsIgnoreCase("exit")) {
                            running = false;
                            break;
                        }
                        selectedArmor = scannerChecker(selectedArmor, "[0-" + inv.size() + "]", checker);
                        if (selectedArmor == -1) {
                            System.out.println("Invalid");
                        } else {
                            break;
                        }
                    }
                    if (!running) {
                        running = true;
                        changingArmor = false;
                        actionRepeater(selectedChar);
                        break;
                    }
                    armorEquiper(selectedArmor,selectedChar);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Vallah film heute");
                    }
                    clearScreen();
                    actionRepeater(selectedChar);
                    changingArmor = false;
                }



















                while (wonOrLose) {
                    if (allCharacter().get(selectedChar) instanceof Monkey){
                        break;
                    }
                    toAdd = reward(selectedChar);
                    while (running) {
                        String proof = scanner.nextLine();
                        selectedOption = scannerChecker(selectedOption, "[1-2]", proof);
                        if (selectedOption != -1) {
                            break;
                        }
                    }
                    break;
                }
                game.addingOrNot(toAdd, selectedOption,selectedChar);
                while (removing) {
                    System.out.println("Wanna Drop something\n y = yes n = no\n");
                    String action = scanner.nextLine();
                    switch (action.toLowerCase()) {
                        case "y":
                            clearScreen();
                            invRemover(selectedChar);
                            running = true;
                            int itemToRemove = 0;
                            while (running) {
                                System.out.println("Exit to quit");
                                String proof = scanner.nextLine();
                                if (proof.equalsIgnoreCase("Exit")){
                                    running = false;
                                    break;
                                }
                                itemToRemove = scannerChecker(itemToRemove, "[0-" + inv.size() + "]", proof);
                                if (itemToRemove != -1) {
                                    break;
                                }
                            }
                            if (!running){
                                running = true;
                                break;
                            }
                            removeItem(toAdd, selectedChar, itemToRemove);
                            break;
                        case "n":
                            removing = false;
                            break;
                        default:
                            System.out.println("Invalid");
                    }
                    removing = false;
                    if (!wonOrLose) {
                        actionRepeater(selectedChar);
                    }
                }
                if (wonOrLose) {
                    bossFight = false;
                }
            }
            for (int y = 0; y < inv.size(); y++) {
                logger.fine(inv.get(y).getName());
            }
            wonOrLose = false;
            endOfRound(generator, selectedChar);
        }
    }











    public static int scannerChecker(int selectedOption, String regex, String toCheck) {
        if (!(toCheck.matches(regex))) {
            System.out.println("Invalid");
        } else {
            selectedOption = Integer.parseInt(toCheck);
            return selectedOption;
        }
        return -1;
    }

    public static void clearScreen() {
        String lowerOSName = System.getProperty("os.name").toLowerCase();
        if (lowerOSName.contains("window")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
