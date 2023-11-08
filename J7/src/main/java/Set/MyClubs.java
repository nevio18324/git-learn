package Set;

import Outputvalidator.OutputValidation;

import java.util.Set;
import java.util.TreeSet;

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
    Set<String> alleVereine = new TreeSet<>();


    public static void main(String[] args) {
        OutputValidation outputValidation = new OutputValidation();
        MyClubs myClubs = new MyClubs();
        myClubs.alleVereine.addAll(myClubs.tanzVerein);
        myClubs.alleVereine.addAll(myClubs.musikVerein);
        myClubs.alleVereine.addAll(myClubs.schwimmVerein);
        myClubs.alleVereine.addAll(myClubs.fussballVerein);
        outputValidation.logAndPrint(myClubs.vereinsMitglieder());
        outputValidation.logAndPrint(myClubs.alleTänzerUndFussballer());
        outputValidation.logAndPrint(myClubs.alleFussballerOhneTanzOderSchwimmVerein());
        outputValidation.printControlHash();
    }

    public String vereinsMitglieder() {
        String[] vereinsMitglieder = {""};
        int[] anzahlVereinsMitglieder = {0};
        alleVereine.stream().forEach(s -> {
            anzahlVereinsMitglieder[0]++;
            vereinsMitglieder[0] += s + ", ";
        });
        String print = "- Wie viele Personen machen min. in einem Verein mit: " + anzahlVereinsMitglieder[0] + ": " + vereinsMitglieder[0].substring(0, vereinsMitglieder[0].length() - 2);
        return print;
    }

    public String alleTänzerUndFussballer() {
        String [] alleTänzerUndFussballer = {""};
        int [] anzahlTänzerUndFussballer = {0};
        alleVereine.stream().forEach(s -> {
            if (tanzVerein.contains(s) && fussballVerein.contains(s)) {
                anzahlTänzerUndFussballer[0]++;
                alleTänzerUndFussballer[0] += s + ", ";
            }
        });
        String print = "- Alle Personen, welche im Fussball und Tanz Verein sind: " + anzahlTänzerUndFussballer[0] + ": " + alleTänzerUndFussballer[0].substring(0, alleTänzerUndFussballer[0].length() - 2);
        return print;
    }


    public String alleFussballerOhneTanzOderSchwimmVerein() {
        String [] alleFussballerOhneTanzOderSchwimmVerein = {""};
        int [] anzahlFussballerOhneTanzOderSchwimmVerein = {0};
        alleVereine.stream().forEach(s -> {
            if (!tanzVerein.contains(s) && !schwimmVerein.contains(s) && fussballVerein.contains(s)) {
                anzahlFussballerOhneTanzOderSchwimmVerein[0]++;
                alleFussballerOhneTanzOderSchwimmVerein[0] += s + ", ";
            }
        });
        String print = "- Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: " + anzahlFussballerOhneTanzOderSchwimmVerein[0] + ": " + alleFussballerOhneTanzOderSchwimmVerein[0].substring(0, alleFussballerOhneTanzOderSchwimmVerein[0].length() - 2);
        return print;
    }
}
