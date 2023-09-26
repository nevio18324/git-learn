package AufgabenGrundlagen;

import java.util.Scanner;

public class Aufgabe6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Text eingeben");
        String rev = scanner.nextLine();
        StringBuilder builder = new StringBuilder(rev);
        builder.reverse();
        System.out.println(builder);
        var items = rev.split(" ");
        System.out.println("Its "+ items.length+ " words lomg");
    }
}
