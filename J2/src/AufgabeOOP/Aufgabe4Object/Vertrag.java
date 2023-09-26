package AufgabeOOP.Aufgabe4Object;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static AufgabeOOP.Aufgabe4Object.Immobilie.immobilie;
import static AufgabeOOP.Aufgabe4Object.Mieter.mieter;
import static AufgabeOOP.Aufgabe4Object.Wohnung.wohnung;

public class Vertrag {
    Wohnung name;
    Mieter owner;
    LocalDate startDate;
    LocalDate endDate;
    int miete;
    Immobilie immobillie;

    public Vertrag(Wohnung name, Mieter owner, LocalDate startDate, LocalDate endDate, int miete, Immobilie immobillie) {
        this.name = name;
        this.owner = owner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.miete = miete;
        this.immobillie = immobillie;
    }
    public static ArrayList<Vertrag> vertrag(){
        ArrayList<Vertrag> vertragArrayList= new ArrayList<>();
        LocalDate startDateRaphael = LocalDate.of(2020,5,20);
        LocalDate endDateRaphael = LocalDate.of(2023,9,10);
        LocalDate startDateOtto = LocalDate.of(2000,10,27);
        LocalDate endDateOtto = LocalDate.of(2023,9,9);
        LocalDate startDateMaria = LocalDate.of(2016,9,3);
        LocalDate endDateMaria = LocalDate.of(2024,10,14);
        Vertrag vertragRaphael = new Vertrag(wohnung().get(1),mieter().get(0),startDateRaphael,endDateRaphael,2000,immobilie().get(1));
        Vertrag vertragOtto = new Vertrag(wohnung().get(2),mieter().get(1),startDateOtto,endDateOtto,1000, immobilie().get(2));
        Vertrag vertragMaria = new Vertrag(wohnung().get(0),mieter().get(2),startDateMaria,endDateMaria,2500,immobilie().get(0));
        vertragArrayList.add(vertragMaria);
        vertragArrayList.add(vertragOtto);
        vertragArrayList.add(vertragRaphael);
        return vertragArrayList;
    }
    public static String allContractsForChoosenImmo(){
        String allContracts = "";
        for (int i = 0; i < vertrag().size() ; i++) {
            if (immobilie().get(2).name.equals(vertrag().get(i).immobillie.name)) {
                allContracts += vertrag().get(i).owner.name + " ";
            }
        }
        return allContracts;
    }
    public static String getExpiringContracts(){
        LocalDate date = LocalDate.now();
        String expiringContracts = "";
        for (int i = 0; i < vertrag().size(); i++) {
            LocalDate endDate = vertrag().get(i).endDate;
            long monthsDifference = ChronoUnit.MONTHS.between(date, endDate);
            if (monthsDifference < 1){
                expiringContracts += vertrag().get(i).owner.name +" ";
            }
        }
        return expiringContracts;
    }
    public static int getAllEmptyWohnungen(){
        int counter = immobilie().get(0).wohnungen;
        for (int j = 0; j < vertrag().size(); j++) {
            if (immobilie().get(0).name.equals(vertrag().get(j).immobillie.name)){
                counter--;
            }
        }
        return counter;
    }
    public static String allWohnungenForPerson(){
        String allWohnungenForAllPersons = "";
        for (int j = 0; j < mieter().size(); j++) {
            allWohnungenForAllPersons += "\n" + mieter().get(j).name;
            for (int i = 0; i < vertrag().size(); i++) {
                if (vertrag().get(i).owner.name.equals(mieter().get(j).name)){
                    allWohnungenForAllPersons += "  "+ vertrag().get(i).name.beschreibung + "  " +vertrag().get(i).miete + "CHF" ;
                }
            }
        }
        return allWohnungenForAllPersons;
    }
    public static int miete(){
        int miete = 0;
        for (int i = 0; i < immobilie().size() ; i++) {
            miete = 0;
            for (int j = 0; j < vertrag().size(); j++) {
                if (immobilie().get(i).name.equals(vertrag().get(j).immobillie)){
                    miete = miete + vertrag().get(j).miete;
                }
            }
        }
        return miete;
    }
    public static String monthlyIncome(){
        String monthlyIncomeOfImmobilie = "";
        for (int i = 0; i < immobilie().size() ; i++) {
            int miete = 0;
            for (int j = 0; j < vertrag().size(); j++) {
                if (immobilie().get(i).name.equals(vertrag().get(j).immobillie.name)){
                    miete = miete + vertrag().get(j).miete;
                }
            }
            monthlyIncomeOfImmobilie += immobilie().get(i).name + " " + miete + "CHF " + "\n";
        }
        return monthlyIncomeOfImmobilie;
    }
    public static String yearlyIncome(){
        LocalDate date = LocalDate.now();
        String expiringContracts = "";
        for (int i = 0; i < vertrag().size(); i++) {
            LocalDate endDate = vertrag().get(i).endDate;
            long monthsDifference = ChronoUnit.MONTHS.between(date, endDate);
            int miete = 0;
            for (int j = 0; j < vertrag().size(); j++) {
                if (immobilie().get(i).name.equals(vertrag().get(j).immobillie.name)){
                    miete = miete + vertrag().get(j).miete;
                }
            }
            if (monthsDifference >= 12) {
                expiringContracts += immobilie().get(i).name + " " + miete * 12 + "CHF " + "\n";
            } else if (monthsDifference <= 12) {
                expiringContracts += immobilie().get(i).name + " " + miete*monthsDifference + "CHF " + "\n";
            }
        }
        return expiringContracts;
    }
}
