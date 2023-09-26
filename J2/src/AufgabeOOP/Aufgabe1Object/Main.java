package AufgabeOOP.Aufgabe1Object;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String input = "";
        Patient john = new Patient("john");
        double scannedHeight = 0;
        while (running) {
            System.out.println("Grösse");
            input = scanner.nextLine();
            scannedHeight = john.checkUpHeight(input);
            if (scannedHeight != 0){
                running = false;
            }
        }
        double scannedWeight = 0;
        while (!running) {
            System.out.println("Gewicht");
            input = scanner.nextLine();
            scannedWeight = john.checkUpWeight(input);
            if (scannedWeight != 0){
                running = true;
            }
        }
        double scannedTemprature = 0;
        while (running) {
            System.out.println("Temparatur");
            input = scanner.nextLine();
            scannedTemprature = john.checkUpTemparatur(input);
            if (scannedTemprature != 0){
                running = false;
            }
        }
        String scannedGeimpft = "";
        while (!running) {
            System.out.println("Geimpft yes = y no = n");
            input = scanner.nextLine();
             scannedGeimpft = john.checkUpGeimpft(input);
            if (scannedGeimpft != null){
                running = true;
            }
        }
        System.out.print(" Grösse "+ scannedHeight + " Geimpft " + scannedGeimpft +" Gewicht "+ scannedWeight +" Temparatur "+ scannedTemprature);
    }
}


