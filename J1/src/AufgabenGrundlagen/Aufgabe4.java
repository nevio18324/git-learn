package AufgabenGrundlagen;

import java.util.Scanner;

public class Aufgabe4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masse eingeben");
        String masse = scanner.nextLine();
        String parts [] = masse.split(" ");
        double zahl1 = Double.parseDouble(parts[0]);
        double zahl2 = Double.parseDouble(parts[1]);
        double zahl3 = zahl1 * zahl2;
        System.out.println("Fläche Rechteck");
        System.out.println(zahl3);
        System.out.println("Umfang Rechteck");
        System.out.println(zahl1 + zahl1 + zahl2 + zahl2);
        System.out.println("Fläche Kreis");
        System.out.println(zahl3 * 3.14159265358979323846);
        System.out.println("Seitenlänge Höhe eingeben");
        String masse1 = scanner.nextLine();
        String parts1 [] = masse1.split(" ");
        double zahl4 = Double.parseDouble(parts1[0]);
        double zahl5 = Double.parseDouble(parts1[1]);
        System.out.println("Volumen Dreieck");
        System.out.println(zahl4 * zahl4 * zahl5 / 3);
        System.out.println("Geburtsdatum in DD.MM.YYYY");
        String masse3 = scanner.nextLine();
        String parts3 [] = masse3.split("\\.");
        double zahl6 = Double.parseDouble(parts3[0]);
        double zahl7 = Double.parseDouble(parts3[1]);
        double zahl8 = Double.parseDouble(parts3[2]);
        double day = 17 - zahl6;
        double month = 8 - zahl7;
        double year = 2023 - zahl8;
        double days = year * 365 + month * 30 + day;
        System.out.println("Tage"+" "+ days);
        System.out.println("Monate"+" "+ days / 30);
        System.out.println("jahre"+" "+ days / 365);
        System.out.println("Nummer eingeben");
        Integer num2 = scanner.nextInt();
        int x = num2 * 3;
        int y = num2 * 5;
        System.out.println(x + y);
    }
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nummer eingeben");
            int num2 = scanner.nextInt();
            int x = num2 * 3;
            int y = num2 * 5;
            System.out.println(x + y);
        }
    }
}
