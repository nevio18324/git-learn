package AufgabeOOP.Aufgabe5Object;

import java.util.ArrayList;

public class Water {
    int amount;
    boolean direction;
    String unit;

    public Water(int amount, boolean direction, String unit) {
        this.amount = amount;
        this.direction = direction;
        this.unit = unit;
    }
    public static ArrayList<Water> waters(){
        ArrayList<Water> waterArrayList = new ArrayList<>();
        Water input = new Water (100 , false , "l/sek");
        waterArrayList.add(input);
        Water output = new Water (98, true , "l/sek");
        Water input2 = new Water(2,true,"ml/sek");
        waterArrayList.add(output);
        waterArrayList.add(input2);
        return waterArrayList;
    }
    public static String inputOrOutput() {
        int totalOutlet = 0;
        int totalInlet = 0;
        for (int i = 0; i < waters().size(); i++) {
            if (waters().get(i).direction) {
                totalInlet = totalInlet + waters().get(i).amount;
            } else if (!waters().get(i).direction) {
                totalOutlet = totalOutlet + waters().get(i).amount;
            }
        }
        String result = "";
        if (totalInlet == totalOutlet) {
            result = "Gleich";
        }
        if (totalInlet < totalOutlet) {
            result = "Damm öffnen";
        }
        if (totalInlet > totalOutlet){
            result = "Damm schliessen";
        }
        return result;
    }
}
