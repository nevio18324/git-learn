import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        createLog();
        int amountOfWords = 0;
        int amountOfWordsWithQ = 0;
        String allSpecialChars = "";
        int amountOfChars = 0;
        String filePath = "/home/ndigennaro/Downloads/words.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger(line);
                String [] lineSplitted = line.split("");
                amountOfWords++;
                if (line.toLowerCase().contains("q")){
                    amountOfWordsWithQ++;
                }
                for (int i = 0; i < lineSplitted.length; i++) {
                    amountOfChars++;
                    if (lineSplitted[i].matches("[!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/|\\\\-]")&&!(allSpecialChars.contains(lineSplitted[i]))){
                        allSpecialChars += lineSplitted[i];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(amountOfWords);
        System.out.println(amountOfWordsWithQ);
        System.out.println(allSpecialChars);
        System.out.println(amountOfChars);
        System.out.println(amountOfChars/amountOfWords);
    }
    public static Logger logger = Logger.getLogger(Main.class.getName());

    public static void createLog(){
        try {
            FileHandler fileHandler = new FileHandler("mylog.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void logger(String line){
        logger.info(line);
    }
}
