/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author alsul
 */
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RectangleAnimation extends JFrame {

    private static final int FRAME_WIDTH = 800; // frame-width
    private static final int FRAME_HEIGHT = 800; // frame-height

    public RectangleAnimation() {

        setLayout(new BorderLayout()); // layout of frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);                // set width & height of frame
        setTitle("Rectangle Animation 2D");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelRectangleAnimation panel = new PanelRectangleAnimation();
        add(panel, BorderLayout.CENTER); // add panel in frame

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new RectangleAnimation();
    }

}

class PanelRectangleAnimation extends JPanel implements Runnable {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;
    private static final int RW = 60;
    private static final int RH = 40;

    int x, y;

    Rectangle2D.Double rec;

    Thread mythread;

    public PanelRectangleAnimation() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.white);

        mythread = new Thread(this);
        mythread.start();
    }

    public void run() {

        int stateUpOrDown = 0;  // if going down value is 0 if up value is 1 
        // animation loop
        boolean flag = true;
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            if (x == PANEL_WIDTH - RW || y == PANEL_HEIGHT - RH) {
                stateUpOrDown = 1;
            }

            if (x == 0 || y == 0) {
                stateUpOrDown = 0;
            }

            if (stateUpOrDown == 0) {

                // rate of moving the rec 
                x = x + 5;
                y = y + 5;

            }

            if (stateUpOrDown == 1) {
                // rate of moving the rec backwards 
                x = x - 5;
                y = y - 5;

            }

            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.red);
        rec = new Rectangle2D.Double(x, y, RW, RH);

        g2.fill(rec);
    }
}
