import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = "This is the data in the output file";

        try {
            FileWriter output = new FileWriter("writtenFile.txt");

            output.write(scanner.nextLine());

            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }
}

