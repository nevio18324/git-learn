package GenericsBibliothek;

class Book extends LibraryItem {
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        super(title);
        this.author = author;
        this.genre = genre;
    }
    public String toString() {
        return "Buch: " + super.toString() + ", Autor: " + author + ", Genre: " + genre;
    }
}
