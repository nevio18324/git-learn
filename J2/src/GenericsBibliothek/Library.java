package GenericsBibliothek;

import java.util.ArrayList;
import java.util.List;

class Library<T extends LibraryItem> {
    private List<T> inventory = new ArrayList<>();

    public void addItem(T item) {
        inventory.add(item);
    }

    public void removeItem(T item) {
        inventory.remove(item);
    }

    public void listInventory() {
        System.out.println("Inventar der Bibliothek:");
        int indexRow = 0;
        for (T item : inventory) {
            indexRow++;
            System.out.print( indexRow+ ":");
            System.out.println(item);
        }
    }
}
