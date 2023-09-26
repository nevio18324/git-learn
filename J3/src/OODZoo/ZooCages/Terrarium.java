package OODZoo.ZooCages;

public class Terrarium extends Cages {
    int wetness;
    public Terrarium(double temprature, String size, int cageNumber, int wetness) {
        super(temprature, size, cageNumber);
        this.wetness = wetness;
    }
}
