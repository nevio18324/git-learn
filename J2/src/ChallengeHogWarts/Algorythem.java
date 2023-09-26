package ChallengeHogWarts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static ChallengeHogWarts.Eigenschaft.*;
import static ChallengeHogWarts.Haus.allHomes;

public class Algorythem {
    public static String dreamHouse() {
        Scanner scanner = new Scanner(System.in);
        String wunschhaus = "";
        System.out.println("Wunschhaus \n Gryffindor = 0 \n Hufflepuff = 1\n Ravenclaw = 2\n Slytherin = 3");
        String input = scanner.nextLine();
        if (input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3")) {
            switch (input) {
                case "0":
                    wunschhaus = "Gryffindor";
                    return wunschhaus;
                case "1":
                    wunschhaus = "Hufflepuff";
                    return wunschhaus;
                case "2":
                    wunschhaus = "Ravenclaw";
                    return wunschhaus;
                case "3":
                    wunschhaus = "Slytherin";
                    return wunschhaus;
                default:
                    System.out.println("Invalid Input");
                    dreamHouse();
            }
        } else {
            System.out.println("Invalid");
            dreamHouse();
        }
        return null;
    }

    public static String favColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lieblingfarbe");
        String favColor = scanner.nextLine().toLowerCase();
        return favColor;
    }

    public static String Verwandschaft() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nachname eingeben");
        String verwandschaft = scanner.nextLine();
        return verwandschaft;
    }

    public static ArrayList<Integer> eigenschaften() {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> proof = new ArrayList<>();
        for (int i = 0; i < allEigenchaften().size(); i++) {
            boolean running = true;
            int randomNumber = rand.nextInt(allEigenchaften().size());
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(0) == randomNumber){
                    randomNumber = rand.nextInt(allEigenchaften().size());
                    j = 0;
                }
                if (numbers.get(j) == randomNumber) {
                    randomNumber = rand.nextInt(allEigenchaften().size());
                    j = 0;
                }
            }
            numbers.add(randomNumber);
            while (running) {
                System.out.println("Hast du " + allEigenchaften().get(randomNumber).name + " yes = y no = n");
                String input = scanner.nextLine();
                if (input.equals("y")) {
                    proof.add(randomNumber);
                    running = false;
                } else if (input.equals("n")) {
                    running = false;
                } else {
                    System.out.println("Invalid du spassti");
                }
            }
        }
        return proof;
    }

    public static String result() {
        String dreamHouse = dreamHouse();
        String favColor = favColor();
        Random rand = new Random();
        String verwandter = Verwandschaft();
        ArrayList<Integer> eigenschaften = eigenschaften();
        int[] score = {0, 0, 0, 0};
        int scoreForFamilyMembers = 0;
        for (int i = 0; i < FamilyTree.allFamilies().size(); i++) {
            if (verwandter.toLowerCase().equals(FamilyTree.allFamilies().get(i).familyName.toLowerCase())){
                for (int j = 0; j < allHomes().size() ; j++) {
                    if (allHomes().get(j).name.equals(FamilyTree.allFamilies().get(i).house.name)){
                        scoreForFamilyMembers = FamilyTree.allFamilies().get(i).familyMembersAtHogWarts;
                        for (int k = FamilyTree.allFamilies().get(i).familyMembersAtHogWarts -1 ; k > 0; k--) {
                            scoreForFamilyMembers = scoreForFamilyMembers * k;
                        }
                        score[j] += scoreForFamilyMembers;
                    }
                }
            }

        }
        for (int i = 0; i < allHomes().size(); i++) {
            if (allHomes().get(i).color.toLowerCase().contains(favColor)) {
                score[i] += 10;
                if (allHomes().get(i).name.equals(dreamHouse)) {
                    score[i] += rand.nextInt(5) + 5;
                }
            }
        }
        for (int i = 0; i < GryffindorEigenschaften().size(); i++) {
            for (int j = 0; j < eigenschaften.size(); j++) {
                if (GryffindorEigenschaften().get(i).name.equals(allEigenchaften().get(eigenschaften.get(j)).name)) {
                    score[0] += allEigenchaften().get(eigenschaften.get(j)).weight;
                }
            }
        }
        for (int i = 0; i < HufflepuffEigenschaften().size(); i++) {
            for (int j = 0; j < eigenschaften.size(); j++) {
                if (HufflepuffEigenschaften().get(i).name.equals(allEigenchaften().get(eigenschaften.get(j)).name)) {
                    score[1] += allEigenchaften().get(eigenschaften.get(j)).weight;
                }
            }
        }
        for (int i = 0; i < RavenclawEigenschaften().size() ; i++) {
            for (int j = 0; j < eigenschaften.size(); j++) {
                if (RavenclawEigenschaften().get(i).name.equals(allEigenchaften().get(eigenschaften.get(j)).name)) {
                    score[2] += allEigenchaften().get(eigenschaften.get(j)).weight;
                }
            }
        }
        for (int i = 0; i < SlytherinEigenschaften().size(); i++) {
            for (int j = 0; j < eigenschaften.size(); j++) {
                if (SlytherinEigenschaften().get(i).name.equals(allEigenchaften().get(eigenschaften.get(j)).name)) {
                    score[3] += allEigenchaften().get(eigenschaften.get(j)).weight;
                }
            }
        }
        int result = 0;
        String school = "";
        for (int i = 0; i < score.length; i++) {
            if (score[i] == result) {
                for (int j = 0; j < allHomes().size(); j++) {
                    if (school.equals(allHomes().get(j).name)) {
                        if (allHomes().get(i).apprentices < allHomes().get(j).apprentices) {
                            school = allHomes().get(i).name;
                        }
                    }
                }
            }
            if (score[i] > result) {
                result = score[i];
                school = allHomes().get(i).name;
            }
        }
        System.out.println(Arrays.toString(score));
        return school + " Haus " + result;
    }
}
