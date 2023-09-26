package ChallengeHogWarts;

import java.util.ArrayList;
import java.util.Collections;

public class Eigenschaft {
    String name;
    int weight;

    public Eigenschaft(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public static ArrayList<Eigenschaft> allEigenchaften(){
        ArrayList<Eigenschaft> allEigenschaften = new ArrayList<>();
        allEigenschaften.add(new Eigenschaft("Tapferkeit", 20));
        allEigenschaften.add(new Eigenschaft("Kühnheit", 16));
        allEigenschaften.add(new Eigenschaft("Courage", 12));
        allEigenschaften.add(new Eigenschaft("Ritterlichkeit", 8));
        allEigenschaften.add(new Eigenschaft("Entschlossenheit", 4));
        allEigenschaften.add(new Eigenschaft("Fleiss", 20));
        allEigenschaften.add(new Eigenschaft("Hingabe", 16));
        allEigenschaften.add(new Eigenschaft("Geduld", 12));
        allEigenschaften.add(new Eigenschaft("Loyalität", 8));
        allEigenschaften.add(new Eigenschaft("Fairplay", 4));
        allEigenschaften.add(new Eigenschaft("Intelligenz", 20));
        allEigenschaften.add(new Eigenschaft("Wissen", 16));
        allEigenschaften.add(new Eigenschaft("Neugier", 12));
        allEigenschaften.add(new Eigenschaft("Kreativität", 8));
        allEigenschaften.add(new Eigenschaft("Geistige Wndigkeit", 4));
        allEigenschaften.add(new Eigenschaft("Ehrgeiz", 20));
        allEigenschaften.add(new Eigenschaft("Führerschaft", 16));
        allEigenschaften.add(new Eigenschaft("Selbsterhaltung", 12));
        allEigenschaften.add(new Eigenschaft("List", 8));
        allEigenschaften.add(new Eigenschaft("Einfallsreichtum", 4));
        return allEigenschaften;
    }
    public static ArrayList<Eigenschaft> GryffindorEigenschaften(){
        ArrayList<Eigenschaft> gryffindorEigenschaften = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            gryffindorEigenschaften.add(allEigenchaften().get(i));
        }
        return gryffindorEigenschaften;
    }
    public static ArrayList<Eigenschaft> HufflepuffEigenschaften(){
        ArrayList<Eigenschaft> hufflepuffEigenschaften = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            hufflepuffEigenschaften.add(allEigenchaften().get(i));
        }
        return hufflepuffEigenschaften;
    }
    public static ArrayList<Eigenschaft> RavenclawEigenschaften(){
        ArrayList<Eigenschaft> ravenclawEigenschaften = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            ravenclawEigenschaften.add(allEigenchaften().get(i));
        }
        return ravenclawEigenschaften;
    }
    public static ArrayList<Eigenschaft> SlytherinEigenschaften(){
        ArrayList<Eigenschaft> slytherinEigenschaften = new ArrayList<>();
        for (int i = 15; i < 20; i++) {
            slytherinEigenschaften.add(allEigenchaften().get(i));
        }
        return slytherinEigenschaften;
    }
}
