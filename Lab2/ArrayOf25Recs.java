/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import java.awt.*;
import java.awt.event.*;

public class ArrayOf25Recs {

    public static void main(String[] args) {
        ArrayOfRectanglesFrames frame = new ArrayOfRectanglesFrames();
        frame.setTitle("Tiles of Rectangles");
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    } // end of main 
}

class ArrayOfRectanglesFrames extends Frame {

    private static final int FW = 800; // frame width
    private static final int FH = FW; // frame height

    private static final int RW = FW / 8; // rectangle width
    private static final int RH = RW;  // rectangle height

    private static final int H = RW / 2; // horz. space b/w rectangles
    private static final int V = H;      // vert. space b/w rectangles

    private static final int NO_OF_RECT = 25;

    Rectangle rectAry[] = new Rectangle[NO_OF_RECT];

    public ArrayOfRectanglesFrames() {
        setSize(FW, FH);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int x = H;
        int y = V;
        int c = 0;
        int row=1;

        g2.setColor(Color.blue);
        for (int j = 0; j < NO_OF_RECT; j++) {
            
            if (j % 5 == 0 && j>0) {
                y = y + RH + H;
                x=H;
                row++;
            }
            
            if(row%2==0){
                g2.setColor(Color.green);
            }else {
                g2.setColor(Color.blue);
            }
            rectAry[c] = new Rectangle(x, y, RW, RH);
            g2.fill(rectAry[c]);
            c = c + 1;
            x = x + RW + H;
        }

    } // End of paint() method

}
