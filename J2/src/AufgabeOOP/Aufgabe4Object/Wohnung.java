package AufgabeOOP.Aufgabe4Object;

import static AufgabeOOP.Aufgabe4Object.Immobilie.immobilie;
import java.util.ArrayList;

public class Wohnung {
    int stockwerk;
    int wohnungsNummer;
    String address;
    String beschreibung;

    public Wohnung(int stockwerk, int wohnungsNummer, String beschreibung, String address) {
        this.stockwerk = stockwerk;
        this.wohnungsNummer = wohnungsNummer;
        this.beschreibung = beschreibung;
        this.address = address;
    }

    public static ArrayList<Wohnung> wohnung() {
        ArrayList<Wohnung> wohnungArrayList = new ArrayList<>();
        Wohnung tulpen = new Wohnung(2, 4, "Eine schöne Tulpe auf Balkon in Mitte Hamburg", immobilie().get(0).address);
        Wohnung neufeld = new Wohnung(3, 3, "Über der Reithalle sorgt für gute Stimmung", immobilie().get(1).address);
        Wohnung oberfeld = new Wohnung(3, 3, "Gute aussicht auf die schönen SBB züge", immobilie().get(2).address);
        wohnungArrayList.add(tulpen);
        wohnungArrayList.add(neufeld);
        wohnungArrayList.add(oberfeld);
        return wohnungArrayList;
    }
}
