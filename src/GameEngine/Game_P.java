package GameEngine;

import Jugador.random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game_P {
    public void Game_P(int level) {
        double aceleracionNPC;
        double tiempoNPC;
        random R1 = new random();
        aceleracionNPC = R1.Randomizer(level);
        tiempoNPC = CalculoSeg(CalculoFrame(aceleracionNPC));
        System.out.println("TiempoNPC: "+tiempoNPC);
        JFrame ventana = new JFrame("Game");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectanguloLlenadoInfinito rect1= new RectanguloLlenadoInfinito(500);
        JPanel panel = new JPanel();
        ventana.add(rect1);
        ventana.setLocation(150, 100);
        ventana.setSize(1100, 700); // Ajusta el tamaño según tus necesidades
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(null,"Tiempo del rival: "+tiempoNPC+" segundos");
        rect1.addKeyListener(new KeyListener() {
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
                    double frame;
                    double aceleracionPlayer;
                    aceleracionPlayer = rect1.getAcceleration();
                    System.out.println("Acel jug: "+aceleracionPlayer);
                    frame = CalculoFrame(aceleracionPlayer);
                    System.out.println("Frames"+frame);
                    ventana.dispose();
                    JFrame ventana2 = new JFrame("Game");
                    ventana2.add(new createScene.ImagePanel(frame,tiempoNPC));
                    ventana2.setLocation(150, 100);
                    ventana2.setSize(1100, 700); // Ajusta el tamaño según tus necesidades
                    ventana2.setVisible(true);
                    ventana2.setLocationRelativeTo(null);
                }
            }
        });
        rect1.requestFocus();
    }

    public double CalculoFrame(double acceleration) {
        return ((100 * 500) / acceleration);
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