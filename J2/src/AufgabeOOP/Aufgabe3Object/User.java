package AufgabeOOP.Aufgabe3Object;

import java.util.ArrayList;

public class User {
    String name;
    String email;
    String creditCard;
    String paymentMethod;
    ArrayList<Movie> seenMovies = new ArrayList<>();


    public User(String name, String email, String creditCard, String paymentmethod) {
        this.name = name;
        this.email = email;
        this.creditCard = creditCard;
        this.paymentMethod = paymentmethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String setKreditcard(String kreditcard) {
        this.creditCard = kreditcard;
        return kreditcard;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setSeenMovies(Movie movie){
        seenMovies.add(movie);
    }
    public ArrayList getSeenMovies(String name){
        return seenMovies;
    }
}
