package GameEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RectanguloLlenadoInfinito extends JPanel {

    private int width = 0;
    private int maxWidth;
    private Timer timer;
    private int acceleration = 0;
    private double acceleracionD;
    private BufferedImage image;

    public RectanguloLlenadoInfinito(int maxWidth) {
        this.maxWidth = maxWidth;
        setFocusable(true);

        try {
            image = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 1 Initial Light tamaño.png")); // Reemplaza "ruta_de_tu_imagen.jpg" con la ruta real de tu imagen
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    startAnimation();
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
                        width += 5;
                        repaint();
                        acceleration = (width * 100) / maxWidth;
                    } else {
                        width = 0;
                    }
                }
            });
            timer.start();
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

        // Dibuja la imagen en la ventana
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }

        g.setColor(Color.BLACK);
        g.fillRect(320, 75, width, 100);

        g.setColor(Color.RED);
        g.drawRect(320, 75, maxWidth + 1, 100);
        g.drawRect(319, 74, maxWidth + 1, 101);
    }

    public double getAcceleration() {
        acceleracionD=acceleration;
        return acceleracionD;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1100, 700);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Rectángulo Llenado Progresivo con Imagen");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                RectanguloLlenadoInfinito panel = new RectanguloLlenadoInfinito(500);
                frame.add(panel);
                frame.setLocation(150, 100);
                frame.setSize(1100, 700); // Ajusta el tamaño según tus necesidades
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}