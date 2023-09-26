package AufgabeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> numbers(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numberCombination = new ArrayList<>();
        System.out.println("Zahlen Kombination");
        String [] number = scanner.nextLine().split(" ");
        for (int i = 0; i < number.length; i++) {
            if (number[i].matches("\\D")) {
                System.out.println("Invalid Number");
                System.exit(0);
            }
            numberCombination.add(Integer.valueOf(number[i]));
        }
        System.out.println("Nach welcher Zahl suchen");
        int searchedPosition = scanner.nextInt();
        if (searchedPosition > -1 && searchedPosition < numberCombination.size()) {
            System.out.println(numberCombination.get(searchedPosition));
        } else if (searchedPosition < -1||searchedPosition > numberCombination.size() ) {
            System.out.println("ERROR! Die Position " + searchedPosition + " existiert nicht");
        }
        return numberCombination;
    }
    public static ArrayList<String> words(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> sentence = new ArrayList<>();
        System.out.println("Satz / Wörter eingeben");
        String [] sentenceSplit = scanner.nextLine().split(" ");
        sentence.addAll(List.of(sentenceSplit));
        System.out.println(sentence.size());
        System.out.println(sentence);
        for (int i = 0; i <sentence.size() ; i++) {
            if (sentence.get(i).charAt(0) == sentence.get(i).toUpperCase().charAt(0)){
                System.out.println(sentence.get(i).toUpperCase());
            }
        }
        for (int i = sentence.size() - 1; i > -1; i--) {
            System.out.print(sentence.get(i)+", ");
        }
        return sentence;
    }

    public static void main(String[] args) {
        numbers();
        words();
    }
}
