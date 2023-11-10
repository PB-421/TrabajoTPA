package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelSelect extends JDialog {

    private Integer selectedLevel;
    private int level;

    public LevelSelect(JFrame parent) {
        super(parent, "Seleccionar Nivel", true); // Hacer que el JDialog sea modal

        setSize(300, 200);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        Integer[] niveles = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        JComboBox<Integer> opciones = new JComboBox<>(niveles);
        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLevel = (Integer) opciones.getSelectedItem();
            }
        });

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level = selectedLevel;
                JOptionPane.showMessageDialog(null, "Nivel seleccionado: " + selectedLevel);
                dispose(); // Cierra la ventana cuando se hace clic en "Aceptar"
            }
        });

        panel.add(opciones);
        panel.add(btnAceptar);

        setLayout(new FlowLayout());
        add(panel);

        setLocationRelativeTo(parent); // Centra la ventana con respecto al JFrame padre
        setVisible(true);
    }

    public int getSelectedLevel() {
        return level;
    }

    public static void main(String[] args) {
        JFrame parentFrame = new JFrame();
        parentFrame.setSize(400, 300); // Tamaño del JFrame principal (puedes ajustarlo)
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(() -> {
            LevelSelect levelSelector = new LevelSelect(parentFrame);
            int selectedLevel = levelSelector.getSelectedLevel();
            System.out.println("Nivel seleccionado: " + selectedLevel);
        });
    }
}