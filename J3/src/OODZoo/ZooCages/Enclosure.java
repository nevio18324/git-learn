package OODZoo.ZooCages;

public class Enclosure extends Cages {
    int wetness;
    int fenceHeightInM;
    boolean water;

    public Enclosure(double temprature, String size, int cageNumber, int wetness, int fenceHeightInM, boolean water) {
        super(temprature, size, cageNumber);
        this.wetness = wetness;
        this.fenceHeightInM = fenceHeightInM;
        this.water = water;
    }
}
