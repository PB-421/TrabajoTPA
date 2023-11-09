package GameEngine;

import Jugador.random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game_P {
    public void Game_P(int level) {
        double aceleracionNPC;
        double aceleracionPlayer;
        double tiempoNPC;
        double tiempoPlayer;
        int frame;
        random R1 = new random();
        aceleracionNPC = R1.Randomizer(level);
        tiempoNPC = CalculoSeg(CalculoFrame(aceleracionNPC));
        JFrame ventana = new JFrame("Game");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectanguloLlenadoInfinito panel = new RectanguloLlenadoInfinito(500);

        // Agrega el KeyListener al panel
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                }
            }
        });
        ventana.add(panel);
        ventana.setLocation(150, 100);
        ventana.setSize(1100, 700); // Ajusta el tamaño según tus necesidades
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

    public double CalculoFrame(double acceleration) {
        return ((60 * 1000) / acceleration);
    }

    public double CalculoSeg(double Frame) {
        return ((Frame / 1000) * 10);
    }
    public static void main(String[] args) {
        // Crear una instancia de Game_P y pasar un nivel (por ejemplo, nivel 5)
        Game_P game = new Game_P();
        game.Game_P(5);
    }
}