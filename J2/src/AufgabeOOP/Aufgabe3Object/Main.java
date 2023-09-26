package AufgabeOOP.Aufgabe3Object;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int login(){
        Scanner scanner = new Scanner(System.in);
        boolean log = true;
        int logged = 0;
        while (log) {
            System.out.println("Enter username or 5 for register");
            String loggedinuser = scanner.nextLine().toLowerCase();
            if (loggedinuser.equals("5")) {
                System.out.println("Name Email Kreditkarte Zahlmethode");
                String[] newcontact = scanner.nextLine().split(" ");
                User contact = new User(newcontact[0], newcontact[1], newcontact[2], newcontact[3]);
                users().add(contact);
                logged = users().indexOf(contact);
                break;
            }
            for (int i = 0; i < users().size(); i++) {
                if (loggedinuser.equals(users().get(i).getName().toLowerCase())) {
                    logged = i;
                    log = false;
                    break;
                }
                System.out.println("invalid username");
            }
        }
        return logged;
    }
    public static ArrayList<User> users(){
        ArrayList<User> user = new ArrayList<>();
        User john = new User("John", "John@gmail.com", "2180 2108 6480 5091", "Monatlich");
        user.add(john);
        return user;
    }
    public static ArrayList<Movie> movies(){
        ArrayList<Movie> film = new ArrayList<>();
        Movie Spiderman = new Movie("Spiderman", "2:30:47", "Action", "Disney");
        film.add(Spiderman);
        Movie Starwars = new Movie("Starwars", "2:10:30", "Action", "Disney");
        film.add(Starwars);
        Movie Endgame = new Movie("Avengers Endgame", "3:20:17", "Action", "Disney");
        film.add(Endgame);
        return film;
    }
    public static String action(){
        int logged = login();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("0 = Exit");
            System.out.println("1 = Film als gesehen markieren");
            System.out.println("2 = Kreditkarte ändern");
            System.out.println("3 = Zahlungsart ändern");
            System.out.println("4 = Alle Benutzer anzeigen");
            System.out.println("5 = Konto löschen");
            System.out.println("6 = Nach einem Film suchen");
            System.out.println("7 = Nach einem Genre suchen");
            System.out.println("8 = Views anzeigen");
            System.out.println("9 = Alle die Monatlich zahlen anzeigen");
            String input = scanner.nextLine();
            int action = Integer.parseInt(input);
            switch (action) {
                case 0:
                System.exit(0);
                case 1:
                System.out.println("Film als gesehen markieren");
                for (int i = 0; i < movies().size(); i++) {
                    System.out.println(movies().get(i).getName());
                }
                String watchedmovie = scanner.nextLine().toLowerCase();
                for (int i = 0; i < movies().size(); i++) {
                    if (movies().get(i).getName().toLowerCase().equals(watchedmovie)) {
                        users().get(logged).setSeenMovies(movies().get(i));
                        movies().get(i).watch();
                        break;
                    }
                }
                break;
                case 2:
                System.out.println("Kartennummer");
                String newkreditcard = users().get(0).setKreditcard(scanner.nextLine());
                case 3:
                System.out.println("Currently " + users().get(0).getPaymentMethod());
                System.out.println("Monatlich = 10$");
                System.out.println("Jährlich = 100$");
                users().get(0).setPaymentMethod(scanner.nextLine().toLowerCase());
                break;
                case 4:
                System.out.println(users().size());
                case 5:
                System.out.println("Name der Person die gelöscht werden soll");
                String delete = scanner.nextLine().toLowerCase();
                for (int i = 0; i < users().size(); i++) {
                    if (delete.equals(users().get(i).getName().toLowerCase())) {
                        users().remove(users().get(i));
                    }
                }
                break;
                case 6:
                System.out.println("Gesuchter Film eingeben");
                String searchingfilm = scanner.nextLine().toLowerCase();
                for (int i = 0; i < movies().size(); i++) {
                    if (movies().get(i).getName().toLowerCase().contains(searchingfilm)) {
                        System.out.println(movies().get(i).getName());
                    }
                }
                break;
                case 7:
                System.out.println("Welches Genre");
                String genre = scanner.nextLine();
                for (int i = 0; i < movies().size(); i++) {
                    if (movies().get(i).getGenre().toLowerCase().equals(genre.toLowerCase())) {
                        System.out.println(movies().get(i).getName());
                    }
                }
                break;
                case 8:
                System.out.println("Von welchem Film die Views anzeigen");
                String viewsMovie = scanner.nextLine().toLowerCase();
                for (int i = 0; i < movies().size(); i++) {
                    if (movies().get(i).getName().toLowerCase().equals(viewsMovie)) {
                        System.out.println(movies().get(i).views);
                    }
                }
                break;
                case 9:
                for (int i = 0; i < users().size(); i++) {
                    if (users().get(i).getPaymentMethod().equals("Monatlich")) {
                        System.out.println(users().get(i).getCreditCard());
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        action();
    }
}