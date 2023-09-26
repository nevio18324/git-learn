package AufgabenGrundlagen;

import java.util.Scanner;

public class Aufgabe8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numsplit = {-21, 9, 0, 10, 89, 9, 7, 10, 9};
        System.out.println("Single Number");
        int sn = scanner.nextInt();
        int index = 0;
        boolean p = false;
        for (int i = 0; i < numsplit.length ; i++) {
            if (sn == numsplit[i]){
                index = i;
                p = true;
                break;
            }
        }
        if (p)
            System.out.println(sn + " found at index = " + index);
        else
            System.out.println(sn + " Not found");
        //int largest = Integer.parseInt(num[num.length - 1]);
        //System.out.println("Largest number in the array: " + largest);
    }
}

