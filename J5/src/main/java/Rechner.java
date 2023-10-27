import java.util.Scanner;

public class Rechner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zahl 1 eingeben");
        String toProof = scanner.nextLine();
        int number1 = 0;
        if (numberValid(toProof)) {
             number1 = Integer.parseInt(toProof);
        }
        System.out.println("Operations Zeichen");
        String operation = scanner.nextLine();
        System.out.println("Zahl 2 eingeben");
        toProof = scanner.nextLine();
        int number2 = 0;
        if (numberValid(toProof)) {
            number2 = Integer.parseInt(toProof);
        }
        switch (operation){
            case "-" -> System.out.println(number1 - number2);
            case "+" -> System.out.println(number1 + number2);
            case "/" -> System.out.println(number1 / number2);
            case "*" -> System.out.println(number1 * number2);
        }
    }
    public static boolean numberValid(String toProof){
        try{
            Integer.parseInt(toProof);
            return true;
        }catch (NumberFormatException E){
            System.out.println("Invalid Number");
            return false;
        }
    }
}
