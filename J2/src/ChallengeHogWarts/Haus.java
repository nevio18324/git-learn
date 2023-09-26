package ChallengeHogWarts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static ChallengeHogWarts.Eigenschaft.*;
public class Haus {
    String name;
    ArrayList eigenschaften;
    String color;
    String pet;
    String element;
    String founder;
    int apprentices;

    public Haus(String name, ArrayList eigenschaften, String color, String pet, String element, String founder, int apprentices) {
        this.name = name;
        this.eigenschaften = eigenschaften;
        this.color = color;
        this.pet = pet;
        this.element = element;
        this.founder = founder;
        this.apprentices = apprentices;
    }

    public static ArrayList<Haus> allHomes() {
        ArrayList<Haus> allHouses = new ArrayList<>();
        Haus gryffindor = new Haus("Gryffindor", GryffindorEigenschaften(), "Gold Scharlachrot", "Löwe", "Feuer", "Godric Gryffindor", 31);
        Haus hufflepuff = new Haus("Hufflepuff", HufflepuffEigenschaften(), "Gelb Schwarz", "Dachs", "Erde", "Helga Hufflepuff", 15);
        Haus ravenclaw = new Haus("Ravenclaw", RavenclawEigenschaften(), "Blau Bronze", "Adler", "Luft", "Rowena Ravenclaw", 33);
        Haus slytherin = new Haus("Slytherin", SlytherinEigenschaften(), "Smaragdgrün Silber", "Schlange", "Wasser", "Salazar Slytherin", 48);
        allHouses.add(gryffindor);
        allHouses.add(hufflepuff);
        allHouses.add(ravenclaw);
        allHouses.add(slytherin);
        return allHouses;
    }
}