package AufgabeGenerics2;
import java.util.ArrayList;

public class Main {
     static void biggestNumberResults() {
        Integer[] integers = {3, 7, 1, 9, 4, 100};
        Double[] doubles = {1.2, 12.9, 10.4};
        Float[] floats = {1f, 200f, 20.12f, 123f};
        Numberlist<Integer> integerNumberlist = new Numberlist<>();
        Numberlist<Double> doubleNumberlist = new Numberlist<>();
        Numberlist<Float> floatNumberlist = new Numberlist<>();
        ArrayList<Integer> resultInteger = integerNumberlist.biggestNumber(integers);
        ArrayList<Double> resultDoubles = doubleNumberlist.biggestNumber(doubles);
        ArrayList<Float> resultFloats = floatNumberlist.biggestNumber(floats);
        if (resultFloats.get(0) > resultDoubles.get(0) && resultFloats.get(0) > resultInteger.get(0)) {
            System.out.println(resultFloats);
        } else if (resultDoubles.get(0) > resultFloats.get(0) && resultDoubles.get(0) > resultInteger.get(0)) {
            System.out.println(resultDoubles);
        } else if (resultInteger.get(0) > resultFloats.get(0) && resultInteger.get(0) > resultDoubles.get(0)) {
            System.out.println(resultInteger.get(0));
        }
    }
    static void smallestNumberResult() {
        Integer[] integers = {30, 7, 10, 9, 4, 100,10};
        Double[] doubles = {10.2, 12.9, 100.4};
        Float[] floats = {10f, 200f, 20.12f, 123f};
        Numberlist<Integer> integerNumberlist = new Numberlist<>();
        Numberlist<Double> doubleNumberlist = new Numberlist<>();
        Numberlist<Float> floatNumberlist = new Numberlist<>();
        ArrayList<Integer> resultInteger = integerNumberlist.smallestNumber(integers);
        ArrayList<Double> resultDoubles = doubleNumberlist.smallestNumber(doubles);
        ArrayList<Float> resultFloats = floatNumberlist.smallestNumber(floats);
        if (resultFloats.get(0) < resultDoubles.get(0) && resultFloats.get(0) < resultInteger.get(0)) {
            System.out.println(resultFloats);
        } else if (resultDoubles.get(0) < resultFloats.get(0) && resultDoubles.get(0) < resultInteger.get(0)) {
            System.out.println(resultDoubles);
        } else if (resultInteger.get(0) < resultFloats.get(0) && resultInteger.get(0) < resultDoubles.get(0)) {
            System.out.println(resultInteger.get(0));
        }
    }



    public static void main(String[] args) {
        biggestNumberResults();
        smallestNumberResult();
    }
}
