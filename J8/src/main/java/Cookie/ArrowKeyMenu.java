package Cookie;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.awt.event.KeyEvent.VK_ENTER;

public class ArrowKeyMenu extends JFrame {

    public ArrowKeyMenu(String[] items, JTextArea textAreaCookieAmount ,JButton grandma,JTextArea textAreaCookie,JPanel panel,JButton factory) {
        setTitle("Arrow Key Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        panel.setLayout(new FlowLayout());
        textAreaCookieAmount.append(items[0]);
        textAreaCookieAmount.setBackground(Color.BLACK);
        textAreaCookieAmount.setForeground(Color.WHITE);
        textAreaCookieAmount.setEditable(false);
        String cookie = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⡶⠾⠟⠻⠶⣶⣤⣤⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣴⣾⠋⠁⢀⣠⣤⣤⣀⠀⠉⠛⠛⠛⠛⠛⠛⠿⢿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⡶⠿⠿⠟⠛⠋⠁⠀⣰⣿⣟⣋⣻⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠬⣝⣻⣿⡷⠶⣶⣶⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⡿⡏⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠳⢶⣬⣍⠛⢿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⡿⠟⢫⡼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⣦⡘⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⢋⣥⣴⣾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⣿⣦⡀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢠⣿⠏⣠⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣦⡀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡾⠃⣴⡿⠁⠀⠀⠀⠀⠀⢠⣶⣿⣿⢷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣯⠈⢿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠻⢿⣷⣄⠀⠀⠀
⠀⠀⠀⠀⠀⢠⡞⢀⣼⡟⠁⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣷⣄⠙⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣷⣾⣿⡆⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⢢⠘⢿⣦⡀⠀
⠀⠀⠀⠀⣴⠏⣠⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣷⣾⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡟⠛⠿⣿⡿⠗⠀⠀⠀⢀⣴⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⣧⠘⣿⣷⠀
⠀⠀⢠⣾⠏⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡿⣛⣿⣿⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡟⠙⣿⡇⠀⠀⠀⠀⢸⡇⣿⣿⠀
⠀⢠⣾⡏⠰⠁⠀⠀⠀⠀⣀⡄⠀⠀⠀⠀⠀⠀⠀⠋⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⢀⣿⠁⣿⣇⠀
⠀⢸⣿⠀⠀⢠⡄⣀⣴⡿⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠿⠿⣿⠿⠟⠁⠀⠀⠀⠀⠸⣿⡄⣿⣿⠀
⠀⢸⡏⠀⠀⠘⢿⣿⣿⣧⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⡼⣿⣇
⠀⣸⠇⠀⠀⠀⠈⢿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⣶⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⡷⣄⠀⠀⠀⠀⠀⠀⢀⣤⠀⢄⠀⢸⣿
⢀⡏⢠⠀⠀⠀⠀⠈⠻⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣏⠙⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠻⣿⣿⣿⣿⣿⡇⣼⠀⠀⠀⠀⠀⣴⣿⣿⡇⢸⡆⠀⣿
⣸⡇⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣀⣀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣆⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣧⣸⣿⣿⣿⡿⠴⠃⠀⠀⠀⢠⡾⢻⣿⣿⡇⢀⡇⢀⣿
⣿⡇⣿⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⡟⠻⣷⡄⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⡿⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠀⠀⠀⠀⠀⠀⠐⠟⢷⣾⣿⣿⡇⢸⡇⣼⡟
⢹⣧⢻⣆⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣷⣿⣿⠀⠀⠀⠀⠀⠀⠉⠛⠿⣿⣛⣫⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⠿⢠⡿⣹⡟⠀
⠀⢿⣎⢿⣦⣄⣠⣄⣀⣀⡀⠘⢿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⣵⡿⠀⠀
⠀⠈⢿⣦⣴⣿⣿⣮⣵⣿⣿⣷⣤⣽⣿⣟⡋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⠇⣼⣿⡇⠀⠀
⠀⠀⠀⠻⠿⣛⣉⠙⢿⡿⠋⠉⠻⡿⠿⢿⣿⣿⣦⣄⡀⠀⠀⢀⣠⣤⣶⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⢀⣾⣿⡏⢸⣿⡿⠃⠀⠀
⠀⠀⠀⠀⠀⢘⡻⣷⠌⠀⠀⠿⠿⠀⠀⠀⠿⠟⠻⣿⡿⠆⠀⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⡹⣿⡆⠀⠀⠀⠀⣠⢞⣼⣿⠃⣼⣿⠁⠀⠀⠀
⠀⠀⠀⠀⠀⠸⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣦⠘⣿⣿⣿⣿⣿⠟⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣷⣾⡇⠀⠀⠀⣻⣷⣿⠟⢁⣼⣿⠃⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⡿⠀⢟⠿⣿⣿⣯⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⡿⢿⣿⠿⣿⠅⠀⢀⣾⣿⠟⣁⣴⣿⠟⠁⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠾⣷⣄⠈⠛⠶⠭⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠒⠛⠁⠀⢀⣼⡿⢣⣾⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣼⠄⢻⣿⠇⠀⠀⠀⠀⠀⠀⢀⣤⣤⡤⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⢡⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠳⣿⣟⣀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣄⣾⣿⣧⠀⠀⣀⣀⣠⣴⣫⣾⡿⠿⠿⠿⠛⠛⣡⣾⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⣿⣏⣷⣖⣒⣄⣚⠏⣿⣿⣿⣿⣿⣿⡟⢀⣾⠿⣛⡛⢛⣋⣥⣤⣴⣶⣶⣶⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣅⣿⣿⡛⢛⣛⣛⣓⡮⠻⠿⠿⠟⠋⢴⣋⣤⣯⣽⣶⣿⣿⡿⠟⠛⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡿⣿⡟⠻⢿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣿⣿⠿⠛⠛⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀""";
        textAreaCookie.append(cookie);
        textAreaCookie.setBackground(Color.BLACK);
        textAreaCookie.setForeground(Color.WHITE);
        textAreaCookie.setEditable(false);
        grandma.setVisible(true);
        factory.setVisible(true);
        panel.add(textAreaCookie);
        panel.add(textAreaCookieAmount);
        panel.add(grandma);
        panel.add(factory);
        add(panel);
        panel.setBackground(Color.black);

    }

    public static void main(String[] args) {
        JPanel panel = new JPanel(new GridLayout(2, 10));
        JTextArea textAreaCookie = new JTextArea(10, 20);
        Connection connection = createConnection();
        createTable(connection);
        int userId = 1;



        // Perform database operations here
        JTextArea textAreaCookieAmount = new JTextArea(2, 2);
        String[] items = {"Cookies =" + getInt(connection,userId,"Cookies")};
        JButton buttonBuyGrandma = new JButton("Buy Grandma");
        JButton buttonBuyFabric = new JButton("Buy Fabric");





        ArrowKeyMenu menu = new ArrowKeyMenu(items,textAreaCookieAmount,buttonBuyGrandma,textAreaCookie,panel,buttonBuyFabric);
        for (int i = 0; i < 1; i++) {
            ThreadForCookieProducers object = new ThreadForCookieProducers(menu,textAreaCookieAmount,connection,userId);
            object.start();
        }
        for (int i = 0; i < 1; i++) {
            ThreadToUpdate object = new ThreadToUpdate(textAreaCookieAmount,menu,userId,connection);
            object.start();
        }
        SwingUtilities.invokeLater(() -> {
            menu.setVisible(true);
        });
        buttonBuyGrandma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInt(connection,userId,"Cookies") >= 100) {
                    buttonPressed(connection,userId,"Grandmas",-100);
                }
            }
        });
        buttonBuyFabric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInt(connection,userId,"Cookies")>= 10000){
                    buttonPressed(connection,userId,"Fabric",-10000);
                }
            }
        });
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();
        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(VK_ENTER, 0);
        inputMap.put(enterKeyStroke, "Mouse Click");
        actionMap.put("Mouse Click", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInt(connection,userId,1,"Cookies");
            }
        });
    }




    public static void createTable(Connection connection){
        String createTableAllSubjects = "CREATE TABLE IF NOT EXISTS Cookiegame (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "Cookies INT DEFAULT 0," +
                "Grandmas INT DEFAULT 0," +
                "Fabric INT DEFAULT 0" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableAllSubjects);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection createConnection() {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/Cookie";  // Specify the database name
        String username = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getInt(Connection connection, int userId, String column){
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT "+column+" FROM Cookie.Cookiegame WHERE id = "+userId+";");
            set.next();
            int amount = set.getInt(column);
            return amount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateInt(Connection connection, int userid, int value, String column){
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet set =statement.executeQuery("SELECT "+column+",id FROM Cookiegame WHERE id ="+userid+";");
            set.next();
            set.updateInt(column, getInt(connection,userid,column) + value);
            set.updateRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void buttonPressed(Connection connection,int userId,String column, int price){
        updateInt(connection,userId,1,column);
        updateInt(connection,userId,price,"Cookies") ;
    }
}
