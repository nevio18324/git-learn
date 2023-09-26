package OODZoo.ZooCages;

public class Fishtank extends Cages {
    boolean saltWater;

    public Fishtank(double temprature, String size, int cageNumber, boolean saltWater) {
        super(temprature, size, cageNumber);
        this.saltWater = saltWater;
    }
}
