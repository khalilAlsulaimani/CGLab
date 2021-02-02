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

public class GraphicsPrimitives2D extends JFrame {

        private static final int FW = 800; // frame-width
        private static final int FH = 800; // frame-height

        public GraphicsPrimitives2D() {

        setLayout(new BorderLayout( )); // layout of frame
        setSize(FW, FH);                // set width & height of frame
        setTitle("Graphics Primtives 2D");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
        DrawingPanel panel = new DrawingPanel(FW, FH);
        add(panel, BorderLayout.CENTER); // add panel in frame
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
    	
    	new GraphicsPrimitives2D(); 

    }
}

class DrawingPanel extends JPanel {
	
	private static int PW;
	private static int PH;

	public DrawingPanel(int FW, int FH)	{
		PW = FW;
		PH = FH;
		setPreferredSize(new Dimension(PW, PH)); // set width & height of panel
		this.setBackground(Color.white);
	}
	
        @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // Line
        // Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);      
        Line2D.Double line = new Line2D.Double(120, 40, 390, 240);
        g2.setColor(Color.red);
        g2.draw(line); 
        
        // Rectangle
        //Rectangle2D.Double  rect = new Rectangle2D.Double(x, y, width, height);
        Rectangle2D.Double  rect = new Rectangle2D.Double(450, 70, 300, 200);         	
        g2.setColor(Color.green);
        g2.draw(rect); 

        // Ellipse2D.Double  elps = new Ellipse2D.Double(x, y, width, height);
        Ellipse2D.Double  elps = new Ellipse2D.Double(70, 300, 150, 250);
        g2.setColor(Color.yellow);
        g2.fill(elps); 
         
        // Font 
        Font myFont = new Font("Times", Font.BOLD, 36);
        g2.setFont(myFont);             
        g2.setColor(Color.magenta);
        // drawString("JAVA Programming", x, y);       	
        g2.drawString("JAVA Programming", 20, 700);

        
    }
}




