package OODZoo.ZooCages;

public class Cage extends Cages {
    int wetness;

    public Cage(double temprature, String size, int cageNumber, int wetness) {
        super(temprature, size, cageNumber);
        this.wetness = wetness;
    }
}
