package Set;

import Outputvalidator.OutputValidation;

import java.util.*;

public class ClubActivity {
    public static void main(String[] args) {
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
        /*- Wie viele Personen machen min. in einem Verein mit: 2: Maria,Xaver
          - Alle Personen, welche im Fussball und Tanz Verein sind: 2: Maria,Xaver
          - Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: 2: Maria,Xaver*/

        OutputValidation outputValidation = new OutputValidation();


        Set<String> mindestensEinVerein = new HashSet<>();
        mindestensEinVerein.addAll(fussballVerein);
        mindestensEinVerein.addAll(schwimmVerein);
        mindestensEinVerein.addAll(musikVerein);
        mindestensEinVerein.addAll(tanzVerein);
        TreeSet<String> treesetMindEinVerein = new TreeSet<>(mindestensEinVerein);

        StringBuilder mindestensEinVereinReturnString = new StringBuilder();
        mindestensEinVereinReturnString.append("- Wie viele Personen machen min. in einem Verein mit: ")
                .append(treesetMindEinVerein.size()).append(": ");
        for (String name : treesetMindEinVerein) {
            mindestensEinVereinReturnString.append(name).append(",");
        }
        mindestensEinVereinReturnString.setLength(mindestensEinVereinReturnString.length() - 1);
        outputValidation.logAndPrint(mindestensEinVereinReturnString.toString());




        Set<String> fussballUndTanz = new HashSet<>(fussballVerein);
        fussballUndTanz.retainAll(tanzVerein);
        TreeSet<String> treeSetFussballUndTanz = new TreeSet<>(fussballUndTanz);

        StringBuilder fussballUndTanzReturnString = new StringBuilder();
        fussballUndTanzReturnString.append("- Alle Personen, welche im Fussball und Tanz Verein sind: ")
                .append(treeSetFussballUndTanz.size()).append(": ");
        for (String name : treeSetFussballUndTanz) {
            fussballUndTanzReturnString.append(name).append(",");
        }
        fussballUndTanzReturnString.setLength(fussballUndTanzReturnString.length() - 1);
        outputValidation.logAndPrint(fussballUndTanzReturnString.toString());



        Set<String> fussballNichtTanzOderSchwimmen = new HashSet<>(fussballVerein);
        fussballNichtTanzOderSchwimmen.removeAll(tanzVerein);
        fussballNichtTanzOderSchwimmen.removeAll(schwimmVerein);
        TreeSet<String> treeSetFussballNichtTanzOderSchwimmen = new TreeSet<>(fussballNichtTanzOderSchwimmen);

        StringBuilder fussballNichtTanzOderSchwimmenReturnString = new StringBuilder();
        fussballNichtTanzOderSchwimmenReturnString.append("- Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: ")
                .append(treeSetFussballNichtTanzOderSchwimmen.size()).append(": ");
        for (String name : treeSetFussballNichtTanzOderSchwimmen) {
            fussballNichtTanzOderSchwimmenReturnString.append(name).append(",");
        }
        fussballNichtTanzOderSchwimmenReturnString.setLength(fussballNichtTanzOderSchwimmenReturnString.length() - 1);
        outputValidation.logAndPrint(fussballNichtTanzOderSchwimmenReturnString.toString());

        outputValidation.getControlHash();
    }
}
