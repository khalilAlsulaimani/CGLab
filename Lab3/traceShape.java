/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

/**
 *
 * @author alsul
 */
public class traceShape extends JFrame {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HIGHT = 800;

    public traceShape() {
        setLayout(new BorderLayout());
        setSize(FRAME_WIDTH, FRAME_HIGHT);
        setTitle("Move Polygon By Arrow Keys");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanal panal = new DrawingPanal(FRAME_WIDTH, FRAME_HIGHT);
        add(panal, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new traceShape();
    }

}

class DrawingPanal extends JPanel {

    private static int PANEL_WIDTH; // panel width
    private static int PANEL_HEIGHT; // panel height

    String msg = "Use Arrow Keys to Move the Polygon";

    private JPanel msgPanal = new JPanel();
    private JTextField msgTextFild = new JTextField(msg, 40);

    private static final int polyW = 60;  //polygon-width
    private static final int polyH = 100; //polygon-height

    // (x,y) coordinate of points to be use in polygon	
    private static int x0 = 150;
    private static int y0 = 600;
    private static int x1 = x0 + polyW;
    private static int y1 = y0;
    private static int x2 = x0 + (x1 - x0) / 2;
    private static int y2 = y0 - polyH;

    private static int xPoly[] = {x0, x1, x2}; // initialize array
    private static int yPoly[] = {y0, y1, y2};

    private static final int arrSize = 100;
    private static int[] xDot = new int[arrSize];
    private static int[] yDot = new int[arrSize];
    private static int count = 0;

    // the values that the arrow key input effects the shape in 
    private static int tx = 10;     // tranlsation distances along x-axis
    private static int ty = tx;     // tranlsation distances along y-axis

    public DrawingPanal(int FRAME_WIDTH, int FRAME_HIGHT) {
        PANEL_WIDTH = FRAME_WIDTH;
        PANEL_HEIGHT = FRAME_HIGHT;

        int DM = 50;

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT - DM));
        this.setBackground(Color.white);

        msgPanal.setLayout(new FlowLayout());
        msgPanal.setPreferredSize(new Dimension(PANEL_WIDTH, DM));
        msgPanal.add(msgTextFild);
        msgPanal.setBackground(Color.green);
        add(msgPanal, BorderLayout.NORTH);

        this.setFocusable(true);

        // register keyboard listener
        KeyPressListener listenerKey = new KeyPressListener();
        addKeyListener(listenerKey);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(5.0f));

        g.setFont(new Font("Arial", Font.BOLD, 30));
        g2.drawString(msg, 100, 140);

        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        Shape polyShape = poly;
        g2.setColor(Color.green);
        g2.fill(polyShape);

        

        

        for (int i = 0; i < count; i++) {
            g2.setColor(Color.black);
            g2.drawLine(xDot[i], yDot[i], xDot[i], yDot[i]);
        }

        count++;
    }

    private class KeyPressListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    moveRight();
                    break;
                case KeyEvent.VK_UP:
                    moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    moveDown();
                    break;

            }
            if (keyCode == KeyEvent.VK_LEFT | keyCode == KeyEvent.VK_RIGHT | keyCode == KeyEvent.VK_UP | keyCode == KeyEvent.VK_DOWN) {
                xDot[count] = xPoly[2];
                yDot[count] = yPoly[2];
                count++;
                
                if (count == arrSize) {
                    count = 0;
                }

            }
            msgTextFild.setText(msg + " (x , y) = " + xPoly[2] + " , " + yPoly[2]);
            repaint();

        }

        public void moveLeft() {
            for (int i = 0; i < xPoly.length; i++) {
                xPoly[i] = xPoly[i] - tx;
            }
        }

        public void moveRight() {
            for (int i = 0; i < xPoly.length; i++) {
                xPoly[i] = xPoly[i] + tx;
            }
        }

        public void moveUp() {
            for (int i = 0; i < yPoly.length; i++) {
                yPoly[i] = yPoly[i] - ty;
            }
        }

        public void moveDown() {
            for (int i = 0; i < yPoly.length; i++) {
                yPoly[i] = yPoly[i] + ty;
            }
        }

    }

}
