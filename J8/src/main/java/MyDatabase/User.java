package MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User implements GradesInterface {
    public static Connection connection = createConnection();
    public static Connection createConnection() {
        String jdbcUrl = "jdbc:mariadb://localhost:3306";  // Specify the database name
        String username = "root";
        String password = "root";
        try {
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        user.createTable();
        user.action(scanner);
    }



    public void action(Scanner scanner) {
        boolean running = true;
        System.out.println("\u001B[33mPress Enter to Start");
        while (running) {
            scanner.nextLine();
            System.out.println("\u001B[33m1 | Neue Note\n2 | Note Löschen\n3 | Note bearbeiten\n4 | Fachdurchschnitt bekommen\n5 | Zeugnis\nExit | Beenden");
            String whichSubject = """
                    \u001B[33mWelches Fach?
                    1 | Franz
                    2 | Physik
                    3 | Math
                    4 | Englisch""";
            switch (scanner.nextLine().toLowerCase()) {
                case "1" -> {
                    System.out.println(whichSubject);
                    caseAdd(scanner);
                }
                case "2" -> {
                    System.out.println(whichSubject);
                    caseRemove(scanner);
                }
                case "3" -> {
                    System.out.println(whichSubject);
                    caseEdit(scanner);
                }
                case "4" -> {
                    System.out.println(whichSubject);
                    System.out.println(grade(scanner));
                }
                case "5" -> {
                    System.out.println(zeugnis());
                }
                case "exit" ->{
                    System.exit(0);
                }
                default -> {
                    action(scanner);
                }

            }
        }
    }

    @Override
    public void remove(int index) {
        String query = "DELETE FROM School.Grades WHERE id =  ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,index);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void caseRemove(Scanner scanner) {
        try {
            printSelectStatement(scanner);
            System.out.println("ID der Note Welche sie löschen möchten");
            int idToDelete = scanner.nextInt();
            user.remove(idToDelete);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Input");
            caseRemove(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            caseRemove(scanner);
        }
    }

    @Override
    public void add(float grade, String subject, Scanner scanner) {
        System.out.println("Date in Format DD.MM.YYYY");
        String proof = scanner.nextLine();
        if (!proof.matches("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}$")) {
            System.out.println("Invalid Date");
            add(grade, subject, scanner);
        }
        try {
            String insertQuery = "INSERT INTO School.Grades (Subject, GRADE, DATE) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, String.valueOf(subject));
            preparedStatement.setFloat(2, grade);
            preparedStatement.setString(3, proof);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void caseAdd(Scanner scanner) {
        try {
            String subject = scanner.nextLine();
            int sub = Integer.parseInt(subject) - 1;
            Statement statement = connection.createStatement();
            statement.execute("SELECT Subject FROM AllSubjects");
            ResultSet set = statement.getResultSet();
            for (int i = 0; i <= sub; i++) {
                set.next();
            }
            user.add(user.getGrade(scanner), set.getString("Subject"), scanner);
        } catch (NumberFormatException e) {
            action(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(float newGrade, int id) {
        try {
            String query = "UPDATE Grades SET GRADE = ?  WHERE ID =  ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1,newGrade);
            statement.setInt(2,id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void caseEdit(Scanner scanner) {
        try {
            printSelectStatement(scanner);
            System.out.println("Von welcher ID");
            int sub = scanner.nextInt();
            scanner.nextLine();
            user.edit(user.getGrade(scanner), sub);
        } catch (NumberFormatException e) {
            caseEdit(scanner);
        }
    }

    @Override
    public String grade(Scanner scanner) {
        try {
            int sub = scanner.nextInt() - 1;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Subject FROM AllSubjects");
            for (int i = 0; i <= sub; i++) {
                resultSet.next();
            }
            String subject = resultSet.getString("Subject");
            String query = "SELECT * FROM School.Grades WHERE Subject = " + "'" + subject + "'";
            resultSet = statement.executeQuery(query);
            ResultSet set = statement.executeQuery("SELECT AVG(GRADE) FROM Grades WHERE Subject = "+"'"+subject+"'");
            set.next();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double grade = resultSet.getDouble("GRADE");
                String date = resultSet.getString("DATE");
                System.out.println("\u001B[34mID | " + id + " | Subject | " + subject + " | Grade | " + grade + " | Datum | " + date);
            }
            if (set.getDouble("avg(grade)") < 4){
                return "\u001B[31mDurchschnitt im Fach | " + subject + " | " + set.getDouble("avg(grade)");
            }
            return "\u001B[32mDurchschnitt im Fach | " + subject + " | " + set.getDouble("avg(grade)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            grade(scanner);
        }
        return null;
    }

    @Override
    public String zeugnis() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Subject FROM AllSubjects");
            while (resultSet.next()) {
                String query = "SELECT AVG(GRADE), Subject FROM Grades WHERE Subject = " + "'" + resultSet.getString("Subject") + "'";
                ResultSet set = statement.executeQuery(query);
                set.next();
                System.out.println("\u001B[34mDurchschnitt im Fach | " + resultSet.getString("Subject") + " | " + set.getDouble("avg(grade)"));
            }
            resultSet = statement.executeQuery("SELECT AVG(GRADE) FROM Grades");
            resultSet.next();
            if  (resultSet.getDouble("avg(grade)") < 4){
                return "\u001B[31mZeugnisnote | " + resultSet.getDouble("avg(grade)");
            }
            return "\u001B[32mZeugnisnote | " + resultSet.getDouble("avg(grade)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            zeugnis();
        }
        return null;
    }

    public void printSelectStatement(Scanner scanner) {
        try {
            int sub = scanner.nextInt();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Subject FROM AllSubjects");
            for (int i = 0; i < sub; i++) {
                resultSet.next();
            }
            String query = "SELECT * FROM School.Grades WHERE Subject = " + "'" + resultSet.getString("Subject") + "'";

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String subject = resultSet.getString("Subject");
                double grade = resultSet.getDouble("GRADE");
                String date = resultSet.getString("DATE");
                System.out.println("\u001B[34mID | " + id + " | Subject | " + subject + " | Grade | " + grade + " | Datum | " + date);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
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
            ArrayList<String> allSubject = new ArrayList<>();
            allSubject.add("Franz");
            allSubject.add("Physik");
            allSubject.add("Math");
            allSubject.add("Englisch");
            for (String sub : allSubject) {
                String insert = "INSERT INTO School.AllSubjects(Subject) VALUE(" + "'" + sub + "');";
                PreparedStatement insertAllSubjects = connection.prepareStatement(insert);
                insertAllSubjects.execute();
            }
            PreparedStatement deleteAllDupesSub = connection.prepareStatement("DELETE FROM School.AllSubjects WHERE ID > 4");
            deleteAllDupesSub.execute();


            PreparedStatement createAllGradesTable = connection.prepareStatement(createTableAllGrades);
            createAllGradesTable.execute();
            for (double i = 1; i <= 6; i += 0.25) {
                String insert = "INSERT INTO School.AllGrades(GRADE) VALUE(" + i + ");";
                PreparedStatement insertAllGrades = connection.prepareStatement(insert);
                insertAllGrades.execute();
            }
            PreparedStatement deleteAllDupesGRD = connection.prepareStatement("DELETE FROM School.AllGrades WHERE ID > 21");
            deleteAllDupesGRD.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public float getGrade(Scanner scanner) {
        System.out.println("Was für eine Note auf 0.25 gerundet");
        String proof = scanner.nextLine();
        try {
            Statement statement = connection.createStatement();
            statement.execute("SELECT GRADE FROM AllGrades");
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                if (String.valueOf(set.getInt("GRADE")).equals(proof)) {
                    return Integer.parseInt(proof);
                }
            }
            System.out.println("Invalid");
            getGrade(scanner);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    static User user = new User();
}
