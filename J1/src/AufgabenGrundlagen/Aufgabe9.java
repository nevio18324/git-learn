package AufgabenGrundlagen;

public class Aufgabe9 {
    public static int values(int value1, int value2){
        value1 = 10;
        value2 = 20;
        return value1 + value2;
    }
    public static String names(String name){
        name = "Nevio";
        return name;
    }
    public static void main(String[] args) {
        System.out.println(values(1,2));
        System.out.println("Hello "+ names(""));
    }
}