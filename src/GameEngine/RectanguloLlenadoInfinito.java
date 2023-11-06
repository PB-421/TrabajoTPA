package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RectanguloLlenadoInfinito extends JPanel {

    private int width = 0;
    // Ancho inicial del rectángulo
    private int maxWidth; // Ancho máximo del rectángulo
    private Timer timer;
    private int acceleration = 0;
    private double acceleracionD = acceleration;

    public RectanguloLlenadoInfinito(int maxWidth) {
        this.maxWidth = maxWidth;
        setFocusable(true); // Asegurarse de que el panel tenga el foco para recibir eventos de teclado

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    startAnimation(); // Comienza la animación al presionar la tecla SPACE
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    stopAnimation();
                    width = 0;
                    JOptionPane.showMessageDialog(null, "Su aceleracion es de " + acceleration, "Acceleracion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void startAnimation() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (width < maxWidth) {
                        width += 3; // Aumenta el ancho del rectángulo
                        repaint(); // Vuelve a dibujar el panel
                        acceleration = (width * 100) / maxWidth;
                    } else {
                        width = 0;
                    }
                }
            });
            timer.start(); // Inicia el temporizador solo si no está en ejecución
        }
    }

    private void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(50, 50, width, 100); // Dibuja el rectángulo
        g.setColor(Color.RED);
        g.drawRect(50, 50, maxWidth + 1, 100); //dibuja el borde
        g.drawRect(49, 49, maxWidth + 1, 101);
    }

    public double getAcceleration() {
        return acceleracionD;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RectanguloLlenadoInfinito();
            }
        });
    }

    public RectanguloLlenadoInfinito() {
        JFrame frame = new JFrame("Rectángulo Llenado Progresivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectanguloLlenadoInfinito panel = new RectanguloLlenadoInfinito(400);// Ancho máximo
        frame.add(panel);
        frame.setLocation(800, 300);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}