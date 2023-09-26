package AufgabeOOP.Aufgabe2Object;

public class User {
    String name;
    String emailadress;
    String phonenumber;

    public User(String name, String emailadress, String phonenumber) {
        this.name = name;
        this.emailadress = emailadress;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }
    public String getall() {
        return name + " " + phonenumber + " " + emailadress;
    }
}
