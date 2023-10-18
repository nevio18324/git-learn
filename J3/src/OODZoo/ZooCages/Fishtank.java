package OODZoo.ZooCages;

public class Fishtank extends Cages {
    boolean saltWater;
    int capacity;

    public Fishtank(double temprature, String size, int cageNumber, boolean saltWater, int capacity) {
        super(temprature, size, cageNumber);
        this.saltWater = saltWater;
        this.capacity = capacity;
    }
}
