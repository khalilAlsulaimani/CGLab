/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

/**
 *
 * @author alsul
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Ex1 extends JFrame {

    private static final int FW = 800;// frame width
    private static final int FH = 800;//  frame hight

    public Ex1() {
        setLayout(new BorderLayout());
        setSize(FW, FH);
        setTitle("Exersise 1");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanal2 panal = new DrawingPanal2(FW, FH);
        add(panal, BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {

        new Ex1();

    }

}

class DrawingPanal2 extends JPanel {

    static int PW;// PANAL width
    static int PH;// panal hight

    DrawingPanal2(int FH, int FW) {
        PW = FW;
        PH = FH;

        setPreferredSize(new Dimension(PW, PH)); // setting panal hight and widtt
        this.setBackground(Color.white);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // line
        int midX = PW / 2; // mid point of x axis

        // Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        //drawing y axis vertical line 
        Line2D.Double lineY = new Line2D.Double(midX, 0, midX, PH);
        g2.setColor(Color.red);
        g2.draw(lineY);

        //drawing x axis horzontal line 
        int midY = PH / 2; // mid point of y axis
        Line2D.Double lineX = new Line2D.Double(0, midY, PW, midY);
        g2.draw(lineX);

        // drawing rectangle middle of panal 
        //Rectangle2D.Double  rect = new Rectangle2D.Double(x, y, width, height);
        Rectangle2D.Double recBlue = new Rectangle2D.Double(midX - 150, midY - 100, 300, 200);
        g2.setColor(Color.blue);
        g2.draw(recBlue);

        //gray rectangle bottem left corner 
        Rectangle2D.Double recGray = new Rectangle2D.Double(50, 550, 250, 150);
        g2.setColor(Color.gray);
        g2.fillRect(50, 550, 250, 150);

        // yellow eclipse width 250 and height 150 
        // Ellipse2D.Double  elps = new Ellipse2D.Double(x, y, width, height);
        Ellipse2D.Double oval = new Ellipse2D.Double(500,550,250,150);
        g2.setColor(Color.yellow);
        g2.fillOval(500,550,250, 150);
        
        
        //drawing string 
        Font myFont = new Font("Times",Font.BOLD,36);
        
        g2.setFont(myFont);
        g2.setColor(Color.green);
        g2.drawString("JAVA programming",40 ,250);

    }

}
