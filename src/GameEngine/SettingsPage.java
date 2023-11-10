package GameEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPage extends JFrame {
    private JCheckBox checkBoxOption;
    private JTextField textFieldOption;
    private JButton saveButton;

    public SettingsPage() {
        super("Settings Page");
        setLayout(new GridLayout(0, 1));
        checkBoxOption = new JCheckBox("Enable Option");
        textFieldOption = new JTextField(20);
        saveButton = new JButton("Save Settings");

        add(checkBoxOption);
        add(textFieldOption);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu();

            }
        });

        add(saveButton);

        // Set the JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SettingsPage();
            new Menu();
        });
    }
}
