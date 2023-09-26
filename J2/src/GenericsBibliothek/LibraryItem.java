package GenericsBibliothek;

class LibraryItem {
    private String title;
    private boolean checkedOut;

    public LibraryItem(String title) {
        this.title = title;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }


    public String toString() {
        return title + " (Ausgeliehen: " + checkedOut + ")";
    }
}
