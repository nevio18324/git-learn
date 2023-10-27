import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileReader implements FileReaderInter{
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        reader.reader();
    }
    public  void reader() {
        String filePath = "/home/ndigennaro/Downloads/words.txt";
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            System.out.println(FileReader.wordsCounter(reader));
            BufferedReader reader1 = new BufferedReader(new java.io.FileReader(filePath));
            System.out.println(FileReader.wordsWithQ(reader1));
            BufferedReader reader2 = new BufferedReader(new java.io.FileReader(filePath));
            System.out.println(allSpecialChars(reader2));
            BufferedReader reader3= new BufferedReader(new java.io.FileReader(filePath));
            System.out.println(FileReader.amountOfChars(reader3));
            addAll(wordsCounter(reader),wordsWithQ(reader),allSpecialChars(reader),amountOfChars(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int wordsCounter(BufferedReader fileToRead){
        String line = "";
        int amountOfWords = 0;
        try {
            while ((line = fileToRead.readLine()) != null) {
                amountOfWords++;
        }
        }catch (IOException E){
            System.out.println("Failed");
        }
        return amountOfWords;
    }
    public static int wordsWithQ(BufferedReader fileToRead){
        String line = "";
        int amountOfWordsWithQ = 0;
        try {
            while ((line = fileToRead.readLine()) != null) {
                if (line.toLowerCase().contains("q")){
                    amountOfWordsWithQ++;
                }
            }
        }catch (IOException E){
            System.out.println("Failed");
        }
        return amountOfWordsWithQ;
    }

    public String allSpecialChars(BufferedReader fileToRead){
        String line;
        String allSpecialChars = "";
        try {
            while ((line = fileToRead.readLine()) != null){
                String [] splittedLine = line.split("");
                for (int i = 0; i < splittedLine.length; i++) {
                    if (splittedLine[i].matches("[!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/|\\\\-]")&&!(allSpecialChars.contains(splittedLine[i]))){
                        allSpecialChars += splittedLine[i];
                    }
                }
            }
        }catch (IOException E){
            System.out.println("Failed");
        }
        return allSpecialChars;
    }
    public static int amountOfChars(BufferedReader fileToRead){
        String line;
        int amountOfChars = 0;
        try {
            while ((line = fileToRead.readLine()) != null){
                String [] splittedLine = line.split("");
                amountOfChars += splittedLine.length;
            }
        }catch (IOException E){
            System.out.println("Failed");
        }
        return amountOfChars;
    }

    @Override
    public void addAll(int AmountOfWords, int wordsWithQ, String allSpecialChars, int AmountOfChars) {
    }
}
