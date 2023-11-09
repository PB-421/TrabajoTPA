package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelSelect extends JFrame {

    private Integer selectedLevel;

    public LevelSelect() {
        setTitle("Seleccionar Nivel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                JOptionPane.showMessageDialog(null, "Nivel seleccionado: " + selectedLevel);
                dispose(); // Cierra la ventana cuando se hace clic en "Aceptar"
            }
        });

        panel.add(opciones);
        panel.add(btnAceptar);

        setLayout(new java.awt.FlowLayout());
        add(panel);

        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    public int getSelectedLevel() {
        int nivel = selectedLevel.intValue();
        return nivel;
    }

    public static void main(String[] args) {
        LevelSelect levelSelector = new LevelSelect();
    }
}