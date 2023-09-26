package AufgabeOOP.Aufgabe4Object;

import static AufgabeOOP.Aufgabe4Object.Immobilie.immobilie;
import static AufgabeOOP.Aufgabe4Object.Immobilie.wohnungenresult;
import static AufgabeOOP.Aufgabe4Object.Vertrag.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(wohnungenresult());
        System.out.println(immobilie().get(1).abwart);
        System.out.println(allContractsForChoosenImmo());
        System.out.println(getAllEmptyWohnungen());
        System.out.println(getExpiringContracts());
        System.out.println(allWohnungenForPerson());
        System.out.println(monthlyIncome());
        System.out.println(yearlyIncome());
    }
}

