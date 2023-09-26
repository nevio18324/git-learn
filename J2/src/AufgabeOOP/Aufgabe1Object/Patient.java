package AufgabeOOP.Aufgabe1Object;

public class Patient {

    String  name;

    public Patient(String name) {
        this.name = name;
    }
    public static Patient john(){
        Patient john = new Patient("john");
        return john;
    }
    public double checkUpHeight(String input) {
        double resultHeight = 0;
            if (input.matches("\\D")) {
                System.out.println("ERROR 404 invalid Number");
            }
            if (!(input.matches("\\D"))) {
                resultHeight = Double.parseDouble(input);
            }
        return resultHeight;
    }
    public double checkUpTemparatur(String input) {
        double temparatur = 0;
            if (input.matches("\\D")) {
                System.out.println("ERROR 404 invalid Number");
            }
            if (!input.matches("\\D")) {
                temparatur = Double.parseDouble(input);
            }
        return temparatur;
    }
    public  String checkUpGeimpft(String input){
        String geimpft = null;
            if (input.equals("y") || input.equals("n")) {
                geimpft = input;
            }else {
                System.out.println("Invalid");
            }
        return geimpft;
    }
    public  double checkUpWeight(String input) {
        double weight = 0;
            if (input.matches("\\D")) {
                System.out.println("ERROR 404 invalid Number");
            }
            if (!input.matches("\\D")) {
                weight = Double.parseDouble(input);
            }
        return weight;
    }
    public static String outPrint(){
        return outPrint();
    }
}
