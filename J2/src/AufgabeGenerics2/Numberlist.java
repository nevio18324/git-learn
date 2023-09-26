
package AufgabeGenerics2;

import java.util.ArrayList;

public class Numberlist<T extends Comparable<T>> {
    public ArrayList<T> biggestNumber(T[] array) {
        ArrayList<T> numbers = new ArrayList<>();
        T biggestNumber = null;
        for (T element : array) {
            if (biggestNumber == null || element.compareTo(biggestNumber) > 0) {
                biggestNumber = element;
            }
        }
        numbers.add(biggestNumber);
        return numbers;
    }
    public ArrayList<T> smallestNumber(T[] array) {
        T smallestNumber = null;
        for (T element : array) {
            if (smallestNumber == null || (element.compareTo(smallestNumber) < 0)) {
                smallestNumber = element;
            }
        }
        ArrayList<T> numbers = new ArrayList<>();
        numbers.add(smallestNumber);
        return numbers;
    }
}

