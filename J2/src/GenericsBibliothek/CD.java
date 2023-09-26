package GenericsBibliothek;

class CD extends LibraryItem {
    private String artist;
    private int numberOfSongs;

    public CD(String title, String artist, int numberOfSongs) {
        super(title);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
    }


    public String toString() {
        return "CD: " + super.toString() + ", Interpret: " + artist + ", Anzahl der Songs: " + numberOfSongs;
    }
}
