package GenericsBibliothek;

class Magazine extends LibraryItem {
    private String publisher;
    private String date;

    public Magazine(String title, String publisher, String date) {
        super(title);
        this.publisher = publisher;
        this.date = date;
    }


    public String toString() {
        return "Zeitschrift: " + super.toString() + ", Herausgeber: " + publisher + ", Datum: " + date;
    }
}
