package AufgabeStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static List<Integer> baseNumbersCombination(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Zahlen Kombination");
        String [] numero = scanner.nextLine().split(" ");
        List<Integer> greetingList = new ArrayList<>();
        for (int i = 0; i <numero.length ; i++) {
            if (numero[i].matches("\\D")) {
                System.out.println("Invalid Number");
                System.exit(0);
            }
            greetingList.add(Integer.valueOf(numero[i]));
        }
        return greetingList;
    }
    public static void task(){
        List<Integer> baseNumbers = baseNumbersCombination();
        baseNumbers.stream()
                .forEach(System.out::println);
        baseNumbers.stream()
                .sorted()
                .forEach(System.out::println);
        List<Integer> multipliedNumbers = baseNumbers.stream()
                .map(x->x*x)
                .collect(Collectors.toList());
        baseNumbers.stream()
                .forEach(System.out::println);
        multipliedNumbers.stream()
                .forEach(System.out::println);
        baseNumbers.stream()
                .sorted()
                .forEach(System.out::println);
        multipliedNumbers.stream()
                .sorted()
                .forEach(System.out::println);
    }
    //public static Arrays Au
    public static void main(String[] args) {
        task();
    }
}
