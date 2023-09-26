package RP;

import RP.CharactersRP.*;
import RP.CharactersRP.ElfMagicsRP.ElfMagic;
import RP.ItemsRP.UsablesRP.PotionsRP.*;
import RP.ItemsRP.UsablesRP.RingsRP.*;
import RP.ItemsRP.UsablesRP.Usables;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.*;
import RP.ItemsRP.WeaponsRP.CloseRangeRP.Banana.*;
import RP.ItemsRP.WeaponsRP.LongRangeRP.*;
import RP.ItemsRP.WeaponsRP.Weapons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Definer {
    public static boolean changingWeapon = false;
    public static boolean removing = false;
    public static int difficulty = 0;
    public static boolean usingPotions = false;
    public static boolean bossFight = true;
    public static boolean wonOrLose = true;
    public static HealPotion healPotions = new HealPotion("Gandalfs Pisse",5,30);
    public static DamagePotion damagePotions = new DamagePotion("Uranurin",5,5);
    public static ProtectionRing gandalfRing = new ProtectionRing("Gandalfs Ehering",5,10);
    public static StrenghRing ogersRing = new StrenghRing("Ogers Prachtstück",5,20);

    public static Glock glock = new Glock("Ratatata Glock",12,20,20);
    public static StarterWeapon starterWeapon = new StarterWeapon("Shitty Sword",15,20,20,4);
    public static LongSword longSword = new LongSword("Kurzes Lang Schwert",30,20,20,5);
    public static Dwarf dwarf = new Dwarf("Dwarfigol aka Dwarf", 100, 45, starterWeapon,100,1);
    public static Monkey monkey = new Monkey("Uga",70,40,monkey(),70,1);



    public static ElfMagic healSpell = new ElfMagic(50);
    public static Bow bow = new Bow("Big Bunda Bow",20,20,20);
    public static Elf elf = new Elf("Josephine aka Elf",50,25,starterWeapon,50,2,null);
    public static Goblin goblin = new Goblin("Goblinus aka Goblin",100,45,starterWeapon,100,1);



    public static Club club = new Club("Bonk Club",30,30,30,3);
    public static Troll troll = new Troll("Troller aka Troll",111,40,starterWeapon,111,1);
    public static Oger oger = new Oger("Ogerius aka Oger",200,50,starterWeapon,200,3);



    public static Human human = new Human("Homo aka Human",100,45,starterWeapon,100,2);
    public static HPUpdater hpUpdater = new HPUpdater();
    public static DamageCalc damageCalc = new DamageCalc();
    public static Inventory weightCalc = new Inventory();
    public static Game game = new Game();
    public static Banana monkey(){
        Random rand = new Random();
        double random = rand.nextInt(2);
        ArrayList<Banana> bananaList = new ArrayList<>();
        DodgeBanana dodgeBanana = new DodgeBanana("dodger",10,40,40,5,50);
        LifeStealBanana lifeStealBanana = new LifeStealBanana("lifeStealer",10,40,40,5,33);
        bananaList.add(dodgeBanana);
        bananaList.add(lifeStealBanana);
        int randomBanana = rand.nextInt(bananaList.size());
        return bananaList.get(randomBanana);
    }

    public static List<Potions> allPotions(){
        List<Potions> allChars = new ArrayList<>();
        allChars.add(healPotions);
        allChars.add(damagePotions);
        return allChars;
    }
    public static List<Usables> allItems(){
        List<Usables> allChars = new ArrayList<>();
        allChars.add(healPotions);
        allChars.add(damagePotions);
        allChars.add(gandalfRing);
        allChars.add(ogersRing);
        return allChars;
    }
    public static List<Weapons> allWeapons(){
        List<Weapons> allChars = new ArrayList<>();
        allChars.add(club);
        allChars.add(longSword);
        allChars.add(bow);
        allChars.add(glock);
        return allChars;
    }

    public static List<Characters> allCharacter(){
        List<Characters> allChars = new ArrayList<>();
        allChars.add(elf);
        allChars.add(oger);
        allChars.add(troll);
        allChars.add(human);
        allChars.add(goblin);
        allChars.add(dwarf);
        allChars.add(monkey);
        return allChars;
    }
}
