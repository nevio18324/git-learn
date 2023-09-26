package AufgabenGrundlagen;

import java.util.Scanner;

public class Aufgabe2 {

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.print("enter number");
        String  zahl = scanner.nextLine();
        double zahl1 = Double.parseDouble(zahl);
        if (zahl1 %4 == 0 && zahl1 %100 != 0){
            System.out.println("Es ist ein Schaltjahr");
        } else {
            System.out.println("Es ist kein Schaltjahr");
        }
        if (zahl1 %2 == 0){
            System.out.println("Es ist eine gerade Zahl");
        } else if (zahl1 %2 != 0) {
            System.out.println("Es ist eine ungerade Zahl");
        }

        if (zahl.equals("Nevio")){
            System.out.println("Hallo Nevio");
            System.exit(0);
        }
        if (zahl1 > 0 ){
            System.out.println("Grösser als 0");
        } else if (zahl1 == 0) {
            System.out.println("Gleich wie 0");
        }
        if (zahl1 < 0 ){
            System.out.println("Kleiner als 0");
        }





    }
}
