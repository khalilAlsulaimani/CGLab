/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author alsul
 */
public class ex1 extends JFrame {

    private static final int FW = 800;
    private static final int FH = 800;

    public ex1() {
        setLayout(new BorderLayout());

        setSize(FW, FH);

        setTitle("exsersise 1 ");

        setLocationRelativeTo(null);// means center of the screen 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TranslatePanel1 panel = new TranslatePanel1(FW, FH);

        add(panel, BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {

        new ex1();
    }

    public class TranslatePanel1 extends JPanel {

        private static final int FW = 800;
        private static final int FH = 600;
        private static final double RW = 80;
        private static final double RH = 60;
        private static final double X = (FW - RW) / 2;// law to make the shape be drawn in the middle
        private static final double Y = (FH - RH) / 2;

        public TranslatePanel1(int FW, int FH) {

            setPreferredSize(new Dimension(FW, FH));
            this.setBackground(Color.white);
        }

        public double degreeTransform(double degree) {

            double radian = degree * Math.PI / 180;
            return radian;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            // create shape       
            Shape rec = new Rectangle2D.Double(X, Y, RW, RH);

            g2.setColor(Color.blue);
            g2.fill(rec);

            // create an object of class AffineTransform  
            AffineTransform transform = new AffineTransform();

            //Translation
            transform.translate(200, -100); // tx, ty
            rec = transform.createTransformedShape(rec);
            g2.setColor(Color.red);
            g2.fill(rec);

            //transform.scale(sx,sy);	
            transform.scale(0.5, 2);
            rec = transform.createTransformedShape(rec);
            g2.setColor(Color.yellow);
            g2.fill(rec);

            //Rotation
            transform.setToRotation(degreeTransform(15));
            rec = transform.createTransformedShape(rec);
            g2.setColor(Color.green);
            g2.fill(rec);
        }
    }

}
