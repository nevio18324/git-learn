package AufgabeOOP.Aufgabe4Object;

import java.util.ArrayList;

public class Firma {
    String hauptsitz;
    int immobilien;
    String firmaName;

    public Firma(String hauptsitz, int immobilien, String firmaName) {
        this.hauptsitz = hauptsitz;
        this.immobilien = immobilien;
        this.firmaName = firmaName;
    }
    public static ArrayList<Firma> firma(){
        ArrayList<Firma> firmaArrayList = new ArrayList<>();
        Firma Firma = new Firma("Tulpenweg 9", 3, "Tulpen");
        firmaArrayList.add(Firma);
        return firmaArrayList;
    }

    public void setHauptsitz(String hauptsitz) {
    this.hauptsitz = hauptsitz;
}
}
