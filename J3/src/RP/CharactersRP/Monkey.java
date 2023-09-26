package RP.CharactersRP;


import RP.ItemsRP.WeaponsRP.CloseRangeRP.Banana.LifeStealBanana;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.Random;

import static RP.Main.logger;

public class Monkey extends Characters{
    public Monkey(String name, double hP, int carryWeight, Weapons weapon, int maxHP, int hitBox) {
        super(name, hP, carryWeight, weapon, maxHP, hitBox);
    }
    public double monkeyDamage(Characters characters){
        Random rand = new Random();
        double random = rand.nextDouble(0.2);
        if (characters.getWeapon() instanceof LifeStealBanana){
            LifeStealBanana lifeStealBanana = (LifeStealBanana) characters.getWeapon();
            if (characters.gethP()+characters.getWeapon().getDamage() * (random +0.9)*(lifeStealBanana.getAmount()/100) > characters.getMaxHP()){
                double healedHp = characters.getMaxHP() - characters.gethP();
                System.out.println("U stealed "+healedHp+" HP\n");
                logger.fine("U stealed "+healedHp+" HP\n");
                characters.sethP(characters.getMaxHP());
            }else {
                System.out.println("U stealed "+characters.gethP()+characters.getWeapon().getDamage() * (random +0.9)*(lifeStealBanana.getAmount()/100)+" HP\n");
                logger.fine("U stealed "+characters.gethP()+characters.getWeapon().getDamage() * (random +0.9)*(lifeStealBanana.getAmount()/100)+" HP\n");
                characters.sethP(characters.gethP()+characters.getWeapon().getDamage() * (random +0.9)*(lifeStealBanana.getAmount()/100));
            }
        }
        return characters.getWeapon().getDamage() * (random +0.9);
    }
}
