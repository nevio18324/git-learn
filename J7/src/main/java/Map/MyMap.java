package Map;

import Outputvalidator.OutputValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class MyMap {
    public static void main(String[] args) {
        int amountPLZ = -1;
        OutputValidation outputValidation = new OutputValidation();
        Map<String, String> plzMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/ndigennaro/Downloads/Postleitzahlen_ISO-8859-1.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder(line);
                stringBuilder.deleteCharAt(4);
                stringBuilder.replace(4,4,"%");
                line = String.valueOf(stringBuilder);
                String[] parts = line.split("%");
                amountPLZ++;
                if (parts.length == 2) {
                    String plz = parts[0].trim();
                    String gemeinde = parts[1].trim();
                    gemeinde = gemeinde.substring(1,gemeinde.length() - 1).trim();
                    plzMap.put(plz, gemeinde);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputValidation.logAndPrint("- Anzahl PLZ: " + amountPLZ);

        final int[] ints = {0, 0, 0, 0, 10, 0,10000};
        final String[] strings = {"", "", "", "",""};
        ArrayList<String> list = new ArrayList<>();
        plzMap.forEach((s, s2) -> {
            if (s2.length() > ints[5]) {
                ints[5] = s2.length();
            }
            if (s2.length() < ints[4]) {
                ints[4] = s2.length();
            }
            if (s2.length() == 3) {
               list.add(s2);
            }
            if (s2.length() == 7) {
                ints[2]++;
            }
            if (s2.toLowerCase().contains("ent")) {
                ints[3]++;
            }
            if (s2.length() > 10) {
                ints[1]++;
            }
            if (s2.equals("Bern")) {
                if (Integer.parseInt(s) > ints[0]) {
                    ints[0] = Integer.parseInt(s);
                    strings[0] = s2;
                }
                if (Integer.parseInt(s) < ints[6]){
                    ints[6] = Integer.parseInt(s);
                    strings[4] = s2;
                }
            }
        });
        plzMap.forEach((s, s2) -> {
            if (s2.length() == ints[4]) {
                strings[2] += s2 + ", ";
            }
            if (s2.length() == ints[5]) {
                strings[3] += s2 + ",";
            }
        });
        String allWith3Letters = list.stream().sorted().toList().toString();
        String smallest = strings[2].substring(0,strings[2].length() - 2);
        String biggest = strings[3].substring(0, strings[3].length() -1);
        outputValidation.logAndPrint("- Kleinste PLZ der Gemeinde Bern: " + ints[6] + " " + strings[4]);
        outputValidation.logAndPrint("- Grösste PLZ der Gemeinde Bern: " + ints[0] + " " + strings[0]);
        outputValidation.logAndPrint("- Anzahl Gemeinden mit mehr als 10 Buchstaben: " + ints[1]);
        outputValidation.logAndPrint("- Anzahl Gemeinden mit 7 Buchstaben: " + ints[2]);
        outputValidation.logAndPrint("- Anzahl Gemeinden mit der Buchstabenfolge 'ent': " + ints[3]);
        outputValidation.logAndPrint("- Gemeinden mit 3 Buchstaben: " + allWith3Letters.substring(1,allWith3Letters.length()-1));
        outputValidation.logAndPrint("- Anzahl Buchstaben der kleinsten Gemeinden: " + ints[4]);
        outputValidation.logAndPrint("- Kleinsten Gemeinden: " + smallest);
        outputValidation.logAndPrint("- Anzahl Buchstaben der grössten Gemeinden: " + ints[5]);
        outputValidation.logAndPrint("- Grössten Gemeinden: " + biggest.replaceAll("�","ü"));
        System.out.println(outputValidation.verifyControlHash(outputValidation.getControlHash()));
    }
}
