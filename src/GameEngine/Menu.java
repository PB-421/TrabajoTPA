package GameEngine;

import GameEngine.SettingsPage;
import GameEngine.createScene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void main(String[] args) {
        JFrame pantalla = new JFrame("Menu");;
        generarInicio(pantalla);
        System.out.println("Hello, world!");
        System.out.println("ALLL MY FELLAS");

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
                screen.setVisible(false);
                JFrame nivel = new JFrame();
                nivel.setSize(400, 300); // Tamaño del JFrame principal (puedes ajustarlo)
                nivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SwingUtilities.invokeLater(() -> {
                    LevelSelect levelSelector = new LevelSelect(nivel);
                    int selectedLevel = levelSelector.getSelectedLevel();
                    System.out.println("Nivel seleccionado: " + selectedLevel);
                    Game_P game = new Game_P();
                    game.Game_P(selectedLevel);
                });
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsPage();
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