package AufgabenGrundlagen;

import java.util.Locale;

public class Aufgabe5 {
    public static void main(String[] args) {
    String poem = """
        Ein Ninja leise wie der Wind,
         Seine Waffen stets geschwind.
         "Shurikens" fliegen, scharf und schnell,
         Klingen funkeln, furchterregend hell.


         "Nunchakus" wirbeln im Tanz,
         Mit jedem Schlag, im Vorteil er ganz.
         Seine Waffen, geheim und klug,
         Begleiten ihn bei jedem Zug.""";
        var items = poem.split(" ");
        System.out.println("Its "+ items.length+ " words lomg");
        String caps = poem.toUpperCase(Locale.ROOT);
        System.out.println(caps);
        String punkt = poem.replace(" ",".");
        System.out.println(punkt);
        int shur = poem.indexOf("\"Shurikens\"");
        System.out.println(shur);
        StringBuilder builder = new StringBuilder(poem);
        for (int i= 0; i<=10; i++){
            builder.deleteCharAt(62);
        }
        System.out.println(builder);
    }
}

