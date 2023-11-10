

package GameEngine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class createScene {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                JFrame frame = new JFrame("Image Timer");
                frame.add(new ImagePanel(1100.43,12));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class ImagePanel extends JPanel {
        BufferedImage[] images;
        BufferedImage[] startImages;
        BufferedImage[] EndImages;
        int frameCounter = 0;
        Timer timer;

        double tiempoP;

        int frameint;

        int tiempoRival;

        int contaux=1;

        public ImagePanel(double frames,double tiempoNPC) {
            images = new BufferedImage[10];
            frameint = (int) frames;
            tiempoRival = (int) tiempoNPC;
            try {
                images[0] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fr4ame 1.png"));
                images[1] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fram 4.png"));
                images[2] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/CAr moving Frame 2.png"));
                images[3] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 3.png"));
                images[4] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 5.png"));
                images[5] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fr4ame 1.png"));
                images[6] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fram 4.png"));
                images[7] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/CAr moving Frame 2.png"));
                images[8] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 3.png"));
                images[9] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 5.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }

            startImages = new BufferedImage[3];
            try {
                startImages[0] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 1 Initial Light.png"));
                startImages[1] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 2 Second Light.png"));
                startImages[2] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 3 Go Light.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }
            EndImages = new BufferedImage[1];
            try {
                EndImages[0] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame Finish With Car.png"));

            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }
            setBackground(Color.BLACK);

            timer = new Timer(frameint, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    contaux++;
                }
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (frameCounter < startImages.length) {
                BufferedImage img = startImages[frameCounter];
                g.drawImage(img, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
            }
            else if (frameCounter < startImages.length + images.length) {
                BufferedImage img = images[frameCounter - startImages.length];
                g.drawImage(img, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
            }
            else {
                BufferedImage img = EndImages[0];
                g.drawImage(img, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                timer.stop();
            }
            frameCounter = (frameCounter + 1) % (startImages.length + images.length + EndImages.length);
            if(contaux==14){
                JFrame info = new JFrame("Resultado");
                info.setSize(300,100);
                info.setLocation(650,400);
                info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                tiempoP = calcularTiempo(frameint);
                JLabel texto = new JLabel("Has completado la carrera en "+tiempoP+" segundos");
                if(tiempoP<tiempoRival){
                    JLabel texto2 = new JLabel("Has Ganado!!!!");
                    panel.add(texto2);
                }
                else if(tiempoP>tiempoRival){
                    JLabel texto2 = new JLabel("Has perdido :(");
                    panel.add(texto2);
                }
                else{
                    JLabel texto2 = new JLabel("Has quedado empate");
                    panel.add(texto2);
                }
                panel.add(texto);
                info.add(panel);
                info.setVisible(true);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1100, 700);
        }

        public double calcularTiempo(double frame){
            return ((frame/1000)*10);
        }
    }
}