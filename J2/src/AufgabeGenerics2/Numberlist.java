
package AufgabeGenerics2;

import java.util.ArrayList;

public class Numberlist<T extends Comparable> {
    public T biggestNumber(T[] array) {
        T biggestNumber = null;
        for (T element : array) {
            if (biggestNumber == null || element.compareTo(biggestNumber) > 0) {
                biggestNumber = element;
            }
        }
        return biggestNumber;
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

