package GenericsBibliothek;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "Fantasy");
        Magazine magazine1 = new Magazine("National Geographic", "National Geographic Society", "September 2023");
        CD cd1 = new CD("Greatest Hits", "Queen", 15);
        DVD dvd1 = new DVD("Inception", "Christopher Nolan", "Science Fiction");
        Book book2 = new Book("Perry Otter", "J. Rowling", "Fantasy");
        Magazine magazine2 = new Magazine("National Hymn", "National Geographic Society", "November 2023");
        CD cd2 = new CD("Black", "Metallica", 15);
        DVD dvd2 = new DVD("Barbie", "Barbie Productions", "Love");
        Book book3 = new Book("Larry Otter", "J.K. Oswald", "Animal");
        Magazine magazine3 = new Magazine("Albert Einstein", "A. E. Foundation", "April 2023");
        CD cd3 = new CD("Greatest Hits", "ABBA", 15);
        DVD dvd3 = new DVD("Where's The UFO", "Tom Nolan", "Science Fiction");

        Library<LibraryItem> library = new Library<>();
        library.addItem(book1);
        library.addItem(magazine1);
        library.addItem(cd1);
        library.addItem(dvd1);
        library.addItem(book2);
        library.addItem(magazine2);
        library.addItem(cd2);
        library.addItem(dvd2);
        library.addItem(book3);
        library.addItem(magazine3);
        library.addItem(cd3);
        library.addItem(dvd3);
        library.listInventory();
        System.out.println(" ");
        System.out.println(" ");

        book1.checkOut();
        System.out.println("Item Ausgeliehen" + book1);
        System.out.println(" ");

        book1.checkIn();
        System.out.println("Item zurückgegeben: " + book1);
        System.out.println(" ");

        cd2.checkOut();
        System.out.println("Item Ausgeliehen" + cd2);
        System.out.println(" ");
        System.out.println(" ");

        magazine3.checkOut();
        System.out.println("Item Ausgeliehen" + magazine3);
        System.out.println(" ");
        System.out.println(" ");

        dvd1.checkOut();
        System.out.println("Item ausgeliehen: " + dvd1);
        System.out.println(" ");
        System.out.println(" ");
        library.listInventory();
        System.out.println(" ");
        System.out.println(" ");

        cd2.checkOut();
        System.out.println("Item zurückgegeben: " + cd2);
        System.out.println(" ");
        System.out.println(" ");

        library.listInventory();



    }

}
