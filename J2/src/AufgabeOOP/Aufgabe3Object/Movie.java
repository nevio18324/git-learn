package AufgabeOOP.Aufgabe3Object;

public class Movie {
    String name;
    String dauer;
    String genre;
    String producer;
    int views;

    public int getViews() {
        return views;
    }

    public void watch() {
        this.views++;
    }

    public Movie(String name, String dauer, String genre, String producer) {
        this.name = name;
        this.dauer = dauer;
        this.genre = genre;
        this.producer = producer;
        this.views = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDauer() {
        return dauer;
    }

    public void setDauer(String dauer) {
        this.dauer = dauer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getall(){
        return name+" "+dauer+" "+genre+" "+producer;
    }
}
