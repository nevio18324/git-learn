package RP;
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

    public static void invAdder(Items item, int selectedChar){
        int weight = 0;
        for (int i = 0; i < inv.size(); i++) {
            weight += inv.get(i).getWeight();
            if (inv.get(i) instanceof StrenghRing){
                weight -= ((StrenghRing) inv.get(i)).getAmount();
            }
        }
        if (item instanceof Weapons){
                weight += item.getWeight();
                if (weight > allCharacter().get(selectedChar).getCarryWeight()){
                    System.out.println("Inv full wanna Drop something\n y = ye n = no\n");
                    removing = true;
                }else {
                    inv.add(item);
                    removing = false;
                }
            }
        else if (item instanceof Usables) {
            weight += item.getWeight();
            if (weight > allCharacter().get(selectedChar).getCarryWeight()) {
                System.out.println("Inv full wanna Drop something\n y = yes\n n = no");
                removing = true;
            } else {
                inv.add(item);
                removing = false;
            }
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
    public static void weaponRemover(Items items, int selectedChar){
        System.out.println(allCharacter().get(selectedChar).getWeapon().getName()+" got removed");
        logger.fine(allCharacter().get(selectedChar).getWeapon().getName()+" got removed");
        allCharacter().get(selectedChar).setWeapon(null);
        invAdder(items,selectedChar);
    }
}    