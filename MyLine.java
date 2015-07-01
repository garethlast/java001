import java.awt.Color;
import java.awt.Graphics;

// Fig. 8.21: MyLine.java
//Declaration of class MyLine brought forward from Project Part 1
//Modified Project Part 3

//Name: Gareth Last
//Email: garethlast@hotmail.com

//class MyLine
public class MyLine extends MyShape {

   // Call superclass passing parameters
   public MyLine(int x1, int y1, int x2, int y2, Color color) {
      super(x1, y1, x2, y2, color);
   }// end MyLine Constructor

   // Draw the line in the specified color
   public void draw(Graphics g) {
      g.setColor(getColor());
      g.drawLine(getX1(), getY1(), getX2(), getY2());
   }// end method draw
}// end class MyLine
