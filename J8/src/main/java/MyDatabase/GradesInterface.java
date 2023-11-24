package MyDatabase;

import java.time.LocalDate;
import java.util.Scanner;

public interface GradesInterface {
    public void remove(int index);
    public void add(float grade, String subject, Scanner scanner);
    public void edit(float newGrade,int id);
    public String grade(Scanner scanner);
    public String zeugnis();
}
