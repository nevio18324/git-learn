package AufgabeGenerics;

public class Main {
    static <T> void arrayMaster(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }

    }

    public static void main(String[] args) {
        String[] strArray = {"jjjj","gggg","aswd"};
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.2,2.3,6.7};
        arrayMaster(strArray);
        arrayMaster(intArray);
        arrayMaster(doubleArray);
    }

}
