package RP;
import RP.ItemsRP.ArmorRP.Armor;
import RP.ItemsRP.Items;
import RP.ItemsRP.UsablesRP.RingsRP.StrenghRing;
import RP.ItemsRP.UsablesRP.Usables;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.ArrayList;
import java.util.List;

import static RP.Main.logger;
import static RP.Definer.*;

public class  Inventory{
    static List <Items> inv = new ArrayList<>();
    public static void invAdder(Items item, int selectedChar) {
        if (item == null){
            return;
        }
        int weight = 0;
        if (allCharacter().get(selectedChar).getArmor() != null) {
            weight += allCharacter().get(selectedChar).getArmor().getWeight();
        }
        for (int i = 0; i < inv.size(); i++) {
            weight += inv.get(i).getWeight();
            if (inv.get(i) instanceof StrenghRing) {
                weight -= ((StrenghRing) inv.get(i)).getAmount();
            }
        }

        int characterCarryWeight = allCharacter().get(selectedChar).getCarryWeight();
        int newWeight = weight + item.getWeight();
        if (newWeight <= characterCarryWeight) {
            inv.add(item);
            removing = false;
        } else {
            System.out.println("Inventory full. Cannot add item.");
            removing = true;
        }
    }
    public static void invRemover(int selectedChar){
        System.out.println("What do u wanna remove");
        System.out.println("Name Weight");
        for (int i = 0; i < inv.size(); i++) {
            System.out.println(i+" = "+inv.get(i).getName()+" "+inv.get(i).getWeight());
        }
    }
    public static void removeItem(Items items,int selectedChar,int itemToRemove){
        System.out.println(inv.get(itemToRemove).getName()+" got removed");
        logger.fine(inv.get(itemToRemove).getName()+" got removed");
        inv.remove(itemToRemove);
        invAdder(items,selectedChar);
    }

    public static void armorEquiper(int selectedArmor,int selectedChar){
        if (inv.get(selectedArmor) != null) {
            if (inv.get(selectedArmor).equals(allCharacter().get(selectedChar).getArmor())) {
                allCharacter().get(selectedChar).setArmor(null);
                System.out.println(inv.get(selectedArmor).getName() + " Is now Unequiped  ");
            } else {
                allCharacter().get(selectedChar).setArmor((Armor) inv.get(selectedArmor));
                System.out.println(inv.get(selectedArmor).getName() + " Is now Equiped  ");
            }
        }else {
            allCharacter().get(selectedChar).setArmor((Armor) inv.get(selectedArmor));
            System.out.println(inv.get(selectedArmor).getName() + " Is now Equiped  ");
        }
    }
}    