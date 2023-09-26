package AufgabeOOP.Aufgabe2Object;

import java.util.ArrayList;
import java.util.Scanner;

public class Addressbuch {
    public static String result(){
        ArrayList<User> result = new ArrayList<>();
        User john = new User("John", "John@gmail.com", "+41 079 500 69 69");
        result.add(john);
        User alice = new User("Alice", "Alice@gmail.com", "+41 079 555 40 60");
        result.add(alice);
        User freddy = new User("Freddy", "Freddy@gmail.com", "+51 050 555 67 90");
        result.add(freddy);
        User manfred = new User("Manfred", "Manfred@gmail.com", "+41 079 679 79 25");
        result.add(manfred);
        User peter = new User("Peter", "Peter@gmail.com", "+21 083 419 40 69");
        result.add(peter);
        while (true) {
            System.out.println("1 = Kontakt suchen");
            System.out.println("2 = Alle Kontakte anzeigen");
            System.out.println("3 = neuen Kontakt erstellen");
            System.out.println("4 = Anzahl Kontakte anzeigen");
            System.out.println("5 = Kontakt löschen");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            int input = Integer.parseInt(action);
            switch (input) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Name");
                    String contacttosearch = scanner.nextLine().toLowerCase();
                    for (int i = 0; i <= result.size() - 1; i++) {
                        if (contacttosearch.equals(result.get(i).getName().toLowerCase())) {
                            System.out.println(result.get(i).getall());
                            break;
                        }
                    }
                    break;
                case 3:
                        System.out.println("Name Nummer Email");
                        String[] newcontact = scanner.nextLine().split(" ");
                        User contact = new User(newcontact[0], newcontact[1], newcontact[2]);
                        System.out.println(contact);
                        result.add(contact);
                        System.out.println(result.size());
                        return contact.name;
                case 4:
                        System.out.println(result.size());
                        break;
                case 5:
                        System.out.println("Name der Person die gelöscht werden soll");
                        String delete = scanner.nextLine().toLowerCase();
                        for (int i = 0; i < result.size(); i++) {
                            if (delete.equals(result.get(i).getName().toLowerCase())) {
                                result.remove(result.get(i));
                                System.out.println(result.size());
                            }
                        }
                        break;
                case 2:
                        for (int i = 0; i < result.size(); i++) {
                            System.out.println(result.get(i).getName());
                        }
                        break;
            }
        }
    }
}
