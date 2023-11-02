package MyDatabase;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User implements GradesInterface {
    public static ArrayList<Subject> allSubject = new ArrayList<>();
    public static Connection connection = createConnection();
    static User user = new User();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        allSubject.add(Subject.FRANZ);
        allSubject.add(Subject.PHYSIK);
        allSubject.add(Subject.MATH);
        allSubject.add(Subject.ENGLISCH);
        user.createTable();
        user.action(scanner);
    }
    public void action(Scanner scanner) {
        System.out.println("Press Enter to Start");
        scanner.nextLine();
        System.out.println("1 = Neue Note\n2 = Note Löschen\n3 = Note bearbeiten\n4 = Fachdurchschnitt bekommen\n5 = Zeugnis");
        String whichSubject = "Welches Fach\n" +
                "1 = Franz\n" +
                "2 = Physik\n" +
                "3 = Math\n" +
                "4 = Englisch";
        switch (scanner.nextLine()) {
            case "1" -> {
                System.out.println(whichSubject);
                caseAdd(scanner);
                break;
            }
            case "2" -> {
                System.out.println(whichSubject);
                caseRemove(scanner);
                break;
            }
            case "3" -> {
                System.out.println(whichSubject);
                caseEdit(scanner);
                break;
            }
            case "4" -> {
                System.out.println(whichSubject);
                System.out.println(grade(scanner));
            }
            case "5" ->{
                System.out.println(zeugnis());
            }
            default -> {
                action(scanner);
            }

        }
    }



    @Override
    public void remove(int index) {
        String query = "DELETE FROM Grades WHERE id = " + index;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void caseRemove(Scanner scanner){
        try {
            printSelectStatement(scanner );
            System.out.println("ID der Note Welche sie löschen möchten");
            int idToDelete = scanner.nextInt();
            user.remove(idToDelete);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Input");
            caseRemove(scanner);
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input");
            caseRemove(scanner);
        }
    }

    @Override
    public void add(float grade, Subject subject,Scanner scanner) {
        System.out.println("Date in Format DD.MM.YYYY");
        String proof = scanner.nextLine();
        if (!proof.matches("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}$")){
            System.out.println("Invalid Date");
            add(grade,subject,scanner);
        }
        try {
            String insertQuery = "INSERT INTO Grades (Subject, GRADE, DATE) VALUES (?, ?, ?)";

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for placeholders in the query
            preparedStatement.setString(1, String.valueOf(subject));
            preparedStatement.setFloat(2, grade);
            preparedStatement.setString(3,proof);
            // Perform database operations here
            int rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    public void caseAdd(Scanner scanner){
        try {
            String subject = scanner.nextLine();
            int sub = Integer.parseInt(subject) - 1;
            user.add(user.getGrade(scanner), allSubject.get(sub),scanner);
        } catch (IndexOutOfBoundsException e) {
            action(scanner);
        } catch (NumberFormatException e){
            action(scanner);
        }
    }

    @Override
    public void edit(float newGrade, int id) {
        try {
            String query = "UPDATE Grades SET GRADE = "+newGrade+" WHERE ID = "+id+";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void caseEdit(Scanner scanner){
        try {
            printSelectStatement(scanner);
            System.out.println("Von welcher ID");
            int sub = scanner.nextInt();
            scanner.nextLine();
            user.edit(user.getGrade(scanner),sub);
        }catch (NumberFormatException e){
            caseEdit(scanner);
        }
    }

    @Override
    public String grade(Scanner scanner) {
        try {
            int sub = scanner.nextInt() - 1;
            String query = "SELECT * FROM Grades WHERE Subject = " + "'" + String.valueOf(allSubject.get(sub)) + "'";
            Statement statement = connection.createStatement();
            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);
            int amountOfTests = 0;
            Double averageGrade = 0.0;
            while (resultSet.next()) {
                amountOfTests++;
                int id = resultSet.getInt("id");
                String subject = resultSet.getString("Subject");
                double grade = resultSet.getDouble("GRADE");
                averageGrade += grade;
                String date = resultSet.getString("DATE");
                System.out.println("ID: " + id + ", Subject: " + subject + ", Grade: " + grade +", Datum: " +date);
            }
            return "Durchschnitt im Fach "+ allSubject.get(sub) + ":  "+averageGrade/amountOfTests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NumberFormatException e){
            grade(scanner);
        }catch (InputMismatchException e){
            grade(scanner);
        }
        return null;
    }

    @Override
    public String zeugnis() {
        try {
            int allTests = 0;
            double allGrades = 0;
            for (int i = 0; i < allSubject.size(); i++) {
                String query = "SELECT * FROM Grades WHERE Subject = " + "'" + String.valueOf(allSubject.get(i)) + "'";
                Statement statement = connection.createStatement();
                // Execute the query
                ResultSet resultSet = statement.executeQuery(query);
                int amountOfTests = 0;
                Double averageGrade = 0.0;
                while (resultSet.next()) {
                    amountOfTests++;
                    allTests++;
                    double grade = resultSet.getDouble("GRADE");
                    averageGrade += grade;
                    allGrades += grade;
                    String date = resultSet.getString("DATE");
                }
                System.out.println("Durchschnitt im Fach "+ allSubject.get(i) + ":  "+averageGrade/amountOfTests);
            }
            return "Zeugnisnote = "+ allGrades/allTests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NumberFormatException e){
            zeugnis();
        }catch (InputMismatchException e){
            zeugnis();
        }
        return null;
    }











    public void printSelectStatement(Scanner scanner){
        try {
            int sub = scanner.nextInt() - 1;
            String query = "SELECT * FROM Grades WHERE Subject = " + "'" + String.valueOf(allSubject.get(sub)) + "'";
            Statement statement = connection.createStatement();
            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and print the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String subject = resultSet.getString("Subject");
                double grade = resultSet.getDouble("GRADE");
                String date = resultSet.getString("DATE");
                System.out.println("ID: " + id + ", Subject: " + subject + ", Grade: " + grade +", Datum: " +date);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NumberFormatException e){
            printSelectStatement(scanner);
        }catch (InputMismatchException e){
            printSelectStatement(scanner);
        }
    }
    public void createTable() {
        try {
            // SQL statement to create the "Grades" table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Grades (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "Subject TEXT," +
                    "GRADE FLOAT NOT NULL," +
                    "DATE TEXT NOT NULL" +
                    ")";

            // SQL statement to switch to the "School" database
            String useDatabaseQuery = "USE School";


            // Create prepared statements
            PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery);
            PreparedStatement useDatabaseStatement = connection.prepareStatement(useDatabaseQuery);

            // Execute the SQL statements
            useDatabaseStatement.execute();
            createTableStatement.execute();

            // Close resources
            createTableStatement.close();
            useDatabaseStatement.close();


            String createTableAllGrades = "CREATE TABLE IF NOT EXISTS AllGrades (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "GRADE FLOAT NOT NULL" +
                    ")";
            String createTableAllSubjects = "CREATE TABLE IF NOT EXISTS AllSubjects (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "Subject TEXT NOT NULL" +
                    ")";
            PreparedStatement createAllSubjectsTable = connection.prepareStatement(createTableAllSubjects);
            createAllSubjectsTable.execute();
            for (Subject sub: allSubject) {
                String insert = "INSERT INTO AllSubjects(Subject) VALUE("+"'"+sub+"');";
                PreparedStatement insertAllSubjects= connection.prepareStatement(insert);
                insertAllSubjects.execute();
            }
            PreparedStatement deleteAllDupesSub = connection.prepareStatement("DELETE FROM AllSubjects WHERE ID > 4");
            deleteAllDupesSub.execute();





            PreparedStatement createAllGradesTable = connection.prepareStatement(createTableAllGrades);
            createAllGradesTable.execute();
            for (double i = 1; i <= 6; i += 0.25) {
                String insert = "INSERT INTO AllGrades(GRADE) VALUE("+i+");";
                PreparedStatement insertAllGrades = connection.prepareStatement(insert);
                insertAllGrades.execute();
            }
            PreparedStatement deleteAllDupesGRD = connection.prepareStatement("DELETE FROM AllGrades WHERE ID > 21");
            deleteAllDupesGRD.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection createConnection() {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/School";  // Specify the database name
        String username = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public float getGrade(Scanner scanner) {
        System.out.println("Was für eine Note auf 0.25 gerundet");
        while (true) {
            String proof = scanner.nextLine();
            float grade = 0f;

            if (proof.matches("^(6(\\.00)?|([1-5](\\.(00|25|5|75))?))$")) {
                grade = Float.parseFloat(proof);
                return grade;
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
