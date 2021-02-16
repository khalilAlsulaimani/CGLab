/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author alsul
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class MovePolygonByKeys extends JFrame {

    private static final int FRAME_WIDTH = 800; // frame-width
    private static final int FRAME_HEIGHT = 800; // frame-height

    public MovePolygonByKeys() {

        setLayout(new BorderLayout()); // layout of frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);                // set width & height of frame
        setTitle("Move Polygon By Arrow Keys");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel panel = new DrawingPanel(FRAME_WIDTH, FRAME_HEIGHT);
        add(panel, BorderLayout.CENTER); // add panel in frame

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new MovePolygonByKeys();
    }

}

class DrawingPanel extends JPanel {

    private static int PANEL_WIDTH; // panel width
    private static int PANEL_HEIGHT; // panel height
    

    String msg = " Use Arrow Keys to Move the Polygon ";
    
        
    private JPanel msgPanel = new JPanel();
    private JTextField msgTxtField = new JTextField(msg, 40);

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

    private static int tx = 10;     // tranlsation distances along x-axis
    private static int ty = tx;     // tranlsation distances along y-axis

    public DrawingPanel(int FRAME_WIDTH, int FRAME_HEIGHT) {
        PANEL_WIDTH = FRAME_WIDTH;
        PANEL_HEIGHT = FRAME_HEIGHT;

        int DM = 50;
         
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT - DM)); // set width & height of panel
        this.setBackground(Color.white);

        msgPanel.setLayout(new FlowLayout());        
        msgPanel.setPreferredSize(new Dimension(PANEL_WIDTH, DM));
        msgPanel.add(msgTxtField);  
        msgPanel.setBackground(Color.yellow);	
        add(msgPanel, BorderLayout.NORTH);	
        	
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

    }

    // inner class to handle keyboard events
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
            
            msgTxtField.setText(msg + " (x , y) = " + xPoly[2]+" , "+yPoly[2]);            
            repaint();

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

    public void moveRight() {
        for (int i = 0; i < xPoly.length; i++) {
            xPoly[i] = xPoly[i] + tx;
        }
    }

    public void moveLeft() {
        for (int i = 0; i < xPoly.length; i++) {
            xPoly[i] = xPoly[i] - tx;
        }
    }

}
