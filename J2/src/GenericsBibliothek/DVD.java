package GenericsBibliothek;

class DVD extends LibraryItem {
    private String director;
    private String genre;

    public DVD(String title, String director, String genre) {
        super(title);
        this.director = director;
        this.genre = genre;
    }


    public String toString() {
        return "DVD: " + super.toString() + ", Regisseur: " + director + ", Genre: " + genre;
    }
}
