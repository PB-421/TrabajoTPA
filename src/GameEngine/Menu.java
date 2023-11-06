package GameEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void main(String[] args) {
        JFrame pantalla = new JFrame("Prueba");
        ;
        generarInicio(pantalla);
    }

    public static void generarInicio(JFrame screen) {
        JButton b1 = new JButton("Play");
        JButton b2 = new JButton("Settings");
        JButton b3 = new JButton("Quit");
        b1.setBounds(130, 100, 100, 40);
        b2.setBounds(130, 200, 100, 40);
        b3.setBounds(130, 300, 100, 40);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.dispose();
                new NPCMessage();
                new RectanguloLlenadoInfinito();
            }

        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.dispose();
            }

        });
        screen.add(b1);
        screen.add(b2);
        screen.add(b3);
        screen.setSize(400, 500);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}