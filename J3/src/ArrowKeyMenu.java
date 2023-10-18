import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrowKeyMenu extends JFrame {
    private JLabel[] menuItems;
    private int selectedItemIndex = 0;

    public ArrowKeyMenu(String[] items) {
        setTitle("Arrow Key Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        menuItems = new JLabel[items.length];
        JPanel panel = new JPanel(new GridLayout(items.length, 1));

        for (int i = 0; i < items.length; i++) {
            menuItems[i] = new JLabel(items[i]);
            menuItems[i].setOpaque(true);
            menuItems[i].setBackground(Color.BLACK);
            menuItems[i].setForeground(Color.WHITE);
            panel.add(menuItems[i]);
        }

        add(panel);
        addKeyListener(new MenuKeyListener());

        // Adding an ActionListener for the Enter key
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        inputMap.put(enterKeyStroke, "enterAction");
        actionMap.put("enterAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when Enter is pressed
                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
    }

    private class MenuKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            int itemCount = menuItems.length;

            if (keyCode == KeyEvent.VK_UP) {
                selectedItemIndex = (selectedItemIndex - 1 + itemCount) % itemCount;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                selectedItemIndex = (selectedItemIndex + 1) % itemCount;
            }
            updateMenuSelection();
        }
    }

    private void updateMenuSelection() {
        for (int i = 0; i < menuItems.length; i++) {
            if (i == selectedItemIndex) {
                menuItems[i].setForeground(Color.BLACK);
                menuItems[i].setBackground(Color.WHITE);
            } else {
                menuItems[i].setForeground(Color.WHITE);
                menuItems[i].setBackground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
            ArrowKeyMenu menu = new ArrowKeyMenu(items);
            menu.setVisible(true);
        });
    }
}
