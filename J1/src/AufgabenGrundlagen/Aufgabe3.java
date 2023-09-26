package AufgabenGrundlagen;

import java.util.Scanner;

public class Aufgabe3 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Number eingeben");
        Integer zahl = scanner.nextInt();
        int result = 1;
        for (int i = 1; zahl >= i; i++){
            result*= i;
            System.out.println(result);
        }
        System.out.println();
int result2 = 0;
        int zahl2 = zahl;
        for (int zahl1 = 1; zahl1 <= 100; zahl1++){
            if (zahl1 %zahl2 == 0){
                result2+=zahl1;
            }



        }
        System.out.println(result2);
    }
}
