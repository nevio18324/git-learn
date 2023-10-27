package Set;

import Outputvalidator.OutputValidation;

import java.util.Set;
public class MyClubs {

    Set<String> fussballVerein = Set.of(
            "Emil", "Hans", "Felix", "Fritz", "Patrick",
            "Hanne", "Anja", "Paula", "Petra", "Anna"
    );

    Set<String> schwimmVerein = Set.of(
             "Emil", "Klaus", "Paul", "Fritz", "Patrick",
            "Hanne", "Anina", "Nicole", "Petra", "Gerda"
    );

    Set<String> musikVerein = Set.of(
            "Kari", "Hans", "Max",
            "Karin", "Petra", "Anna"
    );

    Set<String> tanzVerein = Set.of(
            "Emil", "Hans", "Paul", "Felix", "Max",
            "Lara", "Anja", "Sabine", "Anna"
    );

    public static void main(String[] args) {
        OutputValidation OutputValidation = new OutputValidation();
        MyClubs mySet = new MyClubs();
        String allCharacter = "";
        String allFootballPlayers = "";
        int amountOfPeople = 0;
        for (Object element: mySet.tanzVerein) {
            allCharacter += element+" ";
        }
        for (Object element: mySet.musikVerein) {
            allCharacter += element+" ";
        }
        for (Object element: mySet.fussballVerein) {
            allCharacter += element+" ";

        }
        for (Object element: mySet.schwimmVerein) {
            allCharacter += element+" ";
        }
        String [] allCharacterSplitted = allCharacter.split(" ");
        bubbleSort(allCharacterSplitted);
        allCharacter = "";
        String allDancerAndBallers = "";
        int ballers = 0;
        int dancersAndBallers = 0;
        for (int i = 0; i < allCharacterSplitted.length; i++) {
            if (!(allCharacter.contains(allCharacterSplitted[i]))){
                amountOfPeople++;
                if (i != allCharacterSplitted.length - 1) {
                    allCharacter += allCharacterSplitted[i] + ",";
                } else {
                    allCharacter += allCharacterSplitted[i];
                }
            }
            if (!(mySet.schwimmVerein.contains(allCharacterSplitted[i]))&&!(mySet.tanzVerein.contains(allCharacterSplitted[i]))&& mySet.fussballVerein.contains(allCharacterSplitted[i])){
                    allFootballPlayers+= allCharacterSplitted[i] + ",";
                    ballers++;

            }
            if (mySet.fussballVerein.contains(allCharacterSplitted[i]) && mySet.tanzVerein.contains(allCharacterSplitted[i])&&!(allDancerAndBallers.contains(allCharacterSplitted[i]))){
                allDancerAndBallers += allCharacterSplitted[i] + ",";
                dancersAndBallers++;
            }
        }
        String newAllBallers = allFootballPlayers.substring(0,allFootballPlayers.length() - 1);
        String newAllDancerAndBallers = allDancerAndBallers.substring(0,allDancerAndBallers.length() - 1);
        System.out.println(newAllBallers);
        OutputValidation.logAndPrint("- Wie viele Personen machen min. in einem Verein mit: "+ amountOfPeople+": "+allCharacter);
        OutputValidation.logAndPrint("- Alle Personen, welche im Fussball und Tanz Verein sind: "+dancersAndBallers+": "+newAllDancerAndBallers);
        OutputValidation.logAndPrint("- Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: "+ballers+": "+newAllBallers);
        OutputValidation.printControlHash();
        System.out.println(-1421274666);

    }
    public static void bubbleSort(String[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }if (!swapped) {
                break;
            }
        }
    }

}
