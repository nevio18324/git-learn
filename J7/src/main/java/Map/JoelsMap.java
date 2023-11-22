package Map;

import Outputvalidator.OutputValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JoelsMap {
    public static void main(String[] args) {
        OutputValidation outputValidation = new OutputValidation();
        Map<String, String> plzMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/ndigennaro/Downloads/Postleitzahlen_ISO-8859-1.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String plz = parts[0].trim();
                    String gemeinde = parts[1].substring(1, parts[1].length()-1);
                    plzMap.put(plz, gemeinde);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        outputValidation.log("- Anzahl PLZ: " + plzMap.size());

        List<String> gemeinden = new ArrayList<>(plzMap.values());
        Collections.sort(gemeinden);

        String kleinstePLZ = null;
        String groesstePLZ = null;
        for (Map.Entry<String, String> entry : plzMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Bern")) {
                if (kleinstePLZ == null || entry.getKey().compareTo(kleinstePLZ) < 0) {
                    kleinstePLZ = entry.getKey();
                }
                if (groesstePLZ == null || entry.getKey().compareTo(groesstePLZ) > 0) {
                    groesstePLZ = entry.getKey();
                }
            }
        }
        outputValidation.log("- Kleinste PLZ der Gemeinde Bern: " + kleinstePLZ + " Bern");
        outputValidation.log("- Grösste PLZ der Gemeinde Bern: " + groesstePLZ + " Bern");

        long anzahlMehrAls10Buchstaben = gemeinden.stream().filter(g -> g.length() > 10).count();
        outputValidation.log("- Anzahl Gemeinden mit mehr als 10 Buchstaben: " + anzahlMehrAls10Buchstaben);

        long anzahl7Buchstaben = gemeinden.stream().filter(g -> g.length() == 7).count();
        outputValidation.log("- Anzahl Gemeinden mit 7 Buchstaben: " + anzahl7Buchstaben);

        long anzahlMitEnt = gemeinden.stream().filter(g -> g.contains("ent")).count();
        outputValidation.log("- Anzahl Gemeinden mit der Buchstabenfolge 'ent': " + anzahlMitEnt);

        List<String> gemeindenMit3Buchstaben = gemeinden.stream().filter(g -> g.length() == 3).collect(Collectors.toList());
        outputValidation.log("- Gemeinden mit 3 Buchstaben: " + String.join(", ", gemeindenMit3Buchstaben));

        int kleinsteGemeindenBuchstaben = gemeinden.stream().mapToInt(String::length).min().orElse(0);
        outputValidation.log("- Anzahl Buchstaben der kleinsten Gemeinden: " + kleinsteGemeindenBuchstaben);

        Set<String> kleinstenGemeinden =  gemeinden.stream().filter(g -> g.length() == kleinsteGemeindenBuchstaben).collect(Collectors.toSet());
        outputValidation.log("- Kleinsten Gemeinden: " + String.join(", ", kleinstenGemeinden));

        int groessteGemeindenBuchstaben = gemeinden.stream().mapToInt(String::length).max().orElse(0);
        outputValidation.log("- Anzahl Buchstaben der grössten Gemeinden: " + groessteGemeindenBuchstaben);

        List<String> groesstenGemeinden = gemeinden.stream().filter(g -> g.length() == groessteGemeindenBuchstaben).collect(Collectors.toList());
        outputValidation.log("- Grössten Gemeinden: " + String.join(", ", groesstenGemeinden));

        outputValidation.printAll();
        outputValidation.getControlHash();
    }
}
