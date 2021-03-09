/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author alsul
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Translate extends JFrame {

    private static final int FRAME_WIDTH = 800; // frame-width
    private static final int FRAME_HEIGHT = 800; // frame-height

    public Translate() {

        setLayout(new BorderLayout()); // layout of frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);                // set width & height of frame
        setTitle("Translate");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TranslatePanel panel = new TranslatePanel(FRAME_WIDTH, FRAME_HEIGHT);
        add(panel, BorderLayout.CENTER); // add panel in frame

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new Translate();
    }
}

class TranslatePanel extends JPanel {

    private static final int FW = 800;
    private static final int FH = 600;
    private static final double RW = 80;
    private static final double RH = 60;
    private static final double X = (FW - RW) / 2;
    private static final double Y = (FH - RH) / 2;

    public TranslatePanel(int FW, int FH) {
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
