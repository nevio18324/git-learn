package AufgabeOOP.Aufgabe4Object;

import java.util.ArrayList;

import static AufgabeOOP.Aufgabe4Object.Immobilie.immobilie;

public class Mieter {
    String name;
    char geschlecht;
    String birthdate;
    String wohnung;
    int wohnungsnummer;
    String vertrag;
    ArrayList<Vertrag> userContracts = new ArrayList<>();


    public Mieter(String name, char geschlecht, String birthdate, String wohnung, int wohnungsnummer, String vertrag) {
        this.name = name;
        this.geschlecht = geschlecht;
        this.birthdate = birthdate;
        this.wohnung = wohnung;
        this.wohnungsnummer = wohnungsnummer;
        this.vertrag = vertrag;
    }

    public void makecontract(Wohnung wohnung, Vertrag vertrag){
        userContracts.add(vertrag);
    }
    public static ArrayList<Mieter> mieter(){
        ArrayList<Mieter> mieterArrayList= new ArrayList<>();
        Mieter raphael = new Mieter("Raphael", 'M',"10.8.2007",immobilie().get(1).address,3,"Vertrag Raphael");
        Mieter otto = new Mieter("Otto", 'M',"10.8.1950",immobilie().get(2).address,3,"Vertrag Otto");
        Mieter maria = new Mieter("Maria",'W',"4.7.1998",immobilie().get(0).address,2,"Vertrag Maria");
        mieterArrayList.add(raphael);
        mieterArrayList.add(otto);
        mieterArrayList.add(maria);
        return mieterArrayList;
    }
}
