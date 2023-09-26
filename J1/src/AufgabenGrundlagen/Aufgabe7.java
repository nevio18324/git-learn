package AufgabenGrundlagen;

import java.util.Scanner;

public class Aufgabe7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name");
        String name = scanner.nextLine();
        System.out.println("Alter");
        int age = scanner.nextInt();
        int age2 = age + 1;
        String text = String.format("Hello "+ name+ " you are "+ age+ " years old. Next year, you will be "+ age2);
        System.out.println(text);

    }
}
