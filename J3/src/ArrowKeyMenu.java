import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import static java.awt.event.KeyEvent.VK_ENTER;

public class ArrowKeyMenu extends JFrame {
    static public int amountOfCookies = 0;
    static JTextArea textAreaCookieAmount = new JTextArea(2, 2);
    static String[] items = {"Cookies =" + amountOfCookies};
    static ArrowKeyMenu menu = new ArrowKeyMenu(items);
    static int grandmaAmount = 0;
    private JLabel[] menuItems;
    private int selectedItemIndex = 0;
    public ArrowKeyMenu(String[] items) {
        setTitle("Arrow Key Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        menuItems = new JLabel[items.length];
        JPanel panel = new JPanel(new GridLayout(2, 10));
        JTextArea textAreaCookie = new JTextArea(10, 20);
        panel.setLayout(new FlowLayout());
        textAreaCookieAmount.append(items[0]);
        textAreaCookieAmount.setOpaque(true);
        textAreaCookieAmount.setBackground(Color.BLACK);
        textAreaCookieAmount.setForeground(Color.WHITE);
        textAreaCookieAmount.setEditable(false);
        String cookie = """
                ⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣿⣿⡿⠿⠷⣶⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣇⠀⠀⢸⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢀⣴⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀
                ⠀⠀⠀⢠⣿⡟⠁⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀
                ⠀⠀⢠⣿⣿⣿⣦⣄⣠⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣷⠀⠀⠀
                ⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⢹⣿⣿⣿⡇⠀⠀
                ⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⠀⠀
                ⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀
                ⠀⠀⠈⢿⣿⣿⣿⣿⠟⠻⣿⣿⠋⠀⠉⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⢙⣿⠃⠀⠀
                ⠀⠀⠀⠈⢿⣿⣿⠁⠀⠀⠘⣿⣆⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀
                ⠀⠀⠀⠀⠀⠙⢿⣦⣤⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠉⢹⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠿⠿⣿⣿⣿⣷⡤⠾⠛⠉⠀⠀⠀""";
        textAreaCookie.append(cookie);
        textAreaCookie.setOpaque(true);
        textAreaCookie.setBackground(Color.BLACK);
        textAreaCookie.setForeground(Color.WHITE);
        textAreaCookie.setEditable(false);
        JButton grandma = new JButton("Buy Grandma  100Cookies");
        grandma.setAction(getAction());
        grandma.setSize(100,100);
        grandma.setOpaque(true);
        panel.add(textAreaCookie);
        panel.add(textAreaCookieAmount);
        panel.add(grandma);
        add(panel);


        // Adding an ActionListener for the Enter key
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();


        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(VK_ENTER, 0);
        inputMap.put(enterKeyStroke, "Mouse Click");
        actionMap.put("Mouse Click", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountOfCookies++;
                textAreaCookieAmount.setText("Cookies =" + amountOfCookies);
                menu.revalidate();
                menu.repaint();
            }
        });
    }

    public static void main(String[] args) {
        int thread = 1;
        for (int i = 0; i < thread; i++) {
            BackGround object = new BackGround();
            object.start();
        }
        SwingUtilities.invokeLater(() -> {
            String[] ada = {"121"};
            menu.setVisible(true);
        });
    }

    public static Action getAction() {
        Action action = new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                grandmaAmount++;
                System.out.println(grandmaAmount);
            }
        };
        return action;
    }
}
